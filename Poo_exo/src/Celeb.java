
public class Celeb {


	public static void main(String[] args) {

		Person[] listCeleb = new Person[6];

		listCeleb[0] = new Person("Macron", "Emmanuel", 43, "L'Elysée à Paris", new City ("Amiens", "France"));
		listCeleb[1]= new Person ("Sarkozy", "Nicolas", 66, "Paris", new City ("Paris", "France"));
		listCeleb[2]= new Person ("Johnson", "Boris", 56, "Downing Street à London", new City ("New York", "Etats-Unis"));
		listCeleb[3]= new Person ("Depardieu", "Gerard", 72, "Moscou", new City ("Chateauroux", "France"));
		listCeleb[4]= new Person ("Kravitz", "Lenny", 56, "Hotel Particulier à Paris", new City ("New-York", "USA"));
		listCeleb[5]= new Person ("Lawrence", "Jennifer", 30, "Louisville aux USA", new City ("Idan Hills", "USA"));

		System.out.println("Liste de personnalités : ");

		for (Person celeb : listCeleb) {
			System.out.println(celeb);
		}

		System.out.println("--------------------------------------\nListe après notre filtre :");

		for (Person celeb : listCeleb) {
			if (celeb.getLivingPlace().toLowerCase().contains("paris") || celeb.getCity().getCountry()== "France") {
				System.out.println(celeb);
			} else {
				continue;
			}
		}
	}
}