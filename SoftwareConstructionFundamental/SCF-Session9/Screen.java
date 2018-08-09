import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class implements various methods based on Shapes and performs various
 * operations on Shapes
 * 
 * @author Shubham Jain
 *
 */
public class Screen {
    static ArrayList<Shape> shapesList = new ArrayList<>();

    public Screen() {
        shapesList.clear();
        addShape(Shape.ShapeType.CIRCLE, new Point(200, 200), new ArrayList<>(
                Arrays.asList(50d)));
        addShape(Shape.ShapeType.RECTANGLE, new Point(1, 23), new ArrayList<>(
                Arrays.asList(12d, 23d)));
        addShape(Shape.ShapeType.SQUARE, new Point(300, 100), new ArrayList<>(
                Arrays.asList(120d)));
        addShape(Shape.ShapeType.TRIANGLE, new Point(40, 200), new ArrayList<>(
                Arrays.asList(120d, 200d, 200d)));
    }

    /**
     * Add Shape to Shape List
     * 
     * @param shapeType
     * @param point
     * @param parameters
     * @return
     */
    public int addShape(Shape.ShapeType shapeType, Point point,
            ArrayList<Double> parameters) {
        shapesList.add(ShapeFactory.createShape(shapeType, point, parameters));
        return shapesList.size();
    }

    /**
     * Delete Shape from Shape List
     * 
     * @param shapeType
     * @param point
     * @return
     */
    boolean deleteShape(Shape.ShapeType shapeType, Point point) {
        if (shapeType == null || point == null) {
            throw new AssertionError("Arguments in deleteShape can't be Null");
        }

        for (int i = 0; i < shapesList.size(); i++) {
            if (shapesList.get(i).getShape() == shapeType
                    && shapesList.get(i).getOrigin().getXCoordinate() == point
                            .getXCoordinate()
                    && shapesList.get(i).getOrigin().getYCoordinate() == point
                            .getYCoordinate()) {
                shapesList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete all Shapes of Specific Shape type
     * 
     * @param shapeType
     * @return
     */
    boolean deleteShapesOfSpecificType(Shape.ShapeType shapeType) {
        if (shapeType == null) {
            throw new AssertionError(
                    "ShapeType can't be Null in deleteShapesOfSpecificType");
        }
        for (int i = 0; i < shapesList.size(); i++) {
            if (shapesList.get(i).getShape() == shapeType) {
                shapesList.remove(i);
                i--;
            }
        }
        return true;
    }

    /**
     * Arranges Shapes in ascending order on the basis of Area
     * 
     * @return
     */
    ArrayList<Shape> ascendingInArea() {
        ArrayList<Shape> sortedShapes = new ArrayList<>(shapesList);
        for (int i = 0; i < sortedShapes.size() - 1; i++) {
            for (int j = 0; j < sortedShapes.size() - i - 1; j++) {
                if (sortedShapes.get(j).getArea() > sortedShapes.get(j + 1)
                        .getArea()) {
                    Shape temporary = sortedShapes.get(j + 1);
                    sortedShapes.set(j + 1, sortedShapes.get(j));
                    sortedShapes.set(j, temporary);
                }
            }
        }
        return sortedShapes;
    }

    /**
     * Arranges Shapes in ascending order on the basis of Perimeter
     * 
     * @return
     */
    ArrayList<Shape> ascendingInPerimeter() {
        ArrayList<Shape> sortedShapes = new ArrayList<>(shapesList);
        for (int i = 0; i < sortedShapes.size() - 1; i++) {
            for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
                if (sortedShapes.get(j).getPerimeter() > sortedShapes
                        .get(j + 1).getPerimeter()) {
                    Shape temporary = sortedShapes.get(j + 1);
                    sortedShapes.set(j + 1, sortedShapes.get(j));
                    sortedShapes.set(j, temporary);
                }
            }
        }
        return sortedShapes;
    }

    /**
     * Arranges Shapes in ascending order on the basis of Time Stamp
     * 
     * @return
     */
    ArrayList<Shape> ascendingInTimeStamp() {
        ArrayList<Shape> sortedShapes = new ArrayList<>(shapesList);
        for (int i = 0; i < sortedShapes.size() - 1; i++) {
            for (int j = 0; j < sortedShapes.size() - i - 1; j++) {
                if (sortedShapes.get(j).getTimeStamp()
                        .after(sortedShapes.get(j + 1).getTimeStamp())) {
                    Shape temporary = sortedShapes.get(j + 1);
                    sortedShapes.set(j + 1, sortedShapes.get(j));
                    sortedShapes.set(j, temporary);
                }
            }
        }
        return sortedShapes;
    }

    /**
     * Arranges Shapes in ascending order on the basis of Origin Distance
     * 
     * @return
     */
    ArrayList<Shape> ascendingInOriginDistance() {
        ArrayList<Shape> sortedShapes = new ArrayList<>(shapesList);
        for (int i = 0; i < sortedShapes.size() - 1; i++) {
            for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
                double originDistance1 = Math.sqrt(Math.pow(sortedShapes.get(j)
                        .getOrigin().getXCoordinate(), 2)
                        + Math.pow(sortedShapes.get(j).getOrigin()
                                .getYCoordinate(), 2));
                double originDistance2 = Math.sqrt(Math
                        .pow(sortedShapes.get(j + 1).getOrigin()
                                .getXCoordinate(), 2)
                        + Math.pow(sortedShapes.get(j + 1).getOrigin()
                                .getYCoordinate(), 2));
                if (originDistance1 > originDistance2) {
                    Shape temp = sortedShapes.get(j + 1);
                    sortedShapes.set(j + 1, sortedShapes.get(j));
                    sortedShapes.set(j, temp);
                }
            }
        }
        return sortedShapes;
    }

    /**
     * Returns all the Shapes that Enclose the given Point
     * 
     * @param point
     * @return
     */
    ArrayList<Shape> isPointEnclosed(Point point) {
        if (point == null) {
            throw new AssertionError("Point can't be Null in isPointEnclosed");
        }
        ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
        for (int i = 0; i < shapesList.size(); i++) {
            if (shapesList.get(i).isPointEnclosed(point)) {
                pointEnclosedShapes.add(shapesList.get(i));
            }
        }
        return pointEnclosedShapes;
    }
}
