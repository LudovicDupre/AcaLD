import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.business.IJobImpl;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.BddConnection;
import fr.fms.entities.Article;
import fr.fms.entities.Users;

public class Test_Test {

	public static ArticleDao artDao = new ArticleDao();
	public static IJobImpl shopJob = new IJobImpl();

	public static void main(String[] args) throws SQLException {

		//		method (login , password) return a boolean , only one sql request.
		//		if null?
		String login = "Anderson";
		String password = "Neo";


		Connection conn = BddConnection.getCon();

		String strSql = "SELECT T_Users.Password FROM T_Users WHERE Login ='"+login+"';";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					String rsPassword = resultSet.getString(1);
					System.out.println(rsPassword);
					System.out.println(password);
					
					if (rsPassword.compareTo(password)==0) {
						System.out.println("TRUE");
					} else {
						System.out.println("FALSE");
					}
				}
			}
		}
	}
}
