package lambda;
import java.util.ArrayList;
import java.util.List;

import permutation.MyCharacter;

public class Node {
	private final List<MyCharacter> written = new ArrayList<>();
	private final List<MyCharacter> left = new ArrayList<>();

	public List<MyCharacter> getWritten() {
		return written;
	}

	public List<MyCharacter> getLeft() {
		return left;
	}

	@Override
	public String toString() {
		return "Node [written=" + written + ", left=" + left + "]";
	}

}
