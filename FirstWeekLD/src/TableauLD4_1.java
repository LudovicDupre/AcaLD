import java.util.Arrays;

public class TableauLD4_1 {
// 4.1
	public static void main(String[] args) {
		int[] note = {5, 7, 16, 13, 9, 19, 3, 14};
		// Réorganisation par ordre croissant par la méthode .sort()
		Arrays.sort(note);
		int L = note.length;
		// La plus petite note est à l'index 0
		int small = note[0];
		System.out.println("La plus petite note : " + small);
		// La plus grande note est à l'index le plus grand
		int big = note[L-1];
		System.out.println("La plus grande note est : " + big);
		//Boucle pour obtenir la moyenne
		int sum =0;
		for (int i=0; i<L; i++) {
			 sum += note[i];
		}
		int average = sum/L;
		System.out.println("La moyenne est : " + average);
	}
}