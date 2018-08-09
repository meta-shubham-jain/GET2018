import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Rectangle class implements Shape interface
 * @author Shubham Jain
 *
 */
public class Rectangle implements Shape{

	private Point origin;
	private double height;
	private double width;
	private Date timeStamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Rectangle(double height, double width, Point origin, Date timestamp) {
		this.height = height;
		this.width = width;
		this.origin = origin;
		this.timeStamp = new Date();
		Point point = null;
		/**
		 * Checking if shape lies on the screen
		 */
		if (!(point.isPointOnScreen((origin.getXCoordinate() + width),(origin.getYCoordinate() + height)))) {
			throw new AssertionError("Width or Height is out of Screen in Rectangle");
		}
	}
	
	public double getLength() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));		
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * (width + height)));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public ShapeType getShape() {
		return ShapeType.RECTANGLE;
	}


    /*
     * If originX <= pointX <= originX+width and originY <= pointY <=originY+height
     * then the given point is enclosed by Rectangle
     */
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (origin.getXCoordinate() < isPointEnclosed.getXCoordinate()
				&& isPointEnclosed.getXCoordinate() < origin.getXCoordinate() + width) {
			if (origin.getYCoordinate() < isPointEnclosed.getYCoordinate()
					&& isPointEnclosed.getYCoordinate() < origin.getYCoordinate() + height) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}
}
