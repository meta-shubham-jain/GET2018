import java.util.Scanner;

/**
 * Calculates area of different Shapes
 * 
 * @author Shubham Jain
 */
public class Area {

	/**
	 * Calculates area of triangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfTriangle(double width, double height) {
	    if (!(isCheck(width) && isCheck(height))) {
		        throw new AssertionError("Input should be greater than zero");
			}
		return 0.5 * width * height;
	}

	/**
	 * Calculates area of rectangle
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	double areaOfRectangle(double width, double height) {
		if (!(isCheck(width) && isCheck(height))) {
		        throw new AssertionError("Input should be greater than zero");
			}
		return width * height;
	}

	/**
	 * Calculates area of square
	 * 
	 * @param width
	 * @return
	 */
	double areaOfSquare(double width) {
		if (!(isCheck(width))) {
				throw new AssertionError("Input should be greater than zero");
			}
		return width * width;
	}

	/**
	 * Calculates area of circle
	 * 
	 * @param radius
	 * @return
	 */
	double areaOfCircle(double radius) {
		if (!(isCheck(radius))) {
		        throw new AssertionError("Input should be greater than zero");
			}
		return Math.PI * radius * radius;
	}

	/**
	 * It will check whether given input is greater than zero or not
	 * 
	 * @param input
	 * @return
	 */
	boolean isCheck(double input) {
		if (input <= 0) {
			return false;
		}
		return true;
	}
}