import java.sql.SQLException;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFacto;
import fr.fms.entities.Article;

public class TestDao {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("");
		Dao<Article> articleDao = DaoFacto.getArticleDAO();
		for (int i=1; i<5;i++ ) {
			Article article = articleDao.read(i);
			System.out.println("\tArticle n°"+article.getId()+" - Descritption : "+article.getDescription()+" - Brand : "+article.getBrand()+" - Unitary Price : "+article.getPrice());
		}
	}

}
