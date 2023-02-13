
public class Person {
	
	String firstName;
	String lastName;
	int age;
	String livingPlace;
	public City city = new City();

	public Person(String lastName, String firstName, int age, String livingPlace, City city) {
		//1-8
		this.firstName = firstName;
		this.lastName = lastName;
		this.age= age;
		this.livingPlace = livingPlace;
		this.city = city;
	}
	public Person(String lastName, String firstName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Person(String lastName, String firstName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age =age;
	}
	public String getLivingPlace() {
		return livingPlace;
	}
	public City getCity() {
		return city;
	}
	
//	@Override
//	public String toString() {
//		return   "[lastname= "+lastName+ ", firstName= "+firstName+", age= "+age+", adress="+livingPlace+"]; BirthPlace:"
//				+"[name= "+city.getTown()+", State= "+city.getCountry()+", population :"+city.getPopulation()+"]";
//	}
	@Override
	public String toString() {
		return lastName+" , "+ firstName+" , "+age+"ans , habitant "+livingPlace+" , Ville de Naissance : "+city.getTown()+" , "+city.getCountry();
	}
}
