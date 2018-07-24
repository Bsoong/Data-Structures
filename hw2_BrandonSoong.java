
public class hw2_BrandonSoong {
	public static void method0(int a){
		//O(n) is shown using one for loop and a counter variable
		if(a <= 0) {
			return;
		}else {
			int counter = 0;
			for(int i = 0; i < a; i++) {
				System.out.println("Operation "+counter);
				counter++;
		}
		}
	}
	public static void method1(int a) {
		//O(n^2) is shown using two for loops and a counter variable
		if(a <= 0) {
			return;
		}else {
			int counter = 0;
			for(int i = 0; i < a; i++) {
			    for(int j = 0; j < a; j++)
			    {
			        System.out.println("Operation " + counter);
			        counter++;
			    }
		}
		
		}
	}
	public static void method4(int a) {
		//O(n^3) is shown using three for loops and a counter variable
		if(a <= 0) {
			return;
		}else {
			int counter = 0;
			for (int i=0; i< a; i++) {
			    for (int j= 0; j< a; j++) {
			        for (int k= 0; k<a; k++) {
			            System.out.println("Operation " + counter);
			            counter++;
			        }
		}
		    }
		}
	}

	public static void method3(int a) {
		//Using the for loop from O(n) and combining it witht eh for loop from O(logn) you get nlogn
		if(a <= 0) {
			return;
		}else {
			int counter = 0;
			for(int i = 0; i < a; i++) {
				for(int j = 1; j <= a; j = j*2) {
					System.out.println("Operation " + counter);
					counter++;
				}
			}
		
		}
	}
	public static void method2(int a) {
		//O(log(n)) is shown using two for loops and a counter variable. The difference from the other is that because it is a log, the j variable is
		//incremented by multiplying 2.
		int counter = 0;
		if(a <= 0) {
			return;
		}else {
			for(int i = 1; i < a; i = i*2) {
					System.out.println("Operation " + counter);
					counter++;
				}
			}
		}
		
	public static void method5(int a) {
		//O(log(log(n)) is shown using a for loop and a counter variable
		if(a < 0) {
			return;
		}else {
			int counter = 0;
			for(int i = 1; i < a; i*=i) {
				System.out.println("Operation " + counter);
				counter++;
				i++;
		
			}
		}
	
		
	}
	
	public static void main(String[] args) {
	
	}
}
