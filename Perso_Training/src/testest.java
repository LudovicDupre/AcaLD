import java.util.Date;

public class testest {

	public static boolean checkInput(String userEntry) {

		boolean hasString = false;
		int index = 0;
		while(index < userEntry.length()) {

			if (!(userEntry.charAt(index)>= '0' && userEntry.charAt(index)<= '9')) {
				hasString = true;
			}
			index++;
		}
		return hasString;
	}
}
