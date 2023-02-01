
public class RechercheStringLD_5_2 {
	// 5.2 Recherche de mot
	public static void main(String[] args) {
		String sent = "il fait beau aujourd'hui";
		String word = "beau";
		if (sent.contains(word)== true) {
			System.out.println("Le mot " + word +" est trouvé dans la phrase.");
		} else {
			System.out.println("Le mot " + word +" n'est pas trouvé dans la phrase.");
		}
	}

	//5.3 Replacement
	public static void main2(String[] args) {
		String sent = "il fait beau aujourd'hui";
		String word = "beau";
		String newWord = "chaud";
		if (sent.contains(word)== true) {
			System.out.println(sent.replace(word, newWord));
		} else {
			System.out.println("Le mot " + word +" n'est pas trouvé dans la phrase.");
		}
	}
}

/** String str = "il fait beau aujourd'hui";
char[] ch = str.toCharArray();
String input = "beau";
char[] chInput = input.toCharArray();
for (int i=0 ; i<ch.length; i++); {
	for (int j=0 ; j<chInput.length; j++); {*/
		