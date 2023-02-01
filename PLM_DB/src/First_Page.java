import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class First_Page {
	
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
		// Séparer et corriger les méthodes/interactions.
		
		//System.out.println("Enter ID numberof plane you wish to display,\n or 'ALL' if you wish to display all : ");
		System.out.println("search by keyword :");
		String search = sc.next();
		keyWord(planeDB,search);
//		if (planeDB.containsKey(search)) {
//			System.out.println(search+"\n"+planeDB.get(search));
//		} else if (search.equals("ALL")){
//			iteMap(planeDB);
//		} else {
//			System.out.println("This plane doesn't exist.");
//		}
		
	}
	public static void iteMap(HashMap<String, List<String>> map) {
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println(key+"\n"+value);
		}
	}
	public static void keyWord(HashMap<String, ArrayList<String>> map, String input) {

		for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> value = entry.getValue();
				if (key.contains(input) || value.contains(input)) {
					System.out.println(key+" "+value);
				} else {
					System.out.println("not found");
					break;
				}
		}
	}
}