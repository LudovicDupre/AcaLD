import java.util.Collections;
import java.util.List;
//6.2 
public class PyramideétoileLD6_2 {

	public static void main(String[] args) {
		// Boucle avec volume ajustable
		int row = 7;
		for (int i = 0; i < row; i++) {
			// Creation de listes flexibles avec les caractères nécessaires
			List<String> esp = Collections.nCopies(6-i, " ");
			List<String> eto = Collections.nCopies(2*i+1, "*");
			// Joinage des listes
			String espace = new String(String.join("", esp));
			String etoile = new String(String.join("", eto));
			// Impression
			System.out.println(espace + etoile);
		}
	}
}
