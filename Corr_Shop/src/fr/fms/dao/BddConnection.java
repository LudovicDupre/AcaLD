/**
 * Gestion de la connexion à la base à partir des données dans le fichier config.properties
 * Afin d'assurer qu'une seule connexion est établie pour tous les composants d'accès aux données,
 * nous avons utilisé ici un Singleton à l'aide du constructeur privé
 * @author El babili - 2023
 */

package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class BddConnection {
	private static Connection connection = null;
	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	
	private static final Logger logger = Logger.getLogger(BddConnection.class.getName());
	
	private BddConnection() {
		try {
			getConfigFile();								
			Class.forName(driver);	
			connection = DriverManager.getConnection(url,login,password);				
			//if(connection != null) logger.info("access bdd success"); 
		}			
		catch (ClassNotFoundException | SQLException e) {
			logger.severe("connection pb : " + e.getMessage());
		}
		catch (FileNotFoundException e) {
			logger.severe("config.properties not found:" + e.getMessage());
		} 
		catch (IOException e) {
			logger.severe("I/O pb : " + e.getMessage());
		}
		catch (Exception e) {
			logger.severe("pb : " + e.getMessage());
		}
	}
	
	/**
	 * méthode qui retourne une connection, si inexistante, il l'a crée une seule fois
	 * @return Connection
	 */
	public static Connection getConnection() {	
		if(connection == null) 	new BddConnection();
		return connection;
	}
	
	/**
	 * méthode qui ouvre le fichier de config d'une connection
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();		
		try (FileInputStream fis = new FileInputStream("files/config.properties")){
			props.load(fis);
		} catch (FileNotFoundException e1) {
			logger.severe("Fichier de config non trouvé " + e1.getMessage());
		} catch (IOException e1) {
			logger.severe("Erreur lecture fichier config " + e1.getMessage());
		}		
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		login = props.getProperty("db.login");
		password = props.getProperty("db.password");
	}
}
