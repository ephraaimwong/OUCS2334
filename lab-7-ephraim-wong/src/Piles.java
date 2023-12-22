import java.util.Arrays;

public class Piles{
	private int[] sizes;

	//dont need to try/catch since we are not creating objects in this class
	public Piles(int... initSizes) throws IllegalArgumentException {
		if (initSizes == null || initSizes.length == 0){
			throw new IllegalArgumentException();
		}
		for(int i : initSizes) {
			//each pile must be > 0.
			if (i<=0) {
				throw new IllegalArgumentException();
			}
		}
		sizes = Arrays.copyOf(initSizes, initSizes.length);
	}
	public int[] getSizes() {
		return Arrays.copyOf(sizes, sizes.length);
	}
	
	public void removeObjects(int[] move) throws IllegalMoveException {
		//first 2 if's must be before try/catch
		//these conditions must be valid for game to work, else build failure
		if (move == null) {
			throw new IllegalMoveException("null move");
		}
		if (move.length != 2) {
			throw new IllegalMoveException("Invalid length: " + move.length);
		}
		int index = move[0];
		int number = move[1];
		try {
			if (index < 0 || index >= getSizes().length) {
				throw new IllegalMoveException("Index out of bounds: " + move[0]);
			}
			if (getSizes()[index]== 0) {
				throw new IllegalMoveException("Pile " + index + " is empty.");
			}
			if (number <=0) {
				throw new IllegalMoveException("Nonpositive object number: " + number);
			}
			if (number > getSizes()[index] ) {
				throw new IllegalMoveException("Object number greater than pile size: " + number + " > " + getSizes()[index]);
			}
			sizes[index] -= number;
		} 
		catch (IllegalMoveException e) {
			//e is a throwable object
			throw e;
		}
	}
	public boolean isEmpty() {
		for (int i: sizes) {
			if (i != 0) {
				return false;
			} 
		}
		return true;
	}
}
