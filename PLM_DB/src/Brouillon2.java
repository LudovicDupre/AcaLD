import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Brouillon2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		HashMap<String, ArrayList<String>> planeDB = new HashMap<>();
		ArrayList<String> listL6I8 = new ArrayList<>(Arrays.asList("A350","assy","passager"));
		ArrayList<String> listK5L9 = new ArrayList<>(Arrays.asList("A400M","concept","fret"));
		ArrayList<String> listH7O3 = new ArrayList<>(Arrays.asList("A320","prod","business"));
		ArrayList<String> listE6H2 = new ArrayList<>(Arrays.asList("A380","prod","fret"));
		ArrayList<String> listP6M3 = new ArrayList<>(Arrays.asList("A350","concept","passager"));
		ArrayList<String> listT8B6 = new ArrayList<>(Arrays.asList("A380","assy","business"));
		ArrayList<String> listC6R4 = new ArrayList<>(Arrays.asList("A320","prod","passager"));
		
		planeDB.put("L6I8",listL6I8);
		planeDB.put("K5L9",listK5L9);
		planeDB.put("H7O3",listH7O3);
		planeDB.put("E6H2",listE6H2);
		planeDB.put("P6M3",listP6M3);
		planeDB.put("T8B6",listT8B6);
		planeDB.put("C6R4",listC6R4);
		
		System.out.println(listL6I8);
		//String search = sc.next();
	}}