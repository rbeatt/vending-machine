package sprint2_team35;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChangeTubeTest {
	ChangeTube testChangeTube;

	@BeforeEach
	void setUp() throws Exception {
		testChangeTube = new ChangeTube("testChangeTube", 10);
	}

	@Test
	void testGetQuantity() {
		System.out.println("\n===== TEST CASE FOR getQuantity() =====");
		int expected = 10;
		int actual = testChangeTube.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testSetQuantity() {
		System.out.println("\n===== TEST CASE FOR setQuantity() =====");
		testChangeTube.setQuantity(20);
		int expected = 20;
		int actual = testChangeTube.getQuantity();
		assertEquals(expected, actual);

		testChangeTube.setQuantity(-1);
		int newExpected = 0;
		int newActual = testChangeTube.getQuantity();
		assertEquals(newExpected, newActual);
	}
	
	@Test
	void testGetTubeName() {
		System.out.println("\n===== TEST CASE FOR getTubeName() =====");
		String expected = "testChangeTube";
		String actual = testChangeTube.getTubeName();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetTubeName() {
		System.out.println("\n===== TEST CASE FOR setTubeName() =====");
		String newTubeName = "newChangeTube";
		testChangeTube.setTubeName(newTubeName);
		String expected = newTubeName;
		String actual = testChangeTube.getTubeName();
		assertEquals(expected, actual);
		
		testChangeTube.setTubeName("");
		String newExpected = "changeTube";
		String newActual = testChangeTube.getTubeName();
		assertEquals(newExpected, newActual);
	}
	
	@Test
	void testToString() {
		System.out.println("\n===== TEST CASE FOR toString() =====");
		assertNotNull("\nTest testToString() failed --- null value returned", testChangeTube.toString());
	}

}
