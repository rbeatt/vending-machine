package sprint2_team35;

import java.text.DecimalFormat;

public class GenericProducts implements IProducts{
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private String productName;			//Product name
	private ProductType productType;	//Product type e.g. food, drink
	private double price;				//Product's price
	private int quantity;				//Product's amount
	private int saleCount;				//Product's sale amount
	
	/**
	 *  A empty constructor
	 */
	public GenericProducts() {
		setProductName("");
		setPrice(0);
		setQuantity(0);
	}

	/**
	 * 
	 * @param itemName
	 * @param price
	 * @param quantity
	 */
	public GenericProducts(String productName, ProductType productType ,double price, int quantity, int saleCount) {
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.saleCount = saleCount;
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
	public int getQuantity() {
		return this.quantity;
	}
	
	public int getSaleCount() {
		return this.saleCount;
	}
	
	/**
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		if(productName != null) {
			this.productName = productName;
		}
		else if(productName == null || productName == "") {
			//default value
			this.productName = "Undefined";
		}
	}
	
	/**
	 * This method will check if price can be divide by 10p
	 * @param price
	 */
	public void setPrice(double price) {
		double check = ((price * 100) % 10);			//If modulus 10p is 0 then it will accept the value so change can be given out
		if(check == 0) {
			this.price = price;
		}
	}
	
	/**
	 * This method will add product stocks to the current stock
	 * @param count
	 */
	public void setQuantity(int quantity) {
		if(quantity >= 0 && quantity <= 20) {
			this.quantity = quantity;
		}
		else if(quantity < 0) {
			this.quantity = 0;
		}
		else if(quantity > 20) {
			this.quantity = 20;
		}
	}
	
	public void setProductType(ProductType productType) {
		switch (productType) {
		case FOOD:
			this.productType = ProductType.FOOD;
			break;
		case DRINK:
			this.productType = ProductType.DRINK;
			break;
		case ACCESSORY:
			this.productType = ProductType.ACCESSORY;
			break;
		case CLOTHING:
			this.productType = ProductType.CLOTHING;
			break;
		default:
			this.productType = ProductType.OTHER;
			break;
		}
	}
	
	public void setProductSaleCount(int saleCount) {
		if(saleCount <= 0) {
			this.saleCount = 0;
		}
		else {
			this.saleCount = saleCount;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String lowOnProducts() {
		String stock = "";
		if(this.quantity <= 3) {
			stock += "Product is low on stock";
			return stock;
		}
		else if(this.quantity <= 0){
			stock += "Product is out of stock";
			return stock;
		}
		return "";
	}
	
	/**
	 * 
	 */
	public String toString() {
        String details = this.productName + "," + this.productType + "," +  df.format(this.price) + "," + this.quantity + "," + this.saleCount;
        return details;
    }
}
