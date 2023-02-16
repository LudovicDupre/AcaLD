package fr.bankSyst;

public class Savings extends Client implements Operation{
	
	private String savingsId;
	private double balance;
	private int interestsRate;
	
	//constructeur 
	public Savings(String epargneId, double balance, int interestsRate) {
		this.savingsId = epargneId;
		this.balance = balance;
		this.interestsRate = interestsRate;
	}
	public Savings() {
	}
	//setters getters
	public String getSavingsId() {
		return savingsId;
	}
	public void setSavingsId(String savingsId) {
		this.savingsId = savingsId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getInterestsRate() {
		return interestsRate;
	}
	public void setTauxInteret(int interestsRate) {
		this.interestsRate = interestsRate;
	}
	@Override
	public String toString() {
		return " Savings Accounts : \n Balance : "+balance+"\n Interests rate: "+interestsRate;
	}
}
