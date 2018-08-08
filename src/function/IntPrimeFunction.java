package function;

import java.util.Optional;
import java.util.function.Predicate;

import mymethods.MyMath;

public class IntPrimeFunction implements MyFunction {
	private final String VALID = "It is a prime";
	private final String INVALID = "No, it's not a prime";

	@Override
	public String generate(String text) {
		Predicate<Integer> intPrime = MyMath::isPrime;
		Optional<Integer> bound = convertToInt(text);
		return bound.isPresent() ? 
				(intPrime.test(bound.get()) ?  VALID : INVALID )
				: NOT_NUMBER;

	}

}
