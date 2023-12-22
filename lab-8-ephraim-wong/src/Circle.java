
public class Circle extends Ellipse{

	public Circle(double radius) {
		// TODO Auto-generated constructor stub
		super(radius,radius);
	}
	public double getRadius() {
		//can use either a or b
		return getA();
	}
}
