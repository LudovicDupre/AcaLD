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

	public static void main(String[] args) {
		//représente l'activité de notre banque
		IBankImpl bankJob = new IBankImpl();
		String userEntry;
		Double number;


		//System.out.println("création puis affichage de 2 comptes bancaires");
		Customer robert = new Customer(1, "Dupont", "Robert", "robert.dupont@xmail.com");
		Customer julie = new Customer(2, "Jolie", "Julie", "julie.jolie@xmail.com");		
		Current firstAccount = new Current(100200300, new Date(), 1500, 200 , robert);
		Saving secondAccount = new Saving(200300400, new Date(), 2000, 5.5, julie);
		bankJob.addAccount(firstAccount);
		bankJob.addAccount(secondAccount);

		List<Customer> listCustomer = Arrays.asList(julie, robert);
		
		//beginning
		int choice2 = -1;
		while (true) {

			Account selectedAccount = null;
			while (selectedAccount == null) {
				
				System.out.println("Please enter a valid account identifier : ");
				userEntry = sc.nextLine();
				
				while (checkInput(userEntry)) {
					
					System.out.println("Please enter a number :");
					userEntry = sc.nextLine();	
					
				}
				double searchId = Double.parseDouble(userEntry);
				selectedAccount = bankJob.consultAccount(searchId);
			}
			
			Customer selectedCustomer = selectedAccount.getCustomer();
			double selectedId =selectedAccount.getAccountId();

			System.out.println("Welcome "+selectedCustomer.getFirstName()+" "+selectedCustomer.getName()+", what do you wish to do? Press the matching key : \n"+ subMenu() );

			choice2 =-1;
			//Main menu
			while(choice2!=6) {
				choice2 = sc.nextInt();
				while (choice2>6 || choice2<0)  {choice2 = sc.nextInt();}
				switch(choice2)   {

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
					System.out.println("Please enter recipient account :");
					long recipientId = sc.nextLong();
					System.out.println("Please enter amount to be transfered :");
					double amountTransfer = sc.nextDouble();
					bankJob.transfert(selectedId, recipientId, amountTransfer);
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
		}
		//System.out.println("GoodBye.");


//				while (selectedAccount == null) {
//		
//					System.out.println("Please enter a valid account identifier : ");
//					userEntry = sc.nextLine();
//					
//					while (checkInput(userEntry)) {
//						
//						System.out.println("Please enter a number :");
//						userEntry = sc.nextLine();	
//						
//					}
//					double searchId = Double.parseDouble(userEntry);


//		while (selectedAccount == null) {
//			
//			System.out.println("Please enter a valid account identifier : ");
//			try {
//				 searchId = sc.nextDouble();
//				//double searchId = Double.parseDouble(userEntry);
//			} catch (InputMismatchException e) {
//				selectedAccount = null;
//				 searchId = (double) 0;
//			}
//			

	
	}
	public static String subMenu(){
		return "1 : deposit - 2 : withdrawal - 3 : transfer - 4 : information account - 5 : operation summary - 6 : quit";
	}
	public static String printMatchingNumber() {
		return "-------------------------------press the matching key----------------------------------------";
	}
	public static double loopingCheck() {
		String userEntry = null;
		Double number;
		while (checkInput(userEntry)) {
			userEntry = sc.nextLine();
		}
		number = Double.parseDouble(userEntry);
		return number;
	}
	public static boolean checkInput(String userEntry) {
		boolean hasString = false;
		int index = 0;
		while(index < userEntry.length()) {

			if (!(userEntry.charAt(index)>= '0' && userEntry.charAt(index)<= '9')) {
				hasString = true;
			}
			index++;
		}
		return hasString;
	}
	
}
