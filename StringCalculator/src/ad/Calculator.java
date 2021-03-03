package ad;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Calculator {
	private String delimeter;
	private String numbers;
	public static int count;
	
	Calculator(String delimeter, String numbers) {
		this.delimeter = delimeter;
		this.numbers = numbers;
		
	}
	
	Calculator() {
		// TODO Auto-generated constructor stub
		
	}
	private int sum() throws Exception {
		
		ensureNoNegativeNumberInInput();
		
		return getNumber()
				.sum();
	}

	private void ensureNoNegativeNumberInInput() throws Exception {
		String negativeNumberSequence = getNumber().filter(n -> n<0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if(!isEmpty(negativeNumberSequence)) {
			
			throw new Exception("Negative Number :"+negativeNumberSequence);
		}
	}

	private IntStream getNumber() {
		return Arrays.stream(numbers.split(delimeter))
				.mapToInt(Integer::parseInt)
				.filter(n -> n< 1000);
	}

	public int add(String input) throws Exception {
		count++;
		if (isEmpty(input)) {
			return 0;
		}
		
		return splitInput(input).sum();

	}

	

	private static Calculator splitInput(String input) {
		if (input.startsWith("//")) {
			String[] delimiterWithNumbers = input.split("\n", 2);
			
			return new Calculator(parseDelimiterFromHead(delimiterWithNumbers[0]), delimiterWithNumbers[1]);
		} else {
			return new Calculator(",|\n", input);
		}
	}

	private static String parseDelimiterFromHead(String head) {
		String newDelimeter = head.substring(2);
		if(newDelimeter.startsWith("[")) {
			newDelimeter = newDelimeter.substring(1, newDelimeter.length()-1);
			
		}
		return Stream.of(newDelimeter.split("]\\["))
				.map(Pattern::quote)
				.collect(Collectors.joining("|"));
	}

	private static boolean isEmpty(String input) {
		return input.isEmpty();
	}

	public static  int GetCalledCount() {
		System.out.print(count);
		return count;
	
	}

	

}
