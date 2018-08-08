package function;

import java.util.function.UnaryOperator;

public class UpperCaseUnderScoreFunction implements MyFunction {

	@Override
	public String generate(String text) {
		UnaryOperator<String> stringToUpperCaseAndSwitchedSpaces = x -> x.replaceAll(" ", "_").toUpperCase();
		return stringToUpperCaseAndSwitchedSpaces.apply(text);
	}

}
