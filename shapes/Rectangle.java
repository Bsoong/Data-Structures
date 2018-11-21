package shapes;


public class Rectangle extends Shape { 
	// Data fields or Instance Variables
	private double base;
	private double height;
	// Static or class variables
	public static int noOfRectangles;
	
	// Constructors
	Rectangle (double b, double h, String c) {
		super(c);
		base=b;
		height=h;
		noOfRectangles++;
	}
	
	// Methods
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	/**
	 * Sets the base of a rectanlge
	 * @param base This is the base
	 */
	public void setBase(double base) {
		this.base=base;
	}

	public void setHeight(double height) {
		this.height=height;
	}
	
	public double area() {
		return base*height;
	}
	
	public Pair<Double,Double> getBaseHeight() {
		return new Pair<Double,Double>(base,height);
	}
	
	public Pair<Double,String> getBaseColor() {
		return new Pair<Double,String>(base,color);
	}
	
	/* This method returns a string representation 
	 * of rectangles 
	 */
	public String toString() {
		return "base: "+base+ ", height "+height + ", color "+color;
	}
	
	

	
}