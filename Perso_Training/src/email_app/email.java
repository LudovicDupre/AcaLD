package email_app;
import java.util.Scanner;

public class email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email1;
	private int mailboxCap = 500;
	private int defaultPasswordLength=10;
	private String altEmail;
	private String companySuffix = "fms-ea.com";

	//Constructor to received the first and last name
	public email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email successfully created: " +this.firstName +" "+ this.lastName);

		//call a methofd to ask for the dep and return the dep
		this.department = setDepartment();
		System.out.println("Departement : "+this.department);

		//call a method returning a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password);

		//combine element to generate email
		email1 = firstName.toLowerCase()+"."+ lastName.toLowerCase()+"."+department+"@"+companySuffix;
		System.out.println("your new email is : "+email1);
	}

	//ask for the department
	private String setDepartment() {
		System.out.println("Department Codes:\n1 for Sales \n2 for Developement\n3 for Accounting\n0 for none\nEnter department code :");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		if (depChoice ==1) {return "Sales";}
		else if (depChoice ==2) {return "Dev";}
		else if (depChoice ==3) {return "Acct";}
		else {return "";}
	}

	//generate a random password
	private String randomPassword(int length) {
		String passwordSet = "0123456789";
		char[] password = new char[length];
		for(int i=0; i<length;i++) {
			int rand =(int) (Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}


	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCap = capacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	//change the password
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() { return mailboxCap; }
	public String getAltEmail() { return altEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "Display name : " + firstName +" "+ lastName +
				"\nCompany email : "+ email1 +
				"\nMailbox capacity : " +mailboxCap+"mb";
	}

}
