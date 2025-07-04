package gbuy.discount;

public class StudentDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount*0.2;
	}

}