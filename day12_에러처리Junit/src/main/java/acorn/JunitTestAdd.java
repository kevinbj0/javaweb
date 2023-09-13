package acorn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTestAdd {

	JunitTest test = new JunitTest();
	@Test
	void testAdd() {
		int result = test.add(5, 3);
		assertEquals(8, result);
	}

}
