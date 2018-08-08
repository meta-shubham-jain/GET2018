/**
 * It is a interface for Priority Queue
 * 
 * @author Shubham Jain
 *
 */
public interface InterfacePriorityQueue {

    /**
     * It will add the bowlers information in queue according to key
     * 
     * @param key
     * @param name
     */
    void add(int key, String name);

    /**
     * It will return the top element of priority queue
     * 
     * @return
     */
    String remove();

    /**
     * It will return the top element of queue
     * 
     * @return
     */
    Bowler peek();

    /**
     * It will check whether queue is empty or not
     * 
     * @return
     */
    boolean isEmpty();

    /**
     * It will check whether queue is full
     * 
     * @return
     */
    boolean isFull();
}