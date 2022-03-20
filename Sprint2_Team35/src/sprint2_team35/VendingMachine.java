package sprint2_team35;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.FileNotFoundException;

/**
 * This class models a vending machine, capable of holding 25 different items
 * and 5 different coin values, as well as storing profit in a cashbox.
 */

public class VendingMachine {

	private GenericProducts[][] item = new GenericProducts[5][5];
	private CashBox cashBox = new CashBox();
	private CashBox eurCashBox = new EuroCashBox();
	private double credit = 0;
	private USBDevice usbPort = new USBDevice(); // USBDevice object

	/**
	 * Constructor method for VendingMachine object. Loads the relevant item and
	 * coin holder data from a text file.
	 */

	public VendingMachine() {
		loadFromFile(this.cashBox);
		loadFromFile(this.eurCashBox);
	}
	
	public double getRate(CashBox cashbox) {
		return cashbox.getRate();
	}
	
	

	/**
	 * Get method for an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's name, cost, and quantity, as a string
	 */

	public String getItem(int row, int column) {
		return item[row][column].toString();
	}
	
	public CashBox getCashBox(String currency) {
		if (currency == "EUR") {
			return this.eurCashBox;
		}
		else if (currency == "GBP") {
			return this.cashBox;
		}
		else {
			return this.cashBox;
		}
	}

	/**
	 * Get method for an item cost in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @return - the item's cost
	 */
	public double getCost(int row, int column) {
		return item[row][column].getPrice();
	}

	/**
	 * Get method for the machine's cashbox.
	 * 
	 * @return - the cashbox data, as a string
	 */

	public String getCashbox(CashBox cashbox) {
		return cashbox.toString();
	}

	/**
	 * Get method for the credit input by a customer.
	 * 
	 * @return - the credit
	 */

	public double getCredit() {
		return this.credit;
	}

	/**
	 * Set method for the name of an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @param name   - the new name of the item
	 */

	public void setItemName(int row, int column, String name) {
		item[row][column].setProductName(name);
	}

	/**
	 * Set method for the type of an item in the machine
	 * 
	 * @param row
	 * @param column
	 * @param type
	 */
	public void setItemType(int row, int column, ProductType type) {
		item[row][column].setProductType(type);
	}

	/**
	 * Set method for the cost of an item in the machine.
	 * 
	 * @param row    - the row index of the item
	 * @param column - the column index of the item
	 * @param name   - the new cost of the item
	 */

	public void setItemCost(int row, int column, double cost) {
		item[row][column].setPrice(cost);
	}

	/**
	 * Set method for the quantity of an item in the machine.
	 * 
	 * @param row      - the row index of the item
	 * @param column   - the column index of the item
	 * @param quantity - the new quantity of the item
	 */

	public void setItemQuantity(int row, int column, int quantity) {
		item[row][column].setQuantity(quantity);
	}

	/**
	 * Set method for the sale count of an item in the machine
	 * 
	 * @param row
	 * @param column
	 * @param saleCount
	 */
	public void setItemSaleCount(int row, int column, int saleCount) {
		item[row][column].setProductSaleCount(saleCount);
	}

	/**
	 * Set method for the quantity of coins in tubes.
	 * 
	 * @param ten    - the quantity of 10ps
	 * @param twenty - the quantity of 20ps
	 * @param fifty  - the quantity of 50ps
	 * @param one    - the quantity of �1s
	 * @param two    - the quantity of �2s
	 */

	public void setTubes(CashBox cashbox, int ten, int twenty, int fifty, int one, int two) {
		cashbox.setTotal10s(ten);
		cashbox.setTotal20s(twenty);
		cashbox.setTotal50s(fifty);
		cashbox.setTotal1s(one);
		cashbox.setTotal2s(two);
	}

	/**
	 * Adds coins into tubes on top of existing coins
	 * 
	 * @param ten    - the quantity of 10ps to add
	 * @param twenty - the quantity of 20ps to add
	 * @param fifty  - the quantity of 50ps to add
	 * @param one    - the quantity of �1s to add
	 * @param two    - the quantity of �2s to add
	 */

	public void addTubes(CashBox cashbox, int[] array) {
		cashbox.addTubes(array);
	}


	/**
	 * Set method for the credit input by a customer.
	 * 
	 * @param credit - the credit
	 */

	public void setCredit(double credit) {
		this.credit = credit;
	}

	/**
	 * This method resets the value in the collection box to �0.
	 */

	public void resetCashbox(CashBox cashbox) {
		cashbox.setCashBoxAmount(0.00);
	}

	/**
	 * This method saves the data for items and coin holders in the machine to text
	 * files.
	 */

	public void saveToFile(CashBox cashbox) {	
		String myDir = null;
		PrintWriter myPw = null;
		String currencySymbol = cashbox.getCashBoxSymbols()[0];
		String altSymbol = cashbox.getCashBoxSymbols()[1];
		
		if (cashbox == this.eurCashBox) {
			myDir = "EURcashbox.csv";
		}
		else if (cashbox == this.cashBox) {
			myDir = "cashbox.csv";
		}
		else {
			myDir = "cashbox.csv";
		}

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
			myPw.println("10" + altSymbol + " ," + cashbox.getTotal10s());
			myPw.flush();
			myPw.println("20" + altSymbol + " ," + cashbox.getTotal20s());
			myPw.flush();
			myPw.println("50" + altSymbol + " ," + cashbox.getTotal50s());
			myPw.flush();
			myPw.println(currencySymbol + "1" + " ," + cashbox.getTotal1s());
			myPw.flush();
			myPw.println(currencySymbol + "2" + " ," + cashbox.getTotal2s());
			myPw.flush();
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
	 * This method loads the data for items, coin holders, and the cashbox in the
	 * machine from text files.
	 */

	public void loadFromFile(CashBox cashbox) {

		File myFile;
		Scanner myScanner = null;
		String myDir = null;
		
		if (cashbox == this.eurCashBox) {
			myDir = "EURcashbox.csv";
		}
		else if (cashbox == this.cashBox) {
			myDir = "cashbox.csv";
		}
		else {
			myDir = "cashbox.csv";
		}

		// Loading cashbox data

		try {
			myFile = new File(myDir);
			myScanner = new Scanner(myFile);
			try {
				myScanner.nextLine();
				double total = myScanner.nextDouble();
				cashbox.setCashBoxAmount(total);
				if (cashbox.getCashBoxAmount() < 0) {
					cashbox.setCashBoxAmount(0.00);
				}
				myScanner.nextLine();
				myScanner.nextLine();
				myScanner.nextLine();
				String[] cashboxStr = myScanner.nextLine().split(",");
				int ten = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int twenty = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int fifty = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int one = Integer.parseInt(cashboxStr[1]);
				cashboxStr = myScanner.nextLine().split(",");
				int two = Integer.parseInt(cashboxStr[1]);
				setTubes(cashbox,ten, twenty, fifty, one, two);
			} catch (Exception e) {
				System.out.println("Error occurred when loading cashbox data.\n");
				cashbox.setCashBoxAmount(0.00);
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred when loading cashbox data. File not found.\n");
			cashbox.setCashBoxAmount(0.00);
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
						case "Food":
							itemType = ProductType.FOOD;
							break;
						case "Drink":
							itemType = ProductType.DRINK;
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
	 * This method calculates how much change should be given in a transaction and
	 * deducts from the coin holders appropriately.
	 */

	public String giveChange(CashBox cashbox, double moneyPaid, double actualCost) {
		String currencySymbol = cashbox.getCashBoxSymbols()[0];
		String altSymbol = cashbox.getCashBoxSymbols()[1];
		int[] change = cashbox.giveChange(moneyPaid, actualCost);
		String changeStr = "Change given: ";
		if (change[4] > 0) {
			changeStr += change[4] + " " + currencySymbol + "2 coin(s), ";
		}
		if (change[3] > 0) {
			changeStr += change[3] + " " + currencySymbol + "1 coin(s), ";
		}
		if (change[2] > 0) {
			changeStr += change[2] + " 50" + altSymbol + " coin(s), ";
		}
		if (change[1] > 0) {
			changeStr += change[1] + " 20" + altSymbol + " coin(s), ";
		}
		if (change[0] > 0) {
			changeStr += change[0] + " 10" + altSymbol + " coin(s), ";
		}
		if (changeStr.length() > 15) {
			changeStr = changeStr.substring(0, changeStr.length() - 2);
		} else {
			changeStr += "None";
		}
		this.credit = 0.0; // Sets credit to 0
		saveToFile(cashbox);
		return changeStr + ".\n";
	}

	/**
	 * This method is used to insert coins into the vending machine to purchase
	 * items
	 * 
	 * @param coin - the amount to be inserted
	 * @return - the total credit
	 */

	public double addCredit(CashBox cashbox, double coin) {
		double[] acceptedCoins = cashbox.getAcceptedCoins();
		boolean isAccepted = false;

		for (int i = 0; i < acceptedCoins.length; i++) {
			if (acceptedCoins[i] == coin) {
				isAccepted = true;
			}
		}

		if (isAccepted) {

			if (cashbox != cashBox) {
				double conversion = (coin / cashbox.getRate());
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
	 * 
	 * @return
	 */
	/*
	 * public String highestSaleCounts() { if(item.length > 0) { GenericProducts
	 * data[] = new GenericProducts[item.length]; int index = 0; for
	 * (GenericProducts[] items : item) { data[index] = items[index]; index++; }
	 * sortSaleCount(data); displaySaleCount(data); } return null; }
	 */

	public String highestSaleCounts() {
		if (item.length > 0) {
			GenericProducts[] data = new GenericProducts[26];
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

	/*
	 * private void sortSaleCount(GenericProducts items[]) { int swaps; int index =
	 * 0; do { GenericProducts[] data = new GenericProducts[item.length]; swaps = 0;
	 * for(int row = 0; row < 5; row++) { for(int column = 0; column < 5; column++)
	 * { data[index++] = item[row][column]; } }
	 * 
	 * for(int i = 0; i < items.length -1; i++) { if(data[i].getSaleCount() < data[i
	 * + 1].getSaleCount()) { GenericProducts temp = data[i]; data[i] = data[i + 1];
	 * data[i + 1] = temp; swaps++; } } }while (swaps > 0); }
	 */

	/**
	 * 
	 * @param items
	 * @return
	 */
	private static void displaySaleCount(GenericProducts items[]) {
		if (items != null && items.length > 0) {
			for (int index = 0; index < 25; index++) {
				System.out.println("Product Name: " + items[index].getProductName() + " Product Type: "
						+ items[index].getProductType() + " Price: " + items[index].getPrice() + " Quantity: "
						+ items[index].getQuantity() + " Sales: " + items[index].getSaleCount());
			}
		} else {
			System.out.println("No data to display.");
		}
	}

	private GenericProducts searchProduct(String productName) {
		int index = 0;
		for (GenericProducts products[] : item) {
			String art = products[index++].getProductName();
			if (productName.equals(art)) {
				return products[index];
			}
		}

		return null;
	}

	private String[] getProductInfo(String productName) {
		if (item.length > 0) {
			String data[] = new String[item.length];
			int index1 = 0;
			int index2 = 0;
			GenericProducts product = searchProduct(productName);
			if (product != null) {
				for (GenericProducts products[] : item) {
					String item = products[index1++].getProductName();
					if (productName.equals(item)) {
						data[index2++] = products[index1].toString();
					}
				}
				return data;
			} else {
				return null;
			}
		}
		return null;
	}

}
