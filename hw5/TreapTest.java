package hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreapTest {
	Treap<String> StringTest = new Treap<String>();
	Treap<Integer> IntegerTest = new Treap<Integer>(60);
	
	@Test
	public void testIntegerTest() {
		IntegerTest.add(10);
		assertTrue(IntegerTest.add(20));
		IntegerTest.add(500);
		IntegerTest.add(19);
		IntegerTest.add(77);
		assertFalse(IntegerTest.add(77));
		System.out.println(IntegerTest.toString());
	}

	@Test
	public void testStringTest() {
		StringTest.add("Trees");
		assertTrue(StringTest.add(":)"));
		StringTest.add("Save");
		StringTest.add("The");
		StringTest.add("World");
		assertFalse(StringTest.add("The"));
		assertNotEquals("Test 2","WOrlD",StringTest.find("World"));
		System.out.println(StringTest.toString());
	}
	

}
	