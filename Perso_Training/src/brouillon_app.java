import java.util.Scanner;



public class brouillon_app {
	static Scanner sc  = new Scanner(System.in);

	public static void main(String args[]) {

		int choice1 =-1;
		//Main menu
		while(choice1!=3) {
			choice1 = sc.nextInt();
			while (choice1>3 || choice1<0)  {choice1 = sc.nextInt();}
			switch(choice1)   {

			case 1 :  // first sub-menu

				int choice2 = -1;
				while (choice2!=4) {
					choice2 = sc.nextInt();
					while (choice2>4 || choice2<0) {choice2 =sc.nextInt();}

					switch(choice2) {

					case 1:
						break;

					case 2:
						break;

					case 3: 
						break;
					}


					break;
				}
			case 2 : //second sub-menu

				int choice3 = -1;
				while (choice3!=4) {
					choice3 = sc.nextInt();
					while (choice3>4 || choice3<0) {choice3 =sc.nextInt();}
					switch(choice3) {

					case 1: 
						break;

					case 2: 
						break;

					case 3: 
						break;

					}
					break;
				}
			}
		}
	}
}
