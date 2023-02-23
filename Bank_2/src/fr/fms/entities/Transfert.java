/**
 * @author El babili - 2022
 * 
 */

package fr.fms.entities;

import java.util.Date;

public class Transfert extends Transaction {

	public Transfert(double transactionId, Date transactionDate, double amount, double accountId) {
		super(transactionId, transactionDate, amount, accountId);		
	}

	@Override
	public String toString() {
		return "Versement : " + super.toString();
	}
	
}
