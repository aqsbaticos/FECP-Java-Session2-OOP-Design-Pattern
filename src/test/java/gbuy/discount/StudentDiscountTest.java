package gbuy.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDiscountTest {

	private StudentDiscount studentDiscount;

	@BeforeEach
	void setup() {
		this.studentDiscount = new StudentDiscount();
	}

	@Test
	void applyDiscountPositiveAmount() {
		double actualDiscountedAmount = studentDiscount.applyDiscount(100.0);
		assertEquals(20.0, actualDiscountedAmount, 0.001);
	}

	@Test
	void applyDiscountZeroAmount() {
		double actualDiscountedAmount = studentDiscount.applyDiscount(0);
		assertEquals(0, actualDiscountedAmount, 0.001);
	}

	@Test
	void applyDiscountLargeAmount() {
		double actualDiscountedAmount = studentDiscount.applyDiscount(1_000_000.0);
		assertEquals(200_000.00, actualDiscountedAmount, 0.001);
	}

}