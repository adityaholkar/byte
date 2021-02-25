package ad;

public class Calculator {
	 private static String delimeter = ",|\n";
	public int add(String input) {
		
		if(isEmpty(input)) {
			return 0;
		}
		if(input.length() == 1) {
			return strToInt(input);
		}
		else {
			if(input.matches("//(.*)\n(.*)")) {
				String temp = Character.toString(input.charAt(2));
				delimeter=delimeter+"|"+temp;
				input = input.substring(4);
			}
			
			
			String[] numbers = input.split(delimeter);
			return getSum(numbers);
		}
		
	}
	private int getSum(String[] numbers) {
		
		int sum=0;
		for(String number:numbers) {
			sum+=strToInt(number);
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
