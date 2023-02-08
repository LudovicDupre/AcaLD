
public class Test_City {
	/** remove comment from the part you do not wish to see
	 * @param args
	 */
	public static void main(String[] args) {

		City toulouse = new City("Toulouse","France",450000);
		City dax = new City("Dax","France",21000);
		City macao = new City("Macao","Chine",690000);
		City lisbonne = new City("Lisbonne","Portugal",510000);
		City moscou = new City("Moscou", "Russie",12000000);



		//1
		//System.out.println(toulouse.population);
		//toulouse.population = toulouse.population + 20000;
		//System.out.println(toulouse.population);

		//2 customized Setter
		//System.out.println(toulouse.population);
		//toulouse.setPopulation(-200);
		//System.out.println(toulouse.population);

		//3 print

		//4 
		//toulouse.display();
		//1.7
		//System.out.println(City.getNumberRunCount());

	}
}

/**5 - System.out.println(toulouse);
 *  result = City@1ee0005
 *  revois à un emplacement mémoire, comme pour un tableau.
 * 
 */