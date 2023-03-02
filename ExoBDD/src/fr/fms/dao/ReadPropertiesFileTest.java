package fr.fms.dao;

import java.io.*;
import java.util.*;

public class ReadPropertiesFileTest {
	
   public static void main(String args[]) throws IOException {
	   
      Properties prop = readPropertiesFile("C:\\Users\\DupreL\\eclipse-workspace\\ExoBDD\\lib\\config.properties");
      System.out.println("username: "+ prop.getProperty("db.login"));
      System.out.println("password: "+ prop.getProperty("db.password"));
      System.out.println("url: "+ prop.getProperty("db.url"));
      System.out.println("driver: "+ prop.getProperty("db.driver.class"));
   }
   
   public static Properties readPropertiesFile(String fileName) throws IOException {
	   
      FileInputStream fis = null;
      Properties prop = null;
      
      try {
         fis = new FileInputStream(fileName);
         prop = new Properties();
         prop.load(fis);
      } catch(FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         fis.close();
      }
      return prop;
   }
}
