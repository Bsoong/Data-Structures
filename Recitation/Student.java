package Recitation;

/**
 * Class that defines an object of type Person.
 * @author brand
 *
 */
public class Student extends Person {
	private int ID;
	
	public Student(String name, int age, String email, int ID) {
		super(name, age, email);
		this.ID  = ID;
	}
	
	/**
	 * returns ID
	 * @return
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Sets ID
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	public String toString() {
		return super.toString() + "\nID: " + ID;
	}
	public static void main(String[] args) {
		Student s1 = new Student("Dave", 17, "d@gmail.com", 104422883);
		System.out.println(s1.toString());
	}
	
	
}
