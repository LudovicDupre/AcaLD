import java.util.Arrays;

public class SortingLD6_3 {

	//6.3 - Sorting
	public static void main(String[] args) {
		int[] example = {78, 6, -250, 2, 12, 9};
		int X = example.length;
		Arrays.sort(example);
		System.out.println((example[X-1] + example[X-2]));
	}
}
