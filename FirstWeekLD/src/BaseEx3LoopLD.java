import java.util.Scanner;

public class BaseEx3LoopLD {

	public static void main(String[] args) {
		double input;
		System.out.println("Entrez un nombre entier : ");
		Scanner  value = new Scanner(System.in);
		input = value.nextDouble();
		if (input > 0 && input % 2 == 0) {
			System.out.println("Pair et Positif");
		} else if (input > 0 && input % 2 == 1) {
			System.out.println("Impair et Positif");
		} else if (input < 0 && input % 2 == 0) {
			System.out.println("Pair et Négatif");
		} else if (input < 0 && input % 2 == -1) {
			System.out.println("Impair et Négatif");
		} else {
			System.out.println("Zéro");
		}
		value.close();
	}
}
