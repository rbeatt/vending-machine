package sprint2_team35;

import java.text.DecimalFormat;

/**
 * This class simulates a cash box for Euro currency
 * 
 * @author ryanbeattie
 */

public class EURCashBox extends CashBox implements ICashBox {
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Default constructor for EURCashBox
	 */

	public EURCashBox() {
		super(new double[] { 0.10, 0.20, 0.50, 1.00, 2.00 }, new Currency(1.19, "EUR", "EURcashbox.csv", new String[] { "€", "c" }));
	}

	@Override
	public String toString() {
		String desc = "Total in collection box: €";
		desc += df.format(getCashBoxAmount());
		desc += "\nCoins in tubes: ";
		for (int i = 0; i < this.getAcceptedCoins().length; i++) {
			desc += "\n€" + df.format(this.getAcceptedCoins()[i]) + ": " + getChangeTubes()[i].getQuantity();
		}
		return desc;
	}

}
