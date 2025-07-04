package gbuy.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PromoDiscountTest {

	private PromoDiscount promoDiscount;

	@BeforeEach
	void setup() {
		this.promoDiscount = new PromoDiscount();
	}

	@Test
	void applyDiscountPositiveAmount() {
		double actualDiscountedAmount = promoDiscount.applyDiscount(100.0);
		assertEquals(50.0, actualDiscountedAmount, 0.001);
	}

	@Test
	void applyDiscountZeroAmount() {
		double actualDiscountedAmount = promoDiscount.applyDiscount(0);
		assertEquals(0, actualDiscountedAmount, 0.001);
	}

	@Test
	void applyDiscountLargeAmount() {
		double actualDiscountedAmount = promoDiscount.applyDiscount(1_000_000.0);
		assertEquals(500_000.00, actualDiscountedAmount, 0.001);
	}
	
}