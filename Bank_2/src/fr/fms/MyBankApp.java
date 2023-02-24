/**
 * Version 1.0 d'une appli bancaire simplifiée offrant la possibilitée de créer des clients, des comptes bancaires associés et des opérations ou
 * transactions bancaires sur ceux-ci telles que : versement, retrait ou virement 
 * + permet d'afficher l'historique des transactions sur un compte
 * + la gestion des cas particuliers est rudimentaire ici puisque la notion d'exception n'a pas encore été abordée
 * 
 * @author El babili - 2022
 * 
 */

package fr.fms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import fr.fms.business.IBankImpl;
import fr.fms.entities.Account;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.Saving;
import fr.fms.entities.Transaction;



public class MyBankApp {	

	public static Scanner sc = new Scanner(System.in);
	public static IBankImpl bankJob = new IBankImpl();

	public static void main(String[] args) {

		Customer robert = new Customer(1, "Dupont", "Robert", "robert.dupont@xmail.com");
		Customer julie = new Customer(2, "Jolie", "Julie", "julie.jolie@xmail.com");		
		Current firstAccount = new Current(100200300, new Date(), 1500, 200 , robert);
		Saving secondAccount = new Saving(200300400, new Date(), 2000, 5.5, julie);
		bankJob.addAccount(firstAccount);
		bankJob.addAccount(secondAccount);

		List<Customer> listCustomer = Arrays.asList(julie, robert);

		//beginning
		while (true) {

			Account selectedAccount = null;
			//validity check
			selectedAccount = validBankAccount(selectedAccount);

			Customer selectedCustomer = selectedAccount.getCustomer();
			double selectedId =selectedAccount.getAccountId();

			System.out.println("Welcome "+selectedCustomer.getFirstName()+" "+selectedCustomer.getName()+", what do you wish to do? Press the matching key : \n"+ subMenu() );
			System.out.println(bankJob.checkingBalance(selectedId));
			int choice =-1;
			//Main menu
			while(choice!=6) {
				//validity check
				choice =validMenuSelection(choice);
				switch(choice)   {

				case 1 : //deposit
					System.out.println("Enter amount to be deposit :");
					double amountDeposit = sc.nextDouble();
					bankJob.pay(selectedId, amountDeposit);
					System.out.println(bankJob.checkingBalance(selectedId));
					System.out.println(subMenu());
					break;

				case 2 : //withdrawal
					System.out.println("Enter amount to be withdrawn :");
					double amountWithdraw = sc.nextDouble();
					bankJob.withdraw(selectedId, amountWithdraw);
					System.out.println(bankJob.checkingBalance(selectedId));
					System.out.println(subMenu());
					break;

				case 3: // transfer
					Account recipientAccount = null;
					System.out.println("Recipient account :");
					//validity check
					recipientAccount=validBankAccount(recipientAccount);
					System.out.println("Please enter amount to be transfered :");
					double amountTransfer = sc.nextDouble();
					bankJob.transfert(selectedId, recipientAccount.getAccountId(), amountTransfer);
					System.out.println(bankJob.checkingBalance(selectedId));
					System.out.println(subMenu());
					break;

				case 4: // info on this account
					System.out.println(selectedAccount+"\n"+subMenu());
					break;

				case 5: // list of operation
					System.out.println(selectedAccount.getListTransactions()+"\n"+subMenu());
					break;
				}
			}
			System.out.println("Goodbye "+selectedAccount.getCustomer().getFirstName()+" "+selectedAccount.getCustomer().getName()+".");
		}
	}
	/** printing subMenu
	 * @return string to print
	 */
	public static String subMenu(){
		return "1 : deposit - 2 : withdrawal - 3 : transfer - 4 : information account - 5 : operation summary - 6 : quit\n\"-------------------------------press the matching key----------------------------------------\"";
	}
	/** method to force the user to enter a correct bank account
	 * @param account to verify, null at first
	 * @return 
	 */
	public static  Account validBankAccount(Account account) {
		String userEntry;
		while (account == null) {
			System.out.println("Please enter a valid account identifier : ");
			userEntry = sc.next();
			while (bankJob.checkInput(userEntry,'0','9')) {
				userEntry = sc.nextLine();	
			}
			try {
				double searchId = Double.parseDouble(userEntry);
				account = bankJob.consultAccount(searchId);
			} catch (NumberFormatException  | NullPointerException e ) {
				System.err.println("There is no letter and symbol in a bank account Id!");
			}
		}
		return account;
	}
	/** method to force the user to choose a desired number
	 * @param choice as negative value
	 * @return choice with a proper value
	 */
	public static int validMenuSelection (int choice) {	
		String userEntry =null;
		while (userEntry == null) {
			System.out.println("Please enter a valid menu choice : ");
			userEntry = sc.next();	
			while (bankJob.checkInput(userEntry,'1','6')) {
				userEntry = sc.nextLine();	
			}
			try {
				choice = Integer.parseInt(userEntry);		
			} catch (NumberFormatException e ) {
				System.err.println("Incorrect Input.");
			}
		}
		return choice;
	}
}
