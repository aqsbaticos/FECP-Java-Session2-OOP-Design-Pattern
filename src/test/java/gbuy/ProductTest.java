package gbuy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

	@Test
	void constructor_shouldInitializeNameAndPrice() {

		String expectedName = "Laptop";
		double expectedPrice = 1200.50;
		Product product = new Product(expectedName, expectedPrice);

		assertNotNull(product, "Product object should not be null after creation");
		assertEquals(expectedName, product.getProductName(), "Product name should match the constructor argument");
		assertEquals(expectedPrice, product.getProductPrice(), 0.001, "Product price should match the constructor argument");
	}

	@Test
	void constructor_shouldHandleEmptyName() {

		String expectedName = "";
		double expectedPrice = 50.00;

		Product product = new Product(expectedName, expectedPrice);

		assertEquals(expectedName, product.getProductName(), "Product name should be empty string");
	}

	@Test
	void constructor_shouldHandleZeroPrice() {

		String expectedName = "Free Item";
		double expectedPrice = 0.00;

		Product product = new Product(expectedName, expectedPrice);

		assertEquals(expectedPrice, product.getProductPrice(), 0.001, "Product price should be 0.0");
	}

	@Test
	void constructor_shouldThrowExceptionForNegativePrice() {

		String name = "Invalid Item";
		double negativePrice = -10.0;

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			new Product(name, negativePrice);
		}, "Constructor should throw IllegalArgumentException for negative price");

		assertEquals("Product price cannot be negative.", thrown.getMessage(),
				"Exception message should be 'Product price cannot be negative.'");
	}


	@Test
	void getters_shouldReturnCorrectValues() {

		String name = "Mouse";
		double price = 25.99;
		Product product = new Product(name, price);

		assertEquals(name, product.getProductName(), "getProductName should return the correct name");
		assertEquals(price, product.getProductPrice(), 0.001, "getProductPrice should return the correct price");
	}

	@Test
	void setProductName_shouldUpdateName() {

		Product product = new Product("Old Name", 10.0);
		String newName = "New Name";

		product.setProductName(newName);

		assertEquals(newName, product.getProductName(), "setProductName should update the product name");
	}

	@Test
	void setProductPrice_shouldUpdatePrice_Valid() {

		Product product = new Product("Item", 50.0);
		double newPrice = 75.25;

		product.setProductPrice(newPrice);

		assertEquals(newPrice, product.getProductPrice(), 0.001, "setProductPrice should update the product price");
	}

	@Test
	void setProductPrice_shouldHandleZeroPrice() {

		Product product = new Product("Existing Item", 200.0);
		double zeroPrice = 0.0;

		product.setProductPrice(zeroPrice);

		assertEquals(zeroPrice, product.getProductPrice(), 0.001, "setProductPrice should allow setting zero price");
	}

	@Test
	void setProductPrice_shouldThrowExceptionForNegativePrice() {

		Product product = new Product("Existing Item", 300.0);
		double negativePrice = -15.50;

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			product.setProductPrice(negativePrice);
		}, "setProductPrice should throw IllegalArgumentException for negative price");

		assertEquals("Product price cannot be negative.", thrown.getMessage(),
				"Exception message should be 'Product price cannot be negative.'");

		assertEquals(300.0, product.getProductPrice(), 0.001, "Product price should remain unchanged after failed set");
	}

	@Test
	void setProductName_shouldHandleEmptyName() {

		Product product = new Product("Existing Name", 100.0);
		String emptyName = "";

		product.setProductName(emptyName);

		assertEquals(emptyName, product.getProductName(), "setProductName should allow setting an empty string");
	}

}