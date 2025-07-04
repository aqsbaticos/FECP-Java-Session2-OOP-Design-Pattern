package gbuy;

import gbuy.discount.PromoDiscount;
import gbuy.discount.StudentDiscount;

import java.util.Scanner;

public class GBuy {
	public static final Scanner sc = new Scanner(System.in);
	public static int choice;
	public static boolean running = true;

	public static void main(String[] args) {
		while (running){
			displayMenu();
			switch (choice){
				case 1:
					//Cart.addProduct
					break;
				case 2:
					//Cart.displayProduct
					break;
				case 3:
					computeDiscount();
					break;
				case 4:
					checkout();
					break;
				case 5:
					System.out.println("Thank you for shopping with GBuy!");
					break;
				default:
					System.out.println("Invalid output. Please try again.");
			}
			System.out.println("Would you like to return to the menu?");
			String ans = sc.next().toLowerCase();
			if (!ans.equals("yes")) {
				System.out.println("Thank you! Bye!");
				running = false;
			}
		}
	}

	public static void displayMenu(){
		System.out.println("\n" +
				"=== Welcome to GBuy! What do you want to do today? === \n\n" +
				"1. Add product to cart \n" +
				"2. View cart \n" +
				"3. Apply discount \n" +
				"4. Checkout \n" +
				"5. Exit \n");
		System.out.print("Enter choice: ");
		choice = sc.nextInt();
	}

	public static void checkout(){
		computeTax();
	}

	public static void computeTax(){
		// * 0.12
	}

	public static void computeDiscount(){
		//Discount
		System.out.println("\n === Discount Types === \n" +
				"1. Student \n" +
				"2. Promo \n" +
				"3. None \n");
		System.out.print("Choose discount type: ");
		int discountType = sc.nextInt();
		switch (discountType){
			case 1:
				//Discount.student
				StudentDiscount student = new StudentDiscount();
				double price = 100.00;
				double studentDiscount = student.applyDiscount(price);
				System.out.println("Discount: " + studentDiscount);
				break;
			case 2:
				//Discount.promo
				PromoDiscount promo = new PromoDiscount();
				double amount = 90.00;
				double promoDiscount = promo.applyDiscount(amount);
				System.out.println("Discount: " + promoDiscount);
				break;
			case 3:
				//no discount
				break;
			default:
				System.out.println("Invalid output. Please try again.");
				break;
		}
	}

}
