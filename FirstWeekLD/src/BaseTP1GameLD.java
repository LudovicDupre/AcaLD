import java.util.Scanner;
import java.lang.Math;
public class BaseTP1GameLD {

	public static void main(String[] args) {
		// while loop, décision utilisateur
		System.out.println("Bonjour, souhaitez-vous jouer à mon jeu?");
		Scanner input = new Scanner(System.in);
		String rep = input.next();
		while (rep.equalsIgnoreCase("oui") || rep.equalsIgnoreCase("o")) {
		int target = (int)(((Math.random()*100)+1));
		int attempt = 0;
		// while loop de guess
		while (true) { 
			System.out.println("Saisissez une valeur entre 1 et 100.");
			int guess = input.nextInt();
			attempt++;
			// if condi, pour tester les input utilisateur
			if (guess == target) {
				System.out.println("Vous avez trouvé en  " + attempt + " coups.");
				break;
			}else if (guess > target) {
				System.out.println("Trop grand! Saisissez une valeur plus petite.");

			} else if (guess < target){
				System.out.println("Trop petit! Saisissez une valeur plus grande.");			
			}
		}
		System.out.println("Voulez vous rejouer?");
		rep = input.next();
		}
		System.out.println("Ciao.");
		input.close();
	}

}