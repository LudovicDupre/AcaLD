package fr.bankSyst;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
/**
 * @author Les jeunes avec Macron
 */
public class Test_client {

	static Scanner sc = new Scanner(System.in);
	Client client = new Client();

	public static void main(String[] args)  {

		HashMap<String, Savings> savingsDB =  Data.intiSDB();
		HashMap<String, Current> currentDB =  Data.intiCDB();
		//ArrayList< Client> listClient   = Data.initClient();
		HashMap<String, Transaction> transactionDB = Data.initTransaction();
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
				double amountW = sc.nextDouble();
				withdrawalS(accountS,amountW);
				//dateTransaction stored
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 2:		System.out.println("Please enter amount you wish to deposit :");
				double amountD = sc.nextDouble();
				depositS(accountS,amountD);
				String date = dateTransaction(); 
				addTransaction(buildingTransaction(date,amountD, accountS.getIdC(),""),transactionDB);
				System.out.println(iteMap(transactionDB));
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 3:  double initBalanceDebit = accountS.getBalance();
				System.out.println("Please enter amount you wish to move :");
				double amountT = sc.nextDouble();
				withdrawalS(accountS,amountT);
				double newBalanceDebit = accountS.getBalance();
				if (initBalanceDebit==newBalanceDebit) {
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				} else {
					System.out.println("Please enter receiving account :");
					String receivingId = sc.next();
					depositC(currentDB.get(receivingId),amountT);
					System.out.println(dateTransaction());
					//dateTransaction stored
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				}
				}
			}
			System.out.println("Back to account menu\n\n"+mainMenu());
			break;

			case 2 : Current accountC = currentDB.get(identity);
			System.out.println(accountC+"\n");//Current
			System.out.println(opMenu());

			int choice3 = -1;
			while (choice3!=4) {
				choice3 = sc.nextInt();
				while (choice3>4 || choice3<0) {choice3 =sc.nextInt();}
				switch(choice3) {

				case 1: System.out.println("Please enter amount you wish to withdraw :");
				double amountW = sc.nextDouble();
				withdrawalC(accountC,amountW);
				//dateTransaction stored
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 2: 		System.out.println("Please enter amount you wish to deposit :");
				double amountD = sc.nextDouble();
				depositC(accountC,amountD);
				//dateTransaction stored
				System.out.println("Back to operation menu\n\n"+opMenu());
				break;

				case 3: double initBalanceDebit = accountC.getBalance();
				System.out.println("Please enter amount you wish to move :");
				double amountT = sc.nextDouble();
				withdrawalC(accountC,amountT);
				double newBalanceDebit = accountC.getBalance();
				if (initBalanceDebit==newBalanceDebit) {
					System.out.println("Back to operation menu\n\n"+opMenu());
					break;
				} else {
					System.out.println("Please enter receiving account :");
					String receivingId = sc.next();
					depositC(currentDB.get(receivingId),amountT);
					System.out.println(dateTransaction());
					System.out.println("Back to operation menu\n\n"+opMenu());
					//dateTransaction stored
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
	/**
	 *  method to add to balance of current
	 * @param C current account
	 * @return Current object modified
	 */
	public static  Current depositC(Current C, double amount) {
		double newBalance2 = Operation.deposit(C.getBalance(), amount);
		C.setBalance(newBalance2);
		System.out.println(C+"\n");
		return C;
	}
	/**
	 * method to add to balance of savings
	 * @param S savings account
	 * @return Savings object modified
	 */
	public static  Savings depositS(Savings S, double amount) {
		double newBalance2 = Operation.deposit(S.getBalance(), amount);
		S.setBalance(newBalance2);
		System.out.println(S+"\n");
		return S;
	}
	/**
	 * method to substract from balance
	 * @param C object to have one of its balance modified
	 * @return C object modified
	 */
	public static  Current withdrawalC(Current C, double amount) {
		double newBalance = Operation.withdrawal(C.getBalance(), amount,C.getOverdraft());
		C.setBalance(newBalance);
		System.out.println(C+"\n");
		return C;
	}
	/**
	 *  method to substract from balance
	 * @param S object to have one of its balance modified
	 * @return S object modified
	 */
	public static  Savings withdrawalS(Savings S, double amount) {
		double newBalance = Operation.withdrawal(S.getBalance(), amount,0);
		S.setBalance(newBalance);
		System.out.println(S+"\n");
		return S;
	}
	public static Transaction buildingTransaction(String date, double amount, String receivingAccount, String sendingAccount) {
		if (sendingAccount == "") {
			Transaction transaction = new Transaction( amount,  date,  receivingAccount);
			return transaction;
		} else {
			Transaction transaction = new Transaction( amount,  date,  receivingAccount, sendingAccount);
			return transaction;
		}
	}
	public static HashMap<String, Transaction> addTransaction(Transaction T, HashMap<String, Transaction> m) {
		
		m.put(randomId(), T);
		return m;
	}
	private static String randomId() {
		String passwordSet = "0123456789";
		char[] password = new char[8];
		for(int i=0; i<8;i++) {
			int rand =(int) (Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	public static String iteMap(HashMap<String, Transaction> map) {

		String listPart ="List of Transaction:\n";
		for(Entry<String, Transaction> entry : map.entrySet()) {
			String key = entry.getKey();
			Transaction value = entry.getValue();
			listPart +=  "ID transaction: "+key+"; Info transaction : "+value+"\n";
		}
		return listPart;
	}
}