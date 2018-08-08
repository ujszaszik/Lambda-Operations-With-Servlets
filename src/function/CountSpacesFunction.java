package function;

import java.util.function.Function;

public class CountSpacesFunction implements MyFunction {

	@Override
	public String generate(String text) {
		Function<String, Integer> stringCountSpaces = myMethods::countSpaces;
		return String.valueOf(stringCountSpaces.apply(text));
	}

}
