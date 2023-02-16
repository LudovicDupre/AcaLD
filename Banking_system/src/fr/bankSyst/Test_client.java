package fr.bankSyst;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test_client {

	static Scanner sc = new Scanner(System.in);
	Client client = new Client();

	public static void main(String[] args)  {

		HashMap<String, Savings> savingsDB =  intiSDB();
		HashMap<String, Current> currentDB =  intiCDB();
		ArrayList< Client> listClient   = initClient();

		System.out.println("Who are you?"); // replace connexion
		String identity = sc.next();

		System.out.println(mainMenu());
		int choice1 =-1;
		while(choice1!=3) {
			choice1 = sc.nextInt();
			while (choice1>3 || choice1<0)  {choice1 = sc.nextInt();}
			switch(choice1)   {

			case 1 :  Savings accountS = savingsDB.get(identity);
			System.out.println(accountS+"\n"); //Savings
			System.out.println(opMenu());

			int choice2 = -1;
			while (choice2!=4) {
				choice2 = sc.nextInt();
				while (choice2>4 || choice2<0) {choice2 =sc.nextInt();}

				switch(choice2) {

				case 1: System.out.println("Please enter amount you wish to withdraw :");
				int amountW = sc.nextInt();
				double newBalance = Operation.withdrawal(accountS.getBalance(), amountW,0);
				accountS.setBalance(newBalance);
				System.out.println(accountS+"\n");
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 2: System.out.println("Please enter amount you wish to deposit :");
				int amountD = sc.nextInt();
				double newBalance2 = Operation.deposit( accountS.getBalance(), amountD);
				accountS.setBalance(newBalance2);
				System.out.println(accountS+"\n");
				System.out.println("Back to operation menu\n\n"+opMenu()); 
				break;

				case 3: System.out.println("Please enter amount you wish to move :");
				int amountT = sc.nextInt();
				System.out.println("Please enter receiving account :");
				String receivingId = sc.next();
				double initBalanceDebit = accountS.getBalance();
				double newBalanceDebit = Operation.withdrawal(accountS.getBalance(),amountT,0);
				accountS.setBalance(newBalanceDebit);
				if (initBalanceDebit==newBalanceDebit) {
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				} else {
					Current receivingAccount= currentDB.get(receivingId);
					double newBallanceReceivingAccount= Operation.deposit(receivingAccount.getBalance(), amountT);
					accountS.setBalance(newBallanceReceivingAccount);

					System.out.println(dateTransaction());
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				}

				} System.out.println("Back to account menu\n\n"+mainMenu());
				break;
			}
			case 2 : Current accountC = currentDB.get(identity);
			System.out.println(accountC+"\n");//Current
			System.out.println(opMenu());

			int choice3 = -1;
			while (choice3!=4) {
				choice3 = sc.nextInt();
				while (choice3>4 || choice3<0) {choice3 =sc.nextInt();}
				switch(choice3) {

				case 1: System.out.println("Please enter amount you wish to withdraw :");
				int amountW = sc.nextInt();
				double newBalance = Operation.withdrawal(accountC.getBalance(), amountW,accountC.getOverdraft());
				accountC.setBalance(newBalance);
				System.out.println(accountC+"\n");
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 2: System.out.println("Please enter amount you wish to deposit :");
				int amountD = sc.nextInt();
				double newBalance2 = Operation.deposit(accountC.getBalance(), amountD);
				accountC.setBalance(newBalance2);
				System.out.println(accountC+"\n");
				System.out.println("Back to operation menu\n\n"+opMenu()); 
				break;

				case 3: System.out.println("Please enter amount you wish to move :");
				int amountT = sc.nextInt();
				System.out.println("Please enter receiving account :");
				String receivingId = sc.next();
				double initBalanceDebit = accountC.getBalance();
				double newBalanceDebit = Operation.withdrawal(accountC.getBalance(),amountT,accountC.getOverdraft());
				accountC.setBalance(newBalanceDebit);
				if (initBalanceDebit==newBalanceDebit) {
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				} else {
					Current receivingAccount= currentDB.get(receivingId);
					double newBallanceReceivingAccount= Operation.deposit(receivingAccount.getBalance(), amountT);
					accountC.setBalance(newBallanceReceivingAccount);
					System.out.println(dateTransaction());
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				}
				}
			}
			System.out.println("Back to account menu\n\n"+mainMenu());
			break;
			}
		}
		System.out.println("GoodBye.");
	}
	/** initialization of the map object  
	 * @return map of object epargne
	 */
	public static HashMap<String, Savings> intiSDB() {
		HashMap<String, Savings> savingsDB = new HashMap<String, Savings>(); 
		Savings e1 = new Savings("E605", 9000, 6);
		Savings e2 = new  Savings("H685", 8000, 5);
		Savings e3 = new  Savings("R965", 1500, 2);
		Savings e4 = new  Savings("D874", 875, 5);
		Savings e5 = new  Savings("H685", 7500, 5);
		savingsDB.put("T65R", e1);
		savingsDB.put("Z78Q", e2);
		savingsDB.put("J546", e3);
		savingsDB.put("M95L", e4);
		savingsDB.put("A01B", e5);
		return savingsDB;

	}
	/** initialization of the map of object courant 
	 * @return map of object courant
	 */
	public static HashMap<String, Current> intiCDB() {
		HashMap<String, Current> currentDB = new HashMap<String, Current>(); 
		Current c1 =  new Current("G836", 6000, -500);
		Current c2 = new  Current("Z513", 8750, -2500);
		Current c3 = new  Current("D943", 4620, -400);
		Current c4 = new  Current("F842", 4500, -300);
		Current c5 = new  Current("A946", 7850, -1500);
		currentDB.put("T65R", c1);
		currentDB.put("Z78Q", c2);
		currentDB.put("J546", c3);
		currentDB.put("M95L", c4);
		currentDB.put("A01B", c5);
		return currentDB;
	}
	/** initialization client list
	 * @return lclient list
	 */
	public static ArrayList<Client> initClient() {
		ArrayList< Client> listClient   = new ArrayList<>();
		listClient.add(new Client("T65R", "Dupont"));
		listClient.add(new Client("Z78Q", "Fleury"));
		listClient.add(new Client("J546", "Leroy"));
		listClient.add(new Client("M95L", "Bonnet"));
		listClient.add(new Client("A01B", "Moreau"));
		return listClient;
	}
	/**
	 * init main menu
	 * @return main menu
	 */
	public static  String  mainMenu() {
		return "Select an account :\n 1 - Savings account. \n 2 - Current account.  \n 3 - Leave the app.";
	}
	/**
	 * init operation menu
	 * @return operation menu
	 */
	public static String opMenu() {
		return "Select an operation :\n1 - Withdrawal. \n2 - Deposit. \n3 - Transfer. \n4 - Back to main menu.  ";
	}
	/** method to get the date of the transaction
	 * @return dateFormatted 
	 */
	public static String dateTransaction() {	
		LocalDate date = LocalDate.now();
		DateTimeFormatter formtter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateFormatted = date.format(formtter);
		return dateFormatted;
	}
}
