import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnit {
    StackUsingArray stackArray = new StackUsingArray(5);

    @Before
    public void InitializeTest() {
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
    }

    // Inserting an element in stack which is full
    @Test
    public void testPush() {
        try {
            stackArray.push(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Removing element from stack
    @Test
    public void testPop() {
        assertEquals(5, stackArray.pop());
        assertEquals(4, stackArray.pop());
        assertEquals(3, stackArray.pop());
        assertEquals(2, stackArray.pop());
    }

    // Removing element from stack which is empty
    @Test
    public void testPopUnderFlow() {
        try {
            stackArray.pop();
            stackArray.pop();
            stackArray.pop();
            stackArray.pop();
            stackArray.pop();
            stackArray.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Getting Top Element
    @Test
    public void testPeek() {
        assertEquals(5, stackArray.peek());
    }

    // Checking stack is not empty
    @Test
    public void testStackNotEmpty() {
        assertFalse(stackArray.isEmpty());
    }

    // Checking stack is empty
    @Test
    public void testIsEmpty2() {
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        assertTrue(stackArray.isEmpty());
    }
}