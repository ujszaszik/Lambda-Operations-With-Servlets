package function;

import java.util.function.UnaryOperator;

public class CamelCaseFunction implements MyFunction {

	@Override
	public String generate(String input) {
		UnaryOperator<String> stringToCamelCase = myMethods::toCamelCase;
		return stringToCamelCase.apply(input);
	}

}
