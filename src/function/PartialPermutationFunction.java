package function;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import permutation.PartialPermutation;

public class PartialPermutationFunction implements MyFunction {

	@Override
	public String generate(String text) {
		Function<String, Set<String>> permutation = x -> new PartialPermutation().execute(x);
		return permutation
				.apply(text)
				.stream()
				.collect(Collectors.joining("\n"));
	}

}
