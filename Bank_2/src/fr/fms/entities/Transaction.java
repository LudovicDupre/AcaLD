/**
 * @author El babili - 2022
 * 
 */

package fr.fms.entities;

import java.util.Date;

public abstract class Transaction {
	private double transactionId;
	private Date transactionDate;
	private double amount;
	
	private double accountId;

	public Transaction(double transactionId, Date transactionDate, double amount, double accountId) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + Account.SIMPLE_DATE_FORMAT.format(transactionDate) + ", amount="
				+ amount + ", accountId=" + accountId + "]";
	}

	public double getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountId() {
		return accountId;
	}

	public void setAccountId(double accountId) {
		this.accountId = accountId;
	}
	
}
