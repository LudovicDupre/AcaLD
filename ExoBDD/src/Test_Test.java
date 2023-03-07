import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.business.IJobImpl;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.BddConnection;
import fr.fms.entities.Article;
import fr.fms.entities.Users;

public class Test_Test {

	//public static ArticleDao artDao = new ArticleDao();
	public static IJobImpl shopJob = new IJobImpl();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {

		while(true) {
			System.out.println("Please enter your login :");
			String login = sc.next();

			System.out.println("Please enter your password :");
			String password = sc.next();

			boolean result = shopJob.loginCheck(login, password);

			if (result==true) {
				System.out.println("Sucessful connection\n");
				//artDao.readAll();

			}else {
				System.err.println("Wrong input.");
			}
		}
	}
}
