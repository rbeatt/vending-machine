package sprint2_team35;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashBoxTest {

	CashBox testCashBox;
	ChangeTube[] testChangeTubes;
	int[] testIntArray = { 1, 1, 1, 1, 1 };
	double[] testDoubleArray = { 0.25, 0.50, 0.75, 1.00, 1.25 };

	@BeforeEach
	void setUp() throws Exception {
		testCashBox = new CashBox();
		testChangeTubes = testCashBox.getChangeTubes();
	}

	@Test
	void testGetChangeTubes() {
		System.out.println("\n===== TEST CASE FOR getChangeTubes() =====");
		assertNotNull("\nTest testGetChangeTubes() failed --- null value returned", testCashBox.getChangeTubes());
	}

	@Test
	void testSetChangeTubes() {
		System.out.println("\n===== TEST CASE FOR setChangeTubes() =====");
		testChangeTubes = testCashBox.getChangeTubes();
		int[] testArray = new int[testChangeTubes.length];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = 1;
		}

		testCashBox.setChangeTubes(testArray);

		int expected = 1;
		int actual = testChangeTubes[0].getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCurrency() {
		System.out.println("\n===== TEST CASE FOR getCurrency() =====");
		Currency testCurrency = testCashBox.getCurrency();
		String expected = "GBP";
		String actual = testCurrency.getCurrencyName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCurrency() {
		System.out.println("\n===== TEST CASE FOR setCurrency() =====");
		Currency testCurrency = new Currency(1.19, "EUR", "EURcashbox.csv", new String[] { "€", "c" });
		testCashBox.setCurrency(testCurrency);
		String expected = "EUR";
		String actual = testCashBox.getCurrency().getCurrencyName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCashBoxAmount() {
		System.out.println("\n===== TEST CASE FOR getCashBoxAmount() =====");
		double expected = 0.00;
		double actual = testCashBox.getCashBoxAmount();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCashBoxAmount() {
		System.out.println("\n===== TEST CASE FOR setCashBoxAmount() =====");
		testCashBox.setCashBoxAmount(1.00);
		double expected = 1.00;
		double actual = testCashBox.getCashBoxAmount();
		assertEquals(expected, actual);

		testCashBox.setCashBoxAmount(-1.00);
		double newExpected = 0.00;
		double newActual = testCashBox.getCashBoxAmount();
		assertEquals(newExpected, newActual);
	}

	@Test
	void testEnterCoin() {
		System.out.println("\n===== TEST CASE FOR enterCoin() =====");
		int actual = 0;
		testChangeTubes = testCashBox.getChangeTubes();
		testCashBox.enterCoin(2.00);
		for (int i = 0; i < testChangeTubes.length; i++) {
			if (testChangeTubes[i].getQuantity() == 1) {
				actual = 1;
			}
		}
		int expected = 1;

		assertEquals(expected, actual);
	}

	@Test
	void testGiveChange() {
		System.out.println("\n===== TEST CASE FOR giveChange() =====");
		int expected = 1;
		testChangeTubes = testCashBox.getChangeTubes();
		int[] testArray = new int[testChangeTubes.length];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = 1;
		}
		testCashBox.addTubes(testArray);

		int actual = testCashBox.giveChange(7.60, 3.80)[0];

		assertEquals(expected, actual);
	}

	@Test
	void testAddTubes() {
		System.out.println("\n===== TEST CASE FOR addTubes() =====");
		int expected = 1;
		int actual = 0;
		testChangeTubes = testCashBox.getChangeTubes();
		testCashBox.addTubes(testIntArray);
		for (int i = 0; i < testChangeTubes.length; i++) {
			if (testChangeTubes[i].getQuantity() == 1) {
				actual = 1;
			}
		}

		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		System.out.println("\n===== TEST CASE FOR toString() =====");
		assertNotNull("\nTest testToString() failed --- null value returned", testCashBox.toString());
	}

	@Test
	void testGetAcceptedCoins() {
		System.out.println("\n===== TEST CASE FOR getAcceptedCoins() =====");
		assertNotNull("\nTest testGetAcceptedCoins() failed --- null value returned", testCashBox.getAcceptedCoins());
		double expected = 0.10;
		double actual = testCashBox.getAcceptedCoins()[0];
		assertEquals(expected, actual);
	}

	@Test
	void testSetAcceptedCoins() {
		System.out.println("\n===== TEST CASE FOR setAcceptedCoins() =====");
		testCashBox.setAcceptedCoins(testDoubleArray);
		double expected = 0.25;
		double actual = testCashBox.getAcceptedCoins()[0];
		assertEquals(expected, actual);

		double[] newTestDoubleArray = new double[testDoubleArray.length];

		for (int i = 0; i < newTestDoubleArray.length; i++) {
			newTestDoubleArray[i] = -0.01;
		}
		testCashBox.setAcceptedCoins(newTestDoubleArray);

		double newExpected = 0.00;
		double newActual = testCashBox.getAcceptedCoins()[0];
		assertEquals(newExpected, newActual);

	}
}
