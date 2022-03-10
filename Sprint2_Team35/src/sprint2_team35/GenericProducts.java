package sprint2_team35;

public class GenericProducts implements IProducts{
	private String id;					//Product Id for the vending machine e.g. A1 or C4
	private String productName;			//Product name
	private ProductType productType;	//Product type e.g. food, drink
	private double price;				//Product's price
	private int count;					//Product's amount
	
	/**
	 *  A empty constructor
	 */
	public GenericProducts() {
	}

	/**
	 * 
	 * @param id
	 * @param itemName
	 * @param price
	 * @param count
	 */
	public GenericProducts(String id, String productName, double price, int count) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.count = count;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getProductName() {
		return this.productName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getProductType() {
		String productType = null;
		//This switches enum to string.
		switch (this.productType) {
		case FOOD:
			productType = "Food";
			break;
		case DRINK:
			productType = "Drink";
			break;
		case ACCESSORY:
			productType = "Accessory";
			break;
		case CLOTHING:
			productType = "Clothing";
			break;
		default:
			productType = "Other";
			break;
		}
		return productType;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * This method will check if price can be divide by 10p
	 * @param price
	 */
	public void setPrice(double price) {
		double check = (price % 0.1);			//If modulus 10p is 0 then it will accept the value
		if(check == 0) {
			this.price = price;
		}
	}
	
	/**
	 * This method will add product stocks to the current stock
	 * @param count
	 */
	public void setCount(int count) {
		if(count > 0) {
			this.count += count;
		}
	}
	
	/**
	 * 
	 */
	public String purchase() {
		String buy = "";
		buy += "You have bought: " + this.productName + " for " + this.price;
		this.count--;
		return buy;
	}
	
	/**
	 * 
	 */
	public String toString() {
        String details = this.id + "," + this.productName + "," +  this.price + "," + this.count;
        return details;
    }
}
