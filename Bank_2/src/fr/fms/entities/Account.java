/**
 * @author El babili - 2022
 * 
 */

package fr.fms.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Account {
	private double accountId;
	private Date creationDate;
	private double balance;
	private Customer customer;
	static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private ArrayList<Transaction> listTransactions;
	
	public Account(double accountId, Date creationDate, double balance, Customer customer) {
		this.accountId = accountId;
		this.creationDate = creationDate;
		this.balance = balance;
		//Todo : gestion du cas particulier de client non instancié !
		this.customer = customer;
		this.customer.getListAccounts().add(this);		//lorsque j'ajoute un compte à un client, 
														//j'ajoute à la liste de comptes du client ce nouveau compte
		this.listTransactions = new ArrayList<Transaction>();
	}
	public Account() {
	}
	
	@Override
	public String toString() {
		return " [accountId=" + accountId + ", creationDate=" + SIMPLE_DATE_FORMAT.format(creationDate) + ", balance=" + balance + ", \n\t" + customer ;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Transaction> getListTransactions() {
		return listTransactions;
	}
}
