/**
 * It is a interface for Priority Queue
 * 
 * @author Shubham Jain
 *
 */
public interface InterfacePriorityQueue {
    
    /**
     * It will add the information in queue according to key
     * 
     * @param key
     * @param name
     */
    void add(int key, int value);

    /**
     * It will return the top element of priority queue
     * 
     * @return
     */
	int remove();

	/**
     * It will return the top element of queue
     * 
     * @return
     */
	int peek();

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