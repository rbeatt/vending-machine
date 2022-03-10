package sprint2_team35;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This class models a vending machine, capable of holding 25 different items and 5 different coin values, as well as storing profit in a cashbox.
 */

public class VendingMachine {

	private Item[][] item = new Item[5][5];
	private CashBox cashbox = new CashBox();
	private double credit = 0;

	/**
	 * Constructor method for VendingMachine object. Loads the relevant item and coin holder data from a text file.
	 */
	
	public VendingMachine() {
		loadFromFile();		
	}
	
	/**
	 * Get method for an item in the machine.
	 * @param row - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's name, cost, and quantity, as a string
	 */
	
	public String getItem(int row, int column) {
		return item[row][column].toString();
	}
	
	/**
	 * Get method for an item cost in the machine.
	 * @param row - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's cost
	 */
	public double getCost(int row, int column) {
		return item[row][column].getCost();
	}
	
	/**
	 * Get method for the machine's cashbox.
	 * @return - the cashbox data, as a string
	 */
	
	public String getCashbox() {
		return this.cashbox.toString();
	}
	
	/**
	 * Get method for the credit input by a customer.
	 * @return - the credit
	 */
	
	public double getCredit() {
		return this.credit;
	}
	
	/**
	 * Set method for the name of an item in the machine.
	 * @param row - the row index of the item
	 * @param column - the column index of the item
	 * @param name - the new name of the item
	 */
	
	public void setItemName(int row, int column, String name) {
		item[row][column].setName(name);
	}
	
	/**
	 * Set method for the cost of an item in the machine.
	 * @param row - the row index of the item
	 * @param column - the column index of the item
	 * @param name - the new cost of the item
	 */
	
	public void setItemCost(int row, int column, double cost) {
		item[row][column].setCost(cost);
	}
	
	/**
	 * Set method for the quantity of an item in the machine.
	 * @param row - the row index of the item
	 * @param column - the column index of the item
	 * @param quantity - the new quantity of the item
	 */
	
	public void setItemQuantity(int row, int column, int quantity) {
		item[row][column].setQuantity(quantity);
	}
	
	/**
	 * Set method for the quantity of coins in tubes.
	 * @param tenp - the quantity of 10ps
	 * @param twentyp - the quantity of 20ps
	 * @param fiftyp - the quantity of 50ps
	 * @param pound - the quantity of �1s
	 * @param twopound - the quantity of �2s
	 */
	
	public void setTubes(int tenp, int twentyp, int fiftyp, int pound, int twopound) {
		this.cashbox.Total10s = tenp;
		this.cashbox.Total20s = twentyp;
		this.cashbox.Total50s = fiftyp;
		this.cashbox.TotalPounds = pound;
		this.cashbox.Total2Pounds = twopound;
	}
	
	/**
	 * Adds coins into tubes on top of existing coins
	 * @param tenp - the quantity of 10ps to add
	 * @param twentyp - the quantity of 20ps to add
	 * @param fiftyp - the quantity of 50ps to add
	 * @param pound - the quantity of �1s to add
	 * @param twopound - the quantity of �2s to add
	 */
	
	public void addTubes(int tenp, int twentyp, int fiftyp, int pound, int twopound) {
		this.cashbox.Total10s += tenp;
		if (this.cashbox.Total10s < 0) {
			this.cashbox.Total10s = 0;
		}
		if (this.cashbox.Total10s > 50) {
			this.cashbox.Total10s = 50;
		}
		this.cashbox.Total20s += twentyp;
		if (this.cashbox.Total20s < 0) {
			this.cashbox.Total20s = 0;
		}
		if (this.cashbox.Total20s > 50) {
			this.cashbox.Total20s = 50;
		}
		this.cashbox.Total50s += fiftyp;
		if (this.cashbox.Total50s < 0) {
			this.cashbox.Total50s = 0;
		}
		if (this.cashbox.Total50s > 50) {
			this.cashbox.Total50s = 50;
		}
		this.cashbox.TotalPounds += pound;
		if (this.cashbox.TotalPounds < 0) {
			this.cashbox.TotalPounds = 0;
		}
		if (this.cashbox.TotalPounds > 50) {
			this.cashbox.TotalPounds = 50;
		}
		this.cashbox.Total2Pounds += twopound;
		if (this.cashbox.Total2Pounds < 0) {
			this.cashbox.Total2Pounds = 0;
		}
		if (this.cashbox.Total2Pounds > 50) {
			this.cashbox.Total2Pounds = 50;
		}
	}
	
	/**
	 * Set method for the credit input by a customer.
	 * @param credit - the credit
	 */
	
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	/**
	 * This method resets the value in the collection box to �0.
	 */
	
	public void resetCashbox() {
		this.cashbox.CashBoxAmount = 0;
	}
	
	/**
	 * This method saves the data for items and coin holders in the machine to text files.
	 */
	
	public void saveToFile() {
		
		String myDir;
		PrintWriter myPw = null;
		
		// Writing cashbox data
		
		try {
			myDir = "cashbox.csv";
			myPw = new PrintWriter(myDir);
			myPw.flush();
			myPw.println("Total money in cashbox");
			myPw.flush();
			myPw.println(this.cashbox.CashBoxAmount);
			myPw.flush();
			myPw.println("Coins in tubes\nValue,Quantity");
			myPw.flush();
			myPw.println("10p," + this.cashbox.Total10s);
			myPw.flush();
			myPw.println("20p," + this.cashbox.Total20s);
			myPw.flush();
			myPw.println("50p," + this.cashbox.Total50s);
			myPw.flush();
			myPw.println("£1," + this.cashbox.TotalPounds);
			myPw.flush();
			myPw.println("£2," + this.cashbox.Total2Pounds);
			myPw.flush();
			System.out.println("Cashbox data written successfully.");
		}
		catch (IOException e) {
			System.out.println("Error writing cashbox data to file.");
		}
			
		// Writing item data
		
		try {
			myDir = "items.csv";
			myPw = new PrintWriter(myDir);
			myPw.flush();
			myPw.println("Items in stock\nLocation,Name,Cost,Quantity");
			myPw.flush();
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					String rowStr = "?";
					switch (row) {
					case 0: rowStr = "A";
							break;
					case 1: rowStr = "B";
							break;
					case 2: rowStr = "C";
							break;
					case 3: rowStr = "D";
							break;
					case 4: rowStr = "E";
							break;
					}
					myPw.println(rowStr + (column + 1) + "," + item[row][column].getName() + "," + item[row][column].getCost() + "," + item[row][column].getQuantity());
					myPw.flush();
				}
			}
			System.out.println("Item data written successfully.");
		}
		catch (IOException e) {
			System.out.println("Error writing item data to file.");
		}
		
		myPw.close();
		
	}
	
	/**
	 * This method loads the data for items, coin holders, and the cashbox in the machine from text files.
	 */
	
	public void loadFromFile() {
		
		File myFile;
		Scanner myScanner = null;
		
		// Loading cashbox data
		
		try {
			myFile = new File("cashbox.csv");
			myScanner = new Scanner(myFile);			
			try {
				myScanner.nextLine();
				double total = myScanner.nextDouble();
				this.cashbox.CashBoxAmount = total;
				if (this.cashbox.CashBoxAmount < 0) {
					this.cashbox.CashBoxAmount = 0;
				}				
				myScanner.nextLine();
				myScanner.nextLine();
				myScanner.nextLine();
				String[] cashboxStr = myScanner.nextLine().split(",");
				int tenp = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int twentyp = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int fiftyp = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int pound = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int twopound = Integer.parseInt(cashboxStr[1]);
				setTubes(tenp, twentyp, fiftyp, pound, twopound);
			}
			catch(Exception e) {
				System.out.println("Error occurred when loading cashbox data.\n");
				this.cashbox.CashBoxAmount = 0;
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error occurred when loading cashbox data.\n");
			this.cashbox.CashBoxAmount = 0;
		}
		
		// Loading item data
		
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				this.item[row][column] = new Item();
			}
		}
		
		try {
			myFile = new File("items.csv");
			myScanner = new Scanner(myFile);			
			try {
				myScanner.nextLine();
				myScanner.nextLine();
				for (int row = 0; row < 5; row++) {
					for (int column = 0; column < 5; column++) {
						String[] itemStr = myScanner.nextLine().split(",");
						String name = itemStr[1];
						setItemName(row, column, name);
						double cost = Double.parseDouble(itemStr[2]);
						if (Math.round(cost*100) % 10 == 0 && cost >= 0) {
							setItemCost(row, column, cost);
						}
						else {
							System.out.println(cost*100);
							System.out.println("Error occurred when loading data for item (" + (row + 1) + ", " + (column + 1) + ").\n");
						}
						int quantity = Integer.parseInt(itemStr[3]);
						if (quantity >= 0 && quantity <= 20) {
							setItemQuantity(row, column, quantity);
						}
						else {
							System.out.println("Error occurred when loading data for item (" + (row + 1) + ", " + (column + 1) + ").\n");
						}
					}
				}
			}
			catch(Exception e) {
				System.out.println("Error occurred when loading item data.\n");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error occurred when loading item data.\n");
		}
		
		myScanner.close();
		
	}
	
	/**
	 * This method simulates an owner restocking an item in the machine.
	 */
	
	public void restock(int row, int column, int amount) {
		int newQuantity = item[row][column].getQuantity() + amount;
		if (newQuantity > 20) {
			newQuantity = 20;
		}
		if (newQuantity < 0) {
			newQuantity = 0;
		}
		item[row][column].setQuantity(newQuantity);
	}
	
	/**
	 * This method calculates how much change should be given in a transaction and deducts from the coin holders appropriately.
	 */
	
	public String giveChange(double moneyPaid, double actualCost) {
		int[] change = {0,0,0,0,0};
		while (moneyPaid - actualCost >= 1.99 && this.cashbox.Total2Pounds > 0) {
			change[4] += 1;
			this.cashbox.Total2Pounds -= 1;
			moneyPaid -= 2.0;
		}
		while (moneyPaid - actualCost >= 0.99 && this.cashbox.TotalPounds > 0) {
			change[3] += 1;
			this.cashbox.TotalPounds -= 1;
			moneyPaid -= 1.0;
		}
		while (moneyPaid - actualCost >= 0.49 && this.cashbox.Total50s > 0) {
			change[2] += 1;
			this.cashbox.Total50s -= 1;
			moneyPaid -= 0.50;
		}
		while (moneyPaid - actualCost >= 0.19 && this.cashbox.Total20s > 0) {
			change[1] += 1;
			this.cashbox.Total20s -= 1;
			moneyPaid -= 0.20;
		}
		while (moneyPaid - actualCost >= 0.09 && this.cashbox.Total10s > 0) {
			change[0] += 1;
			this.cashbox.Total10s -= 1;
			moneyPaid -= 0.10;
		}
		String changeStr = "Change given: ";
		if (change[4] > 0) {
			changeStr += change[4] + " £2 coin(s), ";
		}
		if (change[3] > 0) {
			changeStr += change[3] + " £1 coin(s), ";
		}
		if (change[2] > 0) {
			changeStr += change[2] + " 50p coin(s), ";
		}
		if (change[1] > 0) {
			changeStr += change[1] + " 20p coin(s), ";
		}
		if (change[0] > 0) {
			changeStr += change[0] + " 10p coin(s), ";
		}
		if (changeStr.length() > 15) {
			changeStr = changeStr.substring(0, changeStr.length() - 2);
		}
		else {
			changeStr += "None";
		}
		this.credit = 0.0; // Sets credit to 0
		saveToFile();
		return changeStr + ".\n"; 
	}
	
	/**
	 * This method is used to insert coins into the vending machine to purchase items
	 * @param coin - the amount to be inserted
	 * @return - the total credit
	 */
	
	public double addCredit(double coin) {
		if (coin == 0.10 || coin == 0.20 || coin == 0.50 || coin == 1.0 || coin == 2.0) {
			this.credit += coin;
			this.cashbox.EnterCoin(coin);
			return this.credit;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * This method is used to purchase a product from the vending machine.
	 * @param row - row number of product
	 * @param column - column number of product
	 * @return - integer to describe event
	 */
	
	public int purchaseProduct(int row, int column) {
				
		if (item[row][column].getQuantity() > 0) {
			if (item[row][column].getCost() < this.credit) {
				item[row][column].setQuantity(item[row][column].getQuantity() - 1);
				this.credit -= item[row][column].getCost();
				return 1; // Product purchased successfully
			}
			else {
				return 2; // Insufficient credit
			}
		}
		else {
			return 0; // Product out of stock
		}
	}
	
}
