
public class Celebrity {

	String firstName;
	String lastName;
	int age;
	String livingPlace;
	public City city = new City();

	public Celebrity(String lastName, String firstName, int age, String livingPlace, City city) {
		//1-8
		this.firstName = firstName;
		this.lastName = lastName;
		this.age= age;
		this.livingPlace = livingPlace;
		this.city = city;
	}
	public Celebrity(String lastName, String firstName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Celebrity(String lastName, String firstName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age =age;
	}
	@Override
	public String toString() {
		if (livingPlace.contains("Paris") || city.getCountry()== "France") {
			return   lastName+ ", "+firstName+", "+age+"ans , habitant "+livingPlace+" , Ville de Naissance : "
					+city.getTown()+" ,  "+city.getCountry()+", population : "+city.getPopulation();
		} else {
			return "";
		}
	}
}


