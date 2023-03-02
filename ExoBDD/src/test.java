import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import fr.fms.dao.BddConnection;
import fr.fms.dao.ReadPropertiesFileTest;
import fr.fms.entities.Article;

import  java.lang.AutoCloseable;

public class test  {
	
	public static void main(String args[]) throws Exception {
		
//		Properties prop = ReadPropertiesFileTest.readPropertiesFile("C:\\Users\\DupreL\\eclipse-workspace\\ExoBDD\\lib\\config.properties");
//		try {
//			Class.forName(prop.getProperty("db.driver.class"));
//
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		String url = prop.getProperty("db.url");
//		String login =  prop.getProperty("db.login");
//		String password = prop.getProperty("db.password");
		ArrayList<Article> articles = new ArrayList<Article>();
//		try (Connection connection = DriverManager.getConnection(url,login,password)) {
		
			String strSql = "SELECT * FROM T_Articles";
			try (Statement statement = BddConnection.getCon().createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(strSql)) {
					while (resultSet.next()) {
						int rsIdUser =resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsMarque = resultSet.getString(3);
						double rsPrixUnitaire = resultSet.getDouble(4);
						articles.add(new Article(rsIdUser,rsDescription,rsMarque,rsPrixUnitaire));
					}
				}
			//}
			for (Article a: articles)
				System.out.println(a.getId()+ "  -  " + a.getDescription()+"  -  "+ a.getBrand()+ "  -  "+a.getPrice());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}