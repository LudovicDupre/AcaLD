package fr.school.management;
/**
 * @author DupreL
 *This class is responsible for keeping track of teacher's id, name and salary.
 */
public class Teacher {

	private int id;
	private String name;
	private int salary;
	/**
	 * Create a new teacher object.
	 * @param id of the teacher
	 * @param name of the teacher
	 * @param salary of the teacher
	 */
	public Teacher(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	/**
	 * @return the teacher's id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the teacher's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the teacher's salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * 
	 * @param salary to alter the teacher's salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}