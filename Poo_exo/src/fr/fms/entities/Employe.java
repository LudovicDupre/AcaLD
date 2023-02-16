package fr.fms.entities;

public class Employe extends Person {

	int salary;
	String company;
	private double CHARGES = 0.20;

	public Employe(String firstName, String lastName, int age, String livingPlace, City city, int salary, String company) {
		super(firstName, lastName, age, livingPlace, city);
		this.salary = salary;
		this.company = company;
	}
	public Employe(String firstName, String lastName, int age, String livingPlace, City city, String company) {
		super(firstName, lastName, age, livingPlace,city);
		this.company = company;
	}
	public Employe (String firstName, String lastName, int age, String livingPlace, Capital capital, int salary, String company) {
		super(firstName, lastName, age, livingPlace, capital);
		this.salary = salary;
		this.company = company;

	}
	public Employe (String firstName, String lastName, int age, String livingPlace, Capital capital, String company) {
		super(firstName, lastName, age, livingPlace, capital);
		this.company = company;
	}
	public Employe() {
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
	@Override
	public int pay() {
		return (int) (salary - salary*CHARGES);
	}
}
