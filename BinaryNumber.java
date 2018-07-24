/*
 * Brandon Soong
 * CS284
 * I Pledge my Honor that I have abided by the Stevens Honor System. -Bsoong
 * Done in Little-Endian Form
 */
public class BinaryNumber {
	//Private Integer and Boolean Values 
	private int data[];
	private boolean overflow = false;
	
	
	
	public BinaryNumber(int length) { 
		//Constructor that sets the value for the data[] array
		if(length < 1) {
			this.data = new int[2];
		}
		this.data = new int[length];
	}
	public BinaryNumber(String str) {
		//Constructor that sets the values for the data[] array is the input is a String
		data = new int[str.length()];
		for(int i = 0; i< str.length(); i++) {
			char x = str.charAt(i);
			int k = Character.getNumericValue(x);
			data[i] = k;
		}
	}
	public int getLength() {
		//Return the length
		return data.length;
	}
	public int getDigit(int index) {
		//Gets the digit at the Index location
		if(index > getLength()-1) {
			System.out.println("This index is out of bounds");
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			return data[index];
		}
	}
	public int toDecimal() {
		//Converts the Binary value to Decimal value
		int value = 0;
		for(int i = 0; i < getLength(); i++) {
			value += data[i] * (int)Math.pow(2, i);
		}
		return value;
	}
	public void shiftR(int amount) {
		//ShiftR Shifts the entire array x amount of spaces to the right.
		if(amount < 1) {
			System.out.println("Negative amount will result in no shift");
			return;
		}else {
		int fake[] = new int[getLength() + amount];
		for(int i = 0; i < getLength(); i++) {
			fake[i + amount] = data[i];
		}
		data = fake;
		}
	}
	public void clearoverflow() {
		//Resets the overflow variable to False
		overflow = false;
	}
	public void add(BinaryNumber aBinaryNumber) {
		//Add function adds two Binary Number inputs
		if (this.getLength() != aBinaryNumber.getLength()) {
			System.out.println("The binary numbers are not the same length");
			return;
		}
		else {
			for(int i = 0; i < getLength()-1; i++) {
				int x = aBinaryNumber.getDigit(i);
				if(overflow == true) {
					if(x == 1 && data[i] == 1) {
						data[i] = 1;
					}
					else if (x == 0 && data[i] == 0) {
						data[i] = 1;
						clearoverflow();
					}
					else {
						data[i] = 0;
					}
				}
				else {
					if(x == 1 && data[i] == 1) {
						data[i] = 0;
						overflow = true;
					} else if (x == 0 && data[i] == 0) {
						data[i] = 0;
					} else { 
						data[i] = 1;
					}
					
				}
			}
		}
	}
	public String toString() {
		//tooString for the Add Function
		if(overflow == true) {
			String x = "Overflow";
			return x;
		} else {
		String combo = "";
		for(int i = 0; i < getLength(); i++) {
			combo += data[i];
		}
		return combo;
		}
	}
	public static void main(String[] args) {
		
		
	}
}