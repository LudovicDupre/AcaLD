
public class Test_PersonLD {
 City City = new City();
	public static void main(String[] args) {
		//1-8 and 9
		Person manu = new Person("Macron", "Emmanuel",43,"Elysee à Paris", new City("Amiens","France"));
		Person poutine = new Person("Poutine", "Vladimir",68);
		Person biden = new Person("Biden", "Joe");
		
		System.out.println(manu);
		System.out.println(poutine);
		System.out.println(biden);
	}
}
