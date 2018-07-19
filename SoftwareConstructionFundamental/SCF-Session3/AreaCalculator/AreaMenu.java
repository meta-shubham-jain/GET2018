import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It contains the main method which consists of menu for user.
 * @author Shubham Jain
 */
public class AreaMenu {
	
	/*
	 * Takes input from User
	 */
	static double  get() {
		double input=0;
		try {
			input = new Scanner(System.in).nextDouble();
		} catch (InputMismatchException ex) {
			System.out.println("Wrong input");
			System.exit(1);
		}
		return input;
		}
	
	/*
	 * Checks for input whether it is greater than zero or not
	 * @return true if input is greater than zero else false
	 */
	static boolean isValidate(double input) {
		if(input > 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		double width;
		double height;
		double radius;
		int option=0;
		Area area =new Area();
		while (true) {
			System.out.println("Enter Option to perform:");
			System.out.println("1.Area of Triangle\n2.Area of Rectangle\n3.Area of Square\n4.Area of Circle\n5.Exit");
			try {
				 option = new Scanner(System.in).nextInt();
			} catch (InputMismatchException ex) {
			     System.out.println("Wrong Format.");
			     System.exit(1);
			}
			switch (option) {
			case 1 : 
				System.out.println("Enter the  width :");
				if (!(isValidate(width =get()))) {
					System.out.println("Input must be Greater than Zero.");
					break;
				}
				System.out.println("Enter the height :");
				if (!(isValidate(height =get()))) {
					System.out.println("Input must be Greater than Zero.");
					break;
				}
				System.out.printf("Area of Triangle = " + "%.2f",area.areaOfTriangle(width, height));
				break;
					
				case 2 : 
					System.out.println("Enter the  width :");
					if (!(isValidate(width=get()))) {
						System.out.println("Input must be Greater than Zero.");
						break;
					}
					System.out.println("Enter the height :");
					if (!(isValidate(height=get()))) {
						System.out.println("Input must be Greater than Zero.");
						break;
					}
					System.out.printf("Area of Rectangle = " + "%.2f", area.areaOfRectangle(width, height));
					break;
					
				case 3 :
					System.out.println("Enter the  width :");
					if (!(isValidate(width=get()))) {
						System.out.println("Input must be Greater than Zero.");
						break;
					}
					System.out.printf("Area of Square = " + "%.2f", area.areaOfSquare(width));
					break;
					
				case 4 : 
					System.out.println("Enter the  width :");
					if (!(isValidate(radius =get()))) {
						System.out.println("Input must be Greater than Zero.");
						break;
					}
					System.out.printf("Area of Circle = " + "%.2f",area.areaOfCircle(radius));
					break;
					
				case 5 : 
					System.exit(1);
					
				default :
					System.out.println("Wrong Option");

			}
		}	
	}
}
