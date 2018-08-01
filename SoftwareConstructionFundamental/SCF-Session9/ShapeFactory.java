import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is Factory class for creating Shape Object
 * 
 * @author Shubham Jain
 *
 */
public class ShapeFactory {

    public static Shape createShape(Shape.ShapeType shapeType, Point point,
            ArrayList<Double> parameters) {
        try {
            switch (shapeType) {
            case CIRCLE:
                return new Circle(parameters.get(0), point, new Date());
            case RECTANGLE:
                return new Rectangle(parameters.get(0), parameters.get(1),
                        point, new Date());
            case SQUARE:
                return new Square(parameters.get(0), point, new Date());
            case TRIANGLE:
                return new Triangle(parameters.get(0), parameters.get(1),
                        parameters.get(2), point, new Date());
            default:
                return null;
            }

        } catch (Exception e) {
            throw new AssertionError();
        }

    }

}