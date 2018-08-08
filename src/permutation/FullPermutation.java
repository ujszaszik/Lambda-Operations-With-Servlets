package permutation;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FullPermutation implements Permutation {
	private Permutation permutation;

	public FullPermutation(Permutation permutation) {
		this.permutation = permutation;
	}

	@Override
	public Set<String> execute(String text) {
		return permutation
				.execute(text)
				.stream()
				.filter(x -> x.length() == text.length())
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

}
