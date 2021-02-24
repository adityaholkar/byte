package ad;

public class Calculator {

	public int add(String string) {
		if(string.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(string);
	}

}
