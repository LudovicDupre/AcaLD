/**
 * @author El babili - 2022
 * 
 */

package fr.fms.entities;

import java.util.Date;

public class withdrawal extends Transaction {

	public withdrawal(double transactionId, Date transactionDate, double amount, double accountId) {
		super(transactionId, transactionDate, amount, accountId);
	}
	
	@Override
	public String toString() {
		return "Retrait : " + super.toString();
	}
}
