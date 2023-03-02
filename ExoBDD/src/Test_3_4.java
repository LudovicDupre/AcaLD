import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.fms.entities.Article;

public class Test_3_4 {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "FMS2023";

		try (Connection connection = DriverManager.getConnection(url,login,password)) {
			String strSql = "SELECT * FROM T_Articles WHERE IdArticles =11;";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(strSql)) {
					while (resultSet.next()) {
					statement.executeUpdate(strSql);
					int rsIdUser =resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsMarque = resultSet.getString(3);
					double rsPrixUnitaire = resultSet.getDouble(4);
					Article article = new Article(rsIdUser,rsDescription,rsMarque,rsPrixUnitaire);
					System.out.println(article.getId()+ "  -  " +article.getDescription()+"  -  "+ article.getBrand()+ "  -  "+article.getPrice());
					}
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
