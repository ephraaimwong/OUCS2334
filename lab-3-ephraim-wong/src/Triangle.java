import java.lang.Math.*;

public class Triangle {
	private double sideA = DEFAULT_SIDE;
	private double sideB = DEFAULT_SIDE;
	private double sideC = DEFAULT_SIDE;
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1.0;
	
//constructors
	public Triangle() {
	}
	public Triangle(double sideA, double sideB, double sideC) {
		this();
		if (isTriangle(sideA, sideB, sideC) == true) {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
		
	}
	public Triangle(double[] sides) {
		this();
		if(isTriangle(sides) == true) {
			this.sideA = sides[0];
			this.sideB = sides[1];
			this.sideC = sides[2];
		}
	}

//copy constructor broken
	public Triangle(Triangle triangle) {
		if (triangle != null && isTriangle(getSideA(),getSideB(), getSideC())== true) {
			this.sideA = triangle.getSideA();
			this.sideB = triangle.getSideB();
			this.sideC = triangle.getSideC();
		}
	}
	
//helper methods
	public static boolean isTriangle(double a, double b, double c) {
		//check for non-neg val & triangle inequality
		if (a>0 && b>0 && c>0 && (a+b)>c && (a+c)>b && (b+c)> a ) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isTriangle(double[] sides) {
		//reject null array & array != 3 elements
		if (sides != null && sides.length == 3) {
			double a = sides[0];
			double b = sides[1];
			double c = sides[2];
			//loop the above method, reduce code
			return isTriangle(a, b, c);
		}else {
			return false;
		}
	}
	public static double lawOfCosines(double a, double b, double c) {
		//double y = 1/ Math.cos(a*a + b*b - 2((a*b))
		double angleC = Math.toDegrees(Math.acos((b * b + a * a - c * c)/(2.0 * b * a)));
		return angleC;
	}
	
//to String
	public String toString() {
		return String.format("%s(%.4f, %.4f, %.4f)", POLYGONSHAPE, getSideA(), getSideB(), getSideC());
	}
//getters
	public double getSideA() {
		return this.sideA;
	}
	public double getSideB() {
		return this.sideB;
	}
	public double getSideC() {
		return this.sideC;
	}
	public double[] getSides() {
		double[] returnArray = new double[]{this.sideA, this.sideB, this.sideC};
		return returnArray;
	}
	public double getAngleA() {
//		int i = 0;
//		System.out.println(i++ + " " + lawOfCosines(getSideB(), getSideC(), getSideA()));
		return lawOfCosines(getSideB(), getSideC(), getSideA());
	}
	public double getAngleB() {
		return lawOfCosines(getSideA(), getSideC(), getSideB());
	}
	public double getAngleC() {
		return lawOfCosines(getSideA(), getSideB(), getSideC());
	}
	public double[] getAngles() {
		double[] temp = {getAngleA(), getAngleB(), getAngleC()};
		return temp;
	}

//setters	
	public boolean setSideA(double newSideA) {
		if (isTriangle(newSideA, getSideB(), getSideC()) == true){
			this.sideA = newSideA;
			return true;
		}else {
			return false;
		}
	}
	public boolean setSideB(double newSideB) {
		if (isTriangle(getSideA(), newSideB, getSideC()) == true){
			this.sideB = newSideB;
			return true;
		}else {
			return false;
		}
	}
	public boolean setSideC(double newSideC) {
		if (isTriangle(getSideA(), getSideB(), newSideC) == true){
			this.sideC = newSideC;
			return true;
		}else {
			return false;
		}
	}
	public boolean setSides(double[] newSides) {
		if(isTriangle(newSides) == true) {
			this.sideA = newSides[0];
			this.sideB = newSides[1];
			this.sideC = newSides[2];
			return true;
		}else {
			return false;
		}
	}
}
