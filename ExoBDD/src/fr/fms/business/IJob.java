package fr.fms.business;

import java.sql.SQLException;
import fr.fms.entities.Users;

public interface IJob {
	
	public int checkUserLogin(String log)throws SQLException;
	public int checkUserPassword(String pass) throws SQLException;
	public boolean compareUser(int a,int b);
	
}
