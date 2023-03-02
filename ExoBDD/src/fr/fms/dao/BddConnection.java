package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/** Singleton  BddConnection
 * @author DupreL + Haikel Fazzani
 *
 */
public class BddConnection  {

	private static Connection conn;

	static 
	{
		try 
		{
			Properties prop = ReadPropertiesFileTest.readPropertiesFile("C:\\Users\\DupreL\\eclipse-workspace\\ExoBDD\\lib\\config.properties");
			Class.forName(prop.getProperty("db.driver.class"));
			conn = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.login"),prop.getProperty("db.password"));
		} 
		catch (Exception e) 
		{
			System.err.println("Exception : ");
			System.err.println(e.getMessage());
		}
	}
	public static Connection getCon() {
		return conn;
	}
}