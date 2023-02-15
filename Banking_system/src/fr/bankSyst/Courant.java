package fr.bankSyst;

public class Courant {
	
	private String courantId;
	private double solde;
	private int decouvert;
	
	
	public String getCourantId() {
		return courantId;
	}
	public void setCourantId(String courantId) {
		this.courantId = courantId;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getDecouvert() {
		return decouvert;
	}
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	} 
	
}
