package sprint1_team35;

import java.text.DecimalFormat;

/**
 * This class models an item in a vending machine, including fields for item name, cost to buy, and quantity in stock.
 */

public class Item {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String name;
	private double cost;
	private int quantity;
	
	/**
	 * Constructor method for Item object. Initialises the item's name, cost, and quantity, using appropriate set methods to validate input.
	 * @param name - the item's name
	 * @param cost - the cost to buy
	 * @param quantity - the initial quantity in stock
	 */
	
	public Item(String name, double cost, int quantity) {
		setName(name);
		setCost(cost);
		setQuantity(quantity);
	}
	
	/**
	 * Overloaded constructor method for initialising an undefined Item object.
	 */
	
	public Item() {
		setName("undefined");
		setCost(0);
		setQuantity(0);
	}
	
	/**
	 * Set method for an item's name.
	 * @param name - the item's name
	 */	
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set method for an item's cost.
	 * @param name - the cost to buy
	 */	
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Set method for an item's quantity.
	 * @param name - the quantity in stock
	 */	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Get method for an item's name.
	 * @return - the item's name.
	 */	
	
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Get method for an item's cost.
	 * @return - the cost to buy.
	 */	
	
	public double getCost() {
		return this.cost;
	}
	
	/**
	 * Get method for an item's quantity.
	 * @return - the quantity in stock.
	 */	
	
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * This method lists an item's data as a single string.
	 * @return - a description of the item's name, cost, and quantity
	 */
	
	public String toString() {
		String desc = "Name: " + getName();
		desc += "\nPrice: �" + df.format(getCost());
		desc += "\nAmount in stock: " + getQuantity();
		return desc;
	}
	
}
