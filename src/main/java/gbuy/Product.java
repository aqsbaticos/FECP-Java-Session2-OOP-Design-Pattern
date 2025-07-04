package gbuy;

public class Product {

    //  INSTANCE VARIABLES
    private String productName;
    private double productPrice;

    //  CONSTRUCTOR
    public Product(String name, double price){
        this.productName = name;
        this.productPrice = price;
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
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
}

