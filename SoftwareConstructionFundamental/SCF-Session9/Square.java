
import java.text.DecimalFormat;
import java.util.Date;

/**
 * This Rectangle class implements Shape interface
 * @author Shubham Jain
 *
 */
public class Square implements Shape {
	private Point origin;
	private double side;
	private Date timeStamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");
	
	public Square(double side, Point origin, Date timeStamp) {
		this.side = side;
		this.origin = origin;
		this.timeStamp = timeStamp;
		
		/**
         * Checking if shape lies on the Screen
         */
		if ((origin.getXCoordinate() + side) > 1080 || (origin.getYCoordinate() + side) > 720) {
			throw new AssertionError("Width is out of Screen in Square");
		}
	}
	
	public double getXCoordinate() {
		return origin.getXCoordinate();
	}

	public double getYCoordinate() {
		return origin.getYCoordinate();
	}

	public double getSide() {
		return side;
	}


	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(side * side));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * side));

	}
	
	/*
     * If originX <= pointX <= originX+width and originY <= pointY <=originY+height
     * then the given point is enclosed by Rectangle
     */
	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		
		if (origin.getXCoordinate() < isPointEnclosed.getXCoordinate()
				&& isPointEnclosed.getXCoordinate() < origin.getXCoordinate() + side) {
			if (origin.getYCoordinate() < isPointEnclosed.getYCoordinate()
					&& isPointEnclosed.getYCoordinate() < origin.getYCoordinate() + side) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public ShapeType getShape() {
		return ShapeType.SQUARE;
	}

}
