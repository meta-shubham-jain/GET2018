import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitStackLinkedListImplementation {
    StackUsingLinkedList stackLinkedList = new StackUsingLinkedList();

    @Before
    public void InitializeTest() {
        stackLinkedList.push(1);
        stackLinkedList.push(2);
        stackLinkedList.push(3);
        stackLinkedList.push(4);
        stackLinkedList.push(5);
    }

    // Removing Element from Queue
    @Test
    public void testPop() {
        assertEquals(5, stackLinkedList.pop());
        assertEquals(4, stackLinkedList.pop());
        assertEquals(3, stackLinkedList.pop());
    }

    // Test for UnderFlow
    @Test
    public void testPopUnderFlow() {
        try {
            stackLinkedList.pop();
            stackLinkedList.pop();
            stackLinkedList.pop();
            stackLinkedList.pop();
            stackLinkedList.pop();
            stackLinkedList.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Test for top Element
    @Test
    public void testPeek() {
        assertEquals(5, stackLinkedList.peek());
    }

    // Checks whether queue is not empty
    @Test
    public void testIsEmpty() {
        assertFalse(stackLinkedList.isEmpty());
    }
    
    // Checks whether queue is not empty
    @Test
    public void testIsEmpty2() {
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.pop();
        stackLinkedList.pop();
        assertTrue(stackLinkedList.isEmpty());
    }
}
