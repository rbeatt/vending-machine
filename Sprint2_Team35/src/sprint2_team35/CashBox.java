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

	public CashBox() {
	}

	public int getTotal10s() {
		return this.total10s;
	}

	public int getTotal20s() {
		return this.total20s;
	}

	public int getTotal50s() {
		return this.total50s;
	}

	public int getTotal1s() {
		return this.total1s;
	}

	public int getTotal2s() {
		return this.total2s;
	}

	public double getCashBoxAmount() {
		return this.cashBoxAmount;
	}
	
	public void setTotal10s(int total10s) {
		this.total10s = total10s;
	}
	
	public void setTotal20s(int total20s) {
		this.total20s = total20s;
	}
	
	public void setTotal50s(int total50s) {
		this.total50s = total50s;
	}
	
	public void setTotal1s(int total1s) {
		this.total1s = total1s;
	}
	
	public void setTotal2s(int total2s) {
		this.total2s = total2s;
	}
	
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
	
	public void addTubes(int ten, int twenty, int fifty, int one, int two) {
		this.total10s += ten;
		if (getTotal10s() < 0) {
			setTotal10s(0);
		}
		else if (getTotal10s() > 50) {
			setTotal10s(50);
		}
		
		this.total20s += twenty;
		if (getTotal20s() < 0) {
			setTotal20s(0);
		}
		else if (getTotal20s() > 50) {
			setTotal20s(50);
		}
		this.total50s += fifty;
		if (getTotal50s() < 0) {
			setTotal50s(0);
		}
		else if (getTotal50s() > 50) {
			setTotal50s(50);
		}
		
		this.total1s += one;
		if (getTotal1s() < 0) {
			setTotal1s(0);
		}
		else if (getTotal1s() > 50) {
			setTotal1s(50);
		}
		
		this.total2s += two;
		if (getTotal2s() < 0) {
			setTotal2s(0);
		}
		else if (getTotal2s() > 50) {
			setTotal2s(50);
		}
	}
	
	
	/**
	 * toString method for cash box to display total amount stored inside
	 */
			
	public String toString() {
		String desc = "Total in collection box: £";
		desc += df.format(cashBoxAmount);
		desc += "\nCoins in tubes: ";
		desc += "\n10p: " + getTotal10s();
		desc += "\n20p: " + getTotal20s();
		desc += "\n50p: " + getTotal50s();
		desc += "\n£1: " + getTotal1s();
		desc += "\n£2: " + getTotal2s();
		return desc;
	}
			
}			