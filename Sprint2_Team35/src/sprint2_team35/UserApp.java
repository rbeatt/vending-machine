package sprint2_team35;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class UserApp {

	private static final DecimalFormat df = new DecimalFormat("0.00"); // Decimal format
	private static final Scanner input = new Scanner(System.in); // Scanner object

	public static VendingMachine machine = new VendingMachine(); // Creates VendingMachine object

	public static void main(String[] args) {
		verifyIdentity(); // Initial state
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
	 * This method lets a user verify their identity using either login details or
	 * simulated facial recognition.
	 */

	public static void verifyIdentity() {

		String[] options = { "Username and Password", "Facial Recognition" };
		String title = "Select a method to log in:";
		Menu loginMenu = new Menu(title, options);

		boolean finished = false;
		do {
			int option = loginMenu.getUserChoice();
			switch (option) {
			case 1:
				logIn();
				finished = true;
				break;
			case 2:
				facialRecognition();
				finished = true;
				break;
			default:
				System.out.println("\nNot a valid option."); // Displays when an invalid option is entered
				break;
			}
		} while (!finished); // Loop finishes when boolean value is true

		verifyIdentity(); // Returns to initial state

	}

	/**
	 * This method simulates a user logging into an account.
	 */

	private static void logIn() {

		System.out.println("Please input username:\n(For simulation purposes, correct username is 'name')");
		String inputUsername = input.nextLine();
		System.out.println("Please input password:\n(For simulation purposes, correct password is '12345')");
		String inputPassword = input.nextLine();

		if (inputUsername.matches("name") && inputPassword.matches("12345")) {
			System.out.println("Login successful!\n");
			addCredit(setCashBox());
		} else {
			System.out.println("Sorry, username or password is incorrect. Please try again.\n");
			verifyIdentity();
		}

	}

	/**
	 * This method simulates a user verifying their identity with facial
	 * recognition.
	 */

	private static void facialRecognition() {

		System.out.println("Scanning face...");

		Random rand = new Random();
		if (rand.nextInt(2) == 1) {
			System.out.println("Face recognised! You are now logged in.\n");
			addCredit(setCashBox());
		} else {
			System.out.println("Sorry, face not recognised. Please try again.\n");
			verifyIdentity();
		}

	}

	/**
	 * 
	 * This method receives input from the user to pass as a parameter for
	 * setCredit() in the VendingMachine class.
	 * 
	 * @param cashbox - the cash box being modified
	 * 
	 */

	private static void addCredit(CashBox cashbox) {
		String acceptedCoinsString = "";
		boolean finished = false;
		double[] acceptedCoins = cashbox.getAcceptedCoins();

		do {
			try {
				System.out.println("Please insert coin: ");
				String coin = input.nextLine(); // Reads input from the user
				if (coin.trim() == "") { // If no coins are entered, request a selection from the user.
					finished = true;

				} else {
					double value = Double.parseDouble(coin); // Converts input to a double value
					if (machine.addCredit(value) != 0) { // Passes as parameter to addCredit() in
															// VendingMachine
						System.out.println("Credit: £" + df.format(machine.getCredit())); // Displays credit
						finished = false;
					} else {
						acceptedCoinsString += "\nMachine only accepts: ";
						for (int i = 0; i < acceptedCoins.length; i++) {
							acceptedCoinsString += df.format(acceptedCoins[i]) + ", ";
						}
						System.out.println(acceptedCoinsString);
						addCredit(null);
					}
				}
			} catch (Exception e) { // Catches exceptions
				System.out.println("Try again.");
			}
		} while (!finished);

		displayInfo(cashbox);

	}

	/**
	 * This method requests input from a user and calls toString() of the selected
	 * product.
	 * 
	 * @param cashbox - the cash box being modified
	 */

	private static void displayInfo(CashBox cashbox) {
		System.out.println("\nPlease make a selection (A1-E5): ");
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
				column = Character.getNumericValue(selection.charAt(1)); // Column is equal to numeric value input by
																			// the user

				if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
					System.out.println(machine.getItem(row - 1, column - 1));
					purchaseProduct(cashbox, row - 1, column - 1); // Calls purchaseProduct() with the selected product
				} else {
					System.out.println("Invalid selection.");
					displayInfo(cashbox);
				}
			} catch (Exception e) {
				System.out.println("Invalid selection.");
				displayInfo(cashbox);
			}

		} else {
			completePurchase(cashbox, machine.getCredit(), 0.0);
		}

	}

	/**
	 * This method calls the purchaseProduct() method in the VendingMachine class
	 * 
	 * @param cashbox - the cash box being modified
	 * @param row     - the row number of selected product
	 * @param column  - the column number of selected product
	 */

	private static void purchaseProduct(CashBox cashbox, int row, int column) {
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
						machine.logTransaction(row, column, cashbox);
						if (machine.getCredit() > 0) {
							System.out.println("Credit remaining: £" + df.format(machine.getCredit()));
							completePurchase(cashbox, moneyPaid, actualCost);
						} else {
							addCredit(setCashBox());
						}
					} else if (machine.purchaseProduct(row, column) == 2) {
						System.out.println("\nInsufficient credit. Please insert more coins or cancel transaction.");
						addCredit(cashbox);
					} else {
						System.out.println("\nItem is out of stock :( ");
						completePurchase(cashbox, moneyPaid, actualCost);
					}
				case 2: // No
					finished = true;
					completePurchase(cashbox, moneyPaid, 0.0);
					addCredit(setCashBox());
				default:
					System.out.println("\nNot a valid option.");
					break;
				}
			} while (!finished);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method calls the giveChange() method in the VendingMachine class. This
	 * method is called after a purchase has been completed and there is credit
	 * remaining.
	 * 
	 * @param cashbox    - the cash box being modified
	 * @param moneyPaid  - total amount inserted by customer
	 * @param actualCost - cost of the product
	 */

	private static void completePurchase(CashBox cashbox, double moneyPaid, double actualCost) {
		Currency currency = cashbox.getCurrency();
		if (currency.getCurrencyName() != "GBP") {
			moneyPaid = Math.round((moneyPaid * currency.getRate()) * 10.00) / 10.0;
			actualCost = Math.round((actualCost * currency.getRate()) * 10.00) / 10.0;
		}
		String[] options = { "Yes", "No" };
		Menu inputMenu = new Menu("\nWould you like to make another purchase?", options); // Prompts user
		boolean finished = false;
		do {
			int option = inputMenu.getUserChoice(); // Calls getUserChoice() in Menu
			switch (option) {
			case 1:
				displayInfo(cashbox); // Calls displayInfo() to make another purchase
				break;
			case 2:
				System.out.println("Amount to be refunded: " + currency.getCurrencySymbols()[0] + df.format(moneyPaid - actualCost));
				System.out.println(machine.giveChange(moneyPaid, actualCost));

				if (machine.getCredit() == 0) { // Transaction successfully cancelled if credit = 0
					System.out.println("\nTransaction cancelled. Remaining credit refunded.");
					addCredit(setCashBox()); // Returns to initial state
				} else {
					System.out.println("Credit remaining: £" + machine.getCredit());
					System.out.println("Error cancelling transacton.");
				}
				break;
			default:
				System.out.println("\nNot a valid option.");
				break;
			}
		} while (!finished);
	}

}
