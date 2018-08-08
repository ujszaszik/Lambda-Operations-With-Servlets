package function;

import java.util.function.UnaryOperator;

public class LexicographicalFunction implements MyFunction {

	@Override
	public String generate(String text) {
		UnaryOperator<String> toLexicoGraphicalOrder = myMethods::stringToLexicoGraphical;
		return toLexicoGraphicalOrder.apply(text);
	}

}
