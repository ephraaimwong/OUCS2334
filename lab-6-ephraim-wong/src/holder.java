
public class holder {

public class RangeList extends IntegerList {
	public RangeList() {
		super();
	}
	public RangeList(int lowerBound, int upperBound) {
		this();
		if (lowerBound >= upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound");
		}
		add(lowerBound, upperBound);
			//insert all int in range between lower and upper bound
		}
		
		
	
	public void add(int lowerBound, int upperBound) {
		if (lowerBound >= upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		} else if (size() == 0) {
			for (int i = lowerBound; i < upperBound+1; i++ ) {
				super.add(i);
				System.out.println(i+"added");
			}
		}
		
		if (lowerBound < get(0)) {
//			int val = lowerBound;
			int previousLow = get(0);
//			for (int i = 0; i < indexOf(previousLow);i++) {
//				super.insert(i,val);
//				val++;
//			}
			for (int i = previousLow; i > lowerBound; i--) {
				super.insert(0, i-1);
			}
			
		} 
		if (upperBound > get(size()-1)) {
//			int previousHigh = get(size()-1);
			int val = get(size()-1) + 1;
//			int index = indexOf(previousHigh) + 1;
			while (!(val == upperBound+1)) {
				super.add(val);
				val++;
			}
			
		}
		
		
			
	}
	public void remove(int lowerBound, int upperBound) {
		if (lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		if (size() == 0) {
			throw new UnsupportedOperationException("Cannot remove range from an empty list.");
		}
		if (lowerBound < get(0) || upperBound > get(size()-1)) {
			throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
		}
		
		if (lowerBound == get(0) || upperBound == get(size()-1)) {
			if(lowerBound == upperBound) {
					remove(indexOf(lowerBound));
			}
			if(lowerBound == get(0)) {
				for (int i = indexOf(lowerBound); i < (upperBound-lowerBound)+1;i++ ) {
					super.remove(0);
				}
			}
			if(upperBound == get(size()-1)) {
				for (int i = indexOf(upperBound); i >= indexOf(lowerBound); i--) {
					super.remove(i);
				}
			}
			
			
		} else {
				throw new IllegalArgumentException("Cannot remove non-terminal ranges.");
		}
	}
//		for (int i = 0; i < size(); i++) {
////			int val = get(i);
//			if (get(i) != lowerBound || get(i) != upperBound) {
//				throw new IllegalArgumentException("Cannot remove non-terminal ranges.");
//			}else {
//				remove(i);
//			
//			}

//			for (int i = lowerBound; i < upperBound+1; i++ ) {
//				super.add(i);
//				System.out.println(i+"added");
//			}
//		}
	
//	@Override
//	public void insert(int index, int integer) {
//		throw new UnsupportedOperationException();
//	}
	@Override
	public void add(int integer) {
		throw new UnsupportedOperationException();	
	}
}

}
