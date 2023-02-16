package fr.bankSyst;

public class Client {
	
	private String idC;
	private String name;
	
	//constructeur
	public Client(String idC, String name) {
		this.idC = idC;
		this.name = name;
	}
	public Client()  {
	}
	//setters getters
	public String getIdC() {
		return idC;
	}
	public void setIdC(String idC) {
		this.idC = idC;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
