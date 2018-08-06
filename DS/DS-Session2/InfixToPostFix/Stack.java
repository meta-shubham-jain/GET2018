/**
 * It is an Typeerface which has methods related to stack
 * @author Shubham Jain
 *
 */
public interface Stack<Type> {

    /**
     * Insert element in Stack
     * 
     * @param value
     */
    void push(Type value);

    /**
     * Remove element from Stack
     * 
     * @return
     */
    Type pop();

    /**
     * Returns top Element of Stack
     * 
     * @return
     */
    Type peek();

    /**
     * It returns true if stack is empty otherwise false
     * 
     * @return
     */
    boolean isEmpty();
}
