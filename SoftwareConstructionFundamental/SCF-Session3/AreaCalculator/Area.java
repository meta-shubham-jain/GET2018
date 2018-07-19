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
		return width * height;
	}

	/**
	 * Calculates area of square
	 * 
	 * @param width
	 * @return
	 */
	double areaOfSquare(double width) {
		return width * width;
	}

	/**
	 * Calculates area of circle
	 * 
	 * @param radius
	 * @return
	 */
	double areaOfCircle(double radius) {
		return Math.PI * radius * radius;
	}
}
