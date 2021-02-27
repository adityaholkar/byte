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
	public void emptyStringAnswerNull() throws Exception {
		
		assertEquals(calculator.add(""), 0);
		
	}
	@Test
	public void singleValuedAnswer() throws Exception {
		assertEquals(calculator.add("1"),1);
	}
	@Test
	public void twoValueCommaDelimiterAnswer() throws Exception {
		assertEquals(calculator.add("1,2"),3);
	}
	@Test
	public void multivalueCommaDelimiterAnswer() throws Exception {
		assertEquals(calculator.add("1,2,3,4"),10);
	}
	@Test
	public void twoValueNewLineDelimiterAnswer() throws Exception {
		assertEquals(calculator.add("1\n2,4"),7);
	}
	@Test
	public void supportDifferentDelimeter() throws Exception {
		assertEquals(calculator.add("//;\n1;2"),3);
	}
	@Test(expectedExceptions =Exception.class)
	public void throwsOnNegativeNumber() throws Exception {
		assertEquals(calculator.add("-3"),"Negative Number :-3");
	}
	@Test(expectedExceptions =Exception.class)
		public void throwsOnAllNegativeNumberInInput() throws Exception {
			assertEquals(calculator.add("1,-3,3,-5,-13"),"Negative Number :-3,-5,-13");
		
	}
}
