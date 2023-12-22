
public class SortedList extends IntegerList{
	public SortedList() {
		super();
	}
	public SortedList(int cap) {
		super(cap);
	}
	@Override
	public void add(int integer) {
		int index = 0;
		while(index < size() && integer > get(index)) {
			index++;
		}
		super.insert(index, integer);
	}
	@Override
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
		
	}
}
