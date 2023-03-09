/**
 * @author El babili - 2022
 * 
 */

package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

public interface IBusiness {	
	/**
	 * méthode qui ajoute un article au panier
	 * @param article à ajouter
	 */
	public void addToCart(Article article);		
	
	/**
	 * méthode qui retire un article au panier s'il est dedans
	 * @param id de l'article à retirer
	 */
	public void rmFromCart(int id);		
	
	/**
	 * méthode qui renvoi sous la forme d'une liste tous les éléments du panier (gestion en mémoire)
	 * @return Liste d'articles du panier
	 */
	public ArrayList<Article> getCart();	
	
	/**
	 * méthode qui réalise la commande en base avec l'idUser + total de la commande en cours + date du jour + contenu du panier :
	 * - la méthode va céer une commande en base -> idOrder + montant + date + idUser
	 * - puis va ajouter autant de commandes minifiées associées : orderItem -> idOrderItem + idArticle + Quantity + Price + idOrder
	 * @param idUser est l'identifiant du client qui est passé commande
	 * @return 1 si tout est ok 0 si pb 
	 */
	public int order(int idUser);		
	
	/**
	 * méthode qui renvoi tous les articles de la table t_articles en bdd
	 * @return Liste d'articles en base
	 */
	public ArrayList<Article> readArticles();	
	
	/**
	 * méthode renvoie l'article correspondant à l'id
	 * @param id de l'article à renvoyer
	 * @return article correspondant si trouvé, null sinon
	 */
	public Article readOneArticle(int id);	
	
	/**
	 * méthode qui renvoi toutes les catégories de la table t_catégories en bdd
	 * @return Liste de catégories en base
	 */
	public ArrayList<Category> readCategories();
	
	/**
	 * méthode qui renvoi tous les articles d'une catégorie
	 * @param id de la catégorie
	 * @return Liste d'articles
	 */
	public ArrayList<Article> readArticlesByCatId(int idCat);
}
