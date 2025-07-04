package gbuy;

public class Product {

    //  INSTANCE VARIABLES
    private String productName;
    private double productPrice;

    //  CONSTRUCTOR
    public Product(String name, double price){
        this.productName = name;

        if (price >= 0) this.productPrice = price;
        else throw new IllegalArgumentException("Product price cannot be negative.");

    }

    //  GETTERS
    public String getProductName() {
        return productName;
    }
    public double getProductPrice() {
        return productPrice;
    }

    //  SETTERS
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductPrice(double productPrice) {
        if (productPrice >= 0) this.productPrice = productPrice;
        else throw new IllegalArgumentException("Product price cannot be negative.");
    }
}

