package sprint1_team35;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
	
	static VendingMachine machine; // Creates VendingMachine object
	double double1;
	double double2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		machine = new VendingMachine();
	}

	@Test
	String testGetItem() {
		if (machine.getItem(1, 1) == null) {
			fail();	
		}
		return machine.getItem(1, 1);
	}

	@Test
	void testGetCost() {
		double1 = 2.00;
		machine.setItemCost(1, 1, double1);
		double expected = double1;
		double actual = machine.getCost(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	String testGetCashbox() {
		if (machine.getCashbox() == null) {
			fail();
		}
		return machine.getCashbox();	
	}

	@Test
	void testGetCredit() {
		machine.setCredit(1.00);
		double expected = 1.00;
		double actual = machine.getCredit();
		assertEquals(expected, actual);
		
	}

	@Test
	String testSetItemName() {
		machine.setItemName(1, 1, "testname");
		return machine.getItem(1, 1);
	}

	@Test
	String testSetItemCost() {
		double1 = 1.50;
		machine.setItemCost(1, 1, double1);
		if (machine.getItem(1, 1) == null) {
			fail();
		}
		return machine.getItem(1, 1);
	}

	@Test
	String testSetItemQuantity() {
		machine.setItemQuantity(1, 1, 5);
		if (machine.getItem(1, 1) == null) {
			fail();
		}
		return machine.getItem(1, 1);
	}

	@Test
	void testSetCredit() {
		double1 = 2.00;
		machine.setCredit(double1);
		double expected = double1;
		double actual = machine.getCredit();
		assertEquals(expected, actual);
	}

	@Test
	String testResetCashbox() {
		machine.resetCashbox();
		if (machine.getCashbox() == null) {
			fail();
		}
		return machine.getCashbox();
	}

	@Test
	String testRestock() {
		machine.restock(1, 1, 10);
		if (machine.getItem(0, 0) == null) {
			fail();
		}
		return machine.getItem(1,1);
	}

	@Test
	String testGiveChange() {
		double1 = 2.50;
		double2 = 1.00;
		if (machine.giveChange(double1, double2) == null) {
			fail();
		}
		return machine.giveChange(double1, double2);
	}

	@Test
	void testAddCredit() {
		double expected = machine.getCredit() + 2.00;
		double1 = 2.00;
		machine.addCredit(double1);
		double actual = machine.getCredit();
		assertEquals(expected, actual);
	}

	@Test
	void testPurchaseProduct() {
		machine.addCredit(2.00);
		int expected = 1;
		int actual = machine.purchaseProduct(2, 1);
		assertEquals(expected, actual);
	}
	

}
