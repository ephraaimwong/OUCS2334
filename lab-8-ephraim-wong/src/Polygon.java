
public abstract class Polygon extends Shape{
	private double perimeter;
	protected Polygon(double... sides) {
		// TODO Auto-generated constructor stub
		if (sides == null) {
			throw new IllegalArgumentException("null sides");
		}
		if (sides.length < 3) {
			throw new IllegalArgumentException("Invalid number of sides: " + sides.length);
		}
//		double[] listSides = new double[sides.length];
		double total = 0;
		double maxSide = 0;
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] <= 0) {
				throw new IllegalArgumentException("Nonpositive side: " + sides[i]); 
			}
//			listSides[i] = sides[i];
			total += sides[i];
			if (sides[i]> maxSide) {
				maxSide = sides[i];
			}
		}
		//check polygon inequality after summing sides
		if(maxSide >= (total - maxSide)) {
			throw new IllegalArgumentException("Polygon inequality violated: " + maxSide + " >= " + (total-maxSide));
		}
//			for (int idx = 0; idx < listSides.length; idx++ ) {
//				total += listSides[idx];
//				if (sides[i]>= total) {
//					throw new IllegalArgumentException("Polygon inequality violated: " + sides[i] + ">=" + total); 
//				}
//			}
		perimeter = total;
		
	}
	public double getPerimeter() {
		return perimeter;
	}

}
