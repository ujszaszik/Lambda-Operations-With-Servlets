package function;

import java.util.Optional;

import lambda.MyMethods;

public interface MyFunction {
	static final MyMethods myMethods = new MyMethods();
	static final String NOT_NUMBER = "This is not a valid number!";

	String generate(String text);

	default Optional<Integer> convertToInt(String text) {
		try {
			return Optional.of(Integer.parseInt(text));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

}
