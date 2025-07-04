package gbuy;

import gbuy.discount.PromoDiscount;
import gbuy.discount.StudentDiscount;

import java.util.Scanner;

public class GBuy {

	//	CLASS VARIABLES
	public static Cart cart = new Cart();
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String choice; boolean running = true;
		while (running){
			choice = displayMenu();
			switch (choice){
				case "1":
					addToCart();
					break;
				case "2":
					viewCart();
					break;
				case "3":
					//computeDiscount();
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

	public static String displayMenu(){
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

	public static void addToCart(){

		System.out.print("Enter product name: ");
			String prodName = sc.next();
		System.out.print("Enter product price: ");
			double prodPrice = sc.nextDouble();						// this will throw err;
		Product productToAdd = new Product(prodName,prodPrice);
		cart.addProduct(productToAdd);

		System.out.println("Product successfully added to cart!");
	}

	public static void viewCart(){
		cart.getAllProducts();
	}

	public static void checkout(){
		computeTax();
	}

	public static void computeTax(){
		// * 0.12
	}

//	public static void computeDiscount(){
//		//Discount
//		System.out.println("\n === Discount Types === \n" +
//				"1. Student \n" +
//				"2. Promo \n" +
//				"3. None \n");
//		System.out.print("Choose discount type: ");
//		int discountType = sc.nextInt();
//		switch (discountType){
//			case 1:
//				//Discount.student
//				StudentDiscount student = new StudentDiscount();
//				//cart.getProduct();
//				double price =
//				//double studentDiscount = student.applyDiscount(price);
//				System.out.println("Discount: " + studentDiscount);
//				break;
//			case 2:
//				//Discount.promo
//				PromoDiscount promo = new PromoDiscount();
//				double amount = 90.00;
//				double promoDiscount = promo.applyDiscount(amount);
//				System.out.println("Discount: " + promoDiscount);
//				break;
//			case 3:
//				//no discount
//				break;
//			default:
//				System.out.println("Invalid output. Please try again.");
//				break;
//		}
	}
