import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    PriorityQueue queue = new PriorityQueue(5);

    @Test
    public void testAddElement() {
        queue.add(7, 23);
        queue.add(3, 54);
        queue.add(9, 13);
        queue.add(1, 43);
        assertEquals(13, queue.peek());
        queue.add(19, 50);
        assertEquals(50, queue.peek());
    }

    @Test
    public void testQueueFull() {
        try {
            queue.add(4, 54);
            queue.add(5, 13);
            queue.add(1, 45);
            queue.add(7, 45);
            queue.add(8, 45);
            queue.add(9, 45);
        } catch (AssertionError ex) {
            assertEquals("Priority Queue Is Full", ex.getMessage());
        }
    }

    @Test
    public void testRemoveElement() {
        queue.add(4, 54);
        queue.add(5, 13);
        queue.add(6, 45);
        assertEquals(45, queue.remove());
        assertEquals(13, queue.remove());
        assertEquals(54, queue.remove());
    }

    @Test
    public void testQueueEmpty() {
        queue.add(4, 54);
        queue.add(5, 13);
        queue.remove();
        queue.remove();
        assertTrue(queue.isEmpty());
    }
}