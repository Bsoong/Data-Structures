package shapes;

public class Fruit implements HasColor {
	// Data fields
	private String fruitColor;
	
	 // Constructor
	Fruit(String color) {
		fruitColor=color;
	}

	public String getColor() {
		return fruitColor;
	}

	public void setColor(String fruitColor) {
		this.fruitColor = fruitColor;
	}
	
	
	
}
