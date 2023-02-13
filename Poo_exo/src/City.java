/** @author DupreL
 */
public class City {

	public String country;
	public String town;
	public int population;

	public static int runCount;
	/** constructor w/ 3 args
	 * @param country
	 * @param town
	 * @param population
	 */
	public City(String town, String country, int population) {
		this.country = country;
		this.town = town;
		this.population = population;
		runCount++;
	}
	/**Constructor w/0 args
	 */
	public City() {		
	}
	/**Constructor w/ 2 args
	 * @param town
	 * @param country
	 */
	public City(String town, String country) {
		this.country = country;
		this.town = town;
		runCount++;
	}
	// Getters Setters
	public String getCountry() {
		return country;
	}
	public String getTown() {
		return town;
	}
	public int getPopulation() {
		return population;
	}
	public void setCountry(String c) {
		this.country = c;
	}
	public void setTown(String t) {
		this.town = t;
	}
	/**1.2 costumized setter method
	 * @param p = new population
	 */
	public void setPopulation(int p) {
		if (p<0) {
			System.err.println("Can't set population to a negative.");
		} else if (this.population>p) {
			System.err.println("Can't reduce the population.");
		} else this.population = p;
	}
	/**1.3 using getters/setters to found an attribute
	 * @param t
	 * @param p
	 */
	public void print3(String t, int p) {
		System.out.println("[Ville : "+getTown()+"] [pays : "+getCountry()+"] [nombre d'habitants : "+getPopulation()+" ]");
	}
	/** 1.4 method to print a specific message
	 * @return formated String
	 */
	public void display() {
		String result ="ville de "+getTown()+" en "+getCountry()+" ayant "+getPopulation()+" habitants";
		System.out.println(result);
	}
	/** 1.7 one way to count
	 * @return number of times the constructor was used
	 */
	public static int getNumberRunCount() {
		return runCount;
	}
}
