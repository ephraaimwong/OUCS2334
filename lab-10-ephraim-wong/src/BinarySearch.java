import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
			String target, int fromIdx, int toIdx) {
		List<Integer> checked = new ArrayList<>();
		if (fromIdx <= toIdx ) {
			int midIdx = fromIdx + (toIdx - fromIdx)/2; 
			if (!(checked.contains(midIdx))) {
				//problem line with recursion
				checked.add(midIdx);
			}
			int compResult = strings.get(midIdx).compareTo(target);
			//target found
			if (compResult == 0) {return checked;}
			//target in left half
			else if (compResult > 0) {
			List<Integer> temp = binarySearch(strings, target, fromIdx, midIdx-1);

			for (Integer i:temp) {
				if(!(checked.contains(i))) {
					checked.add(i);
					}
				}
				}
			//target in right half
			else { 
				List<Integer> temp = binarySearch(strings, target, midIdx+1, toIdx);
				for(Integer i:temp){ if(!(checked.contains(i))) {checked.add(i);}
				}
			}
			//target not in list 
		} else {
			checked.add(-1);
		}
		return checked;
		
	}
}
