package fr.bankSyst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Test_admin {

	public static void main(String[] args) {

		HashMap<String, Savings> savingsDB =  Data.intiSDB();
		HashMap<String, Current> currentDB =  Data.intiCDB();
		ArrayList< Client> listClient   = Data.initClient();
		

		Scanner sc = new Scanner(System.in);

		int choice1 = -1;
		
		System.out.println(mainMenu());
		while (choice1 != 3) {
			choice1 = sc.nextInt();
			while (choice1 > 3 || choice1 < 0) {
				choice1 = sc.nextInt();
			}
			switch (choice1) {

			case 1: // first sub-menu

				System.out.println("Client List:");
				int count = 1;

				for (Client c : listClient) {
					System.out.println(count + ": " + c);
					System.out.println("--------------");
					count++;
				}
				
				System.out.println("Write his ID then press enter.");
				String existingCustomer = sc.next();
				existingCustomer = existingCustomer.toUpperCase();
				
				Client clientChoose = null;
				
				for(Client client : listClient) {
					if(client.getIdC().equals(existingCustomer)) {
						clientChoose = client;
					}
				}
				
				if(clientChoose!=null) {
					if(currentDB.containsKey(existingCustomer)) {
						System.out.println(currentDB.get(existingCustomer));
					} else {
						System.out.println("New current account to create");
						generateCurrent(currentDB, sc, clientChoose);
						System.out.println("Congratulation ! New current account is create");
					}
					
					if(savingsDB.containsKey(existingCustomer)) {
						System.out.println(savingsDB.get(existingCustomer));
					} else {
						System.out.println("New saving account to create");
						generateSavings(savingsDB, sc, clientChoose);
						System.out.println("Congratulation ! New saving account is create");
					}
				} else {
					System.out.println("The client doesn't exist !");
				}
				
				
				System.out.println(mainMenu());
				choice1 = sc.nextInt();

			case 2: // second sub-menu
				String iDRandomC = generateIDCurrent();

				System.out.println("Entrer le nom du nouveau client");
				String newClient = sc.next();
				
				Client newOneClient = new Client(iDRandomC, newClient);
				listClient.add(newOneClient);
				
				System.out.println("Pour Le Client : " + newClient + ", ID: " + iDRandomC + " souhaitez vous créer:"
						+ "\nTapez: 1 puis Entrer pour un compte Courant"
						+ "\nTapez: 2 puis Entrer pour un compte Epargne");
				
				int choice3 = -1;
				while (choice3 != 3) {
					choice3 = sc.nextInt();
					while (choice3 < 3 || choice3 > 0) {
						switch (choice3) {
						case 1:
							generateCurrent(currentDB, sc, newOneClient);
							break;

						case 2:
							generateSavings(savingsDB, sc, newOneClient);
							break;
						}
						break;
					}
					
					break;
				}
				System.out.println(mainMenu());
				choice1 = sc.nextInt();
			case 3 : 
				System.out.println("Au revoir");
				
				
				
			}
		}

	

	}
/**
 *   method to generate object saving
 * @param savingsDB 
 * @param scanner input user
 * @param newOneClient
 */
	private static void generateSavings(HashMap<String, Savings> savingsDB, Scanner scanner, Client newOneClient) {
		System.out.println("Choisir un taux d'intérêts: ");
		int interestsRate = Integer.parseInt(scanner.next());

		String iDRandomCurrent = generateIDCurrent();

		savingsDB.put(newOneClient.getIdC(),
				new Savings(newOneClient.getIdC(), newOneClient.getName(), iDRandomCurrent, 0, interestsRate));

		for (String c : savingsDB.keySet()) {
			if (c == newOneClient.getIdC()) {
				System.out.println("Trouvé " + savingsDB.get(c));
			}
		}
	}

	private static void generateCurrent(HashMap<String, Current> currentDB, Scanner scanner, Client newOneClient) {
		System.out.println("Choisir un découvert autorisé:" + "\nEcrire le Nombre, il sera en négatif:");
		int authorizedOverdraft = Integer.parseInt(scanner.next());

		String iDRandomCurrent = generateIDCurrent();

		currentDB.put(newOneClient.getIdC(),
				new Current(newOneClient.getIdC(), newOneClient.getName(), iDRandomCurrent, 0, -authorizedOverdraft));

//		for (String c : currentDB.keySet()) {
//			if (c == newOneClient.getIdC()) {
//				System.out.println("Trouvé " + currentDB.get(c));
//			}
//		}
	}

	private static String generateIDCurrent() {
		Random random = new Random();
		int iDRandom;
		iDRandom = random.nextInt(998 - 100);
		String iDRandomS = String.valueOf(iDRandom);

		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'a');

		String code = c + iDRandomS;

		code = code.toUpperCase();

		return code;
	}

 public static String mainMenu() {
	 return "Do you wish to create a new client or find one already existing?\nPress: 1 then Enter to select a client."
				+ "\nPress: 2 then Enter to create a new one."
				+ "\nPress: 3 then Enter to leave the app.";
 }
 }