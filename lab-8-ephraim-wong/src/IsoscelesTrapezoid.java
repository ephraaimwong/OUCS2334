
public class IsoscelesTrapezoid extends Polygon {
	private double top, base, leg, area, triangleBase, height;
	public IsoscelesTrapezoid(double top, double base, double leg) {
		// TODO Auto-generated constructor stub
		//leg == side length, hence leg x2
		super(top, base, leg, leg);
		this.top = top;
		this.base = base;
		this.leg = leg;
		height = Math.sqrt(leg*leg - Math.pow(0.5*(base-top),2));
		area = 0.5*(top+base)*height;
		//Pythagorean theorem
		triangleBase = Math.sqrt(leg*leg - height*height);
	}
	public double getTop() {
		return top;
	}
	public double getBase() {
		return base;
	}
	public double getLeg() {
		return leg;
	}
	public double getArea() {
		return area;
	}
	public Rectangle getCenterRectangle() {
		//accounts for when base>top && top>base
		Rectangle r = new Rectangle(Math.min(top, base), height);
		return r;
	}

}
