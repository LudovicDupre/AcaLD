import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Brouillon_PLM {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		List<String> test = Arrays.asList("oui","non","ouf","oiseau","reptile","mamifere");
		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("bruh", "yep");
//		map.put("brap", "wew");
//		map.put("flop", "burp");
//		map.put("shesh", "boomer");
//		map.put("yuck", "nope");
		System.out.println("Enter smt :");

		String search = sc.next();
		for (int i =0; i<test.size(); i++) {
		System.out.print(test.get(i).contains(search)+" ");
		}
//		for(Map.Entry<String, String> entry : map.entrySet()) {
//			String key = entry.getKey();
//			String value = entry.getValue();
//			if (key.contains(search) || value.contains(search)) {
//				System.out.println(key+" "+value);
//			} else {
//				System.out.println("not found");
//				break;
//			}
//		}
	}
}
