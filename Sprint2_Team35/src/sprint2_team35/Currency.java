package sprint2_team35;

/**
 * This class simulates a currency. Each cash box object instance must have an
 * associated currency object instance.
 * 
 * @author ryanbeattie
 *
 */

public class Currency {
	private double rate = 1.00;
	private String currencyName = "GBP";
	private String myDir = "cashbox.csv";
	private String[] currencySymbols = { "£", "p" };

	/**
	 * Constructor method for Currency. This constructor should be used when
	 * creating an instance of Currency for non GBP currencies.
	 * 
	 * @param rate            - the rate of the currency against GBP (default
	 *                        currency)
	 * @param currencyName    - the name of the currency, e.g., EUR for Euro
	 * @param myDir           - the path for the CSV file
	 * @param currencySymbols - a String array containing associated symbols of the
	 *                        currency, e.g., € for Euro
	 */

	public Currency(double rate, String currencyName, String myDir, String[] currencySymbols) {
		if (rate <= 0.00) {
			this.rate = 1.00;
		} else {
			this.rate = rate;
		}

		if (myDir.trim() == "") {
			this.myDir = "cashbox.csv";
		} else {
			this.myDir = myDir;
		}
		
		if (currencyName.trim() == "") {
			this.currencyName = "GBP";
		} else {
			this.currencyName = currencyName;
		}

		if (currencySymbols == null) {
			currencySymbols = new String[2];
			currencySymbols[0] = "�";
			currencySymbols[1] = "p";
		} else {
			this.currencySymbols = currencySymbols;
		}
	}

	/**
	 * The default constructor for object type Currency
	 */

	public Currency() {
	}

	/**
	 * Getter method for rate
	 * 
	 * @return - the rate of the currency against GBP (default currency)
	 */

	public double getRate() {
		return rate;
	}

	/**
	 * Setter method for rate
	 * 
	 * @param rate - the rate of the currency against GBP (default currency)
	 */

	public void setRate(double rate) {
		if (rate <= 0.00) {
			this.rate = 1.00;
		} else {
			this.rate = rate;
		}
	}

	/**
	 * Getter method for currencyName
	 * 
	 * @return - the name of the currency, e.g., EUR for Euro
	 */

	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * Setter method for currencyName
	 * 
	 * @param currencyName - the name of the currency, e.g., EUR for Euro
	 */

	public void setCurrencyName(String currencyName) {
		if (currencyName.trim() == "") {
			this.currencyName = "GBP";
		} else {
			this.currencyName = currencyName;
		}
	}

	/**
	 * Getter method for myDir
	 * 
	 * @return - the path for the CSV file
	 */

	public String getMyDir() {
		return myDir;
	}

	/**
	 * Setter method for myDir
	 * 
	 * @param - the path for the CSV file
	 */

	public void setMyDir(String myDir) {
		if (myDir.trim() == "") {
			this.myDir = "cashbox.csv";
		} else {
			this.myDir = myDir;
		}
	}

	/**
	 * Getter method for currencySymbols
	 * 
	 * @return - a String array containing associated symbols of the currency, e.g.,
	 *         € for Euro
	 */

	public String[] getCurrencySymbols() {
		return currencySymbols;
	}

	/**
	 * Setter method for currencySymbols
	 * 
	 * @param currencySymbols - a String array containing associated symbols of the
	 *                        currency, e.g., € for Euro
	 */

	public void setCurrencySymbols(String[] currencySymbols) {
		if (currencySymbols == null) {
			currencySymbols = new String[2];
			currencySymbols[0] = "�";
			currencySymbols[1] = "p";
		} else {
			this.currencySymbols = currencySymbols;
		}
	}

}
