package fr.bankSyst;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
	/** initialization of the map object  
	 * @return map of object epargne
	 */
	public static HashMap<String, Savings> intiSDB() {
		HashMap<String, Savings> savingsDB = new HashMap<String, Savings>();
		savingsDB.put("T659", new Savings("T659", "Dupont", "E605", 9000, 6));
		savingsDB.put("Z784", new Savings("Z784", "Fleury", "H685", 8000, 5));
		savingsDB.put("J546", new Savings("J546", "Leroy", "R965", 1500, 2));
		savingsDB.put("M95L", new Savings("M95L", "Bonnet", "D874", 875, 5));
		savingsDB.put("A01B", new Savings("A01B", "Moreau", "H685", 7500, 5));
		return savingsDB;

	}
	/** initialization of the map of object courant 
	 * @return map of object courant
	 */
	public static HashMap<String, Current> intiCDB() {
		HashMap<String, Current> currentDB = new HashMap<String, Current>(); 
		currentDB.put("T659", new Current("T659", "Dupont", "G836", 6000, -500));
		currentDB.put("Z784", new Current("Z784", "Fleury", "Z513", 8750, -2500));
		currentDB.put("J546", new Current("J546", "Leroy", "D943", 4620, -400));
		currentDB.put("M95L", new Current("M95L", "Bonnet", "F842", 4500, -300));
		currentDB.put("A01B", new Current("A01B", "Moreau", "A946", 7850, -1500));
		return currentDB;
	}
	/** initialization client list
	 * @return lclient list
	 */
	public static ArrayList<Client> initClient() {
		ArrayList< Client> listClient   = new ArrayList<>();
		listClient.add(new Client("T659", "Dupont"));
		listClient.add(new Client("Z784", "Fleury"));
		listClient.add(new Client("J546", "Leroy"));
		listClient.add(new Client("M958", "Bonnet"));
		listClient.add(new Client("A017", "Moreau"));
		return listClient;
	}
	
	public static HashMap<String, Transaction> initTransaction() {
		HashMap<String, Transaction> transactionDB = new HashMap<String, Transaction>();
		return transactionDB;
	}
	
}
