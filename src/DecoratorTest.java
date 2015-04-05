import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecoratorTest {

	@Test
	public void testGetName() {
		Decorator d = new Decorator("M&M", 5);
		assertEquals("M&M", d.getName());
	}

	@Test
	public void testGetPrice() {
		Flavor f = new Flavor("M&M", 5);
		assertEquals(5, f.getPrice());
	}

}
