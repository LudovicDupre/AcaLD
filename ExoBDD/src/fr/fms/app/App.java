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

		while(true) {
			System.out.println("Please enter your login :");
			String login = sc.next();

			System.out.println("Please enter your password :");
			String password = sc.next();

			boolean result = shopJob.compareUser(shopJob.checkUserLogin(login),shopJob.checkUserPassword(password));

			if (result==true) {

				ArrayList<Article> fullArticles = artDao.readAll();
				for (Article a: fullArticles)
					System.out.println(a.getId()+ "  -  " + a.getDescription()+"  -  "+ a.getBrand()+ "  -  "+a.getPrice());

			}else {
				System.err.println("Wrong input.");
			}
		}
	}
}
