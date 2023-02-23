package fr.bankSyst;

public class Admin {

	// attributs
	private int idA;
	private String name;

	// constructeurs
	public Admin(int idA, String name) {
		this.idA = idA;
		this.name = name;
	}
	
	// méthodes
	@Override
	public String toString() {
		return "Admin [idA=" + idA + ", name=" + name + "]";
	}

	// Accesseurs
	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}