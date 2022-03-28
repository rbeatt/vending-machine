package sprint2_team35;

import java.text.DecimalFormat;

/**
 * This class models a change tube. Required for storing and dispensing change.
 * 
 * @author ryanbeattie
 *
 */

public class ChangeTube {
	private String tubeName;
	private int quantity;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Default constructor for ChangeTube
	 */

	public ChangeTube() {
	}

	/**
	 * Constructor method for ChangeTube
	 * 
	 * @param tubeName    - the name of the tub, e.g., Tube 1
	 * @param quantity - the total quantity of coins stored in the tube
	 */

	public ChangeTube(String tubeName, int quantity) {
		if (tubeName.trim() == "") {
			this.tubeName = "changeTube";
		} else {
			this.tubeName = tubeName;
		}
		
		if (quantity <= 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
		}
	}

	/**
	 * Getter method for quantity
	 * 
	 * @return - the total quantity of coins stored in the tube
	 */

	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity
	 * 
	 * @param quantity - the new total quantity of coins stored in the tube
	 */

	public void setQuantity(int quantity) {
		if (quantity <= 0) {
			this.quantity = 0;
		} else {
			this.quantity = quantity;
		}
	}

	/**
	 * Getter method for tubeName
	 * 
	 * @return - the name of the tub, e.g., Tube 1
	 */

	public String getTubeName() {
		return tubeName;
	}

	/**
	 * Setter method for tubeName
	 * 
	 * @param tubeName - the name of the tub, e.g., Tube 1
	 */

	public void setTubeName(String tubeName) {
		if (tubeName.trim() == "") {
			this.tubeName = "changeTube";
		} else {
			this.tubeName = tubeName;
		}
	}

	public String toString() {
		String desc = "Total coins in change tube " + this.getTubeName() + ": €";
		desc += "\n" + df.format(this.getQuantity());
		return desc;
	}
}
