package fr.fms.entities;

public class Commerciale extends Employe{

	Employe Employe = new Employe();
	int percent;
	
	public Commerciale(Employe employe, int percent) {
		this.Employe = employe;
		this.percent = percent;
	}
 public String toString() {
	 return firstName+lastName+age+city+company+percent;
 }
}
