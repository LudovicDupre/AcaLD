package fr.school.management;
/**@author DupreL
 *This class is reponsible for keeping track of students fees, names, IDs, grades and fees paid.
 *
 */
public class Student {

	private int id;
	private String name;
	private int grade;
	private int feesPaid;
	private int feesTotal;

	/**To create a new student by initializing
	 * Fees for every students is $30,000.
	 * Fees paid initially is 0
	 * @param id for the student : unique
	 * @param name of the student
	 * @param grade of the student
	 */
	public Student(int id, String name, int grade) {
		this.feesTotal = 30000;
		this.feesPaid = 0;
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public int getFeesPaid() {
		return feesPaid;
	}

	//Not going to alter student's name, or id.
	/**
	 * Used to update the student's grade
	 * @param grade new grade of the student
	 */
	public void setGrade(int grade) {
		this.grade= grade;
	}
	
	/** Keep adding the fees to feesPaid Field.
	 * Add the fees to the fees paid.
	 * The school is going to received the funds.
	 * @param fees that the student pays.
	 */
	public void updateFeesPaid(int fees) {
		feesPaid += fees;
	}


}
