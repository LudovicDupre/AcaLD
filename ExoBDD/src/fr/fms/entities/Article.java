package fr.fms.entities;

public class Article {

	int Id;
	String Description;
	String Marque;
	double PrixUnitaire;
	
	public Article(int Id,String Description,String Marque,double PrixUnitaire) {
		this.Id= Id;
		this.Description = Description;
		this.Marque = Marque;
		this.PrixUnitaire = PrixUnitaire;
	}

	public int getId() {
		return Id;
	}

	public void setIdArticles(int idArticles) {
		Id= idArticles;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}

	public double getPrice() {
		return PrixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		PrixUnitaire = prixUnitaire;
	}	
}