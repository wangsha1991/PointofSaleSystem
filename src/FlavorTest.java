import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FlavorTest {

	@Test
	public void testGetName() {
		Flavor f = new Flavor("Vanilla", 20);
		assertEquals("Vanilla", f.getName());
	}

	@Test
	public void testGetPrice() {
		Flavor f = new Flavor("Vanilla", 20);
		assertEquals(20, f.getPrice());
	}

}
