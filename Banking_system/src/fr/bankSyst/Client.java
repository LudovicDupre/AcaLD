package fr.bankSyst;

import java.util.ArrayList;

public class Client {
	
	
	private String idC;
	private String firstName;
	private String name;
	private ArrayList<Account> listAccount;
	
	//constructeur
	public Client(String idC, String name,String firstName) {
		this.idC = idC;
		this.name = name;
		this.firstName = firstName;
		this.listAccount = new ArrayList<Account>();
	}
	public Client()  {
	}
	
	@Override
	public String toString() {
		return "Client : [client id = " + idC + ", fullName = " + name + " "+firstName+"]";
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public ArrayList<Account> getListAccount() {
		return listAccount;
	}
}
