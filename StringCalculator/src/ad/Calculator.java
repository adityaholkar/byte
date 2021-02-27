package ad;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {
	private String delimeter;
	private String numbers;

	private Calculator(String delimeter, String numbers) {
		this.delimeter = delimeter;
		this.numbers = numbers;
	}

	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	private int sum() throws Exception {
		if(getNumber().anyMatch(n -> n < 0)) {
			String negativeNumberSequence = getNumber().filter(n -> n<0).mapToObj(Integer::toString).collect(Collectors.joining(","));
			throw new Exception("Negative Number :"+negativeNumberSequence);
		}
		return getNumber()
				.sum();
	}

	private IntStream getNumber() {
		return Arrays.stream(numbers.split(delimeter))
				.mapToInt(Integer::parseInt);
	}

	public int add(String input) throws Exception {

		if (isEmpty(input)) {
			return 0;
		}

		return splitInput(input).sum();

	}

	

	private static Calculator splitInput(String input) {
		if (input.startsWith("//")) {
			String[] parts = input.split("\n", 2);
			return new Calculator(parts[0].substring(2), parts[1]);
		} else {
			return new Calculator(",|\n", input);
		}
	}

	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

}
