/**
 * @author El babili - 2022
 * 
 */

package fr.fms.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.CategoryDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.User;

public class IBusinessImpl implements IBusiness {	
	private HashMap<Integer,Article> cart;
	private Dao<Article> articleDao = DaoFactory.getArticleDao();
	private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Category> categoryDao = DaoFactory.getCategoryDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderItem> orderItemDao = DaoFactory.getOrderItemDao();
	private Dao<Customer> customerDao = DaoFactory.getCustomerDao();
	
	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Article>();
	}

	@Override
	public void addToCart(Article article) {
		Article art = cart.get(article.getId());
		if(art != null) {
			art.setQuantity(art.getQuantity() + 1);
		}
		else cart.put(article.getId(), article);
	}

	@Override
	public void rmFromCart(int id) {
		Article article = cart.get(id);
		if(article != null) {
			if(article.getQuantity() == 1)	cart.remove(id);
			else article.setQuantity(article.getQuantity() - 1);
		}				
	}

	@Override
	public ArrayList<Article> getCart() {
		return new ArrayList<Article> (cart.values());
	}

	@Override
	public int order(int idCustomer) {	
		if(customerDao.read(idCustomer) != null) {
			double total = getTotal(); 
			Order order = new Order(total, new Date(), idCustomer);
			if(orderDao.create(order)) {	
				for(Article article : cart.values()) {	
					orderItemDao.create(new OrderItem(0, article.getId(), article.getQuantity(), article.getPrice(), order.getIdOrder()));
				}
				return order.getIdOrder();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Article> readArticles() {
		return articleDao.readAll();
	}
	
	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	@Override
	public Article readOneArticle(int id) {
		return articleDao.read(id);
	}

	@Override
	public ArrayList<Article> readArticlesByCatId(int id) {
		return ((ArticleDao) articleDao).readAllByCat(id);
	}

	/**
	 * renvoi le total de la commande en cours
	 * @return total
	 */
	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += a.getPrice() * a.getQuantity()); 	
		return total[0];
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}
	
	public void clearCart() {
		cart.clear();		
	}

	public Category readOneCategory(int id) {
		return categoryDao.read(id);
	}
}
