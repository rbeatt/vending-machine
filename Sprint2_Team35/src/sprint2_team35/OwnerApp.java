package sprint2_team35;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OwnerApp {

	private static Scanner myScanner = new Scanner(System.in);

	// Declaring and initialising vending machine object

	private static VendingMachine machine = new VendingMachine();
	
	// Decimal format

	private static final DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		// Array of menu options

		String[] options = { "Restock machine", "Top up tubes", "View total in cashbox and tubes", "Set prices",
				"Empty cashbox", "Perform a software update", "Change item name", "Show popular items",
				"Search Product", "Exit Owner Mode" };
		Menu vendingMenu = new Menu("\nOwner Mode", options);

		boolean finished = false;
		do {
			int option = vendingMenu.getUserChoice();
			switch (option) {
			case 1:
				restockMachine();
				break;
			case 2:
				topUpTubes(setCashBox());
				break;
			case 3:
				viewTotal(setCashBox());
				break;
			case 4:
				setPrices();
				break;
			case 5:
				resetCashbox(setCashBox());
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
				searchProduct();
				break;
			case 10:
				finished = true;
				break;
			default:
				System.out.println("\nNot a valid option."); // Displays when an invalid option is entered
				break;
			}
		} while (!finished); // Loop finishes when boolean value is true
	}

	/**
	 * This method is used to set the appropriate cash box for the selected
	 * currency. A list of available currencies are displayed in a switch.
	 * 
	 * @return - CashBox instance
	 */

	private static CashBox setCashBox() {
		boolean finished = false;
		String[] currencies = { "GBP", "EUR" };
		Menu currencyMenu = new Menu("\nPlease select which cash box you would like to interact with: ", currencies);
		do {
			int option = currencyMenu.getUserChoice();
			switch (option) {
			case 1:
				finished = true;
				return machine.setCashBox(new CashBox());
			case 2:
				finished = true;
				return machine.setCashBox(new EURCashBox());
			default:
				System.out.println("\nInvalid selection");
				break;
			}
		} while (!finished);

		return null;
	}

	/**
	 * This method lets a machine owner re stock the items in the machine.
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
	 * 
	 * @param cashbox - the cash box being modified
	 */

	private static void topUpTubes(CashBox cashbox) {
		Currency currency = cashbox.getCurrency();
		int add = 0;
		int[] data = new int[cashbox.getAcceptedCoins().length];
		for (int i = 0; i < cashbox.getAcceptedCoins().length; i++) {
			System.out.println("How many " + currency.getCurrencySymbols()[0] + df.format(cashbox.getAcceptedCoins()[i])
					+ " would you like to add?: ");
			try {
				add = myScanner.nextInt();
				myScanner.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid coin amount.");
				add = 0;
			}

			data[i] = add;
		}

		try {
			machine.addTubes(data);
			System.out.println("Coins added successfully.");
		} catch (Exception e) {
			System.out.println("An invalid amount was added.");
		}
		machine.saveToFile();
	}

	/**
	 * This method lets a machine owner view the total money in the collection box
	 * and change dispenser tubes.
	 * 
	 * @param cashbox - the cash box being modified
	 */

	private static void viewTotal(CashBox cashbox) {
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
						System.out.println("\nEnter a new price £: ");
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

	/**
	 * This method accepts input from the user to search for products
	 * 
	 * @return - an Integer array containing the row and column index of the product
	 */

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
	 * This method lets a machine owner reset the cash box.
	 */

	private static void resetCashbox(CashBox cashbox) {
		System.out.println("\nCashbox reset!");
		machine.resetCashbox();
		machine.saveToFile();
	}

	private static void showPopularItems() {
		machine.highestSaleCounts();
	}

	private static void searchProduct() {
		System.out.println("\nSelect an item to see details to (e.g., A1, B3, etc.)");
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

			System.out.println(machine.searchProduct(row, column));
		} catch (Exception e) {

		}
	}

}
