package shapes;

public class Circle extends Shape {
	// Data fields
	private double radius;
	
	Circle(double r, String c) {
		super(c);
		radius=r;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return Math.PI*radius*radius;
	}
	
	public String toString() {
		return "radius: "+radius+ ", color "+color;
	}
}
