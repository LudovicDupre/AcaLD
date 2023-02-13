package fr.fms.entities;

public class Capital extends City {

	public City City = new City();
	private String monument;
	//constructors
	public Capital(String town,String country,int population, String monument) {
		super(town, country, population);
		this.monument =monument;
	}

	@Override
	public String toString() {
		return super.toString()+" d'habitants, monument :  "+monument;
	}
}