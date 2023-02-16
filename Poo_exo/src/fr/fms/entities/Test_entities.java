package fr.fms.entities;

public class Test_entities {
	
	public static void main(String args[]) {
		
		Person[] pers = new Person[3];
		
		pers[0] =  new Employe("Bill","Gate",65,"USA",new Capital("Washigton", "USA", 7600000, "W-M"),100000,"B&M" );
		pers[1] = new Employe("Elon","Musk",49,"palo alto",new City("Pretoria", "South Africa", 450000),150000,"Tesla");
		pers[2] = new Commercial("Dupont","Robert",49,"rue des rosiers à Toulouse", new City("Limoges","France",133000),"brico", 5 );
		
		for (Person guy : pers) {
			System.out.println(guy);
		}
		
		System.out.println("--------------");
		
		for (Person guy : pers) {
			System.out.println("Salaire mensuel de "+ guy.getFirstName()+" "+guy.getLastName()+" : "+ guy.pay());
		}
	}
}
