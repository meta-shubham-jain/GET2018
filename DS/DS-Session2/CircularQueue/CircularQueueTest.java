import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {
    CircularQueue queue = new CircularQueue(4);

    @Before
    public void test() {
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
    }

    @Test
    public void testEnQueue() {
        // Checking for Insertion
        queue.enQueue(4);
        assertEquals(4, queue.queue[3]);
    }

    @Test
    public void testOverflow() {
        // Checking for Overflow condition
        try {
            queue.enQueue(4);
            queue.enQueue(5);
        } catch (Exception ex) {
            assertEquals("Queue is Full", ex.getMessage());
        }
    }

    @Test
    public void testDeQueue() {
        // Checking for removal of element
        assertEquals(1, queue.deQueue());
        assertEquals(2, queue.deQueue());
    }

    @Test
    public void testUnderFlow() {
        // Checking for Underflow condition
        try {
            queue.deQueue();
            queue.deQueue();
            queue.deQueue();
            queue.deQueue();
        } catch (Exception ex) {
            assertEquals("Queue is Empty", ex.getMessage());
        }
    }

    @Test
    public void testEnqueue2() {
        queue.enQueue(4);
        queue.deQueue();
        queue.enQueue(5);
        assertEquals(5, queue.queue[0]);
    }

    @Test
    public void testIsEmpty() {
        // Checking for empty queue
        assertFalse(queue.isEmpty());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull1() {
        // Checking for queue full
        assertFalse(queue.isFull());
        queue.enQueue(4);
        assertTrue(queue.isFull());
    }

    @Test
    public void testIsFull2() {
        // Checking for queue full
        queue.enQueue(5);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(5);
        queue.enQueue(5);
        assertTrue(queue.isFull());
    }
}
