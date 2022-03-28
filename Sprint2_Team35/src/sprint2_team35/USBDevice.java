package sprint2_team35;

import java.io.*;
import java.util.Scanner;

public class USBDevice {
	private String deviceName = "USB Device";
	private boolean insertDrive = false;

	/**
	 * The constructor method for USBDevice
	 * 
	 * @param deviceName  - the name of the USBDevice inserted
	 * @param insertDrive - true if a device is inserted and false if a device is
	 *                    not inserted
	 */

	public USBDevice(String deviceName, boolean insertDrive) {
		this.deviceName = deviceName;
		this.insertDrive = insertDrive;
	}

	/**
	 * Overloaded constructor method for initialising an undefined USBDevice object.
	 */

	public USBDevice() {
	}

	/**
	 * Setter method for deviceName.
	 * 
	 * @param deviceName - name of the USB device
	 */

	public void setDeviceName(String deviceName) {
		if (deviceName.trim() == "") {
			this.deviceName = "USB Device";
		} else {
			this.deviceName = deviceName;
		}
	}

	/**
	 * Setter method for insertDrive.
	 * 
	 * @param insertDrive - true if a device is inserted, false if a device is not
	 *                    inserted
	 */

	public void setInsertDrive(boolean insertDrive) {
		this.insertDrive = insertDrive;
	}

	/**
	 * Getter method for insertDrive
	 * 
	 * @return - boolean value (true if device is inserted, false if not)
	 */

	public boolean getInsertDrive() {
		return this.insertDrive;
	}

	/**
	 * Setter method for deviceName
	 * 
	 * @return - name of the USB device
	 */

	public String getDeviceName() {
		return this.deviceName;
	}

	/**
	 * This method will change the state of insertDrive to true if a USB device has
	 * been inserted and display the drive letter of the name.
	 * 
	 * @return - insertDrive boolean value
	 */

	public boolean detectUSB() {
		String[] driveLetters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" }; // An array of drive
																								// letters
		File[] listDrives = new File[driveLetters.length];
		boolean[] isDrive = new boolean[driveLetters.length];

		for (int i = 0; i < driveLetters.length; i++) {
			listDrives[i] = new File(driveLetters[i] + ":/");
			isDrive[i] = listDrives[i].canRead(); // .canRead returns true if the file location exists and can be read
													// from
		}

		System.out.println("\nWaiting for USB device...");

		while (!this.insertDrive) {
			for (int i = 0; i < driveLetters.length; i++) {
				boolean insertDrive = listDrives[i].canRead();

				if (insertDrive != isDrive[i]) {
					if (insertDrive) {
						this.setDeviceName(driveLetters[i] + ":/");
						this.setInsertDrive(true);
						System.out.println("\nThe USB device " + this.deviceName + " has been inserted.");

					} else {
						System.out.println("\nThe USB device " + this.deviceName + " has been ejected.");
						isDrive[i] = insertDrive;
						this.setInsertDrive(false);
					}
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				;
			}
		}

		return this.insertDrive;
	}

	/**
	 * This method lists the files stored on the USB memory device.
	 * 
	 * @param directory - name of the USB drive
	 * @return - a String containing the files stored on the USB memory device
	 */

	public String listContents(String directory) {
		File myFile = new File(directory);
		String list = "\nThe following files are stored on this device: " + "\n";
		String[] listDirectory = myFile.list();

		for (String str : listDirectory) {
			list += str + "\n";
		}

		return list;
	}

	/**
	 * This method reads the contents of the "update" file stored on the USB memory
	 * device.
	 * 
	 * @param directory - name of the USB drive
	 * @param fileName  - name of the file to be read
	 * @return - the contents of the file being read
	 */

	public String readContents(String directory, String fileName) {
		String demoMessage = "";
		String location = directory + fileName;
		File myFile = new File(location);
		try {
			Scanner sc = new Scanner(myFile);
			while (sc.hasNextLine()) {
				demoMessage += sc.nextLine() + "\n";
			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("\nThe update file " + fileName + " cannot be found on this USB memory device.");
		}

		return demoMessage;

	}
}