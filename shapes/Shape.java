package shapes;

public abstract class Shape implements HasColor {
	// Data field
	protected String color;
	protected String name;

	// Constructor
	Shape (String color) {
		this.color=color;
		this.name="uninitialized";
	}
	
	// Methods
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// Must be implemented by subclasses
	public abstract double area();
	
	public String toString() {
		return "color: "+color;
	}
	
}
