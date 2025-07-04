package gbuy;

import java.util.ArrayList;
import gbuy.discount.DiscountStrategy;

public class Cart {

    //  VARIABLES
    private ArrayList<Product> items;
    private DiscountStrategy discountStrategy;

    //  CONSTRUCTOR
    Cart() {
        this.items = new ArrayList<>();
        this.discountStrategy = null;
    }

    //  API
    public void addProduct(Product product) {
        items.add(product);
    }

    public void getProduct(int index) {
        if (index >= 0 && index < items.size()) {
            Product product = items.get(index);
            System.out.println((index + 1) + ". " + product.getProductName() + " " + product.getProductPrice());
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void getAllProducts() {
        System.out.println("=== Cart ===");
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i);
            System.out.println((i + 1) + ". " + product.getProductName() + " " + product.getProductPrice());
        }
    }

    public void removeProduct(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void removeAllProducts() {
        items.clear();
        System.out.println("All items have been removed from the cart");
    }

    public void updateProduct(int index, Product newProduct) {
        if (index >= 0 && index < items.size()) {
            items.set(index, newProduct);
        } else {
            System.out.println("Invalid index.");
        }
    }

    //  GETTERS
    public DiscountStrategy getDiscountStrategy() { return this.discountStrategy; }

    //  SETTERS
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}