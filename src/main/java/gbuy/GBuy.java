package gbuy;

import gbuy.discount.DiscountFactory;
import gbuy.discount.DiscountStrategy;

import java.util.Scanner;

public class GBuy {

	//	CLASS VARIABLES
	private static Cart cart = new Cart();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String choice;
		boolean running = true;
		while (running) {
			choice = displayMenu();
			switch (choice) {
				case "1":
					addToCart();
					break;
				case "2":
					viewCart();
					break;
				case "3":
					applyDiscount();
					break;
				case "4":
					checkout();
					break;
				case "0":
					System.out.println("Thank you for shopping with GBuy!");
					running = false;
					break;
				default:
					System.out.println("Invalid output. Please try again.");
					break;
			}
		}
	}

	static String displayMenu() {
		System.out.println("\n" +
				"=== Welcome to GBuy! What do you want to do today? === \n\n" +
				"1. Add product to cart \n" +
				"2. View cart \n" +
				"3. Apply discount \n" +
				"4. Checkout \n" +
				"0. Exit \n");
		System.out.print("Enter choice: ");
		return sc.next();
	}

	static void addToCart() {

		System.out.print("Enter product name: ");
		String prodName = sc.next();
		System.out.print("Enter product price: ");
		double prodPrice = sc.nextDouble();                        // this will throw err;
		Product productToAdd = new Product(prodName, prodPrice);
		cart.addProduct(productToAdd);

		System.out.println("Product successfully added to cart!");
	}

	static void viewCart() {
		cart.getAllProducts();
	}

	public static void checkout() {
		double subTotal = cart.getTotalPrice();
		double tax = computeTax(subTotal);
		double discount = computeDiscount(subTotal);
		double total = subTotal+tax-discount;

		System.out.println();
		System.out.println("=== CHECK OUT ===");
		System.out.printf("Sub-Total: %f\n", subTotal);
		System.out.printf("Tax: +%f\n", tax);
		System.out.printf("Discount: -%f\n", discount);
		System.out.printf("TOTAL: %f\n", total);
		cart.removeAllProducts();
		System.out.println("Thank you for shopping!");
	}
	static double computeTax(double subTotal) {
		return subTotal * 0.12;
	}
	static double computeDiscount(double subTotal) {
		try {
			return cart.getDiscountStrategy().applyDiscount(subTotal);
		} catch (NullPointerException e) {
			System.out.println("No discount applied.");
			return 0;
		}
	}

	static void applyDiscount() {
		System.out.println("\n === Discount Types === \n" +
				"1. Student \n" +
				"2. Promo \n" +
				"3. None \n");
		System.out.print("Choose discount type: ");

		String discountType = sc.next();
		DiscountStrategy discount = new DiscountFactory().getDiscountStrategy(discountType);
		cart.setDiscountStrategy(discount);
		System.out.println(cart.getDiscountStrategy());
	}
}
