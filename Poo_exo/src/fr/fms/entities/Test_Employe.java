package fr.fms.entities;

public class Test_Employe {

	public static void main(String[] args) {

		Employe Gate = new Employe("Bill","Gate",65,"USA",new Capital("Washigton", "USA", 7600000, "W-M"),100000,"B&M" );
		Employe Musk = new Employe("Elon","Musk",49,"palo alto",new City("Pretoria", "South Africa", 450000),150000,"Tesla");

		System.out.println(Gate);
		System.out.println(Musk);
	}
}