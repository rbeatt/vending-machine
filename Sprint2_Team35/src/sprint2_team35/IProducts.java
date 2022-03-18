package sprint2_team35;

public interface IProducts {
	public String toString();
	public String getProductName();
	public double getPrice();
	public int getQuantity();
	public int getSaleCount();
	public String getProductType();
	public void setProductName(String productName);
	public void setPrice(double price);
	public void setQuantity(int quantity);
	public void setProductType(ProductType productType);
	public void setProductSaleCount(int saleCount);
}
