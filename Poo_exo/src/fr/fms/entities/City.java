package fr.fms.entities;

public class City {

	private String country;
	private String town;
	private int population;

	// Constructors
	public City(String town, String country, int population) {
		this.country = country;
		this.town = town;
		this.population = population;
	}
	public City() {		
	}
	public City(String town, String country) {
		this.country = country;
		this.town = town;
	}
	//Getters Setters
	public String getCountry() {
		return country;
	}
	public String getTown() {
		return town;
	}
	public int getPopulation() {
		return population;
	}
	public void setCountry(String c) {
		this.country = c;
	}
	public void setTown(String t) {
		this.town = t;
	}
	public void setPopulation(int p) {
		this.population = p;
	}
	public String toString() {
		return town+" , "+country+" , "+population+" d'habitants";
	}
}
