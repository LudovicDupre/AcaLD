package fr.bankSyst;

public class Transaction {

	// attributs
	String transactionId;
	double amount;
	String date;
	String accountId;

	public Transaction(double amount, String date, String accountId, String transactionId) {
		super();
		this.amount = amount;
		this.date = date;
		this.accountId = accountId;
		this.transactionId = transactionId;

	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReceivingAccount() {
		return accountId;
	}
	public void setReceivingAccount(String accountId) {
		this.accountId = accountId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	@Override
	public String toString() {
		return "Transaction : [Transaction ="+transactionId+", amount=" + amount + ", date=" + date + ", account id=" +accountId+" ]";
	}
	
}
