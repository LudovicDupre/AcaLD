import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {

		System.out.print("Quel est votre nom ?");
		Scanner input1 = new Scanner(System.in);
		String name = input1.next();
		System.out.println("Salut " + name);
		System.out.println("Quel est votre prenom?");
		String firstName = input1.next();
		System.out.println("Bienvenue " + firstName + " "+ name ) ;//
		input1.close();
		
	}
}
