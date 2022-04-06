package sprint2_team35;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
	
	static VendingMachine machine; // Creates VendingMachine object
	double double1;
	double double2;


	@BeforeEach
	void setUpBeforeClass() throws Exception {
		machine = new VendingMachine();
	}

	@Test
	void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCashBox() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCost() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCashbox() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCredit() {
		fail("Not yet implemented");
	}

	@Test
	void testSetItemName() {
		fail("Not yet implemented");
	}

	@Test
	void testSetItemType() {
		fail("Not yet implemented");
	}

	@Test
	void testSetItemCost() {
		fail("Not yet implemented");
	}

	@Test
	void testSetItemQuantity() {
		fail("Not yet implemented");
	}

	@Test
	void testSetItemSaleCount() {
		fail("Not yet implemented");
	}

	@Test
	void testAddTubes() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCredit() {
		fail("Not yet implemented");
	}

	@Test
	void testResetCashbox() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveToFile() {
		fail("Not yet implemented");
	}

	@Test
	void testLoadFromFile() {
		fail("Not yet implemented");
	}

	@Test
	void testGetGPS() {
		fail("Not yet implemented");
	}

	@Test
	void testLogTransaction() {
		fail("Not yet implemented");
	}

	@Test
	void testCopyToMasterFile() {
		fail("Not yet implemented");
	}

	@Test
	void testRestock() {
		fail("Not yet implemented");
	}

	@Test
	void testGiveChange() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCredit() {
		fail("Not yet implemented");
	}

	@Test
	void testPurchaseProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testDetectUSB() {
		fail("Not yet implemented");
	}

	@Test
	void testListUSBContents() {
		fail("Not yet implemented");
	}

	@Test
	void testReadUSBContents() {
		fail("Not yet implemented");
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
