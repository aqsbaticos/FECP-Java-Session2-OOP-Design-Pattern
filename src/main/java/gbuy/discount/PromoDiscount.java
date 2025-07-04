package gbuy.discount;

public class PromoDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount-(amount*0.5);
	}
}