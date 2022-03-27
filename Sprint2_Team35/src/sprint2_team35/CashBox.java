package sprint2_team35;

import java.text.DecimalFormat;

/**
 * This class models a cash box, each with an associated currency object instance and
 * array of accepted coins.
 */

public class CashBox implements ICashBox {
	private ChangeTube[] changeTubes;
	private double[] acceptedCoins = { 0.10, 0.20, 0.50, 1.00, 2.00 };
	private double cashBoxAmount;
	private Currency currency = new Currency();
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Constructor method for CashBox. This constructor should be used when creating
	 * a CashBox instance for non GBP currencies.
	 * 
	 * @param acceptedCoins - a double array containing the accepted coin values for
	 *                      the cash box.
	 * @param currency      - the currency of the cash box
	 */

	public CashBox(double[] acceptedCoins, Currency currency) {
		this.acceptedCoins = acceptedCoins;
		this.currency = currency;
		this.changeTubes = new ChangeTube[acceptedCoins.length];

		/*
		 * For loop to create a new ChangeTube object instance for each coin in
		 * acceptedCoins.
		 */

		for (int i = 0; i < this.acceptedCoins.length; i++) {
			changeTubes[i] = new ChangeTube();
			this.changeTubes[i].setTubeName("Tube " + (i + 1));
			this.changeTubes[i].setQuantity(0);
		}
	}

	/**
	 * Default constructor method for CashBox
	 */

	public CashBox() {
		this.changeTubes = new ChangeTube[acceptedCoins.length];

		/*
		 * For loop to create a new ChangeTube object instance for each coin in
		 * acceptedCoins.
		 */

		for (int i = 0; i < this.acceptedCoins.length; i++) {
			changeTubes[i] = new ChangeTube();
			this.changeTubes[i].setTubeName("Tube " + (i + 1));
			this.changeTubes[i].setQuantity(0);
		}
	}

	/**
	 * Getter method for changeTubes
	 * 
	 * @return - an array containing references to ChangeTube objects
	 */

	public ChangeTube[] getChangeTubes() {
		return this.changeTubes;
	}

	/**
	 * Setter method for changeTubes
	 * 
	 * @param tubeAmount - an Integer array containing the amount each tube should
	 *                   be set to
	 */

	public void setChangeTubes(int[] tubeAmount) {

		// For loop to iterate through each ChangeTube object in changeTubes to set the
		// total amount.

		for (int i = 0; i < tubeAmount.length; i++) {
			this.changeTubes[i].setQuantity(tubeAmount[i]);
		}
	}

	/**
	 * Getter method for currency
	 * 
	 * @return - Currency object
	 */

	public Currency getCurrency() {
		return this.currency;
	}

	/**
	 * Setter method for currency
	 * 
	 * @param currency - Currency object
	 */

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Getter method for cashBoxAmount
	 * 
	 * @return - the total amount in the cash box
	 */

	public double getCashBoxAmount() {
		return this.cashBoxAmount;
	}

	/**
	 * Setter method for cashBoxAmount
	 * 
	 * @param cashBoxAmount - the total amount to be added to the cash box
	 */

	public void setCashBoxAmount(double cashBoxAmount) {
		this.cashBoxAmount = cashBoxAmount;
	}

	/**
	 * This method is used to add coins to the cash box
	 * 
	 * @param coinEntered - the coin amount
	 */

	public void enterCoin(double coinEntered) {
		for (int i = 0; i < this.changeTubes.length; i++) {
			int total = changeTubes[i].getQuantity();

			/*
			 * If the coin entered is in acceptedCoins and the total is less than 50, coins
			 * are added to the change tubes.
			 */

			if (coinEntered == this.acceptedCoins[i] && total < 50) {
				this.changeTubes[i].setQuantity(total + 1);

				// If the quantity is greater than 50, coins are added to the cash box.

			} else if (coinEntered == this.acceptedCoins[i] && total >= 50) {
				this.cashBoxAmount += 1;
			}
		}
	}

	/**
	 * This method is used to retrieve change from the change tubes
	 * 
	 * @param moneyPaid  - the amount initially inserted into the machine
	 * @param actualCost - the amount paid
	 * @return - an array containing the total number of each coin to be given in
	 *         change
	 */

	public int[] giveChange(double moneyPaid, double actualCost) {
		int[] change = new int[changeTubes.length];
		for (int i = (this.changeTubes.length - 1); i >= 0; i--) {
			int total = this.changeTubes[i].getQuantity();
			while (moneyPaid - actualCost >= (this.acceptedCoins[i] - 0.01) && this.changeTubes[i].getQuantity() > 0) { // e.g.,
																														// if
																														// >
																														// 1.99,
																														// add
																														// 2
																														// to
																														// change
																														// array
				change[i] += 1;
				this.changeTubes[i].setQuantity(total - 1); // Change given from change tubes
				moneyPaid -= this.acceptedCoins[i];
			}
		}

		return change;
	}

	/**
	 * This method is used to add coins to the change tubes
	 * 
	 * @param coins - an integer array containing the total number of each coin to
	 *              be added to the change tubes
	 */

	public void addTubes(int[] coins) {
		try {
			for (int i = 0; i < coins.length; i++) {
				int total = this.changeTubes[i].getQuantity();
				this.changeTubes[i].setQuantity(total + coins[i]);

				// If ChangeTube quantity is less than 0, set quantity to 0

				if (this.changeTubes[i].getQuantity() < 0) {
					this.changeTubes[i].setQuantity(0);

					// If ChangeTube is greater than 50, set quantity to 50

				} else if (this.changeTubes[i].getQuantity() > 50) {
					this.changeTubes[i].setQuantity(50);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * toString method for cash box to display total amount stored inside
	 * 
	 * @return - a String containing the total amount stored in the cash box and the
	 *         total amount of coins in each tube.
	 */

	public String toString() {
		String desc = "Total in collection box: £";
		desc += df.format(getCashBoxAmount());
		desc += "\nCoins in tubes: ";
		for (int i = 0; i < this.acceptedCoins.length; i++) {
			desc += "\n£" + df.format(this.acceptedCoins[i]) + ": " + changeTubes[i].getQuantity();
		}
		return desc;
	}

	/**
	 * Getter method for acceptedCoins
	 * 
	 * @return - a double array containing the accepted coin values for the cash
	 *         box.
	 */

	public double[] getAcceptedCoins() {
		return acceptedCoins;
	}

	/**
	 * Setter method for acceptedCoins
	 * 
	 * @param acceptedCoins - a double array containing the accepted coin values for
	 *                      the cash box.
	 */

	public void setAcceptedCoins(double[] acceptedCoins) {
		this.acceptedCoins = acceptedCoins;
	}

}