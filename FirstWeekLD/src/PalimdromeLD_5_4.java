import java.util.Scanner;

public class PalimdromeLD_5_4 {
	//5.4 Palimdrome
		public static void main(String args[]) {
			System.out.println("Ecrivez un mot : ");
			String normal , inverse = "";
			Scanner input = new Scanner(System.in);
			normal = input.nextLine();
			// String normalFixed = normal.replaceAll(" ", "");
			int length = normal.length();
			for (int i = length-1; i>=0; i--) {
				inverse = inverse + normal.charAt(i);
			}
			if (normal.equals(inverse)) {
				System.out.println("Ceci est un palimdrome.");
			} else {
				System.out.println("Ceci n'est pas un palimdrome.");
			}
			input.close();
		//5.5 Pour une phrase entière avec des espaces qui fausserait la recherche de palimdrome,
			// il faut utiliser la methode .replaceAll :
			// normalFixed = normal.replaceAll(" ", "");
			// replacer un espace plein " " par un espace vide "".
}
}