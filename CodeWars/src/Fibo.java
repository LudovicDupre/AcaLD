import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		System.out.println("Please enter an integer : ");
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextInt())) sc.next();
		int input = sc.nextInt();
		System.out.println("The "+ input+"th number of the Fibonnacci sequence is "+ fiboFunction(input));
		sc.close();
	}
	public static int fiboFunction(int a) {
		if (a==0) {
			return 0;
		}
		else if (a==1) {
			return 1;
		} else {
		 return fiboFunction(a-1)+ fiboFunction(a-2);
	}
}
}