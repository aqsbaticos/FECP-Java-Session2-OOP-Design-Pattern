package gbuy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gbuy.discount.DiscountStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CartTest {

    private Cart cart;
    private Product product1;
    private Product product2;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product("Toothbrush", 100);
        product2 = new Product("Toothpaste", 200);
        System.setOut(new PrintStream(outputStream));
    }
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
    @Test
    void shouldGetTotalPrice(){
        cart.addProduct(product1);
        cart.addProduct(product2);
        double price = cart.getTotalPrice();
        assertEquals(300, price, 0.001);
    }
    @Test
    void shouldShowEntireCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.getAllProducts();

        String expectedOutput = "=== Cart ===\n" +
                "1. Toothbrush 100.0\n" +
                "2. Toothpaste 200.0\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    void shouldGetCorrectProduct() {
        cart.addProduct(product1);

        cart.getProduct(0);
        assertEquals("1. Toothbrush 100.0\n", outputStream.toString());
    }
    @Test
    void shouldBeInvalidWhenFetchingInvalidIndex() {
        cart.addProduct(product1);

        cart.getProduct(5);
        assertEquals("Invalid index.\n", outputStream.toString());
    }
    @Test
    void shouldRemoveProductFromCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(0);

        outputStream.reset();
        cart.getAllProducts();

        String expectedOutput = "=== Cart ===\n" +
                "1. Toothpaste 200.0\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
    @Test
    void shouldBeInvalidWhenRemovingProductWithInvalidIndex() {
        cart.addProduct(product1);

        cart.removeProduct(5);
        assertEquals("Invalid index.\n", outputStream.toString());
    }
}
