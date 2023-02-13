package fr.fms.entities;

public class TestCapitale {

	public static void main(String[] args) {
		
		Capital paris =new Capital("Paris", "France", 2000000, "Tour Eiffel");
		Capital london = new Capital("Londres", "GB", 9400000,"BigBen");
		
		System.out.println(paris);
		System.out.println(london);
	}

}
