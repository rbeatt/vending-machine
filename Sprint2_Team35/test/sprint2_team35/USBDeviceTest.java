package sprint2_team35;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class USBDeviceTest {
	USBDevice testDevice;
	String dir;

	@BeforeEach
	void setUp() throws Exception {
		testDevice = new USBDevice("testDevice", true);
		dir = System.getProperty("user.dir");
	}

	@Test
	void testSetDeviceName() {
		System.out.println("\n===== TEST CASE FOR setDeviceName() =====");
		testDevice.setDeviceName("newDevice");
		String expected = "newDevice";
		String actual = testDevice.getDeviceName();
		assertEquals(expected, actual);

		testDevice.setDeviceName("");
		String newExpected = "USB Device";
		String newActual = testDevice.getDeviceName();
		assertEquals(newExpected, newActual);
	}

	@Test
	void testGetDeviceName() {
		System.out.println("\n===== TEST CASE FOR getDeviceName() =====");
		String expected = "testDevice";
		String actual = testDevice.getDeviceName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetInsertDrive() {
		System.out.println("\n===== TEST CASE FOR setInsertDrive() =====");
		testDevice.setInsertDrive(false);
		boolean expected = false;
		boolean actual = testDevice.getInsertDrive();
		assertEquals(expected, actual);
	}

	@Test
	void testGetInsertDrive() {
		System.out.println("\n===== TEST CASE FOR getInsertDrive() =====");
		boolean expected = true;
		boolean actual = testDevice.getInsertDrive();
		assertEquals(expected, actual);
	}

	@Test
	void testDetectUSB() {
		System.out.println("\n===== TEST CASE FOR detectUSB() =====");
		assertTrue("\nTest Case testDetectUSB() failed --- false value returned", testDevice.detectUSB());
	}

	@Test
	void testListContents() {
		System.out.println("\n===== TEST CASE FOR listContents() =====");
		String dir = System.getProperty("user.dir");
		boolean testListContents = false;

		if (testDevice.listContents(dir) != "") {
			testListContents = true;
		}

		boolean expected = true;
		boolean actual = testListContents;
		assertEquals(expected, actual);
	}

	@Test
	void testReadContents() {
		System.out.println("\n===== TEST CASE FOR readContents() USING A FILE THAT DOESN'T EXIST ======");
		boolean testReadContents = false;
		if (testDevice.readContents(dir, "DoesNotExist.txt") == "") {
			testReadContents = true;
		}

		boolean expected = true;
		boolean actual = testReadContents;
		assertEquals(expected, actual);
	}
}
