package sprint2_team35;

/**
 * This class models a change tube. Required for storing and dispensing change.
 * 
 * @author ryanbeattie
 *
 */

public class ChangeTube {
	private String tubeName;
	private int quantity;

	/**
	 * Default constructor for ChangeTube
	 */

	public ChangeTube() {
	}

	/**
	 * Constructor method for ChangeTube
	 * 
	 * @param tubeName    - the name of the tub, e.g., Tube 1
	 * @param totalAmount - the total quantity of coins stored in the tube
	 */

	public ChangeTube(String tubeName, int totalAmount) {
		this.tubeName = tubeName;
		this.quantity = totalAmount;
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
		this.quantity = quantity;
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
		this.tubeName = tubeName;
	}

}
