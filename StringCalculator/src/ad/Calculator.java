package ad;

public class Calculator {
	 private static String delimeter = ",";
	public int add(String input) {
		String[] numbers = input.split(delimeter);
		if(isEmpty(input)) {
			return 0;
		}
		if(input.length() == 1) {
			return strToInt(input);
		}
		else {
			
			return getSum(numbers);
		}
		
	}
	private int getSum(String[] numbers) {
		int numbersSize = numbers.length;
		int sum=0;
		for(int i=0;i<numbersSize;i++) {
			sum+=strToInt(numbers[i]);
		}
		return sum;
	}
	private boolean isEmpty(String input) {
		return input.isEmpty();
	}
	private int strToInt(String input) {
		return Integer.parseInt(input);
	}
}
