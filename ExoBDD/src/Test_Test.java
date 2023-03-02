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

		//		ArrayList<Article> fullArticles = artDao.readAll();
		//		for (Article a: fullArticles)
		//			System.out.println(a.getId()+ "  -  " + a.getDescription()+"  -  "+ a.getBrand()+ "  -  "+a.getPrice());

		int id = -1;
		try (Statement statement = BddConnection.getCon().createStatement()) {
			String strSql = "SELECT * FROM T_Users WHERE Login ='Skywalker';";
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					id =resultSet.getInt(1);
					
					System.out.println(id);

				}
			}
		}
	}
}
