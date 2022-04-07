package sprint2_team35;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * This class models a vending machine, capable of holding 25 different items
 * and 5 different coin values, as well as storing profit in a cashbox.
 */

public class VendingMachine {
	private GenericProducts[][] item = new GenericProducts[5][5];
	private CashBox cashBox = new CashBox();
	private double credit = 0.00;
	private USBDevice usbPort = new USBDevice(); // USBDevice object
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Constructor method for VendingMachine object. Loads the relevant item and
	 * coin holder data from a text file.
	 */

	public VendingMachine() {
		loadFromFile();
	}

	/**
	 * Getter method for an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's name, cost, and quantity, as a string
	 */

	public String getItem(int row, int column) {
		return item[row][column].toString();
	}

	/**
	 * Setter method for the CashBox of VendingMachine
	 * 
	 * @param cashbox - the selected cash box
	 * @return - the cash box of selected currency
	 */

	public void setCashBox(CashBox cashbox) {
		this.cashBox = cashbox;

		loadFromFile();

	}

	/**
	 * Getter method for an item cost in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's cost
	 */

	public double getCost(int row, int column) {
		return item[row][column].getPrice();
	}

	/**
	 * Getter method for the machine's cash box.
	 * 
	 * @return - the cash box
	 */

	public CashBox getCashBox() {
		return this.cashBox;
	}

	/**
	 * Getter method for the credit input by a customer.
	 * 
	 * @return - the credit on the vending machine
	 */

	public double getCredit() {
		return this.credit;
	}

	/**
	 * Setter method for the name of an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @param name   - the new name of the item
	 */

	public void setItemName(int row, int column, String name) {
		item[row][column].setProductName(name);
	}

	/**
	 * Setter method for the type of an item in the machine
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @param type   - the new type of product
	 */
	public void setItemType(int row, int column, ProductType type) {
		item[row][column].setProductType(type);
	}

	/**
	 * Setter method for the cost of an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @param name   - the new cost of the item
	 */

	public void setItemCost(int row, int column, double cost) {
		item[row][column].setPrice(cost);
	}

	/**
	 * Setter method for the quantity of an item in the machine.
	 * 
	 * @param row      - the row index of the item
	 * @param column   - the column index of the item
	 * @param quantity - the new quantity of the item
	 */

	public void setItemQuantity(int row, int column, int quantity) {
		item[row][column].setQuantity(quantity);
	}

	/**
	 * Setter method for the sale count of an item in the machine
	 * 
	 * @param row       - the row index of the item
	 * @param column    - the column index of the item
	 * @param saleCount - the new sale count of the item
	 */

	public void setItemSaleCount(int row, int column, int saleCount) {
		item[row][column].setProductSaleCount(saleCount);
	}

	/**
	 * Adds coins into tubes on top of existing coins
	 * 
	 * @param values - an Integer array containing the amount to be added to each
	 *               tube
	 * 
	 */

	public void addTubes(int[] values) {
		this.cashBox.addTubes(values);
	}

	/**
	 * Setter method for the credit input by a customer.
	 * 
	 * @param credit - the new credit on the vending machine
	 */

	public void setCredit(double credit) {
		this.credit = credit;
	}

	/**
	 * This method resets the value in the collection box to 0.00.
	 */

	public void resetCashbox() {
		this.cashBox.setCashBoxAmount(0.00);
	}

	/**
	 * This method saves the data for items and coin holders in the machine to text
	 * files.
	 */

	public void saveToFile() {
		Currency currency = this.cashBox.getCurrency();
		String myDir = currency.getMyDir();
		PrintWriter myPw = null;
		String currencySymbol = currency.getCurrencySymbols()[0];

		// Writing cashbox data

		try {
			myPw = new PrintWriter(myDir);
			myPw.flush();
			myPw.println("Total money in cashbox");
			myPw.flush();
			myPw.println(this.cashBox.getCashBoxAmount());
			myPw.flush();
			myPw.println("Coins in tubes\nValue,Quantity");
			myPw.flush();
			for (int i = 0; i < this.cashBox.getChangeTubes().length; i++) {
				myPw.println(currencySymbol + df.format(this.cashBox.getAcceptedCoins()[i]) + " ,"
						+ this.cashBox.getChangeTubes()[i].getQuantity());
				myPw.flush();
			}
			System.out.println("Cashbox data written successfully.");
		} catch (IOException e) {
			System.out.println("Error writing cashbox data to file.");
		}

		// Writing item data

		try {
			myDir = "items.csv";
			myPw = new PrintWriter(myDir);
			myPw.flush();
			myPw.println("Items in stock\nLocation,Name,Type,Cost,Quantity,Sale Count");
			myPw.flush();
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					String rowStr = "?";
					switch (row) {
					case 0:
						rowStr = "A";
						break;
					case 1:
						rowStr = "B";
						break;
					case 2:
						rowStr = "C";
						break;
					case 3:
						rowStr = "D";
						break;
					case 4:
						rowStr = "E";
						break;
					}
					myPw.println(rowStr + (column + 1) + "," + item[row][column].getProductName() + ","
							+ item[row][column].getProductType() + "," + item[row][column].getPrice() + ","
							+ item[row][column].getQuantity() + "," + item[row][column].getSaleCount());
					myPw.flush();
				}
			}
			System.out.println("Item data written successfully.");
		} catch (IOException e) {
			System.out.println("Error writing item data to file.");
		}

		myPw.close();

	}

	/**
	 * This method loads the data for items, coin holders, and the cash box in the
	 * machine from text files.
	 */

	public void loadFromFile() {
		Currency currency = this.cashBox.getCurrency();
		File myFile;
		Scanner myScanner = null;
		String myDir = currency.getMyDir();
		int[] tubeAmounts = new int[this.cashBox.getAcceptedCoins().length];

		// Loading cashbox data

		try {
			myFile = new File(myDir);
			myScanner = new Scanner(myFile);
			try {
				myScanner.nextLine();
				double total = myScanner.nextDouble();
				this.cashBox.setCashBoxAmount(total);
				if (this.cashBox.getCashBoxAmount() < 0) {
					this.cashBox.setCashBoxAmount(0.00);
				}
				myScanner.nextLine();
				myScanner.nextLine();
				myScanner.nextLine();
				for (int i = 0; i < tubeAmounts.length; i++) {
					String[] cashboxStr = myScanner.nextLine().split(",");
					int value = Integer.parseInt(cashboxStr[1]);
					tubeAmounts[i] = value;
				}
				this.cashBox.setChangeTubes(tubeAmounts);
			} catch (Exception e) {
				System.out.println("Error occurred when loading cashbox data.\n");
				this.cashBox.setCashBoxAmount(0.00);
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred when loading cashbox data. File not found.\n");
			this.cashBox.setCashBoxAmount(0.00);
		}

		// Loading item data

		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < 5; column++) {
				this.item[row][column] = new GenericProducts();
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

						String type = itemStr[2];
						// changes the string value of type into a enum.
						ProductType itemType = null;
						switch (type) {
						case "Hot Food":
							itemType = ProductType.HOTFOOD;
							break;
						case "Hot Drink":
							itemType = ProductType.HOTDRINK;
							break;
						case "Cold Drink":
							itemType = ProductType.COLDDRINK;
							break;
						case "Confectionary":
							itemType = ProductType.CONFECTIONARY;
							break;
						case "Ticket":
							itemType = ProductType.TICKET;
							break;
						case "Electronics":
							itemType = ProductType.ELECTRONICS;
							break;
						case "Equipment":
							itemType = ProductType.EQUIPMENT;
							break;
						case "Accessory":
							itemType = ProductType.ACCESSORY;
							break;
						case "Clothing":
							itemType = ProductType.CLOTHING;
							break;
						default:
							itemType = ProductType.OTHER;
							break;
						}
						setItemType(row, column, itemType);

						double cost = Double.parseDouble(itemStr[3]);
						if (Math.round(cost * 100) % 10 == 0 && cost >= 0) {
							setItemCost(row, column, cost);
						} else {
							System.out.println(cost * 100);
							System.out.println("Error occurred when loading data for item (" + (row + 1) + ", "
									+ (column + 1) + ").\n");
						}

						int quantity = Integer.parseInt(itemStr[4]);
						if (quantity >= 0 && quantity <= 20) {
							setItemQuantity(row, column, quantity);
						} else {
							System.out.println("Error occurred when loading data for item (" + (row + 1) + ", "
									+ (column + 1) + ").\n");
						}

						int saleCount = Integer.parseInt(itemStr[5]);
						setItemSaleCount(row, column, saleCount);

					}
				}
			} catch (Exception e) {
				System.out.println("Error occurred when loading item data.\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred when loading item data.\n");
		}

		myScanner.close();

	}
	
	/**
	 * This method returns dummy data for a GPS coordinate. REPLACE WHEN GPS TASKS ARE COMPLETED
	 */
	
	public String getGPS() {
		return "0.00000 0.00000";
	}
	
	/**
	 * This method writes data on each transaction to a text file.
	 */
	
	public void logTransaction(int row, int column, CashBox cashbox) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();
		
		String myDir = "recentTransactions.csv";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(myDir, true));
			writer.write(dtf.format(currentTime) + ",£" + df.format(getCost(row, column)) + "," + item[row][column].getProductName() + "," + item[row][column].getProductType() + "," + getGPS() + "\n");
			writer.close();
			System.out.println("Transaction data written successfully.");
		} catch (IOException e) {
			System.out.println("Error writing transaction data to file.");
		}
		
		copyToMasterFile();
		
	}
	
	/**
	 * This method copies the data of the last 10 transactions to the master file, then wipes the recent file..
	 */
	
	public void copyToMasterFile() {
		
		try {
			
			File myFile = new File("recentTransactions.csv");
			Scanner myScanner = new Scanner(myFile);
			myScanner.nextLine();
			
			int transactionCount = 0;
			String[] transactionData = new String[10];
			
			while (myScanner.hasNextLine() && transactionCount < 10) {
				transactionData[transactionCount] = myScanner.nextLine();
				transactionCount++;
			}
			
			if (transactionCount == 10) {
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("masterTransactions.csv", true));
					for (String transaction : transactionData) {
						writer.write("\n" + transaction);
					}
					writer.close();
					PrintWriter myPw = new PrintWriter("recentTransactions.csv");
					myPw.flush();
					myPw.println("DateTime,PricePaid,ProductName,ProductType,GPSLatLong");
					myPw.close();
					System.out.println("Transaction data written to master file successfully.");
				} catch (IOException e) {
					System.out.println("Error writing transaction data to master file.");
				}
				
			}
			
			myScanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error writing transaction data to file.");
		}
		
	}

	/**
	 * This method simulates an owner re stocking an item in the machine.
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
	 * This method calculates how much change should be given in a transaction and
	 * deducts from the coin holders appropriately.
	 * 
	 * @return - a String containing the change given
	 * @param moneyPaid  - the total amount inserted into the vending machine for a
	 *                   single transaction
	 * @param actualCost - the total amount spent in the vending machine
	 * 
	 */

	public String giveChange(double moneyPaid, double actualCost) {
		Currency currency = this.cashBox.getCurrency();
		String currencySymbol = currency.getCurrencySymbols()[0];
		int[] change = this.cashBox.giveChange(moneyPaid, actualCost);

		String changeStr = "Change given: ";
		for (int i = 0; i < change.length; i++) {
			if (change[i] > 0) {
				changeStr += "x" + change[i] + " " + currencySymbol + df.format(this.cashBox.getAcceptedCoins()[i])
						+ " ";
			}
		}
		if (changeStr.length() > 15) {
			changeStr = changeStr.substring(0, changeStr.length() - 2);
		} else {
			changeStr += "None";
		}
		this.credit = 0.0; // Sets credit to 0
		saveToFile();
		return changeStr + ".\n";
	}

	/**
	 * This method is used to insert coins into the vending machine to purchase
	 * items
	 * 
	 * @param coin - the amount to be inserted
	 * @return - the total credit
	 */

	public double addCredit(double coin) {
		Currency currency = this.cashBox.getCurrency();
		double[] acceptedCoins = this.cashBox.getAcceptedCoins();
		boolean isAccepted = false;

		for (int i = 0; i < acceptedCoins.length; i++) {
			if (acceptedCoins[i] == coin) {
				isAccepted = true;
			}
		}

		if (isAccepted) {

			if (currency.getCurrencyName() != "GBP") {
				double conversion = (coin / currency.getRate());
				double rounded = Math.round(conversion * 10.0) / 10.0;
				this.credit += rounded;
			} else {
				this.credit += coin;
			}

			this.cashBox.enterCoin(coin);
			return this.credit;
		} else {
			return 0.00;
		}
	}

	/**
	 * This method is used to purchase a product from the vending machine.
	 * 
	 * @param row    - row number of product
	 * @param column - column number of product
	 * @return - integer to describe event
	 */

	public int purchaseProduct(int row, int column) {

		if (item[row][column].getQuantity() > 0) {
			if (item[row][column].getPrice() <= this.credit) {
				item[row][column].setQuantity(item[row][column].getQuantity() - 1);
				item[row][column].setProductSaleCount(item[row][column].getSaleCount() + 1);
				this.credit -= item[row][column].getPrice();
				item[row][column].lowOnProducts();
				return 1; // Product purchased successfully
			} else {
				return 2; // Insufficient credit
			}
		} else {
			return 0; // Product out of stock
		}
	}

	/**
	 * This method calls the detectUSB() method in USBDevice.
	 * 
	 * @return - true if a USB device is inserted or false if a USB device is not
	 *         inserted.
	 */

	public boolean detectUSB() {
		if (usbPort.detectUSB()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method calls the listContents() method in USBDevice.
	 * 
	 * @return - a String containing the files stored on the device
	 */

	public String listUSBContents() {
		return usbPort.listContents(usbPort.getDeviceName());
	}

	/**
	 * This method calls the readContents() method in USBDevice.
	 * 
	 * @param fileName - the name of the file to install the update from.
	 * @return - a String containing the file contents
	 */

	public String readUSBContents(String fileName) {
		return usbPort.readContents(usbPort.getDeviceName(), fileName);

	}

	/**
	 * returns a single String containing the product name, product type, product
	 * price, quantity and sale count for the items objects within the system
	 * (ordered by sale count, highest to lowest)
	 */

	public String highestSaleCounts() {
		if (item.length > 0) {
			GenericProducts[] data = new GenericProducts[25];
			// String data = "";
			int index = 0;
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					data[index++] = item[row][column];
				}
			}
			sortSaleCount(data);
			displaySaleCount(data);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String displayProducts() {
		if (item.length > 0) {
			GenericProducts[] data = new GenericProducts[25];
			int index = 0;
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					data[index++] = item[row][column];
				}
			}
			displayProducts(data);
		}
		return null;
	}

	/**
	 * 
	 * @param items
	 */
	private static void sortSaleCount(GenericProducts items[]) {
		int swaps;
		do {
			swaps = 0;
			for (int index = 0; index < 24; index++) {
				if (items[index].getSaleCount() < items[index + 1].getSaleCount()) {
					GenericProducts temp = items[index];
					items[index] = items[index + 1];
					items[index + 1] = temp;
					swaps++;
				}
			}
		} while (swaps > 0);
	}

	/**
	 * 
	 * @param items
	 * @return
	 */
	private static void displaySaleCount(GenericProducts items[]) {
		if (items != null && items.length > 0) {
			for (int index = 0; index < 25; index++) {
				System.out.println("Product Name: " + items[index].getProductName() + ", Product Type: "
						+ items[index].getProductType() + ", Price: " + items[index].getPrice() + ", Quantity: "
						+ items[index].getQuantity() + ", Sales: " + items[index].getSaleCount());
			}
		} else {
			System.out.println("No data to display.");
		}
	}

	/**
	 * 
	 * @param items
	 */
	private static void displayProducts(GenericProducts items[]) {
		if (items != null && items.length > 0) {
			for (int index = 0; index < 25; index++) {
				System.out.println("Product Name: " + items[index].getProductName() + ", Product Type: "
						+ items[index].getProductType() + ", Price: " + items[index].getPrice() + ", Quantity: "
						+ items[index].getQuantity());
			}
		} else {
			System.out.println("No data to display.");
		}
	}

	/*
	 * private GenericProducts searchProduct(String productName) { int index = 0;
	 * for (GenericProducts products[] : item) { String art =
	 * products[index++].getProductName(); if (productName.equals(art)) { return
	 * products[index]; } }
	 * 
	 * return null; }
	 */

	/*
	 * private String[] getProductInfo(String productName) { if (item.length > 0) {
	 * String data[] = new String[item.length]; int index1 = 0; int index2 = 0;
	 * GenericProducts product = searchProduct(productName); if (product != null) {
	 * for (GenericProducts products[] : item) { String item =
	 * products[index1++].getProductName(); if (productName.equals(item)) {
	 * data[index2++] = products[index1].toString(); } } return data; } else {
	 * return null; } } return null; }
	 */

	public String searchProduct(int row, int column) {
		if (item.length > 0) {
			GenericProducts data = null;
			data = item[row][column];
			String str = data.toString();
			return str;
		}
		return null;
	}
}