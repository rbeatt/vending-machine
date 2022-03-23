package sprint2_team35;

public enum ProductType {
	HOTFOOD("Hot Food"),HOTDRINK("Hot Drink"),COLDDRINK("Cold Drink"),CONFECTIONARY("Confectionary"),TICKET("Ticket"),ELECTRONICS("Electronics"),EQUIPMENT("Equipment"),ACCESSORY("Accessory"),CLOTHING("Clothing"),OTHER("Other");
	
	private String str;
	
	private ProductType(String productType) {
		str = productType;
	}
	
	public String toString() {
		return str;
	}
}
