package fr.bankSyst;

public class Savings extends Account {
	
	private double rate;

	public Savings(String accountId, double balance, String creationDate, double rate, Client client) {
		super(accountId, balance, creationDate, client);
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Saving Account : " + super.toString() +  ",\n\t\t  rate=" + rate + "]";
	}
}
