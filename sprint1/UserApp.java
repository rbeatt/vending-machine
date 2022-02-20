package sprint1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UserApp {

	private static final DecimalFormat df = new DecimalFormat("0.00"); // Decimal format

	public static VendingMachine machine = new VendingMachine(); // Creates VendingMachine object 

	public static void main(String[] args) {
		addCredit(); // Initial state
	}
	
	/**
	 * This method receives input from the user to pass as a parameter for
	 * setCredit() in the VendingMachine class.
	 */

	public static void addCredit() {
		Scanner input = new Scanner(System.in);
		boolean finished = false;

		do {
			try {
				System.out.println("Please insert coin: ");
				String coin = input.nextLine(); // Reads input from the user
				if (coin.trim() == "") { // If no coins are entered, request a selection from the user.
					finished = true;

				} else {
					double value = Double.parseDouble(coin); // Converts input to a double value
					if (machine.addCredit(value) != 0) { // Passes as parameter to addCredit() in VendingMachine
						System.out.println("Credit: £" + df.format(machine.getCredit())); // Displays credit
						finished = false;
					}
					else {
						System.out.println("Machine only accepts 10p, 20p, 50p, £1 and £2 coins");
						addCredit();
					}
				}
			} catch (Exception e) { // Catches exceptions
				System.out.println("Try again.");
			}
		} while (!finished);

		displayInfo();

		input.close();
	}
	
	/**
	 * This method requests input from a user and calls toString() of the selected product.
	 */

	public static void displayInfo() {
		Scanner input = new Scanner(System.in);

		System.out.println("Please make a selection: ");
		String selection = input.nextLine();
		int row = -1;
		int column = -1;
		
		if (selection.trim() != "") {

		try {
			switch (selection.toUpperCase().charAt(0)) {
			case 'A':
				row = 1; // A = row 1
				break;
			case 'B':
				row = 2; // B = row 2
				break;
			case 'C':
				row = 3; // C = row 3
				break;
			case 'D':
				row = 4; // D = row 4
				break;
			case 'E':
				row = 5; // E = row 5
				break;
			default:
				row = 0;
				break;
			}
			column = Character.getNumericValue(selection.charAt(1)); // Column is equal to numeric value input by the user

			if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
				System.out.println(machine.getItem(row - 1, column - 1));
				purchaseProduct(row - 1, column - 1); // Calls purchaseProduct() with the selected product
			} else {
				System.out.println("Invalid selection.");
				displayInfo();
			}
		} catch (Exception e) {
			System.out.println("Invalid selection.");
			displayInfo(); 
		}
		
		}
		else {
			completePurchase(machine.getCredit(), 0.0);
		}

		input.close();
	}
	
	/**
	 * This method calls the purchaseProduct() method in the VendingMachine class
	 * @param row - the row number of selected product
	 * @param column - the column number of selected product
	 */

	public static void purchaseProduct(int row, int column) {
		Scanner input = new Scanner(System.in);
		double moneyPaid = machine.getCredit(); // Assigns the credit to a variable to be used to calculate change
		double actualCost = 0.0; // Cost of products purchased

		try {
			String[] options = { "Yes", "No" };
			Menu inputMenu = new Menu("\nWould you like to purchase this product?", options); // Prompts user

			boolean finished = false;
			do {
				int option = inputMenu.getUserChoice(); // Calls getUserChoice() in Menu class
				switch (option) {
				case 1: // Yes
					if (machine.purchaseProduct(row, column) == 1) { // 1 = product purchased
						actualCost += machine.getCost(row, column);
						finished = true;
						System.out.println("Purchase successful! Product being dispensed...");
						machine.saveToFile();
						if (machine.getCredit() > 0) {
							System.out.println("Credit remaining: " + df.format(machine.getCredit()));
							completePurchase(moneyPaid, actualCost);
						} else {
							addCredit();
						}
					}
					else if(machine.purchaseProduct(row, column) == 2) {
						System.out.println("\nInsufficient credit. Please insert more coins or cancel transaction.");
						addCredit();
					}
					else {
						System.out.println("\nItem is out of stock :( ");
						completePurchase(moneyPaid, actualCost);
					}
				case 2: // No
					finished = true;
					completePurchase(moneyPaid, 0.0);
					addCredit();
				default:
					System.out.println("\nNot a valid option.");
					break;
				}
			} while (!finished);

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method calls the giveChange() method in the VendingMachine class. This method is called after
	 * a purchase has been completed and there is credit remaining.
	 * @param moneyPaid - total amount inserted by customer
	 * @param actualCost - cost of the product
	 */

	public static void completePurchase(double moneyPaid, double actualCost) {
		Scanner input = new Scanner(System.in);
		try {
			String[] options = { "Yes", "No" };
			Menu inputMenu = new Menu("\nWould you like to make another purchase?", options); // Prompts user
			boolean finished = false;
			do {
				int option = inputMenu.getUserChoice(); // Calls getUserChoice() in Menu
				switch (option) {
				case 1:
					displayInfo(); // Calls displayInfo() to make another purchase
					break;
				case 2:
					System.out.println("Amount to be refunded: £" + df.format(machine.getCredit())); // Displays amount to be refunded
					machine.giveChange(moneyPaid, actualCost); // Calls giveChange() in VendingMachine using parameters
					if (machine.getCredit() == 0) { // Transaction successfully cancelled if credit = 0
						System.out.println("\nTransaction cancelled. Remaining credit refunded.");
						addCredit(); // Returns to initial state
					} else {
						System.out.println("Credit: £" + machine.getCredit());
						System.out.println("Error cancelling transacton.");
					}
					break;
				default:
					System.out.println("\nNot a valid option.");
					break;
				}
			} while (!finished);
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
