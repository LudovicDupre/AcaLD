package fr.fms.business;

import java.util.ArrayList;
import fr.fms.entities.Account;
import fr.fms.entities.Transaction;

/**
 * @author El babili - 2022
 * @since 1.0
 * Interface qui représente la couche métier de l'application bancaire, reprenant fonctionnalités du doc de spécifications fonctionnelles 
 */

public interface IBank {
	public void addAccount(Account account);							//ajoute un compte associé à un client à notre banque
	public Account consultAccount(double accountId);						//renvoi le compte correspondant à l'id 
	public void pay(double accountId, double amount);						//faire un versement sur un compte 
	public boolean withdraw(double accountId, double amount);				//faire un retrait sur un compte
	public void transfert(double accIdSrc, double accIdDest, double amount);	//faire un virement d'un compte source vers destination
	public ArrayList<Transaction> listTransactions(double accountId); 	//renvoi la liste des opérations sur un compte donné
}
