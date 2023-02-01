import java.util.ArrayList;

// Are the twins even?

public class TestTest {

	public static void main(String[] args) {
		ArrayList<Integer> distEven =  new ArrayList<>();
		int[] arr = {5,6,7,8,9};
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length; j++) {
				if (i==j) break;
				int sum = arr[i]+arr[j];
				if (sum%2==0) {
					distEven.add(sum);
				} else {
					break;
				}
			}
		} 
		System.out.println("Liste de sommes paires distinctes : "+distEven);
		System.out.println("Nombre de sommes paires uniques : " +distEven.size());
	}
}
