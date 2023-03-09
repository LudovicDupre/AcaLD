package fr.fms.entities;

public class Article {
	private int id;
	private String description;
	private String brand;
	private double price;
	private int category;
	private int quantity=1;
	
	public static final int MAX_STRING_LENGTH = 20;
	
	public Article(int id, String description, String brand, double price, int category) {
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
	}
	
	public Article(int id, String description, String brand, double price) {
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	public Article(String description, String brand, double price) {
		this.id = 0;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}	

	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(description) + centerString(brand) + centerString(String.valueOf(price));
	}
	
	public static String centerString(String str) {
		if(str.length() >= MAX_STRING_LENGTH) return str;
		String dest = "                    ";
		int deb = (MAX_STRING_LENGTH - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
