package fr.fms.entities;

public class Commercial extends Employe{

	private int percent;
	private int MIN_SALARY = 1000;
	private int CA = 5000;
	
	public Commercial(String firstName, String lastName, int age, String livingPlace, City city, String company, int percent) {
		super( firstName,  lastName,  age,  livingPlace,  city,  company);
		this.percent = percent;
	}
	//Setters Getters
	public void setPercent(int i) {
		if (i<0) {
			setPercent(MIN_SALARY);
		} else {
			this.percent =i;
		}
	}
	public int pay() {
		return  CA*(percent/100);
	}
}
