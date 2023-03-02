package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public void create(Article obj) throws SQLException {
		//Connection conn = BddConnection.getConnection();

		String strSql = "INSERT INTO T_Articles (Descritption , Brand, UnitaryPrice)"
				+"VALUES (?,?,?)";
		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql)) {
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getDescription());
			statement.setString(3, obj.getBrand());
			statement.setDouble(4, obj.getPrice());
			int rows =statement.executeUpdate(strSql);
			if (rows>0) {
				System.out.println("New article has been created.");
			}
		}
	}

	@Override
	public Article read(int id) throws SQLException {
		Article article = null;
		Connection conn = BddConnection.getCon();

		String strSql = "SELECT * FROM T_Articles"
		 + "WHERE IdArticles = "+id+";";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser =resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsMarque = resultSet.getString(3);
					double rsPrixUnitaire = resultSet.getDouble(4);
					article = (new Article(rsIdUser,rsDescription,rsMarque,rsPrixUnitaire));
				}
			}
		}
		return article;
	}

	@Override
	public boolean update(Article obj) throws SQLException {

		//Connection conn = BddConnection.getConnection();

		String strSql = "UPDATE t_articles SET IdArticles = ?, Description = ?, Brand = ?, UnitaryPrice = ?";
		strSql += "WHERE IdArticles = ?;";
		boolean rowUpdated = false;

		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql)) {
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getDescription());
			statement.setString(3, obj.getBrand());
			statement.setDouble(4, obj.getPrice());
			rowUpdated = statement.executeUpdate(strSql)>0;
		}
		return rowUpdated;
	}

	@Override
	public boolean delete(Article obj) throws SQLException {
		//Connection conn = BddConnection.getConnection();
		String strSql = "DELETE FROM T_Articles WHERE Id = ?";
		boolean rowDeleted = false;

		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql))
		{
			statement.setInt(1, obj.getId());
			rowDeleted = statement.executeUpdate(strSql)>0;
		}
		return rowDeleted;
	}

	@Override
	public ArrayList<Article> readAll() throws SQLException {

		ArrayList<Article> articles = new ArrayList<Article>();

		Connection conn = BddConnection.getCon();

		String strSql = "SELECT * FROM T_Articles";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser =resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsMarque = resultSet.getString(3);
					double rsPrixUnitaire = resultSet.getDouble(4);
					articles.add(new Article(rsIdUser,rsDescription,rsMarque,rsPrixUnitaire));
				}
			}
		}
		return articles;
	}
}
