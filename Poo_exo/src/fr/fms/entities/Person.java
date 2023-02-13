package fr.fms.entities;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private String livingPlace;
	private City city;

	public Person(String firstName, String lastName, int age, String livingPlace, City city) {
		//1-8
		this.firstName = firstName;
		this.lastName = lastName;
		this.age= age;
		this.livingPlace = livingPlace;
		this.city = city;
	}
	public Person(Person person, City city) {
		 
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
	//getter
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getLivingPlace() {
		return livingPlace;
	}
	public int getAge() {
		return age;
	}
	
	
	@Override
	public String toString() {
		return lastName+ ",  "+firstName+",  "+age+"ans, habitant "+livingPlace+", Ville de Naissance : "
				+city.getTown()+", "+city.getCountry()+",  "+city.getPopulation()+" d'habitants";
	}
}