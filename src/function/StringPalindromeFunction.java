package function;

import java.util.function.Predicate;

public class StringPalindromeFunction implements MyFunction {
	private final String VALID = "This is a palindrome!";
	private final String INVALID = "It is not a palindrome!";

	@Override
	public String generate(String text) {
		Predicate<String> stringPalindrome = x -> new StringBuilder(x).reverse().toString().equals(x);
		return stringPalindrome.test(text) ? VALID : INVALID;

	}

}
