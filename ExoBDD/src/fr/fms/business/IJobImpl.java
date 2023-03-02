package fr.fms.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.fms.dao.BddConnection;

public class IJobImpl implements IJob{

	public int checkUserLogin(String log) throws SQLException {

		int id = -1;
		try (Statement statement = BddConnection.getCon().createStatement()) {
			String strSql = "SELECT * FROM T_Users WHERE Login ='"+log+"';";
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					id =resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	@Override
	public int checkUserPassword(String pass) throws SQLException {

		int id = -1;
		try (Statement statement = BddConnection.getCon().createStatement()) {
			String strSql = "SELECT *  FROM T_Users WHERE Password ='"+pass+"';";
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					id =resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	@Override
	public boolean compareUser(int a,int b) {
		
		boolean check= false;
		if(a!= -1 && a==b) check = true;
		return check;
	}
}