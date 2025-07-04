package gbuy.discount;

import gbuy.discount.DiscountStrategy;
import gbuy.discount.StudentDiscount;
import gbuy.discount.PromoDiscount;

public class DiscountFactory {

	public DiscountStrategy getDiscountStrategy(String type) {
		switch (type) {
			case "1":
				return new StudentDiscount();
			case "2":
				return new PromoDiscount();
			case "3":
				return null;
			default:
				System.out.println("Invalid input. Please try again.");
				return null;
		}
	}
}