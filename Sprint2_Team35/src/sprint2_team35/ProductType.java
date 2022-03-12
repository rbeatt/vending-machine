package sprint2_team35;

public enum ProductType {
	FOOD("Food"),DRINK("Drink"),ACCESSORY("Accessory"),CLOTHING("Clothing"),OTHER("Other");
	
	private String str;
	
	private ProductType(String productType) {
		str = productType;
	}
	
	public String toString() {
		return str;
	}
}
