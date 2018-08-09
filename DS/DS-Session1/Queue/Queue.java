/**
 * It is an interface which has methods related to queue
 * 
 * @author Shubham Jain
 *
 */
public interface Queue {
    /**
     * For inserting an element in queue
     * 
     * @param data
     */
    void enQueue(int data);

    /**
     * For removing an element from queue
     * 
     * @return
     */
    int deQueue();

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
