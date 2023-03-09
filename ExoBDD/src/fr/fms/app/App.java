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
			while (menuChoice != 7) {
				System.err.println("\n1-View cart;  2-View all article ; 3-Display categories;\n4-Add article;\n5-Remove article;\n6-Order cart;\nSelect a choice :\n");
				menuChoice = sc.nextInt();
				switch (menuChoice) {

				case 1 : // View cart
					shopJob.displayCart(cart);
					break;

				case 2 : // View articles
					artDao.readAll();
					break;

				case 3 : // Categories
					System.err.println("1-Accessories;\n2-Software;\n3-Computers;\n");
					int catSelect = sc.nextInt();
					artDao.displayCat(catSelect);
					break;

				case 4 : // Add article
					System.err.println("Select article to add:");
					int idArticle = sc.nextInt();
					Article a = artDao.read(idArticle);
					shopJob.addCart(a,cart);
					shopJob.displayCart(cart);
					System.err.println("\nAddition successful.\n");
					break;

				case 5 : // Remove article
					System.err.println("\nSelect article to remove:\n");
					int index = sc.nextInt();
					shopJob.subCart(index-1,cart);
					break;

				case 6 : // Order?
					shopJob.orderCart();
					break;
				}
			}
		}
	}
}