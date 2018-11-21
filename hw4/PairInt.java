package hw4;

public class PairInt {
	private int x;
	private int y;
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	//getter for x
	public int getX() {
		return x;
	}
	//setter for x
	public void setX(int x) {
		this.x = x;
	}
	//getter for y 
	public int getY() {
		return y;
	}
	//setter for y
	public void setY(int y) {
		this.y = y;
	}
	public boolean equals(Object P) {
		return (this.x == ((PairInt) P).getX() &&  this.y== ((PairInt)P ).getY());
	}
	public PairInt copy() {
		return new PairInt(this.x, this.y);
	}
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
