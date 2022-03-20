package sprint2_team35;

import java.text.DecimalFormat;

public class CashBox implements ICashBox {

	private int total10s;
	private int total20s;
	private int total50s;
	private int total1s;
	private int total2s;
	private double cashBoxAmount;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private double rate = 0.00;
	private double[] acceptedCoins = { 0.10, 0.20, 0.50, 1.00, 2.00 };
	private String cashBoxName = "GBP";
	private String[] cashBoxSymbols = { "£", "p" };

	/**
	 * Default constructor for CashBox
	 */

	public CashBox() {
	}

	/**
	 * Accessor method for cashBoxSymbols
	 * 
	 * @return - an array containing associated currency symbols, e.g., £, p
	 */

	public String[] getCashBoxSymbols() {
		return this.cashBoxSymbols;
	}

	/**
	 * Accessor method for cashBoxName
	 * 
	 * @return - the currency type of the cash box
	 */

	public String getCashBoxName() {
		return this.cashBoxName;
	}

	/**
	 * Accessor method for acceptedCoins
	 * 
	 * @return - an array containing the accepted coins for the associated currency,
	 *         e.g., 10p, 20p, 50p, £1, £2
	 */

	public double[] getAcceptedCoins() {
		return this.acceptedCoins;
	}

	/**
	 * Accessor method for rate
	 * 
	 * @return - the rate of the currency against the default GBP currency, e.g.,
	 *         1.19 for EUR
	 */

	public double getRate() {
		return this.rate;
	}

	/**
	 * Accessor method for total10s
	 * 
	 * @return - the total number of 10p coins in the change tubes
	 */

	public int getTotal10s() {
		return this.total10s;
	}

	/**
	 * Accessor method for total20s
	 * 
	 * @return - the total number of 20p coins in the change tubes
	 */

	public int getTotal20s() {
		return this.total20s;
	}

	/**
	 * Accessor methods for total50s
	 * 
	 * @return - the total number of 50p coins in the change tubes
	 */

	public int getTotal50s() {
		return this.total50s;
	}

	/**
	 * Accessor methods for total1s
	 * 
	 * @return - the total number of £1 coins in the change tubes
	 */

	public int getTotal1s() {
		return this.total1s;
	}

	/**
	 * Accessor methods for total2s
	 * 
	 * @return - the total number of £2 coins in the change tubes
	 */

	public int getTotal2s() {
		return this.total2s;
	}

	/**
	 * Accessor method for cashBoxAmount
	 * 
	 * @return - the total amount in the cash box
	 */

	public double getCashBoxAmount() {
		return this.cashBoxAmount;
	}

	/**
	 * Mutator method for rate
	 * 
	 * @param - the rate for the currency against the default GBP currency, e.g.,
	 *          1.19 for EUR
	 */

	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * Mutator method for total10s
	 * 
	 * @param - the total number of 10p coins to be added to change tubes
	 */

	public void setTotal10s(int total10s) {
		this.total10s = total10s;
	}

	/**
	 * Mutator method for total20s
	 * 
	 * @param - the total number of 20p coins to be added to change tubes
	 */

	public void setTotal20s(int total20s) {
		this.total20s = total20s;
	}

	/**
	 * Mutator method for total50s
	 * 
	 * @param - the total number of 50p coins to be added to change tubes
	 */

	public void setTotal50s(int total50s) {
		this.total50s = total50s;
	}

	/**
	 * Mutator method for total1s
	 * 
	 * @param - the total number of £1 coins to be added to change tubes
	 */

	public void setTotal1s(int total1s) {
		this.total1s = total1s;
	}

	/**
	 * Mutator method for total2s
	 * 
	 * @param - the total number of £2 coins to be added to change tubes
	 */

	public void setTotal2s(int total2s) {
		this.total2s = total2s;
	}

	/**
	 * Mutator method for cashBoxAmount
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

		// When a 10p is entered, the total 10p coins goes up by 1
		if (coinEntered == 0.1 && getTotal10s() < 50) {

			this.total10s += 1;

		}
		// If there are more than 50 20ps, it will be sent to the Cashbox
		else if (coinEntered == 0.1 && getTotal20s() >= 50) {

			this.cashBoxAmount += 0.1;

		}

		// When a 20p is entered, the total 20p coins goes up by 1
		if (coinEntered == 0.2 && getTotal20s() < 50) {

			this.total20s += 1;

		}
		// If there are more than 50 20ps, it will be sent to the Cashbox
		else if (coinEntered == 0.2 && getTotal20s() >= 50) {

			this.cashBoxAmount += 0.2;

		}

		// When a 50p is entered, the total 50p coins goes up by 1
		if (coinEntered == 0.5 && getTotal50s() < 50) {

			this.total50s += 1;

		}

		else if (coinEntered == 0.5 && getTotal50s() >= 50) {

			this.cashBoxAmount += 0.5;
		}

		// When a £1 is entered, the total �1 coins goes up by 1
		if (coinEntered == 1 && getTotal1s() < 50) {

			this.total1s += 1;

		}

		else if (coinEntered == 1 && getTotal1s() >= 50) {

			this.cashBoxAmount += 1;

		}
		// When a £2 is entered, the total �2 coins goes up by 1
		if (coinEntered == 2 && getTotal2s() < 50) {

			this.total2s += 1;

		}

		else if (coinEntered == 2 && getTotal2s() >= 50) {

			this.cashBoxAmount += 2;

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
		int[] change = { 0, 0, 0, 0, 0 };
		while (moneyPaid - actualCost >= 1.99 && this.total2s > 0) {
			change[4] += 1;
			this.total2s -= 1;
			moneyPaid -= 2.0;
		}
		while (moneyPaid - actualCost >= 0.99 && this.total1s > 0) {
			change[3] += 1;
			this.total1s -= 1;
			moneyPaid -= 1.0;
		}
		while (moneyPaid - actualCost >= 0.49 && this.total50s > 0) {
			change[2] += 1;
			this.total50s -= 1;
			moneyPaid -= 0.50;
		}
		while (moneyPaid - actualCost >= 0.19 && this.total20s > 0) {
			change[1] += 1;
			this.total20s -= 1;
			moneyPaid -= 0.20;
		}
		while (moneyPaid - actualCost >= 0.09 && this.total10s > 0) {
			change[0] += 1;
			this.total10s -= 1;
			moneyPaid -= 0.10;
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
			this.total10s += coins[0];
			if (getTotal10s() < 0) {
				setTotal10s(0);
			} else if (getTotal10s() > 50) {
				setTotal10s(50);
			}

			this.total20s += coins[1];
			if (getTotal20s() < 0) {
				setTotal20s(0);
			} else if (getTotal20s() > 50) {
				setTotal20s(50);
			}
			this.total50s += coins[2];
			if (getTotal50s() < 0) {
				setTotal50s(0);
			} else if (getTotal50s() > 50) {
				setTotal50s(50);
			}

			this.total1s += coins[3];
			if (getTotal1s() < 0) {
				setTotal1s(0);
			} else if (getTotal1s() > 50) {
				setTotal1s(50);
			}

			this.total2s += coins[4];
			if (getTotal2s() < 0) {
				setTotal2s(0);
			} else if (getTotal2s() > 50) {
				setTotal2s(50);
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
		String desc = "Total in collection box: " + this.getCashBoxSymbols()[0];
		desc += df.format(cashBoxAmount);
		desc += "\nCoins in tubes: ";
		desc += "\n10" + this.cashBoxSymbols[1] + ": " + getTotal10s();
		desc += "\n20" + this.cashBoxSymbols[1] + ": " + +getTotal20s();
		desc += "\n50" + this.cashBoxSymbols[1] + ": " + +getTotal50s();
		desc += "\n" + this.cashBoxSymbols[0] + "1: " + getTotal1s();
		desc += "\n" + this.cashBoxSymbols[0] + "2: " + getTotal2s();
		return desc;
	}

}		