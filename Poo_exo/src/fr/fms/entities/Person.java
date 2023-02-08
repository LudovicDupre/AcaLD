package fr.fms.entities;

public class Person {
	
	String firstName;
	String lastName;
	int age;
	String livingPlace;
	public City city = new City();

	public Person(String firstName, String lastName, int age, String livingPlace, City city) {
		//1-8
		this.firstName = firstName;
		this.lastName = lastName;
		this.age= age;
		this.livingPlace = livingPlace;
		this.city = city;
	}
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age =age;
	}
	public Person() {
	}
	@Override
	public String toString() {
		return lastName+ ",  "+firstName+",  "+age+"ans, habitant "+livingPlace+", Ville de Naissance : "
				+city.getTown()+", "+city.getCountry()+",  "+city.getPopulation()+" d'habitants";
	}
}
