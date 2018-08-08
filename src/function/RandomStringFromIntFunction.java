package function;

import java.util.Optional;
import java.util.function.Function;

public class RandomStringFromIntFunction implements MyFunction {

	@Override
	public String generate(String text) {
		Function<Integer, String> createRandomStringFromIntegerLength = myMethods::createRandomByLength;
		Optional<Integer> value = convertToInt(text);
		return value.isPresent() ? createRandomStringFromIntegerLength.apply(value.get()) : NOT_NUMBER;
	}

}
