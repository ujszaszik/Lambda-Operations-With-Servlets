package function;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import permutation.FullPermutation;
import permutation.PartialPermutation;

public class FullPermutationFunction implements MyFunction {

	@Override
	public String generate(String text) {
		Function<String, Set<String>> permutation = 
				x -> new FullPermutation(new PartialPermutation()).execute(x);
		return permutation
				.apply(text)
				.stream()
				.collect(Collectors.joining("\n"));
	}

}
