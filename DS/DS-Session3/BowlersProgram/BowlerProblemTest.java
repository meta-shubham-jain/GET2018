import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingType;

import org.junit.Before;
import org.junit.Test;

public class BowlerProblemTest {
    BowlerOrder bowler = new BowlerOrder(3);

    @Before
    public void init() {
        bowler.addBowlers(5, "Shubham");
        bowler.addBowlers(1, "Rahul");
        bowler.addBowlers(1, "Mohit");
    }

    @Test
    public void testOrder() {
        List<String> list = new ArrayList<>();
        list = bowler.allocateBowlers(3);
        assertEquals("Shubham", list.get(0));
        assertEquals("Shubham", list.get(1));
        assertEquals("Shubham", list.get(2));
    }

    @Test
    public void testOrder2() {
        List<String> list = new ArrayList<>();
        list = bowler.allocateBowlers(6);
        assertEquals("Shubham", list.get(0));
        assertEquals("Shubham", list.get(1));
        assertEquals("Shubham", list.get(2));
        assertEquals("Shubham", list.get(3));
        assertEquals("Shubham", list.get(4));
        assertEquals("Rahul", list.get(5));
    }

    @Test
    public void testOrder3() {
        BowlerOrder bowler = new BowlerOrder(5);
        List<String> list = new ArrayList<>();
        bowler.addBowlers(5, "Shubham");
        bowler.addBowlers(1, "Rahul");
        bowler.addBowlers(1, "Mohit");
        bowler.addBowlers(4, "Raj");
        bowler.addBowlers(3, "Tez");
        list = bowler.allocateBowlers(10);
        assertEquals("Shubham", list.get(0));
        assertEquals("Shubham", list.get(1));
        assertEquals("Raj", list.get(2));
        assertEquals("Raj", list.get(3));
    }

    @Test
    public void testballsToPlayMoreThanDelivered() {
        List<String> list = new ArrayList<>();
        try {
            list = bowler.allocateBowlers(8);
        } catch (AssertionError ex) {
            assertEquals(
                    "Balls to be Played are more than Balls to be Delivered",
                    ex.getMessage());
        }
    }

    @Test
    public void bowlerWithNullNameException() {
        // Adding a Bowler Name as Null
        try {
            bowler.addBowlers(4, null);
        } catch (NullPointerException ex) {
            assertEquals("Bowler Name can't be Null", ex.getMessage());
        }
    }

    @Test
    public void bowlerWithNegativeNoOfBalls() {
        // Adding Bowls with negative value
        try {
            bowler.addBowlers(-5, "Ravi");
        } catch (AssertionError ex) {
            assertEquals("No of Balls can't be negative", ex.getMessage());
        }
    }
}