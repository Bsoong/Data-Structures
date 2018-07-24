import static org.junit.Assert.*;

import org.junit.Test;
//Brandon Soong
//I pledge my honor that I have abided by the Stevens Honor System- Bsoong
public class IDLListTest {
	@Test(expected = IllegalArgumentException.class)
	public void addTest() {
		IDLList<Integer> a1 = new IDLList<Integer>();
		assertEquals(a1.add(-1, 0), Exception.class);		
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void gettest(){
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		a.append(2);
		a.append(3);
		assertEquals(a.get(17), Exception.class);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeAttest(){
		IDLList<Integer> a1 = new IDLList<Integer>();
		a1.add(1);
		a1.append(2);
		a1.append(3);
		assertEquals(a1.removeAt(17), Exception.class);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removetest(){
		IDLList<Integer> a = new IDLList<Integer>();
		assertEquals(a.remove(), Exception.class);
	}
	@Test(expected = NullPointerException.class)
	public void removeLasttest(){
		IDLList<Integer> a1 = new IDLList<Integer>();
		assertEquals(a1.removeLast(), Exception.class);
	}
	@Test(expected = IllegalArgumentException.class)
	public void appendtest(){
		IDLList<Integer> a1 = new IDLList<Integer>();
		a1.add(1);
		a1.append(2);
		a1.append(3);
		assertEquals(a1.append(null), Exception.class);
	}
	


}