
public class Test_Celebrity {

	public static void main(String[] args) {
		
		Celebrity manu = new Celebrity ("Macron", "Emmanuel", 43, "L'Elysée à Paris", new City ("Amiens", "France"));
		Celebrity sarko = new Celebrity ("Sarkozy", "Nicolas", 66, "Paris", new City ("Paris", "France"));
		Celebrity Johnson = new Celebrity ("Johnson", "Boris", 56, "Downing Street à London", new City ("New York", "Etats-Unis"));
		Celebrity gege = new Celebrity ("Depardieu", "Gerard", 72, "Moscou", new City ("Chateauroux", "France"));
		Celebrity lenny = new Celebrity ("Kravitz", "Lenny", 56, "Hotel Particulier à Paris", new City ("New-York", "USA"));
		Celebrity jenny = new Celebrity ("Lawrence", "Jennifer", 30, "Louisville aux USA", new City ("Idan Hills", "USA"));

		
		System.out.println(manu);
		System.out.println(sarko);
		System.out.println(Johnson);
		System.out.println(gege);
		System.out.println(lenny);
		System.out.println(jenny);

	}

}
