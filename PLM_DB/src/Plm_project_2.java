import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
/**
 * @author DupreL
 */
public class Plm_project_2 {

	static Scanner sc = new Scanner(System.in);
	static String mainMenu = "Main Menu :\nWelcome in the Product Data Management of AIRBUS.\nTo make your choice in this menu, please enter a number:\n1:Print all planes.\n2:Print all AC program featuring a keyword.\n3:Add or delete a part in the BOM of a plane.\n4:Print the BOM of a selected plane.\n5:Quit the app.";
	/** Application to articulate two DB, giving the user the ability to alter one of them
	 * We are using ArrayList instead of HashMap here
	 * @param args app to check and alter a db
	 */
	public static void main(String[] args) {
		//calling the raw data
		ArrayList<String> idDB = new ArrayList<>(Arrays.asList("idL6I8","idK5L9","idH7O3","idE6H2","idP6M3","idT8B6","idC6R4"));
		ArrayList<ArrayList<String>> bom = initBom();
		ArrayList<ArrayList<String>> info = initInfo();
		HashMap<String, ArrayList<String>> part =  initPart();

		//User input + choice with switch case	
		System.out.println(mainMenu);
	
		int choice = -1;
		while (choice!=5) {
			choice = sc.nextInt();
			while (choice>5 || choice<0) {choice =sc.nextInt();} 
			
			switch(choice) {
			case 1 : System.out.println(itePlane(idDB,info)+"\n\nBack to main menu...");
			break;

			case 2 : System.out.println("Please enter a keyword :");
			String input = sc.next();
			System.out.println(keyWord(idDB,info,input)+"\n\nBack to main menu...");
			break;

			case 3 : System.out.println("Enter 'add' to add a part\nor 'delete' to delete a pat: ");
			String answer = sc.next();
			if ("add".equalsIgnoreCase(answer)) {
				addPart(idDB,bom,part);
			} else if ("delete".equalsIgnoreCase(answer)){
				delPart(idDB,bom);
			}
			System.out.println("\nBack to main menu...");
			break;

			case 4 : System.out.println("Please enter the plane ID you want the BOM of :");
			//System.out.println(printList(planeDB));
			String idPlane = sc.next();
			int index = idDB.indexOf(idPlane);
			System.out.println("Plane: "+idPlane+"; "+bomPrint(index,bom)+"\nBack to main menu...");
			break;
			} 
		}
		System.out.println("GoodBye.");
	}
	/**Initialization bom ArrayList of ArrayList
	 * @return bomDB to be manipulated
	 */
	public static ArrayList<ArrayList<String>> initBom() {
		ArrayList<String> bomL6I8 = new ArrayList<>(Arrays.asList("belt","curtains"));
		ArrayList<String> bomK5L9 = new ArrayList<>(Arrays.asList("cable"));
		ArrayList<String> bomH7O3 = new ArrayList<>(Arrays.asList("window","screw","seat"));
		ArrayList<String> bomE6H2 = new ArrayList<>(Arrays.asList("cable","belt","window"));
		ArrayList<String> bomP6M3 = new ArrayList<>(Arrays.asList("curtains","seat"));
		ArrayList<String> bomT8B6 = new ArrayList<>(Arrays.asList("windows","curtains","belt","seat","screw"));
		ArrayList<String> bomC6R4 = new ArrayList<>(Arrays.asList("screw","belt"));

		ArrayList<ArrayList<String>> bomDB = new ArrayList<>(Arrays.asList(bomL6I8,bomK5L9,bomH7O3,bomE6H2,bomP6M3,bomT8B6,bomC6R4));
		return bomDB;
	}
	/**Initialization of the partDB/HashMap
	 * @return the partDB
	 */
	public static HashMap<String, ArrayList<String>> initPart() {
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
		
		return partDB;
	}
	/**Initialization of the infoDB via Arraylist of Arraylist
	 * @return infoDB
	 */
	
	public static ArrayList<ArrayList<String>> initInfo() {
		ArrayList<String> infoL6I8 = new ArrayList<>(Arrays.asList("A350","assy","passager"));
		ArrayList<String> infoK5L9 = new ArrayList<>(Arrays.asList("A400M","concept","fret"));
		ArrayList<String> infoH7O3 = new ArrayList<>(Arrays.asList("A320","prod","business"));
		ArrayList<String> infoE6H2 = new ArrayList<>(Arrays.asList("A380","prod","fret"));
		ArrayList<String> infoP6M3 = new ArrayList<>(Arrays.asList("A350","concept","passager"));
		ArrayList<String> infoT8B6 = new ArrayList<>(Arrays.asList("A380","assy","business"));
		ArrayList<String> infoC6R4 = new ArrayList<>(Arrays.asList("A320","prod","passager"));

		ArrayList<ArrayList<String>> infoDB = new ArrayList<>(Arrays.asList(infoL6I8,infoK5L9,infoH7O3,infoE6H2,infoP6M3,infoT8B6,infoC6R4));
		return infoDB;
	}
	
	/**iteration on the plane map
	 * @param arr1 listID
	 * @param arr2 listInfo
	 * @return a string for ease of print
	 */
	public static String itePlane(ArrayList<String> arr1, ArrayList<ArrayList<String>> arr2) {

		String listPlane ="List of plane ID :\n";
		for (int i =0; i<arr1.size(); i++) {
			listPlane += "Plane ID ="+arr1.get(i)+" Info : "+ arr2.get(i)+"\n"; 
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
	 * @param arr1 to iterate over
	 * @return just the list of plane ID of the map 
	 */
	public static String printListID(ArrayList<String> arr1) {

		String listID ="List of plane ID :\n";
		for(int i =0;i<arr1.size(); i++) {
			listID +=  "Plane ID: "+arr1.get(i)+"\n";
		}
		return listID;
	}
	/**Matching keyword to an AC program/index 0 in the list of every list of the plane 
	 * @param arr1  to iterate over a search
	 * @param arr2 keyword to search
	 * @param input keyword to look for
	 * @return a string of all the plane containing the keyword plus their list of info
	 */
	public static String keyWord(ArrayList<String> arr1,ArrayList<ArrayList<String>> arr2, String input) {

		String listKey = "Plane featuring keyword in AC program :\n";

		for (int i =0;i<arr1.size();i++) {
			String id = arr1.get(i);
			ArrayList<String> value = arr2.get(i);
			String[] check = value.toArray(new String[0]);
			if (check[0].contains(input)) { 
				listKey += "\nPlane ID: "+id+"; Info on the plane: "+value;
			} 	
		}
		if (listKey == "Plane featuring keyword in AC program :\n") {
			listKey ="No matches found!";
		}
		return listKey;
	}
	/**Add a part to the list of a specified plane
	 * @param arr1 plane id to choose from
	 * @param arr2 matching BOM to alter
	 * @param map partDB for the user to choose from
	 * @return the bom altered
	 */
	public static  ArrayList<ArrayList<String>> addPart(ArrayList<String> arr1,ArrayList<ArrayList<String>> arr2, HashMap<String, ArrayList<String>> map) {

		System.out.println(printListID(arr1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		int index = arr1.indexOf(planeId);
		System.out.println(iteMapPart(map)+"\nPlease enter a part to add to the plane :");
		String partToAdd = sc.next();
		String partName = map.get(partToAdd).get(0);
		ArrayList<String> matchingList = arr2.get(index);
		matchingList.add(partName);
		arr2.set(index,matchingList);
		System.out.println("Plane "+planeId+": "+bomPrint(index,arr2));

		return arr2;
	}
	/**Remove a part from the plane BOM
	 * @param arr1 for the user to found the plane and the part to delete
	 * @param arr2 bom to manipulate
	 * @return the bom altered
	 */
	public static ArrayList<ArrayList<String>> delPart(ArrayList<String> arr1, ArrayList<ArrayList<String>> arr2) {

		System.out.println(printListID(arr1)+"\nPlease enter plane ID :");
		String planeId = sc.next();
		int index = arr1.indexOf(planeId);
		System.out.println("Please enter the name of the part you wish to remove :\nPlane "+planeId+": "+bomPrint(index,arr2));
		String partToDel = sc.next();
		ArrayList<String> matchingList =  arr2.get(index);
		matchingList.remove(partToDel);
		arr2.set(index,matchingList);
		System.out.println("Plane "+planeId+": List of components :"+bomPrint(index,arr2));

		return arr2;
	}
	/**Create a string of the plane list at the matching index
	 * @param arr1 take the plane list previously choosen by the user
	 * @param x : index matching the id selected by the user
	 * @return bom demanded
	 */
	public static String bomPrint(int x, ArrayList<ArrayList<String>> arr1) {

		String bom ="";
		if ((arr1.get(x)).size()>0) {
			bom = String.join(", ", arr1.get(x));

		} else {
			bom ="No BOM to print.";
		}
		return bom;
	}
}
