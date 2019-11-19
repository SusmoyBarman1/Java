package Question_7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketSellerTest {
	TicketSeller ts = new TicketSeller();

	@Test
	void test() {
		assertEquals(1,ts.calculation());
	}

}
