package fr.fms.entities;

public class Customer {
	@Override
	public String toString() {
		return " " + name + " , " + firstName + " , " + email + " , " + phone + " , " + address;
	}

	private int idCustomer;
	private String name;
	private String firstName;
	private String email;
	private String phone;
	private String address;
	private int idUser;
	
	public Customer(int idCustomer, String name, String firstName, String email, String phone, String address, int idUser) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idUser = idUser;
	}
	
	public Customer(String name, String firstName, String email, String phone, String address, int idUser) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idUser = idUser;
	}
	
	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Customer(String name, String firstName, String email, String phone, String address) {
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
