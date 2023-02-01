import java.util.Scanner;

public class RécursivitéLD {
	// On a ici une fonction qui s'appelle elle-même. (Récursivité)
static int facto(int x) {
	if (x == 0)
		return 1;
	else return (x*facto(x-1));
}
	public static void main(String[] args) {
		int f = 1 ;
		System.out.println("Entrez un nombre : ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		f = facto(n);
		System.out.println("Factorielle de " + n + " est " + f);
		input.close();
	}
}