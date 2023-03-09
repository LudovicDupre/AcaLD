package fr.fms.entities;

public class Category {
	private int id;
	private String name;
	private String description;
	
	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return centerString(String.valueOf(id)) + centerString(name) + centerString(description);
	}
	
	public static String centerString(String str) {
		if(str.length() >= 20) return str;
		String dest = "                                        ";
		int deb = (20 - str.length())/2 ;
		String data = new StringBuilder(dest).replace( deb, deb + str.length(), str ).toString();
		return data;
	}
}
