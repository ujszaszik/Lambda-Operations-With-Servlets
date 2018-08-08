package function;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StringCartesianFunction implements MyFunction {

	@Override
	public String generate(String text) {
		if (!text.contains(":")) {
			return "Not a valid expression!";
		}
		
		int splittingIndex = text.indexOf(":");
		Set<Character> first = toSetOfChars(text.substring(0, splittingIndex).toCharArray());
		Set<Character> second = toSetOfChars(text.substring(splittingIndex + 1).toCharArray());
		BiFunction<Set<Character>, Set<Character>, Set<String>> descartes = myMethods::charCartesianProduct;

		return descartes
				.apply(first, second)
				.stream()
				.collect(Collectors.joining("\n"));

	}

	private Set<Character> toSetOfChars(char[] chars) {
		Set<Character> characters = new LinkedHashSet<>();
		for (char c : chars) {
			characters.add(c);
		}
		return characters;
	}

}
