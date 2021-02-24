package ad;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class testCalculator {
	
	@Test
	public void emptyStringAnswerNull() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.add(""), 0);
	}
}
