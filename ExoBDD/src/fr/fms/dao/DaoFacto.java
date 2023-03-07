package fr.fms.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFacto {

	public static Connection connection = BddConnection.getCon();
	
	public static Dao getUserDAO() {
		return new UserDao(connection);
	}
	
	public static Dao getArticleDAO() {
		return new ArticleDao(connection);
	}
}
