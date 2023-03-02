package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.Users;

public class UserDao implements Dao <Users>{

	@Override
	public void create(Users obj) throws SQLException {

		String strSql = "INSERT INTO T_Users (IdUsers , Login, Password)"
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

		String strSql = "SELECT * FROM T_User"
				+ "WHERE IdUsers = "+id+";";

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

		String strSql = "UPDATE T_Users SET IdUsers = ?, Login = ?, Password = ?";
		strSql += "WHERE IdUsers = ?;";
		boolean rowUpdated = false;

		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql)) {
			statement.setInt(1, obj.getIdUSer());
			statement.setString(2, obj.getLogin());
			statement.setString(3, obj.getPassword());
			rowUpdated = statement.executeUpdate(strSql)>0;
		}
		return rowUpdated;
	}

	@Override
	public boolean delete(Users obj) throws SQLException {

		String strSql = "DELETE FROM T_Users WHERE Id = ?";
		boolean rowDeleted = false;

		try (PreparedStatement statement = BddConnection.getCon().prepareStatement(strSql))
		{
			statement.setInt(1, obj.getIdUSer());
			rowDeleted = statement.executeUpdate(strSql)>0;
		}
		return rowDeleted;
	}

	@Override
	public ArrayList<Users> readAll() throws SQLException {
		
		ArrayList<Users> users = new ArrayList<Users>();

		Connection conn = BddConnection.getCon();

		String strSql = "SELECT * FROM T_Users";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser =resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					users.add(new Users(rsIdUser,rsLogin,rsPassword));
				}
			}
		}
		return users;
	}
}
