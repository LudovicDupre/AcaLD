import java.util.Scanner;

public class playDigit {
	public static void main(String[] ars) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez n : ");
		int n = sc.nextInt();
		System.out.println("Entrez p : ");
		int p = sc.nextInt();
		System.out.println(digPow(n,p));
		sc.close();
	}

		// Is there an integer k such as : (a^p+b^(p+1)+...)= n*k
		public static long digPow(int n, int p) {
	    // Conversion of int n in an array
		  String temp = Integer.toString(n);
	    int[] newArray = new int[temp.length()];
	    for (int i=0; i<temp.length(); i++) {
	    	newArray[i] = temp.charAt(i) -'0';
	    }
	    long temp1 = 0;
	    for (int i =0; i<newArray.length; i++) {
	    	temp1 += (Math.pow(newArray[i],(p+i)));
	    }
	    long k =temp1/n;
	    if (k==0) {return -1;
	    }
	    else {
	    	return k;
	    }
		}	
}