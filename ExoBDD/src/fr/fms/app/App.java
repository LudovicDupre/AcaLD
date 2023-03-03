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
		int menuChoice = -1;
		int subChoice = -1;
		int subChoice2 = -1;
		
		while (true) {
			//Main menu

			while (menuChoice != 4) {
				System.out.println("1-View cart;  2-View article list;  3-Order cart\nSelect a choice :");
				menuChoice = sc.nextInt();
				switch (menuChoice) {

				case 1 : // View cart
					//subMenu of view cart
	
					while (subChoice != 3) {
						shopJob.displayCart(cart);
						System.out.println("1- Remove an article\n2-Order\n3-Quit");
						subChoice = sc.nextInt();
	
						switch (subChoice) {

						case 1 : // Remove article
							System.out.println("Select article to remove:");
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

					while (subChoice2 != 3) {
						artDao.readAll();
						System.out.println("\n\n1- Add an article to cart\n2-Order\n3-Quit");
						subChoice2 = sc.nextInt();

						switch (subChoice2) {

						case 1 : // Remove article
							System.out.println("Select article to add:");
							int idArticle = sc.nextInt();
							Article a = artDao.read(idArticle);
							shopJob.addCart(a,cart);
							shopJob.displayCart(cart);
							System.out.println("Addition successful.\n\n");
							break;

						case 2 : // Order
							shopJob.orderCart();
							break;
						}
					}
					break;

				case 3 : // Order
					shopJob.orderCart();
					break;
				}
			}
			System.out.println("Back to menu.");
		}
	}
}