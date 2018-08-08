package permutation;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import mymethods.MyMath;

public class PartialPermutation implements Permutation {
	private final List<Node> results = new LinkedList<>();
	private final Queue<Node> created = new LinkedList<>();

	public Set<String> execute(String text) {
		List<MyCharacter> word = createMyCharactersFromString(text);
		for (int i = 0; i < word.size(); i++) {
			createFirstNodes(word, i);
		}
		generateResults(word);

		return results
				.stream()
				.map(x -> createStringFromResult(x.getWritten()))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private String createStringFromResult(List<MyCharacter> result) {
		return result
				.stream()
				.map(x -> x.getCharAsString())
				.reduce("", (a, b) -> a + b);
	}

	private void generateResults(List<MyCharacter> word) {
		int total = 0;
		while (total < calculateNumberOfResults(word)) {
			Node n = created.poll();
			for (MyCharacter c : word) {
				if (!n.getWritten().contains(c)) {
					Node node = new Node();
					node.getWritten().addAll(n.getWritten());
					node.getWritten().add(c);
					node.getLeft().addAll(n.getLeft());
					node.getLeft().remove(c);
					addNewResult(node);
				}
			}
			if (n.getWritten().size() != word.size()) {
				created.remove(n);
			} else {
				total++;
			}
		}
	}

	private void addNewResult(Node node) {
		created.add(node);
		results.add(node);
	}

	private void createFirstNodes(List<MyCharacter> word, int i) {
		Node node = new Node();
		node.getWritten().add(word.get(i));
		addLeft(node, word);
		addNewResult(node);
	}

	private List<MyCharacter> createMyCharactersFromString(String text) {
		List<MyCharacter> word = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			word.add(new MyCharacter(text.charAt(i), i));
		}
		return word;
	}

	private void addLeft(Node node, List<MyCharacter> word) {
		for (MyCharacter c : word) {
			if (!node.getWritten().contains(c)) {
				node.getLeft().add(c);
			}
		}
	}

	protected Integer calculateNumberOfResults(List<MyCharacter> word) {
		Map<MyCharacter, List<MyCharacter>> map = word
				.stream()
				.collect(Collectors.groupingBy(x -> x));
		Set<Map.Entry<MyCharacter, List<MyCharacter>>> entry = map.entrySet();
		int result = 1;
		for (Map.Entry<MyCharacter, List<MyCharacter>> e : entry) {
			result *= MyMath.factorial(e.getValue().size());
		}
		return MyMath.factorial(word.size()) / result;
	}

}
