import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Check_TableauLD4_3 {
	
	public static void main(String[] args) {
		// Initialisation des listes avec les notes des étudiants:
		List <Integer> noteRobert = Arrays.asList(12,18,8,10);
		List <Integer> noteBob = Arrays.asList(13,5,14,7);
		List <Integer> noteBobby = Arrays.asList(4,9,13,14);
		List <Integer> noteRob = Arrays.asList(9,15,16,10);
		List <Integer> noteBerty = Arrays.asList(12,11,8,16);
		// Initialisation d'une HashMap/DB
		HashMap<String, List<Integer>> studentNote = new HashMap<>();
		studentNote.put("Robert", noteRobert);
		studentNote.put("Bob", noteBob);
		studentNote.put("Bobby", noteBobby);
		studentNote.put("Rob", noteRob);
		studentNote.put("Berty", noteBerty);
		// Recherche de l'élève.
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel eleve rechercher vous?");
		String search = sc.next();
		if (studentNote.containsKey(search)) {
			System.out.println(search + "\nSes notes sont : " +studentNote.get(search)+"\nSa moyenne est : " +average(studentNote.get(search)));
		}
		else System.out.println("Cet eleve n'est pas présent.");
		sc.close();
	}
	// Fonction sur une liste.
	public static int average(List<Integer>myList) {
		int L = myList.size();
		int result = 0;
		int sum = 0;
		for (int i=0; i<L; i++) {
			sum += myList.get(i);
			result = sum/L;
		} return result;
	}
}