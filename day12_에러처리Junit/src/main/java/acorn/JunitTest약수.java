package acorn;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JunitTest약수 {
	JunitTest test = new JunitTest();
	@Test
	void testMeasure() {
		//fail("Not yet implemented");
		ArrayList<Integer> list = new ArrayList<>();
		list = test.measure(6);
		
		ArrayList<Integer> list2 = new ArrayList<>(List.of(1,2,3,6));

		assertEquals(list2, list);
	}

}
