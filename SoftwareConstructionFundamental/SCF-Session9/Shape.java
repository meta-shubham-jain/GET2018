import java.util.Date;

/**
 * This interface is made for Shapes Properties
 * 
 * @author Shubham Jain
 *
 */
public interface Shape {

    public enum ShapeType {
        SQUARE, RECTANGLE, CIRCLE, TRIANGLE
    }

    double getArea();

    double getPerimeter();

    Point getOrigin();

    ShapeType getShape();

    boolean isPointEnclosed(Point isPointEnclosed);

    Date getTimeStamp();
}
