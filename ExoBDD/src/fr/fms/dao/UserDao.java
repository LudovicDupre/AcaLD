package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.Users;

public class UserDao implements Dao <Users>{

	@Override
	public void create(Users obj) throws SQLException {
		String strSql = "INSERT INTO T_Users (Descritption , Brand, UnitaryPrice)"
				+"VALUES (?,?,?)";
		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql)) {
			statement.setInt(1, obj.getIdUSer());
			statement.setString(2, obj.getLogin());
			statement.setString(3, obj.getPassword());
			int rows =statement.executeUpdate(strSql);
			if (rows>0) {
				System.out.println("New User has been created.");
			}
		}
		
	}

	@Override
	public Users read(int id) throws SQLException {
		Users user = null;
		Connection conn = BddConnection.getCon();

		String strSql = "SELECT * FROM T_Articles"
		 + "WHERE IdArticles = "+id+";";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser =resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					user = (new Users(rsIdUser,rsLogin,rsPassword));
				}
			}
		}
		return user;
	}

	@Override
	public boolean update(Users obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Users obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Users> readAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
