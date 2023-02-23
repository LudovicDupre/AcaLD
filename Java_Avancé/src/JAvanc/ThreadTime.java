package JAvanc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadTime {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Thread thread = new Thread(new MonRunnable(1000));

		System.out.print(df.format(new Date()));

		thread.start();
	}

	private static class MonRunnable implements Runnable {

		private long delai;

		public MonRunnable(long delai) {
			this.delai = delai;
		}

		@Override
		public void run() {
			DateFormat df = new SimpleDateFormat("HH:mm:ss");

			while(true) {
				try {
					Thread.sleep(delai);
					System.out.print("\r");
					System.out.print(df.format(new Date()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
