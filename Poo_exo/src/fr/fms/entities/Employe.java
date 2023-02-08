package fr.fms.entities;

public class Employe extends Person {

	int salary;
	String company;
	public City city = new City();
	public Person person = new Person();
	
	public Employe(String firstName, String lastName, int age, String livingPlace, String company, int salary, City city) {
		super(firstName,lastName,age,livingPlace,city);
		this.salary = salary;
		this.company = company;
	}
	public Employe() {
	}
	@Override
	public String toString() {
		return super.toString()+" , Entreprise "+company+" , salaire : "+salary;
	}
}
