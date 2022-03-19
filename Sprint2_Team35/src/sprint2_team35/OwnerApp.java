package sprint2_team35;

import java.util.Scanner;

public class OwnerApp {

	private static Scanner myScanner = new Scanner(System.in);

	// Declaring and initialising vending machine object
	private static VendingMachine machine = new VendingMachine();

	public static void main(String[] args) {

		// Array of menu options

		String[] options = { "Restock machine", "Top up tubes", "View total in cashbox and tubes", "Set prices",
				"Reset cashbox", "Perform a software update", "Change item name","Show popular items" , "Exit Owner Mode" };
		Menu vendingMenu = new Menu("\nOwner Mode", options);

		boolean finished = false;
		do {
			int option = vendingMenu.getUserChoice();
			switch (option) {
			case 1:
				restockMachine();
				break;
			case 2:
				topUpTubes();
				break;
			case 3:
				viewTotal();
				break;
			case 4:
				setPrices();
				break;
			case 5:
				resetCashbox();
				break;
			case 6:
				softwareUpdate();
				break;
			case 7:
				changeItemData();
				break;
			case 8:
				showPopularItems();
				break;
			case 9:
				finished = true;
				break;
			default:
				System.out.println("\nNot a valid option."); // Displays when an invalid option is entered
				break;
			}
		} while (!finished); // Loop finishes when boolean value is true
	}

	/**
	 * This method lets a machine owner restock the items in the machine.
	 */

	private static void restockMachine() {
		boolean finished = false;
		boolean amountSet = false;
		int row;
		int column;

		int amount = -1;

		do {
			int[] item = getItem();
			if (item != null) {
				row = item[0];
				column = item[1];

				do {
					try {
						System.out.print("\nHow much should it be restocked by?: ");
						amount = myScanner.nextInt();
						myScanner.nextLine();
						if (amount >= 0) {
							machine.restock(row - 1, column - 1, amount);
							System.out.println("Item restocked!\n");
							finished = true;
							amountSet = true;
							machine.saveToFile();
						} else {
							System.out.println("Please input a non-negative integer.");
						}
					} catch (Exception e) {
						System.out.println("Please input a non-negative integer.");
						myScanner.nextLine();
					}
				} while (!amountSet);
			} else {
				System.out.println("\nNot a valid item reference");
			}

		} while (!finished);

	}

	/**
	 * This method lets a machine owner top up the change dispenser tubes.
	 */

	private static void topUpTubes() {
		// Adding 10s
		System.out.println("How many 10s would you like to add?");
		String Add10s = myScanner.nextLine(); // Read user input
		System.out.println("Added: " + Add10s); // Output user input

		// Adding 20s
		System.out.println("How many 20s would you like to add?");
		String Add20s = myScanner.nextLine(); // Read user input
		System.out.println("Added: " + Add20s); // Output user input

		// Adding 50s
		System.out.println("How many 50s would you like to add?");
		String Add50s = myScanner.nextLine(); // Read user input
		System.out.println("Added: " + Add50s); // Output user input

		// Adding Pounds

		System.out.println("How many £1s would you like to add?");
		String Add1s = myScanner.nextLine(); // Read user input
		System.out.println("Added: " + Add1s); // Output user input

		// Adding £2s
		System.out.println("How many £2s would you like to add?");
		String Add2s = myScanner.nextLine(); // Read user input
		System.out.println("Added: " + Add2s); // Output user input

		try {
			machine.addTubes(Integer.parseInt(Add10s), Integer.parseInt(Add20s), Integer.parseInt(Add50s),
					Integer.parseInt(Add1s), Integer.parseInt(Add2s));
			System.out.println("Coins added successfully.");
		} catch (Exception e) {
			System.out.println("An invalid amount was added.");
		}
		machine.saveToFile();
	}

	/**
	 * This method lets a machine owner view the total money in the collection box
	 * and change dispenser tubes.
	 */

	private static void viewTotal() {
		System.out.println("\n" + machine.getCashbox() + "\n");
	}

	/**
	 * This method lets a machine owner set the prices of items in the machine.
	 */

	private static void setPrices() {
		boolean finished = false;
		boolean priceSet = false;
		int row;
		int column;

		double cost = -1;

		do {
			int[] item = getItem();
			if (item != null) {
				row = item[0];
				column = item[1];
				do {
					try {
						System.out.println("\nEnter a new price: ");
						cost = myScanner.nextDouble();
						myScanner.nextLine();
						if (cost >= 0 && (cost * 100) % 10 == 0) {
							machine.setItemCost(row - 1, column - 1, cost);
							System.out.println("\nCost set");
							finished = true;
							priceSet = true;
							machine.saveToFile();
						} else {
							System.out.println("\nPlease input a valid double value.");
						}
					} catch (Exception e) {
						System.out.println("\nPlease input a valid double value.");
						myScanner.nextLine();
					}
				} while (!priceSet);

			} else {
				System.out.println("\nNot a valid item reference.");
			}

		} while (!finished);

	}

	private static int[] getItem() {
		System.out.println("\nSelect an item to make changes to (e.g., A1, B3, etc.)");
		String input = myScanner.nextLine();
		int row = -1;
		int column = -1;
		try {
			switch (input.toUpperCase().charAt(0)) {
			case 'A':
				row = 1;
				break;
			case 'B':
				row = 2;
				break;
			case 'C':
				row = 3;
				break;
			case 'D':
				row = 4;
				break;
			case 'E':
				row = 5;
				break;
			default:
				row = 0;
				break;
			}
			column = Character.getNumericValue(input.charAt(1));

			if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
				System.out.println("\nDetails of item " + input + ":");
				System.out.println(machine.getItem(row - 1, column - 1));
				int[] result = { row, column };
				return result;

			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * This method simulates performing a software update on the vending machine
	 * using methods from USBDevice.
	 */

	private static void softwareUpdate() {
		if (machine.detectUSB()) {
			String[] options = { "Yes", "No" };
			Menu updateMenu = new Menu("\nWould you like to perform a software update with this device?", options);

			boolean finished = false;
			do {
				int option = updateMenu.getUserChoice();
				switch (option) {
				case 1:
					System.out.println(machine.listUSBContents());
					System.out.println("\nPlease enter the file you'd like to perform an update from: ");
					System.out.println(machine.readUSBContents(myScanner.nextLine()));
					finished = true;
					break;
				case 2:
					finished = true;
					break;
				default:
					System.out.println("\nNot a valid option."); // Displays when an invalid option is entered
					break;
				}
			} while (!finished); // Loop finishes when boolean value is true
		} else {
			System.out.println("\nA USB device has not been inserted");
		}
	}

	/**
	 * This method allows the owner to change the names of items.
	 */

	private static void changeItemData() {
		boolean finished = false;
		boolean nameSet = false;
		int row;
		int column;
		String name = "";

		System.out.println("\nPlease insert a keyboard to change item data.");
		if (machine.detectUSB()) { // Checks if a USB device is connected, i.e., a keyboard.

			do {
				int[] item = getItem();
				if (item != null) {
					row = item[0];
					column = item[1];
					do {
						try {
							System.out.println("\nWhat should the new name be?: ");
							name = myScanner.nextLine();
							if (name.trim() != "") {
								machine.setItemName(row - 1, column - 1, name);
								System.out.println("\nName set!");
								finished = true;
								nameSet = true;
								machine.saveToFile();
							} else {
								System.out.println("\nName not set! No user input was detected.");
								finished = false;
							}
						} catch (Exception e) {
							System.out.println("Name not set! Invalid user input.");
						}
					} while (!nameSet);

				} else {
					System.out.println("\nNot a valid item reference.");
				}
			} while (!finished);
		} else {
			System.out.println("\nA keyboard has not been inserted.");
		}
	}

	/**
	 * This method lets a machine owner reset the cashbox.
	 */

	private static void resetCashbox() {
		System.out.println("\nCashbox reset!");
		machine.resetCashbox();
		machine.saveToFile();
	}
	
	private static void showPopularItems() {
		machine.highestSaleCounts();
	}

}
