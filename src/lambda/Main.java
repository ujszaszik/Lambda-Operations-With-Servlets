package lambda;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import permutation.FullPermutation;
import permutation.PartialPermutation;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		MyMethods myMethods = new MyMethods();
		UnaryOperator<String> stringToCamelCase = myMethods::toCamelCase;
		System.out.println(stringToCamelCase.apply("hello ez én vagyok"));

		UnaryOperator<String> stringToUpperCaseAndSwitchedSpaces = x -> x.replaceAll(" ", "_").toUpperCase();
		System.out.println(stringToUpperCaseAndSwitchedSpaces.apply("hello ez én vagyok"));

		Function<Integer, String> createRandomStringFromIntegerLength = myMethods::createRandomByLength;
		System.out.println(createRandomStringFromIntegerLength.apply(5));

		Function<String, Integer> stringCountSpaces = myMethods::countSpaces;
		System.out.println(stringCountSpaces.apply("       "));

		Predicate<String> stringPalindrome = x -> new StringBuilder(x).reverse().toString().equals(x);
		System.out.println(stringPalindrome.test("ababa"));

		UnaryOperator<String> toLexicoGraphicalOrder = myMethods::stringToLexicoGraphical;
		System.out.println(toLexicoGraphicalOrder.apply("sfvasdm"));

		Consumer<Integer> printPositiveNumbersLessThan = x -> IntStream.range(1, x).forEach(System.out::println);
		printPositiveNumbersLessThan.accept(25);

		Predicate<Integer> intPrime = MyMath::isPrime;
		System.out.println(intPrime.test(12));

		BiFunction<Set<Character>, Set<Character>, Set<String>> descartes = myMethods::charCartesianProduct;
		System.out.println(descartes.apply(Set.of('a', 'b', 'c'), Set.of('d', 'e', 'f')));

		Function<String, Set<String>> permutation = x -> new PartialPermutation().execute(x);
		Set<String> permutations = permutation.apply("abcd");
		System.out.println("Total results: " + permutations.size());
		permutations.stream().forEach(System.out::println);

		permutation = x -> new FullPermutation(new PartialPermutation()).execute(x);
		permutations = permutation.apply("abcd");
		System.out.println("Total results: " + permutations.size());
		permutations.stream().forEach(System.out::println);
	}

}
