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

public class Test_3_0  {
	
	public static void main(String args[]) throws Exception {
		
		ArrayList<Article> articles = new ArrayList<Article>();

		
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
			for (Article a: articles)
				System.out.println(a.getId()+ "  -  " + a.getDescription()+"  -  "+ a.getBrand()+ "  -  "+a.getPrice());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}