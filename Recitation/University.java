package Recitation;

public class University {

	public static void main(String[] args) {
		Professor p1 = new Professor("Boy", 85, "asfdasf", 5);
		Student stud1 = new Student("Bill", 20, "Billyboy", 11111111);
		
		Person[] pa = new Person[3];
		
		pa[0] = p1;
		pa[1] = stud1;
		
		for(int i = 0; i <pa.length; i++) {
			System.out.println(pa[i]);
			System.out.println();
		}
		
	}
}
