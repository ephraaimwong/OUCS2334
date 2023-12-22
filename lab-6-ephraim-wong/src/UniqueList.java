
public class UniqueList extends IntegerList {
	public UniqueList() {
		super();
	}
	public UniqueList(int cap) {
		super(cap);
	}
	@Override
	public void add(int integer) {
		if (indexOf(integer) == -1) {
			super.add(integer);
		}
		else {
			throw new IllegalArgumentException("The integer "+integer+" is already in the list.");
		}
	}
	@Override
	public void insert(int index, int integer) {
		if (indexOf(integer) == -1) {
			super.insert(index, integer);
		} else {
			throw new IllegalArgumentException("The integer "+integer+" is already in the list.");
		}
	}
}
