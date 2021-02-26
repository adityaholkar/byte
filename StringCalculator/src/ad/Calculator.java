package ad;

import java.util.Arrays;
import java.util.stream.Stream;

public class Calculator {
	 private static String delimeter = ",|\n";
	 public int add(String input) {
		
		if(isEmpty(input)) {
			return 0;
		}
		if(input.startsWith("//")) {
			String[] parts = input.split("\n",2);
			delimeter = delimeter+"|"+parts[0].substring(2);
			input = parts[1];
		}
		
		
		Stream<String> numbers = Arrays.stream(input.split(delimeter));
		return numbers.mapToInt(Integer::parseInt).sum();
		
	 }
	 
	 private boolean isEmpty(String input) {
		return input.isEmpty();
	 }
	 
}
