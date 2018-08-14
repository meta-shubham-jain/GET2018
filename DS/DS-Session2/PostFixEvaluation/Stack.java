/**
 * It is an interface which has methods related to stack
 * 
 * @author Shubham Jain
 *
 */
public interface Stack {

    /**
     * Insert element in Stack
     * 
     * @param value
     */
    void push(int value);

    /**
     * Remove element from Stack
     * 
     * @return
     */
    int pop();

    /**
     * Returns top Element of Stack
     * 
     * @return
     */
    int peek();

    /**
     * It returns true if stack is empty otherwise false
     * 
     * @return
     */
    boolean isEmpty();
}
