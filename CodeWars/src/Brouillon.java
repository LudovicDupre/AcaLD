import java.util.Scanner;

public class Brouillon {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		  
		   System.out.println("Entrez le code :");
		      int input = sc.nextInt();
		      testCode(input,4242);
		      System.out.println("Premier code bon.");
		      int input2 = sc.nextInt();
		      testCode(input2,2121);
		      System.out.println("Bravo.");
		      sc.close();
		   }
		   public static void testCode(int x, int y) {
			   int z = 0;
		    while (!(x==y || x==z || y==z)) {
		    System.out.println("Entrez le code :");
		     z =sc.nextInt();
		    } ;
		  }
}
