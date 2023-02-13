package fr.fms.entities;

public class Test_Commercial {

	public static void main(String[] args) {
		
		Commercial Dupont = new Commercial("Dupont","Robert",49,"rue des rosiers à Toulouse", new City("Limoges","France",133000),"brico", 5 );

		System.out.println(Dupont);
	}

}
