
public class OperationLD_6_1 {
	
	//6.1 - Operation
	public static void main(String[] args) {
		System.out.println(Add(5,2));
		System.out.println(Sub(5,2));
		System.out.println(Mul(5,2));
		System.out.println(Div(5,0));
	}
	public static int Add(int i, int j) {
		return (i+j);
	}
	public static int Sub(int i, int j) {
		return (i-j);
	}
	public static int Mul(int i, int j) {
		return (i*j);
	}
	public static int Div(int i, int j) {
		return (i/j);
		}
}