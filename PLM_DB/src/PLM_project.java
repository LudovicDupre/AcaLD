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
		ArrayList<String> listL6I8 = new ArrayList<>(Arrays.asList("A350","assy","passager","belt"));
		ArrayList<String> listK5L9 = new ArrayList<>(Arrays.asList("A400M","concept","fret","seat"));
		ArrayList<String> listH7O3 = new ArrayList<>(Arrays.asList("A320","prod","business","curtains"));
		ArrayList<String> listE6H2 = new ArrayList<>(Arrays.asList("A380","prod","fret","window"));
		ArrayList<String> listP6M3 = new ArrayList<>(Arrays.asList("A350","concept","passager","cable","window"));
		ArrayList<String> listT8B6 = new ArrayList<>(Arrays.asList("A380","assy","business","screw"));
		ArrayList<String> listC6R4 = new ArrayList<>(Arrays.asList("A320","prod","passager","belt"));

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

		partDB.put("M055", list001);
		partDB.put("X562", list002);
		partDB.put("E846", list003);
		partDB.put("R845", list004);
		partDB.put("M978", list005);
		partDB.put("A845", list006);

		//User input + choice with switch case	
		System.out.println("Main Menu :\nWelcome in the Product Data Management of AIRBUS.\nTo make your choice in this menu, please enter a number:");
		System.out.println("1:Print all planes.\n2:Print all AC program featuring a keyword.\n3:Add or delete a part in the BOM of a plane.\n4:Print the BOM of a selected plane.\n5:Quit the app.");

		int choice = -1;
		while (choice!=5) {
			choice = sc.nextInt();
			switch(choice) {
			case 1 : System.out.println(iteMapPlane(planeDB)+"\n\nBack to main menu...");
			break;

			case 2 : System.out.println("Please enter a keyword :");
			String input = sc.next();
			System.out.println(keyWord(planeDB,input)+"\n\nBack to main menu...");
			break;

			case 3 : System.out.println("Enter 'add' to add a part\nor 'delete' to delete a pat: ");
			String answer = sc.next();
			if ("add".equalsIgnoreCase(answer)) {
				addPart(planeDB,partDB);
			} else if ("delete".equalsIgnoreCase(answer)){
				delPart(planeDB);
			}
			System.out.println("\nBack to main menu...");
			break;

			case 4 : System.out.println("Please enter the plane ID you want the BOM of :");
			System.out.println(printList(planeDB));
			String idPlane = sc.next();
			System.out.println(idPlane+"; "+bomPrint(planeDB.get(idPlane))+"\nBack to main menu...");
			break;
			} 
		}
		System.out.println("GoodBye.");
	}
	/**iteration on the plane map
	 * @param map the plane DB with the plane ID followed by the plane info list
	 * @return a string for ease of print
	 */
	public static String iteMapPlane(HashMap<String, ArrayList<String>> map) {

		String listPlane ="List of plane ID :\n";
		for(Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			listPlane +=  "\nPlane ID: "+key+"; Info on the plane: ";
			List<String> value = entry.getValue();
			for (int i =0; i<3; i++) {			
				listPlane += " "+value.get(i)+" ";
			}
		}
		return listPlane;
	}
	/**iteration on the part map
	 * @param map the part DB with the part number followed by the part info list
	 * @return a string for ease of print
	 */
	public static String iteMapPart(HashMap<String, ArrayList<String>> map) {

		String listPart ="List of Part:\n";
		for(Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			listPart +=  "Part number: "+key+"; Info on the part: "+value+"\n";
		}
		return listPart;
	}
	/** Print the key of the map plane without the list/value
	 * @param map to iterate over
	 * @return just the list of key of the map 
	 */
	public static String printList(HashMap<String, ArrayList<String>> map) {

		String listID ="List of plane ID :\n";
		for(Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			listID +=  "Plane ID: "+key+"\n";
		}
		return listID;
	}
	/**Matching keyword to an AC program/index 0 in the list of the plane hashmap
	 * @param map  to iterate over a search
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
				listKey += "\nPlane ID: "+key+"; Info on the plane: ";
				for (int i =0; i<3; i++) {			
					listKey +=" "+value.get(i)+" ";
				}
			} listKey = "Plane with "+input+" keyword :\n No Matches found";
		}
		return listKey;
	}
	/**Add a part to the list of a specified plane
	 * @param map1 planeDB to iterate over
	 * @param map2 partDB for the user to choose from
	 * @return plane id and info plus the part added
	 */
	public static HashMap<String, ArrayList<String>> addPart(HashMap<String, ArrayList<String>> map1, HashMap<String, ArrayList<String>> map2) {

		System.out.println(printList(map1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		System.out.println(iteMapPart(map2)+"\nPlease enter a part to add to the plane :");
		String partToAdd = sc.next();
		String partName = map2.get(partToAdd).get(0);
		ArrayList<String> matchingList =  map1.get(planeId);
		matchingList.add(partName);
		map1.replace(planeId,matchingList);
		System.out.println("Plane "+planeId+": "+bomPrint(map1.get(planeId)));

		return map1;
	}
	/**Remove a part from the plane BOM
	 * @param map1 for the user to found the plane and the part to delete
	 * @return the plane id and his list
	 */
	public static HashMap<String, ArrayList<String>> delPart(HashMap<String, ArrayList<String>> map1) {

		System.out.println(printList(map1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		System.out.println("Please enter the name of the part you wish to remove :\nPlane "+planeId+": "+bomPrint(map1.get(planeId)));
		String partToDel = sc.next();
		ArrayList<String> matchingList =  map1.get(planeId);
		matchingList.remove(partToDel);
		map1.replace(planeId,matchingList);
		System.out.println("Plane "+planeId+": "+bomPrint(map1.get(planeId)));

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
			bom.add("No BOM to print.");
		}
		bom.remove(0);
		return bom;
	}
}