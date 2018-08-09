import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Triangle class implements Shape interface
 * 
 * @author Shubham Jain
 *
 */
public class Triangle implements Shape {

	private Point origin;
	private Date timeStamp;
	private double height;
	private double base;
	private double side;
	private DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	Triangle(double height, double base, double side, Point origin, Date timeStamp) {
		this.height = height;
		this.base = base;
		this.side = side;
		this.origin = origin;
		this.timeStamp = timeStamp;
	}

	/**
	 * It will calculate other two points
	 */
	void calculateOtherPoints(Point basePoint, Point upperPoint) {
		double xUpperCoordinate;
		double coordinate;
		basePoint = new Point(origin.getXCoordinate() + base, origin.getYCoordinate());
		coordinate = basePoint.getYCoordinate() + height;
		xUpperCoordinate = Math.sqrt((side * side) - Math.pow(coordinate - origin.getYCoordinate(), 2))
				+ origin.getXCoordinate();
		upperPoint = new Point(xUpperCoordinate, coordinate);
	}

	/**
	 * It will calculate the area of a triangle when three points are given
	 * 
	 * @param point1
	 * @param point2
	 * @param point3
	 * @return
	 */
	double calculateArea(Point point1, Point point2, Point point3) {
		double x1 = point1.getXCoordinate();
		double x2 = point2.getXCoordinate();
		double x3 = point3.getXCoordinate();
		double y1 = point1.getYCoordinate();
		double y2 = point2.getYCoordinate();
		double y3 = point3.getYCoordinate();

		double area = x1 * y2 - x1 * y3 + x2 * y3 - x2 * y1 + x3 * y1 - x3 * y2;
		return Math.abs(area);
	}

	public double getArea() {
		Point basePoint = null;
		Point upperPoint = null;
		calculateOtherPoints(basePoint, upperPoint);
		double area = calculateArea(origin, basePoint, upperPoint);
		return Double.parseDouble(decimalFormatSpecifier.format(area));
	}

	public double getPerimeter() {
		Point basePoint = null;
		Point upperPoint = null;
		calculateOtherPoints(basePoint, upperPoint);
		double side2 = Math.sqrt(Math.pow(upperPoint.getXCoordinate() - basePoint.getXCoordinate(), 2)
				+ Math.pow(upperPoint.getYCoordinate() - basePoint.getYCoordinate(), 2));
		return Double.parseDouble(decimalFormatSpecifier.format(side + base + side2));
	}

	public Point getOrigin() {
		return origin;
	}

	public ShapeType getShape() {
		return ShapeType.TRIANGLE;

	}

	/**
	 * Let the coordinates of three corners be A(x1, y1), B(x2, y2) and C(x3, y3).
	 * And coordinates of the given point P be (x, y) 1) Calculate area of the given
	 * triangle, i.e. area of the triangle ABC Area A = [ x1(y2 – y3) + x2(y3 – y1)
	 * + x3(y1-y2)]/2 2) Calculate area of the triangle PAB. We can use the same
	 * formula for this. Let this area be A1. 3) Calculate area of the triangle PBC.
	 * Let this area be A2. 4) Calculate area of the triangle PAC. Let this area be
	 * A3. 5) If P lies inside the triangle, then A1 + A2 + A3 must be equal to A.
	 */
	public boolean isPointEnclosed(Point isPointEnclosed) {
		Point basePoint = null;
		Point upperPoint = null;
		calculateOtherPoints(basePoint, upperPoint);
		double area1 = calculateArea(origin, basePoint, isPointEnclosed);
		double area2 = calculateArea(origin, upperPoint, isPointEnclosed);
		double area3 = calculateArea(basePoint, upperPoint, isPointEnclosed);
		double area = calculateArea(origin, basePoint, upperPoint);
		if (area1 + area2 + area3 == area) {
			return true;
		}
		return false;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}