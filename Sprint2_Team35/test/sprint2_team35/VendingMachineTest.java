package sprint2_team35;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
	
	static VendingMachine machine; // Creates VendingMachine object
	double double1;
	double double2;
	int [] testTubes = {10, 10, 10, 10, 10};


	@BeforeEach
	void setUpBeforeClass() throws Exception {
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
	void testSetCashBox() {
		System.out.println("\n===== TEST CASE FOR setCashBox() =====");
		String expected = "EUR";
		machine.setCashBox(new EURCashBox());
		CashBox cashbox = machine.getCashBox();
		Currency currency = cashbox.getCurrency();	
		String actual = currency.getCurrencyName();
		assertEquals(expected, actual);
		
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
	void testGetCashbox() {
		System.out.println("\n===== TEST CASE FOR getCashBox() =====");
		assertNotNull("\nTest testGetCashBox() failed --- null value returned", machine.getCashBox().toString());
	}

	@Test
	void testGetCredit() {
		System.out.println("\n===== TEST CASE FOR getCredit() =====");
		double expected = 0.00;
		double actual = machine.getCredit();
		assertEquals(expected, actual);
	}

	@Test
	String testSetItemName() {
		machine.setItemName(1, 1, "testname");
		if (machine.getItem(1, 1) == null) {
			fail();
		}
		return machine.getItem(1, 1);
	}

	@Test
	String testSetItemType() {
		machine.setItemType(1, 1, ProductType.HOTDRINK);
		if (machine.getItem(1, 1) == null) {
			fail();
		}
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
	String testSetItemSaleCount() {
		machine.setItemSaleCount(1, 1, 5);
		if (machine.getItem(1, 1) == null) {
			fail();
		}
		return machine.getItem(1, 1);
	}

	@Test
	void testAddTubes() {
		System.out.println("\n===== TEST CASE FOR addTubes() =====");
		CashBox cashbox = machine.getCashBox();
		ChangeTube[] changeTubes = cashbox.getChangeTubes();

		for (int i = 0; i < changeTubes.length; i++) {
			changeTubes[i].setQuantity(0);
		}
		
		machine.addTubes(testTubes);

		int expected = 10;
		int actual = changeTubes[0].getQuantity();
		System.out.println(changeTubes[0]);
		assertEquals(expected, actual);
	}


	@Test
	void testSetCredit() {
		System.out.println("\n===== TEST CASE FOR setCredit() =====");
		machine.setCredit(0.00);
		double expected = 0.00;
		double actual = machine.getCredit();
		assertEquals(expected, actual);
	}

	@Test
	void testResetCashbox() {
		System.out.println("\n===== TEST CASE FOR resetCashBox() =====");
		machine.resetCashbox();
		double expected = 0.00;
		double actual = machine.getCashBox().getCashBoxAmount();
		assertEquals(expected, actual);
	}

	@Test
	void testSaveToFile() {
		System.out.println("\n===== TEST CASE FOR saveToFile() =====");
		machine.getCashBox().setCashBoxAmount(50.00);
		machine.saveToFile();
		VendingMachine testMachine = new VendingMachine();
		CashBox testCashBox = testMachine.getCashBox();
		double expected = 50.00;
		double actual = testCashBox.getCashBoxAmount();
		assertEquals(expected, actual);
	}

	@Test
	void testGetGPS() {
	}

	@Test
	void testLogTransaction() {
	}

	@Test
	void testCopyToMasterFile() {
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
	void testGiveChange() {
		System.out.println("\n===== TEST CASE FOR giveChange() =====");
		assertNotNull("\nTest testGiveChange() failed --- null value returned", machine.giveChange(20.00, 10.00));
	}

	@Test
	void testAddCredit() {
		System.out.println("\n===== TEST CASE FOR addCredit() =====");
		machine.setCredit(0.00);
		machine.addCredit(2.00);
		double expected = 2.00;
		double actual = machine.getCredit();
		assertEquals(expected, actual);
	}

	@Test
	void testPurchaseProduct() {
		System.out.println("\n===== TEST CASE FOR purchaseProduct() =====");
		machine.setCredit(2.00);
		double actual = machine.purchaseProduct(2, 2);
		double expected = 1;
		assertEquals(expected, actual);
		
	}


	@Test
	String testHighestSaleCounts() {
		if(machine.highestSaleCounts() == null) {
			fail();
		}
		return machine.highestSaleCounts();
	}

	@Test
	String testDisplayProducts() {
		if(machine.displayProducts() == null) {
			fail();
		}
		return machine.displayProducts();
	}

	@Test
	String testSearchProduct() {
		if(machine.searchProduct(1, 1) == null) {
			fail();
		}
		return machine.searchProduct(1, 1);
	}

}
