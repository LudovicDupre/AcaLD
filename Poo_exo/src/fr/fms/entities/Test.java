package fr.fms.entities;

public class Test {

	public static void main(String[] args) {
		
		Employe Gate = new Employe("Bill","Gate",65,"USA","B&M",100000 ,new City("Washigton", "USA", 7600000));
		Employe Musk = new Employe("Elon","Musk",49,"palo alto","Tesla",150000 ,new City("Pretoria", "South Africa", 7600000));
		
		System.out.println(Gate);
		System.out.println(Musk);

	}

}
