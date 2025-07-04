package gbuy;

import java.util.ArrayList;

//    ArrayList<Product> items;
//    addProduct(Product product);
//    getProduct();
//    getAllProducts();
//    removeProduct();
//    remoteAllProducts()
//    updateProduct();

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product){
        items.add(product);
    }

    public void getProduct(int index) {
        if (index >= 0 && index < items.size()) {
            Product product = items.get(index);
            System.out.println((index + 1) + ". " + product.getName() + " " + product.getPrice());
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void getAllProducts() {
        System.out.println("=== Cart ===");
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " " + product.getPrice());
        }
    }

    public void removeProduct(int index){
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void removeAllProducts(){
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

