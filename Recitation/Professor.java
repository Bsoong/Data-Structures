package Recitation;

public class Professor extends Person {
	private int numOfClasses;
	
	public Professor(String name, int age, String email, int numofClasses) {
		super(name, age, email);
		this.numOfClasses = numofClasses;
	}

	public int getNumOfClasses() {
		return numOfClasses;
	}

	public void setNumOfClasses(int numOfClasses) {
		this.numOfClasses = numOfClasses;
	}
	public String toString() {
		return super.toString() + "\nNumber of classes: " + numOfClasses;
	}
}
