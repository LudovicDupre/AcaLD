import java.util.Scanner;

public class Unite {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int nbInput = sc.nextInt();
		
		for (int i=0;i<nbInput;i++) {
			String 
		}

	}
	public static double foot(int x) {
		return  x*3.28084;
	}
	public static double pound(int y) {
		return y*453.592;
	}
	public static double fahren(int z) {
		return (z*(9/5)+32);
	}
	public static void reading(int a, String s) {
		
		switch (s) {
		case "m":
			System.out.println(foot(a)+" p");
		case "g":
			System.out.println(pound(a)+" l");
		case "c":
			System.out.println(fahren(a)+" f");
		}
	}

}
