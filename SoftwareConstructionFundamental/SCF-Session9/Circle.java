import java.text.DecimalFormat;
import java.util.Date;

/**
 * The circle class implements Shape interface
 * 
 * @author Shubham Jain
 *
 */
public class Circle implements Shape {

    private double radius;
    private Date timeStamp;
    private Point origin;
    private DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

    public Circle(double radius, Point origin, Date timeStamp) {
        this.radius = radius;
        this.origin = origin;
        this.timeStamp = timeStamp;
        Point point = null;
        /**
         * Checking if shape lies on the screen
         */
        if (!(point.isPointOnScreen((origin.getXCoordinate() + radius),
                (origin.getYCoordinate() + radius)))
                || !(point.isPointLiesOnScreen(
                        (origin.getXCoordinate() - radius),
                        (origin.getYCoordinate() - radius)))) {
            throw new AssertionError("Shape is Out of Screen");
        }
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Double.parseDouble(decimalFormatSpecifier.format(Math.PI
                * radius * radius));
    }

    @Override
    public double getPerimeter() {
        return Double.parseDouble(decimalFormatSpecifier.format(2 * Math.PI
                * radius));
    }

    @Override
    public Point getOrigin() {
        double valueOfX1;
        double valueOfX2;
        double valueOfY;
        double cofficientOfX2;
        double coefficientOfX;
        double coefficientOfConstant;
        double slopeOfLine = origin.getYCoordinate() / origin.getXCoordinate();

        /*
         * y = mx so we will substitute the value of y to circle equation (x-h)2
         * + (y-k)2 = r2 where (h,k) is the radius coordinate x2(m2 + 1) - 2x(mx
         * + h) + k2 + h2 - r2 = 0 is the equation we get after substitution of
         * y This equation is similar to Ax2 + Bx + C = 0 so we can easily
         * calculate roots of x by formula of Quadratic Equation
         */
        cofficientOfX2 = (Math.pow(slopeOfLine, 2) + 1);
        coefficientOfX = (-2 * (slopeOfLine * origin.getYCoordinate() + origin
                .getXCoordinate()));
        coefficientOfConstant = (Math.pow(origin.getYCoordinate(), 2)
                + Math.pow(origin.getXCoordinate(), 2) - Math.pow(radius, 2));
        double underRoot = Math.sqrt((Math.pow(coefficientOfX, 2) - 4
                * cofficientOfX2 * coefficientOfConstant));
        valueOfX1 = (-coefficientOfX + underRoot) / (2 * cofficientOfX2);
        valueOfX2 = (-coefficientOfX - underRoot) / (2 * cofficientOfX2);
        /*
         * We will get two coordinates of x so we will select only that
         * coordinate whose value is less than the x coordinate of radius
         */
        if (valueOfX1 <= origin.getXCoordinate() && valueOfX2 <= 1080) {
            valueOfY = slopeOfLine * valueOfX1;
            return new Point(valueOfX1, valueOfY);
        } else if (valueOfX2 <= origin.getXCoordinate() && valueOfX1 <= 1080) {
            valueOfY = slopeOfLine * valueOfX2;
            return new Point(valueOfX2, valueOfY);
        }
        return null;
    }

    @Override
    public ShapeType getShape() {
        return ShapeType.CIRCLE;
    }

    @Override
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * If the given point is enclosed in circle then (x-h)2 + (y-k)2 <= r2
     * should satisfy where (h,k) is the point that is Enclosed or not
     */
    @Override
    public boolean isPointEnclosed(Point isPointEnclosed) {
        if (Math.pow(
                origin.getXCoordinate() - isPointEnclosed.getXCoordinate(), 2)
                + Math.pow(
                        origin.getYCoordinate()
                                - isPointEnclosed.getYCoordinate(), 2) < Math
                    .pow(radius, 2)) {
            return true;
        }
        return false;
    }
}