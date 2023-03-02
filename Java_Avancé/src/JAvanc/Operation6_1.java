package JAvanc;

public class Operation6_1 {

	public static void main(String[] args) {
		
		System.out.println(add(5,2));
		System.out.println(sub(5,2));
		System.out.println(div1(3,0));
		System.out.println(div2(3,0));

	}
	
 public static int add(int a, int b) {
	 int c = a+b;
	 return c;
 }
 
 public static int sub(int a, int b) {
	 int c= a-b;
	 return c;
 }
 
 public int mul(int a, int b) {
	 int c = a*b;
	 return c;
 }
 
 public static int div1(int a, int b) {
	 int c=0;
	 try {
	 c = a/b;
	 } catch ( ArithmeticException e) {
		 System.out.println("You cannot divided by 0.");
	 }
	 return c;
 }
 public static int div2(int a, int b) throws ArithmeticException {
	 int c=0;
	if (b==0) {
		throw new ArithmeticException ("Incorrect divider : it cannot be 0.");
	} else {
		c = a/b;
	}
	 return c;
 }
}
