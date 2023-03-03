package fr.fms.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.fms.dao.BddConnection;

public class IJobImpl implements IJob{


	@Override
	public boolean loginCheck(String log, String pass) throws SQLException{


		Connection conn = BddConnection.getCon();
		boolean check= false;
		String strSql = "SELECT T_Users.Password FROM T_Users WHERE Login ='"+log+"';";

		try (Statement statement = conn.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					String rsPassword = resultSet.getString(1);


					if (rsPassword.compareTo(pass)==0) {
						check = true;
					} else {
						check = false;
					}
				}
			}
		}
		return check;
	}
}