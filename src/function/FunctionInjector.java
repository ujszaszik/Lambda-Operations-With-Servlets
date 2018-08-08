package function;

import java.util.HashMap;
import java.util.Map;

public class FunctionInjector {
	public static final Map<String, MyFunction> FUNCTIONS = new HashMap<>();

	static {
		FUNCTIONS.put("Camel Case", new CamelCaseFunction());
		FUNCTIONS.put("Count Spaces", new CountSpacesFunction());
		FUNCTIONS.put("Full Permutation", new FullPermutationFunction());
		FUNCTIONS.put("Prime Check", new IntPrimeFunction());
		FUNCTIONS.put("Lexicographical", new LexicographicalFunction());
		FUNCTIONS.put("Numbers Upper Bound", new NumbersUpperBoundFunction());
		FUNCTIONS.put("Partial Permutation", new PartialPermutationFunction());
		FUNCTIONS.put("Random String", new RandomStringFromIntFunction());
		FUNCTIONS.put("String Cartesian", new StringCartesianFunction());
		FUNCTIONS.put("Palindrome Check", new StringPalindromeFunction());
		FUNCTIONS.put("Upper Case", new UpperCaseUnderScoreFunction());
	}

	public static MyFunction get(String name) {
		return FUNCTIONS.get(name);
	}
}
