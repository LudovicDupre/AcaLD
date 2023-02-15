package fr.bankSyst;

public class Courant extends Client  implements Operation{
	
	private String courantId;
	private double solde;
	private int decouvert;
	
	//Constructeur
	public Courant( String courantId, double solde, int decouvert) {
		this.courantId = courantId;
		this.solde = solde;
		this.decouvert = decouvert;
	}
	
	//setters getters
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
