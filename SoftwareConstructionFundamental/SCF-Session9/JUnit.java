import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JUnit {

    @Test(expected = AssertionError.class)
    public void assertErrorTest() {
        Screen screen = new Screen();
        screen.isPointEnclosed(null);
    }

    @Test
    public void testAddShape() {
        Screen screen = new Screen();
        int size = screen.addShape(Shape.ShapeType.CIRCLE, new Point(20, 35),
                new ArrayList<>(Arrays.asList(5d)));
        assertEquals(5, size);
    }

    @Test
    public void testDeleteShape() {
        Screen screen = new Screen();
        assertTrue(screen.deleteShape(Shape.ShapeType.SQUARE, new Point(300,
                100)));
    }

    @Test
    public void testAllDeleteShape() {
        Screen screen = new Screen();
        screen.deleteShapesOfSpecificType(Shape.ShapeType.CIRCLE);
    }

    @Test
    public void testAscendingInArea() {
        Screen screen = new Screen();
        List<Shape> sortedShape = new ArrayList<Shape>();
        sortedShape.add(Screen.shapesList.get(1));
        sortedShape.add(Screen.shapesList.get(0));
        sortedShape.add(Screen.shapesList.get(2));
        sortedShape.add(Screen.shapesList.get(3));
        assertEquals(sortedShape, screen.ascendingInArea());
    }

    @Test
    public void testAscendingInPerimeter() {
        Screen screen = new Screen();
        List<Shape> sortedShape = new ArrayList<Shape>();
        sortedShape.add(Screen.shapesList.get(1));
        sortedShape.add(Screen.shapesList.get(0));
        sortedShape.add(Screen.shapesList.get(2));
        sortedShape.add(Screen.shapesList.get(3));
        assertEquals(sortedShape, screen.ascendingInPerimeter());
    }

    @Test
    public void testAscendingInTimestamp() {
        Screen screen = new Screen();
        List<Shape> sortedShape = new ArrayList<Shape>();
        sortedShape.add(Screen.shapesList.get(0));
        sortedShape.add(Screen.shapesList.get(1));
        sortedShape.add(Screen.shapesList.get(2));
        sortedShape.add(Screen.shapesList.get(3));
        assertEquals(sortedShape, screen.ascendingInTimeStamp());
    }

    @Test
    public void testAscendingInOriginDistance() {
        Screen screen = new Screen();
        List<Shape> sortedShape = new ArrayList<Shape>();
        sortedShape.add(Screen.shapesList.get(1));
        sortedShape.add(Screen.shapesList.get(3));
        sortedShape.add(Screen.shapesList.get(0));
        sortedShape.add(Screen.shapesList.get(2));
        assertEquals(sortedShape, screen.ascendingInOriginDistance());
    }

    @Test
    public void testIsPointEnclosed() {
        Screen screen = new Screen();
        List<Shape> sortedShape = new ArrayList<Shape>();
        sortedShape.add(Screen.shapesList.get(3));
        assertEquals(sortedShape, screen.isPointEnclosed(new Point(45, 203)));
    }

    @Test
    public void testPointOutOfScreenException() {
        Screen screen = new Screen();
        try {
            screen.addShape(Shape.ShapeType.CIRCLE, new Point(20, 35),
                    new ArrayList<>(Arrays.asList(5d)));
            screen.addShape(Shape.ShapeType.RECTANGLE, new Point(20, 35),
                    new ArrayList<>(Arrays.asList(5d,6d)));
        } catch (Exception ex) {
            assertEquals("Shape is Out of Screen", ex.getMessage());
        }
    }
}