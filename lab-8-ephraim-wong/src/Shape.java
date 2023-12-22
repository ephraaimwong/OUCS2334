
public abstract class Shape implements Comparable<Shape> {

	// TODO: Complete this class.
	private int id;
	private static int nextID = 0;
	
	protected Shape() {
		id = nextID++;
	}
	
	public int getID() {
		return id;
	}
	
	public abstract double getPerimeter();
	public abstract double getArea();
	
	public int compareTo(Shape other) {
		//compare shapes by type
		int typeComp = getClass().getName().compareTo(other.getClass().getName());
		//if types differ, compare by type
		if(typeComp != 0) {
			return typeComp;
		}
		//if type same, compare perimeter
		double periComp = getPerimeter() - other.getPerimeter();
		if(periComp != 0) {
			return Double.compare(periComp, 0);
		}
		//if perimeter same, compare area
		double areaComp = getArea() - other.getArea();
		return Double.compare(areaComp, 0);
		
		
	}

	@Override
	public String toString() {
		return "<"
				+ getClass().getName()
				+ ", ID: " + id
				+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
				+ ", AREA: " + String.format("%.1f", getArea())
				+ ">";
	}
}