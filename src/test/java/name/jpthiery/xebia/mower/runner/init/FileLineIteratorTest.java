package name.jpthiery.xebia.mower.runner.init;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class FileLineIteratorTest {

	@Test
	public void read_scenarioA_file() {
		
		FileLineIterator iterator = new FileLineIterator("src/test/resources/scenarioA.txt");
		
		assertTrue(iterator.hasNext());
		assertEquals("5 5", iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals("1 2 N", iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals("GAGAGAGAA", iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals("3 3 E", iterator.next());
		
		assertTrue(iterator.hasNext());
		assertEquals("AADAADADDA", iterator.next());
		
		assertFalse(iterator.hasNext());
	}
	
}
