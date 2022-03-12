package sprint2_team35;

import java.io.*;
import java.util.Scanner;

public class USBDevice {
	private String deviceName;
	private boolean insertDrive;

	public USBDevice(String deviceName, boolean insertDrive) {
		setDeviceName(deviceName);
		setInsertDrive(insertDrive);
	}

	public USBDevice() {
		setDeviceName("USB Device");
		setInsertDrive(false);
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public void setInsertDrive(boolean insertDrive) {
		this.insertDrive = insertDrive;
	}
	
	public String getDeviceName() {
		return this.deviceName;
	}

	public boolean detectUSB() {
		String[] driveLetters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		File[] listDrives = new File[driveLetters.length];
		boolean[] isDrive = new boolean[driveLetters.length];

		for (int i = 0; i < driveLetters.length; i++) {
			listDrives[i] = new File(driveLetters[i] + ":/");
			isDrive[i] = listDrives[i].canRead();
		}

		System.out.println("Waiting for USB device to perform software update...");

		while (!this.insertDrive) {
			for (int i = 0; i < driveLetters.length; i++) {
				boolean insertDrive = listDrives[i].canRead();

				if (insertDrive != isDrive[i]) {
					if (insertDrive) {
						this.setDeviceName(driveLetters[i] + ":/");
						this.setInsertDrive(true);
						System.out.println("The USB drive " + this.deviceName + " has been inserted.");
						
					} else {
						System.out.println("The USB drive " + this.deviceName + " has been ejected.");
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

	public String listContents(String directory) {
		File myFile = new File(directory);
		String list = "The following files are stored on this device: " + "\n";
		String[] listDirectory = myFile.list();

		for (String str : listDirectory) {
			list += str + "\n";
		}

		return list;
	}
	
	public String readContents(String directory, String fileName) {
		String demoMessage = "";
		String location = directory + fileName;
		File myFile = new File(location);
		try {
			Scanner sc = new Scanner(myFile);
			demoMessage += listContents(directory);
			while (sc.hasNextLine()) {
				demoMessage += sc.nextLine();	
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The update file " + fileName + "cannot be found on this USB memory device.");
		}
		
		if (demoMessage.trim() == "") {
			demoMessage += "There was a problem reading the update file.";
			return demoMessage;
		}
		else {
			return demoMessage;
		}
		
	}
}