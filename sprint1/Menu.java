package sprint1;

import java.util.Scanner;

public class Menu {
	private String items[];
	private String title;
	private Scanner input;
	
	public Menu(String title, String data[]) {
		this.title = title;
		this.items = data;
		this.input = new Scanner(System.in);
	}
	
	/**
	 * Method to display the menu options to the user
	 */
	
	private void display() {
		int index = 0;
		int length = items[0].length();
		for(int i=1; i < items.length; i++ ) {
			if(items[i].length() > length) {
				index = i; length = items[i].length();
			}
		}
		int asterisk = items[index].length() + 3; // Prints * around the options
		System.out.println(title);
		for (int count = 0; count < asterisk; count++) {
			System.out.print("*");
		}
		System.out.println();
		for (int option = 1; option <= items.length; option++) { //Prints an index for each menu item
			System.out.println(option + ". " + items[option-1]);
		}
		for (int count = 0; count < asterisk; count++) {
			System.out.print("*"); // Prints * around the options
		}
		System.out.println();
	}
	
	/**
	 * Method to request input from the user to use in the switch
	 * @return - int input by the user
	 */
	
	public int getUserChoice() {
		display();
		System.out.println("\nEnter Selection: ");
		
		try {
			String value = input.nextLine(); // Accepts input as a String
			
			int parse = Integer.parseInt(value); // Converts String input to an int. This is to prevent an InputMismatchError
			
			if (parse > 0) {
				return parse;
			}
			return 0;
		} catch (Exception e) { // try/catch to prevent invalid data being entered
			return 0;
		}
	}

}
