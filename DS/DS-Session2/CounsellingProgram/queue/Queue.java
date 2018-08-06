package queue;
/**
 * It is an interface which has methods related to queue
 * 
 * @author Shubham Jain
 *
 */
public interface Queue<Type> {
    /**
     * For inserting an element in queue
     * 
     * @param data
     */
    void enQueue(Type data);

    /**
     * For removing an element from queue
     * 
     * @return
     */
    Type deQueue();

    /**
     * For checking whether queue is empty
     * 
     * @return
     */
    boolean isEmpty();

    /**
     * For checking whether queue is full
     * 
     * @return
     */
    boolean isFull();
}
