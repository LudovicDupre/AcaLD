package fr.fms.entities;

public class City {

	public String country;
	public String town;
	public int population;
	
	public static int runCount;
	
	public City(String town, String country, int population) {
		this.country = country;
		this.town = town;
		this.population = population;
		runCount++;
	}
	public City() {		
	}
	public City(String town, String country) {
		this.country = country;
		this.town = town;
	}
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
	//3
//	public void print3(String t, int p) {
//		System.out.println("[Ville : "+t+"] [pays : unkown] [nombre d'habitants : "+p+" ]");
//		String country = getCountry();
//		System.out.println("[Ville : "+t+"] [pays : "+country+"] [nombre d'habitants : "+p+" ]");
//	}
	//4
	public String display() {
		String result ="ville de "+getTown()+" en "+getCountry()+" ayant "+getPopulation()+" habitants";
		return result;
	}
	public String toString() {
		return "Ville de Naissance : "+town+" , "+country+" , "+population+" d'habitants";
	}
	//7
	public static int getNumberRunCount() {
		return runCount;
	}
}
