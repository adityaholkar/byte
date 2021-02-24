package ad;

public class Calculator {

	public int add(String input) {
		if(isEmpty(input)) {
			return 0;
		}
		return strToInt(input);
	}
	private boolean isEmpty(String input) {
		return input.isEmpty();
	}
	private int strToInt(String input) {
		return Integer.parseInt(input);
	}
}
