package permutation;
public class MyCharacter {
	private Character c;
	private int index;

	public MyCharacter(Character c, int index) {
		this.c = c;
		this.index = index;
	}

	public String getCharAsString() {
		return String.valueOf(c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MyCharacter))
			return false;
		MyCharacter other = (MyCharacter) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return c.toString();
	}

}
