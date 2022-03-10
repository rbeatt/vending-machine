package sprint1_team35;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

	Item item = new Item();
	
	@BeforeEach
	void setUp() throws Exception {
		item = new Item();
	}

	@Test
	void testSetName() {
		item.setName("Name");
		String expected = "Name";
		String actual = item.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCost() {
		item.setCost(1.50);
		double expected = 1.5;
		double actual = item.getCost();
		assertEquals(expected, actual);
	}

	@Test
	void testSetQuantity() {
		item.setQuantity(20);
		int expected = 20;
		int actual = item.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testGetName() {
		item.setName("Name");
		String expected = "Name";
		String actual = item.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCost() {
		item.setCost(1.50);
		double expected = 1.5;
		double actual = item.getCost();
		assertEquals(expected, actual);
	}

	@Test
	void testGetQuantity() {
		item.setQuantity(20);
		int expected = 20;
		int actual = item.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		item.setName("Name");
		item.setCost(1.50);
		item.setQuantity(20);
		String expected = "Name: Name\nPrice: £1.50\nAmount in stock: 20";
		String actual = item.toString();
		assertEquals(expected, actual);
	}

}