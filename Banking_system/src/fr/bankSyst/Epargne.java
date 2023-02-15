package fr.bankSyst;

public class Epargne extends Client implements Operation{
	
	private String epargneId;
	private double solde;
	private int tauxInteret;
	
	//constructeur 
	public Epargne(String epargneId, double solde, int tauxInteret) {
		this.epargneId = epargneId;
		this.solde = solde;
		this.tauxInteret = tauxInteret;
	}
	//setters getters
	public String getEpargneId() {
		return epargneId;
	}
	public void setEpargneId(String epargneId) {
		this.epargneId = epargneId;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public int getTauxInteret() {
		return tauxInteret;
	}
	public void setTauxInteret(int tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	
	
}
