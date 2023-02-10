package fr.fms.entities;

public class Employe extends Person {

	int salary;
	String company;
	public City city = new City();
	public Person person = new Person();
	
	public Employe(Person person, String company, int salary, City city) {
		super(person,city);
		this.salary = salary;
		this.company = company;
	}
	public Employe(Employe employe) {
		get
	}
	@Override
	public String toString() {
		return super.toString()+" , Entreprise "+company+" , salaire : "+salary;
	}
	//getters and setters
	public void setSalary(int salary) {
		this.salary= salary;
	}
	public void setCompany(String company) {
		this.company= company;
	}
	public String getCompany() {
		return company;
	}
	public int getSalary() {
		return salary;
	}
}
