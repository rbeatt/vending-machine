package sprint2_team35;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericProductsTest {
	
	GenericProducts genericProduct;

	@BeforeEach
	void setUp() throws Exception {
		genericProduct = new GenericProducts();
	}

	@Test
	void testGetProductName() {
		System.out.println("About to test get product name");
		genericProduct.setProductName("Name");
		String expected = "Name";
		String actual = genericProduct.getProductName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetProductType() {
		System.out.println("About to test get product type");
		genericProduct.setProductType(ProductType.HOTFOOD);
		String expected = "Hot Food";
		String actual = genericProduct.getProductType();
		assertEquals(expected, actual);
	}

	@Test
	void testGetPrice() {
		System.out.println("About to test get product type");
		genericProduct.setPrice(1.20);
		double expected = 1.20;
		double actual = genericProduct.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	void testGetQuantity() {
		System.out.println("About to test get product quantity");
		genericProduct.setQuantity(10);
		int expected = 10;
		int actual = genericProduct.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testGetSaleCount() {
		System.out.println("About to test get product sale count");
		genericProduct.setProductSaleCount(5);
		int expected = 5;
		int actual = genericProduct.getSaleCount();
		assertEquals(expected, actual);
	}

	@Test
	void testSetProductName() {
		System.out.println("About to test set product name");
		genericProduct.setProductName("Name");
		String expected = "Name";
		String actual = genericProduct.getProductName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetPrice() {
		System.out.println("About to test set product type");
		genericProduct.setPrice(1.20);
		double expected = 1.20;
		double actual = genericProduct.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	void testSetQuantity() {
		System.out.println("About to test get product quantity");
		genericProduct.setQuantity(10);
		int expected = 10;
		int actual = genericProduct.getQuantity();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetProductType() {
		System.out.println("About to test set product type");
		genericProduct.setProductType(ProductType.HOTFOOD);
		String expected = "Hot Food";
		String actual = genericProduct.getProductType();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetProductSaleCount() {
		System.out.println("About to test set product sale count");
		genericProduct.setProductSaleCount(5);
		int expected = 5;
		int actual = genericProduct.getSaleCount();
		assertEquals(expected, actual);
	}

	@Test
	void testLowOnProducts() {
		System.out.println("About to test low on products");
		genericProduct.setProductSaleCount(2);
		String expected = "Product is low on stock";
		String actual = genericProduct.lowOnProducts();
		assertEquals(expected, actual);
	}
	
	void testLowOnProducts2() {
		System.out.println("About to test low on products");
		genericProduct.setProductSaleCount(0);
		String expected = "Product is out of stock";
		String actual = genericProduct.lowOnProducts();
		assertEquals(expected, actual);
	}
	
	void testLowOnProducts3() {
		System.out.println("About to test low on products");
		genericProduct.setProductSaleCount(5);
		String expected = "";
		String actual = genericProduct.lowOnProducts();
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		System.out.println("About to test to string");
		genericProduct.setProductName("name");
		genericProduct.setProductType(ProductType.HOTFOOD);
		genericProduct.setPrice(1.2);
		genericProduct.setQuantity(5);
		genericProduct.setProductSaleCount(3);
		String expected = "name,Hot Food,1.20,5,3";
		String actual = genericProduct.toString();
		assertEquals(expected, actual);
	}

}
