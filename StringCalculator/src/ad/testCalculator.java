package ad;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
public class testCalculator {
	Calculator calculator;
	@BeforeTest
	public void init() {
		calculator = new Calculator() ;
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
	public  void multivalueCommaDelimiterAnswer() throws Exception {
		
		assertEquals(calculator.add("1,2,3,4"),10);
	}
	@Test
	public void twoValueNewLineDelimiterAnswer() throws Exception {
		
		assertEquals(calculator.add("1\n2,4"),7);
		
	}
	@Test
	public void supportDifferentDelimeter() throws Exception {
		
		assertEquals(calculator.add("//;\n1;2"),3);
		assertEquals(calculator.add("//.\n1.2.3"),6);
	}
	@Test(expectedExceptions =Exception.class)
	public void throwsOnNegativeNumber() throws Exception {
		
		assertEquals(calculator.add("-3"),"Negative Number :-3");
	}
	@Test(expectedExceptions =Exception.class)
		public void throwsOnAllNegativeNumberInInput() throws Exception {
		
			assertEquals(calculator.add("1,-3,3,-5,-13"),"Negative Number :-3,-5,-13");
		
	}
	
	@Test(priority =9)
	public void getTotalCountOfAdd() {
		
		assertEquals(Calculator.GetCalledCount(),13);
	}
	@Test
	public void ignoreNumberGreaterThan1000() throws Exception {
		assertEquals(calculator.add("2,1002"),2);
	}
	@Test
	public void delimiterOfAnyLength() throws Exception {
		assertEquals(calculator.add("//[***]\n1***2***3"),6);
	}
	@Test
	public void multipleDelimiterWithMultipleLength() throws Exception {
		assertEquals(calculator.add("//[*][%]\n1*2%3"),6);
		assertEquals(calculator.add("//[***][$$$]\n1***2$$$3"),6);
	}
}
