package gbuy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gbuy.Cart;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    static Cart cart;

    @BeforeEach
    void setup(){
        cart = new Cart();
    }

    @Test
    void shouldGetTotalPrice(){
        Product product1 = new Product("toothbrush", 100);
        Product product2 = new Product("toothpaste", 200);
        cart.addProduct(product1);
        cart.addProduct(product2);
        double price = cart.getTotalPrice();
        assertEquals(300, price, 0.001);
    }

//    @Test
//    void shouldAddProduct(){
//        cart = new Cart();
//        Product product = new Product("toothbrush", 100);
//        cart.addProduct(product);
//        assertTrue();
//    }
}