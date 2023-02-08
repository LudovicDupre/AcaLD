package fr.fms.entities;

public class Capital extends City {
	
	public City City = new City();
	public String monument;
	
	public Capital(String town,String country,int population, String monument) {
		super.town = town;
		super.country =country;
		super.population =population;
		this.monument =monument;

	}
	@Override
	public String toString() {
		return town+" , "+country+" , "+population+" d'habitants, monument :  "+monument;
	}
}