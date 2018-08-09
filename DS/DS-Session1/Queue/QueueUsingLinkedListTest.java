import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueUsingLinkedListTest {
    QueueUsingLinkedList queue = new QueueUsingLinkedList();

    @Before
    public void test() {
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
    }

    // Checking for Insertion
    @Test
    public void testEnQueue() {
        queue.enQueue(4);
        assertEquals(4, queue.rear.getData());
    }

    // Checking for removal of element
    @Test
    public void testDeQueue() {
        assertEquals(1, queue.deQueue());
        assertEquals(2, queue.deQueue());
    }

    // Checking for Underflow condition
    @Test
    public void testUnderFlow() {
        try {
            queue.deQueue();
            queue.deQueue();
            queue.deQueue();
            queue.deQueue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Checking whether queue is empty
    @Test
    public void testIsEmpty() {
        assertFalse(queue.isEmpty());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        assertTrue(queue.isEmpty());
    }
}
