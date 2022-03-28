package sprint2_team35;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrencyTest {
	Currency testCurrency;
	Currency testEURCurrency;
	String[] testStringArray = { "$", "c" };

	@BeforeEach
	void setUp() throws Exception {
		testCurrency = new Currency();
		testEURCurrency = new Currency(1.19, "EUR", "EURcashbox.csv", new String[] { "€", "c" });
	}

	@Test
	void testGetRate() {
		System.out.println("\n===== TEST CASE FOR getRate() =====");
		double expected = 1.00;
		double actual = testCurrency.getRate();
		assertEquals(expected, actual);
	}

	@Test
	void testSetRate() {
		System.out.println("\n===== TEST CASE FOR setRate() =====");
		testEURCurrency.setRate(1.18);
		double expected = 1.18;
		double actual = testEURCurrency.getRate();
		assertEquals(expected, actual);

		testEURCurrency.setRate(-0.01);
		double newExpected = 1.00;
		double newActual = testEURCurrency.getRate();
		assertEquals(newExpected, newActual);
	}

	@Test
	void testGetCurrencyName() {
		System.out.println("\n===== TEST CASE FOR getCurrencyName() =====");
		String expected = "GBP";
		String actual = testCurrency.getCurrencyName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCurrencyName() {
		System.out.println("\n===== TEST CASE FOR setCurrencyName() =====");
		testCurrency.setCurrencyName("USD");
		String expected = "USD";
		String actual = testCurrency.getCurrencyName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetMyDir() {
		System.out.println("\n===== TEST CASE FOR getMyDir() =====");
		String expected = "cashbox.csv";
		String actual = testCurrency.getMyDir();
		assertEquals(expected, actual);

	}

	@Test
	void testSetMyDir() {
		System.out.println("\n===== TEST CASE FOR setMyDir() =====");
		testCurrency.setMyDir("newcashbox.csv");
		String expected = "newcashbox.csv";
		String actual = testCurrency.getMyDir();
		assertEquals(expected, actual);

		testCurrency.setMyDir("");
		String newExpected = "cashbox.csv";
		String newActual = testCurrency.getMyDir();
		assertEquals(newExpected, newActual);
	}

	@Test
	void testGetCurrencySymbols() {
		System.out.println("\n===== TEST CASE FOR getCurrencySymbols() =====");
		assertNotNull("\nTest testGetCurrencySymbols() failed --- null value returned",
				testCurrency.getCurrencySymbols());
	}

	@Test
	void testSetCurrencySymbols() {
		System.out.println("\n===== TEST CASE FOR setCurrencySymbols() =====");
		testCurrency.setCurrencySymbols(testStringArray);
		String expected = "$";
		String actual = testCurrency.getCurrencySymbols()[0];
		assertEquals(expected, actual);
		testCurrency.setCurrencySymbols(null);
		assertNotNull("\nTest testGetCurrencySymbols() failed --- null value returned",
				testCurrency.getCurrencySymbols());

	}

}
