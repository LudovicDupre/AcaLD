import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/**@author DupreL
 */
public class PLM_project {

	static Scanner sc = new Scanner(System.in);
	/** Application to articulate two DB, giving the user the ability to alter one of them
	 * @param args Just lines of codes
	 */
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
		//Initialization of the DB for the parts
		HashMap<String, ArrayList<String>> partDB = new HashMap<>();
		ArrayList<String> list001 = new ArrayList<>(Arrays.asList("seat","furniture","200e"));
		ArrayList<String> list002 = new ArrayList<>(Arrays.asList("screw","assembly","1e"));
		ArrayList<String> list003 = new ArrayList<>(Arrays.asList("cable","elec","25e"));
		ArrayList<String> list004 = new ArrayList<>(Arrays.asList("belt","furniture","70e"));
		ArrayList<String> list005 = new ArrayList<>(Arrays.asList("window","assembly","1500e"));
		ArrayList<String> list006 = new ArrayList<>(Arrays.asList("curtains","furniture","30e"));
		
		partDB.put("part001", list001);
		partDB.put("part002", list002);
		partDB.put("part003", list003);
		partDB.put("part004", list004);
		partDB.put("part005", list005);
		partDB.put("part006", list006);
		
		//User input + choice with switch case	
		System.out.println("Menu Principal :\nBienvenue dans l'application de gestion du cycle de vie d'avions AIRBUS.\nFaites votre choix dans le menu, saisissez le chiffre correspondant:");
		System.out.println("1:Afficher tous les avions\n2:Afficher tous les avions contenant un mot clé dans le programme\n3:Ajouter ou supprimer une pièce pour un avion donné\n4:Afficher un avion avec les infos détaillées de chaque pièces\n5:Quitter l'application");
		
		int choice = -1;
		while (choice!=5) {
			choice = sc.nextInt();
			switch(choice) {
			case 1 : System.out.println(iteMap(planeDB));
			break;
			
			case 2 : System.out.println("Please enter a keyword :");
			String input = sc.next();
			System.out.println(keyWord(planeDB,input));
			break;
			
			case 3 : System.out.println("Add or delete a part?");
			String answer = sc.next();
			if ("add".equalsIgnoreCase(answer)) {
				System.out.println(iteMap(addPart(planeDB,partDB)));
			} else if ("delete".equalsIgnoreCase(answer)){
				System.out.println(iteMap(delPart(planeDB)));
			}
			break;
			
			case 4 : System.out.println("Please enter the plane ID you want the BOM of :");
			String idPlane = sc.next();
			System.out.println(bomPrint(planeDB.get(idPlane)));
			break;
			} 
			System.out.println("Retour au menu principal...");
		}
	}
	/**iteration on the plane map
	 * @param map the plane DB with the plane ID followed by the plane info list
	 * @return a string for ease of print
	 */
	public static String iteMap(HashMap<String, ArrayList<String>> map) {

		String listPlane ="List of plane ID :\n";
		for(Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			listPlane +=  "Plane "+key+" "+value+"\n";
		}
		return listPlane;
	}
	/**Matching keyword to an AC program
	 * @param map planeDB to iterate over a search
	 * @param input keyword to search
	 * @return a string of all the plane containing the keyword plus their list of info
	 */
	public static String keyWord(HashMap<String, ArrayList<String>> map, String input) {

		String listKey = "Plane with "+input+" keyword :\n";
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

			String key = entry.getKey();

			ArrayList<String> value = entry.getValue();
			String[] arr = value.toArray(new String[0]);
			if (arr[0].contains(input.toUpperCase())) { 
				listKey += "Plane "+key+" "+value+"\n";	
			}
		}
		return listKey;
	}
	/**Add a part to the list of a specified plane
	 * @param map1 planeDB to iterate over
	 * @param map2 partDB for the user to choose from
	 * @return plane id and info plus the part added
	 */
	public static HashMap<String, ArrayList<String>> addPart(HashMap<String, ArrayList<String>> map1, HashMap<String, ArrayList<String>> map2) {
		
		System.out.println(iteMap(map1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		System.out.println(iteMap(map2)+"\nPlease enter a part to add to the plane :");
		String partToAdd = sc.next();
		String partName = map2.get(partToAdd).get(0);
		ArrayList<String> matchingList =  map1.get(planeId);
		matchingList.add(partName);
		map1.replace(planeId,matchingList);
		
		return map1;
	}
	/**Remove a part from the plane BOM
	 * @param map1 for the user to found the plane and the part to delete
	 * @return the plane id and his list
	 */
public static HashMap<String, ArrayList<String>> delPart(HashMap<String, ArrayList<String>> map1) {
		
		System.out.println(iteMap(map1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		System.out.println("Please enter the name of the part you wish to remove :");
		String partToDel = sc.next();
		ArrayList<String> matchingList =  map1.get(planeId);
		matchingList.remove(partToDel);
		map1.replace(planeId,matchingList);

		return map1;
}
	/**Create a shallow copy of the plane list without the first 3 index, which are inrelevent to the BOM
	 * @param arr1 take the plane list previously choosen by the user
	 * @return the list without the non-BOM related info within the list
	 */
public static ArrayList<String> bomPrint(ArrayList<String> arr1) {

	ArrayList<String> bom = new ArrayList<>(Arrays.asList(""));
	if (arr1.size()>3) {
		for (int i = arr1.size()-1; i>2;i--) {
			bom.add(arr1.get(i));
		} 
	} else {
		bom.add("No BOM to print");
	}
	bom.remove(0);
	return bom;
}
}