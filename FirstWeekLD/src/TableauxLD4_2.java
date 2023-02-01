import java.util.Arrays;
import java.util.Scanner;

public class TableauxLD4_2 {

	public static void main(String[] args) {
		//initialisation nbStudent
		System.out.println("Combien d'eleves avez-vous?");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt() == false) {
			sc.next();
			}
		int nbStudent = sc.nextInt();
		// Boucle : saisir ID
		for (int i=0 ; i<nbStudent ; i++) {
			System.out.println("Entrer son nom et prenom : ");
			String name = sc.nextLine();
			// Boucle : saisir les notes
			System.out.println("Combien de notes allez-vous renter?");
			int nbNote = sc.nextInt();
			
			int [] newArr = new int[nbNote];
			for ( int j = 0 ; j<nbNote; j++) {
			System.out.println("Taper une note puis cliquer 'entre':");
			int note = sc.nextInt();
			newArr[j]= note;
			}
			System.out.println("Nom de l'élève : " +name); 
			System.out.println("Liste de notes : " +Arrays.toString(newArr)); 
			System.out.println("Moyenne de ses notes : "+ average(newArr)); 
		}
		sc.close();
	}
	public static int average(int[] arr) {
		int L = arr.length;
		int result = 0;
		int sum = 0;
		for (int i=0; i<L; i++) {
			sum += arr[i];
			result = sum/L;
		} return result;
	}
}