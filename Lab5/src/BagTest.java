import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagTest {

	@Test
	void testConstructor() {

	Bag<String> bag = new Bag<String>();
	assertTrue( bag.isEmpty() );
	assertFalse( bag.isFull() );
	assertEquals(0, bag.size);

	}
	
	@Test
	void testAdd() {
		
		Bag<String> bag = new Bag<String>();
		assertTrue( bag.isEmpty() );
		bag.add("one");
		assertFalse( bag.isEmpty() );
		assertEquals(1, bag.size());
		
		bag.add("two");
		bag.add("three");
		bag.add("four");

		assertEquals(4, bag.size());

	}
	
	@Test
	void testGet() {
		
		Bag<String> bag = new Bag<String>();
		assertEquals(null, bag.get("one"));
		bag.add("one");

		bag.add("two");
		bag.add("three");
		bag.add("four");
		bag.add("five");
		
		assertEquals("one", bag.get("one"));
		assertEquals("three", bag.get("three"));
		
		for (int i=0; i < 20; i++) {
			bag.add(Integer.toString(i));
		}
		
		for (int i=0; i < 20; i++) {
			assertEquals(Integer.toString(i), bag.get(Integer.toString(i)));
		}

	}
	
	@Test
	void testGrab() {
		
		Bag<String> bag = new Bag<String>();
		for (int i=0; i < 10; i++) {
			bag.add(Integer.toString(i));
		}
		
		assertTrue( "0123456789".contains(bag.grab()));
		
		for ( int i=1; i < 20; i++) {
			System.out.print(bag.grab() + " ");
		}
		
	}
	
	@Test
	void testContains() {
		
		Bag<String> bag = new Bag<String>();
		for (int i=0; i < 10; i++) {
			bag.add(Integer.toString(i));
		}
		
		assertTrue( bag.contains("eight"));
		
	}

}
