package ad;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class testCalculator {
	private Calculator calculator ;
	@BeforeTest
	public void setup() {
		calculator = new Calculator();
	}
	
		
	
	@Test
	public void emptyStringAnswerNull() {
		
		assertEquals(calculator.add(""), 0);
		
	}
	@Test
	public void singleValuedAnswer() {
		assertEquals(calculator.add("1"),1);
	}
	@Test
	public void twoValueCommaDelimiterAnswer() {
		assertEquals(calculator.add("1,2"),3);
	}
	@Test
	public void multivalueCommaDelimiterAnswer() {
		assertEquals(calculator.add("1,2,3,4"),10);
	}
	@Test
	public void twoValueNewLineDelimiterAnswer() {
		assertEquals(calculator.add("1\n2,4"),7);
	}
	
}
