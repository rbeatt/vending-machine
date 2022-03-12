package sprint2_team35;

import java.util.Scanner;

public class OwnerApp {

	private static Scanner myScanner = new Scanner(System.in);
	
	// Declaring and initialising vending machine object
	private static VendingMachine machine = new VendingMachine();
	
	public static void main(String[] args) {
		
		// Array of menu options
		
		String [] options = { "Restock machine", "Top up tubes", 
				"View total in cashbox and tubes", "Set prices", "Reset cashbox", "Exit Owner Mode" };
		Menu vendingMenu = new Menu("\nOwner Mode", options);
		
		boolean finished = false; 
		do {
			int option = vendingMenu.getUserChoice();
			switch (option) {
			case 1: restockMachine();
				break;
			case 2: topUpTubes();
				break;
			case 3: viewTotal();
				break;
			case 4: setPrices();
				break;
			case 5: resetCashbox();
				break;
			case 6:
				break;
			case 7:
				break;
			case 8: finished = true;
				break;
			default:
				System.out.println("\nNot a valid option."); // Displays when an invalid option is entered
				break;
			}
		}
		while (!finished); // Loop finishes when boolean value is true
	}
	
	/**
	 * This method lets a machine owner restock the items in the machine.
	 */
	
	private static void restockMachine() {
		
		int row = -1;
		int column = -1;
		String input = "";
		
		boolean finished = false;		
		do {
			System.out.println("\nSelect an item to restock (eg. A1, B3, etc.): ");
			input = myScanner.nextLine();
		
			try {
				switch (input.toUpperCase().charAt(0)) {
				case 'A': row = 1;
					  	break;
				case 'B': row = 2;
						break;
				case 'C': row = 3;
			  		  	break;
				case 'D': row = 4;
			  		  	break;
				case 'E': row = 5;
			  		  	break;
				default: row = 0;
			  		  	break;
				}
				column = Character.getNumericValue(input.charAt(1));
				
				if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
				finished = true;
				}
				else {
					System.out.println("Not a valid item reference.");
				}
			}
			catch(Exception e) {
				System.out.println("Not a valid item reference.");
			}
			
		} while (!finished);
		
		System.out.println("\nDetails of item " + input + ":");
		System.out.println(machine.getItem(row - 1, column - 1));
		
		int amount = -1;
		
		finished = false;
		do {
			System.out.print("\nHow much should it be restocked by? ");
			try {
				amount = myScanner.nextInt();
				myScanner.nextLine();
				if (amount >= 0) {
					machine.restock(row - 1, column - 1, amount);
					System.out.println("Item restocked!\n");
					finished = true;
					machine.saveToFile();
				}
				else {
					System.out.println("Please input a non-negative integer.");
				}
			}
			catch(Exception e) {
				System.out.println("Please input a non-negative integer.");
				myScanner.nextLine();
			}
		} while (!finished);
		
	}
	
	/**
	 * This method lets a machine owner top up the change dispenser tubes.
	 */
	
	private static void topUpTubes() {
		//Adding 10s
		System.out.println("How many 10s would you like to add?");
		String Add10s = myScanner.nextLine();  // Read user input
		System.out.println("Added: " + Add10s);  // Output user input
		
		
		//Adding 20s
		System.out.println("How many 20s would you like to add?");
		String Add20s = myScanner.nextLine();  // Read user input
		System.out.println("Added: " + Add20s);  // Output user input
		    
	
		    
		//Adding 50s
		System.out.println("How many 50s would you like to add?");
		String Add50s = myScanner.nextLine();  // Read user input
		System.out.println("Added: " + Add50s);  // Output user input
		 
			    
		//Adding Pounds
			    
		System.out.println("How many £1s would you like to add?");
		String Add1s = myScanner.nextLine();  // Read user input
		System.out.println("Added: " + Add1s);  // Output user input
				    
				    
		//Adding £2s
		System.out.println("How many £2s would you like to add?");
		String Add2s = myScanner.nextLine();  // Read user input
		System.out.println("Added: " + Add2s);  // Output user input
		
		try {
			machine.addTubes(Integer.parseInt(Add10s), Integer.parseInt(Add20s), Integer.parseInt(Add50s), Integer.parseInt(Add1s), Integer.parseInt(Add2s));
			System.out.println("Coins added successfully.");
		}
		catch(Exception e) {
			System.out.println("An invalid amount was added.");
		}
		machine.saveToFile();
	}
	
	/**
	 * This method lets a machine owner view the total money in the collection box and change dispenser tubes.
	 */
	
	private static void viewTotal() {
		System.out.println("\n" + machine.getCashbox() + "\n");
	}
	
	/**
	 * This method lets a machine owner set the prices of items in the machine.
	 */
	
	private static void setPrices() {
		
		int row = -1;
		int column = -1;
		String input = "";
		
		boolean finished = false;		
		do {
			System.out.println("\nSelect an item to set the price of (eg. A1, B3, etc.): ");
			input = myScanner.nextLine();
		
			try {
				switch (input.toUpperCase().charAt(0)) {
				case 'A': row = 1;
					  	break;
				case 'B': row = 2;
						break;
				case 'C': row = 3;
			  		  	break;
				case 'D': row = 4;
			  		  	break;
				case 'E': row = 5;
			  		  	break;
				default: row = 0;
			  		  	break;
				}
				column = Character.getNumericValue(input.charAt(1));
				
				if (row >= 1 && row <= 5 && column >= 1 && column <= 5) {
				finished = true;
				}
				else {
					System.out.println("Not a valid item reference.");
				}
			}
			catch(Exception e) {
				System.out.println("Not a valid item reference.");
			}
			
		} while (!finished);
		
		System.out.println("\nDetails of item " + input + ":");
		System.out.println(machine.getItem(row - 1, column - 1));
		
		double cost = -1;
		
		finished = false;
		do {
			System.out.print("\nWhat should the new price be? (in pence, multiple of 10)? ");
			try {
				cost = myScanner.nextDouble();
				myScanner.nextLine();
				if (cost >= 0 && cost % 10 == 0) {
					machine.setItemCost(row - 1, column - 1, cost / 100);
					System.out.println("Cost set!\n");
					finished = true;
					machine.saveToFile();
				}
				else {
					System.out.println("Please input a valid integer.");
				}
			}
			catch(Exception e) {
				System.out.println("Please input a valid integer.");
				myScanner.nextLine();
			}
		} while (!finished);
		
	}
	
	private static void softwareUpdate() {
		Scanner sc = new Scanner(System.in);
		if (machine.detectUSB()) {
			
			machine.listUSBContents();
			System.out.println("Please enter the file you'd like to perform an update from: ");
			machine.readUSBContents(sc.nextLine());
		}
		else {
			System.out.println("A USB device has not been inserted");
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
	
}
