package Recitation;

public class Person {
	private String name;
	private int age;
	private String email;
	
	/**
	 * Constructor for the class person that initializes all three data fields
	 * @param name
	 * @param age
	 * @param email
	 */
	
	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public Person(String name, String email) {
		this.name = name;
		this.age = 0;
		this.email = email;
	}
	public Person(String name,int age) {
		this.name = name;
		this.age = 0;
	}
	
	/**
	 * Returns the name 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * gets age
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Sets age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Get email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	 /**
	  * To String method that returns a string. 
	  * @return
	  */
	@Override
	public String toString() {
		return "Name: " + name + "\nAge: " + age + "\nEmail: " + email;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Brandon", 18, "Bsoong");
		System.out.println(p1.toString());
	}
}
