package function;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersUpperBoundFunction implements MyFunction {

	@Override
	public String generate(String text) {
		Optional<Integer> bound = convertToInt(text);
		return bound.isPresent() ?
				Stream.iterate(Integer.valueOf(0), (Integer i) -> i + 1)
	              .limit(bound.get())
	              .map(integer -> integer.toString())
	              .collect(Collectors.joining("\n"))
	              : NOT_NUMBER;
	}

}
