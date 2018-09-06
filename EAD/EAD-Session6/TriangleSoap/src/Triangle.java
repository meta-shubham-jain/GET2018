/**
 * Triangle class will calculate the area of triangle using heron's formula from
 * 3 sides of triangle
 * 
 * @author Shubham Jain
 *
 */
public class Triangle {
    public double area(double side1, double side2, double side3) {
        // calculates area of triangle using heron's formula
        double p = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return area;
    }

}
