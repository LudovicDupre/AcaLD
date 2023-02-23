package fr.bankSyst;

import java.util.ArrayList;

public class Account {

	private String accountId;
	private double balance;
	private String creationDate;
	private Client client;
	private ArrayList<Transaction> listTransaction;
	
	public Account(String accountId, double balance, String creationDate, Client client) {
		this.accountId = accountId;
		this.balance = balance;
		this.creationDate = creationDate;
		this.client = client;
		this.client.getListAccount().add(this);
		this.listTransaction =new ArrayList<Transaction>();
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountID) {
		this.accountId = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ArrayList<Transaction> getListTransaction() {
		return listTransaction;
	}
	@Override
	public String toString(){
		return "Account identifier : "+accountId+" , Date of Creation : "+creationDate+" , Balance : "+balance+" , Account owner : "+client;
		}
}
