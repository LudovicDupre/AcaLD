package fr.fms.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.business.IJobImpl;
import fr.fms.dao.ArticleDao;
import fr.fms.entities.Article;

public class App {

	static Scanner sc = new Scanner(System.in);
	public static IJobImpl shopJob = new IJobImpl();
	public static ArticleDao artDao = new ArticleDao();

	public static void main(String[] args) throws SQLException {

		ArrayList<Article> cart = new ArrayList<Article>();

		while (true) {
			//Main menu
			int menuChoice = -1;
			while (menuChoice != 5) {
				System.out.println("\n1-View cart;  2-View article list; 3-Display categories;\n4-Order cart;\nSelect a choice :\n");
				menuChoice = sc.nextInt();
				switch (menuChoice) {

				case 1 : // View cart
					//subMenu of view cart
					int subChoice = -1;
					while (subChoice != 3) {
						shopJob.displayCart(cart);
						System.out.println("\n1-Remove an article\n2-Order\n3-Quit\n");
						subChoice = sc.nextInt();

						switch (subChoice) {

						case 1 : // Remove article
							System.err.println("\nSelect article to remove:\n");
							int index = sc.nextInt();
							shopJob.subCart(index-1,cart);
							break;

						case 2 : // Order
							shopJob.orderCart();
							break;
						}
					}
					break;

				case 2 : // View articles
					//subMenu of view article
					int subChoice2 = -1;
					while (subChoice2 != 3) {
						artDao.readAll();
						System.out.println("\n1- Add an article to cart\n2-Order\n3-Quit\n");
						subChoice2 = sc.nextInt();

						switch (subChoice2) {

						case 1 : // Add article
							System.err.println("Select article to add:");
							int idArticle = sc.nextInt();
							Article a = artDao.read(idArticle);
							shopJob.addCart(a,cart);
							shopJob.displayCart(cart);
							System.out.println("\nAddition successful.\n");
							break;

						case 2 : // Order
							shopJob.orderCart();
							break;
						}
					}
					break;

				case 3 : // Categories
					int subChoice3 = -1;
					while (subChoice3 != 4) {
						artDao.readAll();
						System.out.println("\n1-Hardware\n2-Sofware\n3-Computers\n4-Quit\n");
						subChoice3 = sc.nextInt();

						switch (subChoice3) {
						
						case 1 : 
						}
					}
					break;

				case 4 : // Order?
					shopJob.orderCart();
					break;
				}
			}
			System.out.println("Back to menu.");
		}
	}
}