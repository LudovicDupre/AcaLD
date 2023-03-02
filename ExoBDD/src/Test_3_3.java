import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_3_3 {
	
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
			String strSql = "DELETE FROM t_articles  WHERE IdArticles = 14;";
			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(strSql);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
