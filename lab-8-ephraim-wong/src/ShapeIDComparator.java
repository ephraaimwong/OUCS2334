import java.util.Comparator;

public class ShapeIDComparator implements Comparator<Shape> {

	public ShapeIDComparator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(Shape s1, Shape s2) {
		if (s1.getID() < s2.getID()) {
			return -1;
		}
		else if(s1.getID() > s2.getID()) {
			return 1;
		}
		else {
			return 0;
		}
	}


}
