import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class ArrayMapJUnitTest {

	@Test
	void testConstructor() {
		ArrayListMap<String, Integer> ages = new ArrayListMap<> ();	
	assertEquals(0, ages.size());
	assertTrue( ages.isEmpty());
	}
	
	@Test
	void testPut() {
		ArrayListMap<String, Integer> ages = new ArrayListMap<> ();
		
		ages.put("Mark",  32);
		ages.put("kelly",  31);
		ages.put("bobby",  36);
		ages.put("donnie",  34);
		ages.put("ellen",  60);
		ages.put("sean",  20);
		ages.put("bob",  62);
		ages.put("paula",  30);
		
		assertEquals( 8, ages.size());
	}

	@Test
	void testGet() {
ArrayListMap<String, Integer> ages = new ArrayListMap<> ();
		
		ages.put("Mark",  32);
		ages.put("kelly",  31);
		ages.put("bobby",  36);
		ages.put("donnie",  34);
		ages.put("ellen",  60);
		ages.put("sean",  20);
		ages.put("bob",  62);
		ages.put("paula",  30);
		
		assertEquals(32 , ages.get("Mark"));
		assertEquals(31 , ages.get("kelly"));
		assertEquals(36 , ages.get("bobby"));
		assertEquals(34 , ages.get("donnie"));
		assertEquals(60 , ages.get("ellen"));
		assertEquals(20 , ages.get("sean"));
		assertEquals(62 , ages.get("bob"));
		assertEquals(30 , ages.get("paula"));


	}
	
	@Test
	void testRemove() {
		
ArrayListMap<String, Integer> ages = new ArrayListMap<> ();
		
		ages.put("Mark",  32);
		ages.put("kelly",  31);
		ages.put("bobby",  36);
		ages.put("donnie",  34);
		ages.put("ellen",  60);
		ages.put("sean",  20);
		ages.put("bob",  62);
		ages.put("paula",  30);
		
		ages.remove("bobby");
		assertEquals( null ,  ages.get("bobby"));
		assertEquals( 7, ages.size());
		
		ages.remove("Mark");
		assertEquals( null ,  ages.get("Mark"));
		assertEquals( 6, ages.size());
		
		ages.remove("paula");
		assertEquals( null ,  ages.get("paula"));
		assertEquals( 5, ages.size());
		
		ages.remove("kelly");
		assertEquals( null ,  ages.get("kelly"));
		assertEquals( 4, ages.size());
		
		ages.remove("donnie");
		assertEquals( null ,  ages.get("donnie"));
		assertEquals( 3, ages.size());
		
		ages.remove("ellen");
		assertEquals( null ,  ages.get("ellen"));
		assertEquals( 2, ages.size());
		
		ages.remove("sean");
		assertEquals( null ,  ages.get("sean"));
		assertEquals( 1, ages.size());
		
		ages.remove("bob");
		assertEquals( null ,  ages.get("bob"));
		assertEquals( 0, ages.size());
		

		
	}
	
	@Test
	void testContainsKey() {
		
ArrayListMap<String, Integer> ages = new ArrayListMap<> ();
		
		ages.put("Mark",  32);
		ages.put("kelly",  31);
		ages.put("bobby",  36);
		ages.put("donnie",  34);
		ages.put("ellen",  60);
		ages.put("sean",  20);
		ages.put("bob",  62);
		ages.put("paula",  30);
		
		assertTrue( ages.containsKey("Mark"));
		assertTrue( ages.containsKey("paula"));
		assertTrue( ages.containsKey("bob"));
		assertTrue( ages.containsKey("sean"));
		assertTrue( ages.containsKey("ellen"));
		assertTrue( ages.containsKey("donnie"));
		assertTrue( ages.containsKey("bobby"));
		assertTrue( ages.containsKey("kelly"));
		
		assertFalse( ages.containsKey("jim"));


		
	}
	
	@Test
	void testKeySet() {
		
ArrayListMap<String, Integer> ages = new ArrayListMap<> ();
		
		ages.put("Mark",  32);
		ages.put("kelly",  31);
		ages.put("bobby",  36);
		ages.put("donnie",  34);
		ages.put("ellen",  60);
		ages.put("sean",  20);
		ages.put("bob",  62);
		ages.put("paula",  30);
		
		Set<String> result = ages.keySet();
		assertTrue( result.contains("Mark"));
		assertTrue( result.contains("paula"));
		assertTrue( result.contains("bob"));
		assertTrue( result.contains("sean"));
		assertTrue( result.contains("ellen"));
		assertTrue( result.contains("donnie"));
		assertTrue( result.contains("bobby"));
		assertTrue( result.contains("kelly"));
		
		assertEquals(8, result.size());
		
		
	}
	
}
