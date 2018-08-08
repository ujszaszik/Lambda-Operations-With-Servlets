package mymethods;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MyMethods {

	public Set<String> charCartesianProduct(Set<Character> a, Set<Character> b) {
		Set<String> result = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		for (char c1 : a) {
			for (char c2 : b) {
				sb.append(c1);
				sb.append(c2);
				result.add(sb.toString());
				sb.setLength(0);
			}
		}
		return result;
	}

	public String stringToLexicoGraphical(String text) {
		char[] letters = text.toCharArray();
		Arrays.sort(letters);
		StringBuilder sb = new StringBuilder();
		for (char c : letters) {
			sb.append(c);
		}
		return sb.toString();
	}

	public Integer countSpaces(String word) {
		String temp = word.trim();
		if (temp.length() == 0) {
			return word.length();
		}
		return word.split(" ").length - 1;
	}

	public String createRandomByLength(Integer number) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < number; i++) {
			int rand = (random.nextInt(25)) + 97;
			sb.append((char) rand);
		}
		return sb.toString();
	}

	public String toCamelCase(String word) {
		String[] array = word.split("[ ,?!-]");
		StringBuilder sb = new StringBuilder();
		for (String s : array) {
			sb.append(String.valueOf(s.charAt(0)).toUpperCase());
			sb.append(s.substring(1));
		}
		return sb.toString();
	}

}
