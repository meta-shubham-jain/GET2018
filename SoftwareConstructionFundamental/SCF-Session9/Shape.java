import java.util.Date;

/**
 * This interface is made for Shapes Properties
 * 
 * @author Shubham Jain
 *
 */
public interface Shape {

	/**
	 * Enum for shapes
	 * @author Shubham Jain
	 *
	 */
	public enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE
	}

	/**
	 * It will return area of shape
	 * 
	 * @return
	 */
	double getArea();

	/**
	 * It will return Perimeter of shape
	 * 
	 * @return
	 */
	double getPerimeter();

	/**
	 * It will return origin of shape
	 * 
	 * @return
	 */
	Point getOrigin();

	/**
	 * It will return type of shape
	 * 
	 * @return
	 */
	ShapeType getShape();

	/**
	 * It will return whether point is enclosed or not in shape
	 * 
	 * @param isPointEnclosed
	 * @return
	 */
	boolean isPointEnclosed(Point isPointEnclosed);

	/**
	 * It will return time and date of creation
	 * 
	 * @return
	 */
	Date getTimeStamp();
}