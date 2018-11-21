package shapes;

import java.util.Arrays;

public class PlayingWithShapes {

    public static void myPrint(Shape brody) {
    	    System.out.println(brody.toString());
    }
    
    public static String[] colors(HasColor[] ss) {
    		String[] res = new String[ss.length];
    		int i=0;
    		for (HasColor s:ss) {
    			res[i] = s.getColor();
    			i++;
    		}
    		return res;
    }
    
	public static void main (String[] args) {
		Rectangle r = new Rectangle(3.4,4.5,"blue");
		Circle c  = new Circle(4.5,"red");
//		Shape s = new Shape("yellow");
		
		Shape[] rs = new Shape[3];
		rs[0] = r;
		rs[1] = new Rectangle(2.4,4.7,"orange");
		rs[2] = c;
		
		Fruit[] fs = new Fruit[4];
		fs[0] = new Fruit("red");
		fs[1] = new Fruit("blue");
		fs[2] = new Fruit("green");
		fs[3] = new Fruit("yellow");
	
		System.out.println(Arrays.toString(colors(rs)));
		System.out.println(Arrays.toString(colors(fs)));

		System.out.println(r.getBaseHeight());
		System.out.println(r.getBaseColor());
		
		Pair<Shape,Shape> p = new Pair<Shape,Shape>(r,c);

	}
}
