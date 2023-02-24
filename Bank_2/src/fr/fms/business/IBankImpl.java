package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.entities.Account;
import fr.fms.entities.Current;
import fr.fms.entities.Customer;
import fr.fms.entities.SimilarAccountException;
import fr.fms.entities.Transaction;
import fr.fms.entities.Transfert;
import fr.fms.entities.withdrawal;

/**
 * @author El babili - 2022
 * Implémentation de la couche métier de l'appli bancaire
 */
public class IBankImpl implements IBank {
	private HashMap<Double,Account>	accounts;
	private HashMap<Double,Customer>	customers;
	//private HashMap<Long,Transaction>	transactions;

	private long numTransactions;

	public IBankImpl() {
		accounts = new HashMap<Double,Account>();		
		customers = new HashMap<Double,Customer>();
		numTransactions = 1;	//ToDo en attendant insertion en base, incrémentation automatique
	}

	/** méthode qui ajoute un compte bancaire instancié à partir d'un client existant
	 * @param Account est un compte bancaire appartenant à un client
	 */
	@Override
	public void addAccount(Account account) {
		accounts.put(account.getAccountId(), account);		// ajouter un compte à ma liste, s'il existe déjà, ça ne marche pas	
		Customer customer = account.getCustomer(); 			// s'agissant du client de ce compte -> ToDo s'il n'existe pas dans le compte ajouté !
		customers.put(customer.getCustomerId(), customer);  // je veux le rajouter à ma liste de clients s'il n'existe pas

		//l'étape suivante n'est pas indispensable ici puisque nous ajoutons le client à notre collection de clients ci-dessus
		//en revanche, compte tenu du diagramme de classe, un client dispose d'une liste de comptes
		addAccountToCustomer(customer, account);			// j'ajoute au client son nouveau compte bancaire uniquement s'il ne l'a pas déjà
	}

	/**
	 * méthode qui vérifie si un compte existe
	 * @return Account si existe, null sinon
	 */
	@Override
	public Account consultAccount(double accountId) {		
		Account account = accounts.get(accountId);
		if(account == null)	{ 
			System.out.println("You are asking for a non-existing account !");
		}
		return account;
	}

	/**
	 * méthode qui effectue le versement d'un montant sur un compte s'il existe
	 * @param accountId correspond à l'id du compte sur lequel effectuer le versement
	 * @param amount correspond au montant à verser
	 */
	@Override
	public void pay(double accountId, double amount) {				
		Account account = consultAccount(accountId);
		if(account != null)	{
			account.setBalance(account.getBalance() + amount);
			Transaction trans = new Transfert(numTransactions++,new Date(),amount,accountId);
			account.getListTransactions().add(trans);				// création + ajout d'une opération de versement
		}
	}
	/**
	 * méthode qui effectue le retrait d'un montant sur un compte existant tout en gérant le découvert autorisé qqsoit le compte
	 * @param accountId correspond à l'id du compte sur lequel effectuer le retrait
	 * @param amount correspond au montant à retirer 
	 */
	@Override
	public boolean withdraw(double accountId, double amount) {			
		Account account = consultAccount(accountId);
		if(account != null) {
			double capacity = 0;
			if(account instanceof Current) {
				capacity = account.getBalance() + ((Current)account).getOverdraft();	//solde + decouvert autorisé				
			}
			else capacity = account.getBalance();
			if(amount <= capacity) {
				account.setBalance(account.getBalance() - amount);
				Transaction trans = new withdrawal(numTransactions++,new Date(),amount,accountId);
				account.getListTransactions().add(trans);		// création + ajout d'une opération de retrait
			}
			else {
				System.err.println("vous avez dépassé vos capacités de retrait !");
				return false;
			}
		}	
		else return false;	//compte inexistant -> retrait impossible
		return true;	//retrait effectué
	}
	/**
	 * méthode qui effectue un virement d'un compte src vers un compte dest, décomposé en 2 étapes : retrait puis versement
	 * @param accIdSrc correspond à l'id du compte source
	 * @param accIdSrc correspond à l'id du compte destinataire
	 * @param amount correspond au montant à virer
	 */
	@Override
	public void transfert(double accIdSrc, double accIdDest, double amount) throws SimilarAccountException {	//virement
		if(accIdSrc == accIdDest)	throw new SimilarAccountException();
		else {
			if(withdraw(accIdSrc, amount)) {		//retrait si c'est possible
				pay(accIdDest, amount);				//alors versement
			}
			else System.err.println("virement impossible");
		}
	}
	/** Renvoi la liste des transactions sur un compte
	 * @param accountId 
	 * @return ArrayList<Transaction>
	 */
	@Override
	public ArrayList<Transaction> listTransactions(double accountId) {
		return consultAccount(accountId).getListTransactions();
	}
	/**
	 * Renvoi la liste des comptes de notre banque
	 * @return ArrayList<Account>
	 */
	public ArrayList<Account> listAccounts() {		
		return new ArrayList<Account> (accounts.values());
	}
	/**
	 * Ajoute un compte à l'objet client
	 * @param customer
	 * @param account
	 */
	private void addAccountToCustomer(Customer customer, Account account) {
		boolean exist = false;
		for(Account acc : customer.getListAccounts()) {
			if(acc.getAccountId() == account.getAccountId()) {
				exist = true;
				break;
			}
		}
		if(exist == false) customer.getListAccounts().add(account);
	}
	/** method to return the balance
	 * @param accountId og the account user wish to check
	 * @return String for printing
	 */
	public String checkingBalance(double accountId) {
		Account account = consultAccount(accountId);
		double balance = account.getBalance();
		return "Balance of your account : "+ balance+"\n";
	}
}
