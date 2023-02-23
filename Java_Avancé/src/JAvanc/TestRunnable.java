package JAvanc;

import java.util.Collections;

public class TestRunnable implements Runnable{

	public static void main(String[] args) {
		Thread thread = new Thread(new TestRunnable());
		thread.start();
	}
	@Override
	public void run() {
		String str = null;
		for (int i = 1; i<11; i++) {
			str = Character.toString((char)(i+32));
			System.out.println(str+(String.join("",Collections.nCopies(i,"*")))+str);
		}
	}
}