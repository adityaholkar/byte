package ad;

public class Calculator {
	 
	public int add(String input) {
		String[] numbers = input.split(",");
		if(isEmpty(input)) {
			return 0;
		}
		else {
			return strToInt(numbers[0])+strToInt(numbers[1]);
		}
		
	}
	private boolean isEmpty(String input) {
		return input.isEmpty();
	}
	private int strToInt(String input) {
		return Integer.parseInt(input);
	}
}
