package acorn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AcornDAOTest {
	
	AcornDAO dao = new AcornDAO();
	@Test
	void testInsert2() {
		//fail("Not yet implemented");
		int result = dao.insert2(new Customer("d1y","112","곽1야"));
		assertEquals(1, result);
	}

}
