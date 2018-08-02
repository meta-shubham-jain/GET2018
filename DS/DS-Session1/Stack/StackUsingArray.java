/**
 * It implements Stack interface and it performs stack operations using array
 * @author Shubham Jain
 *
 */
public class StackUsingArray implements Stack {
    private int stack[];
    private int top; // topIndex of Stack

    /**
     * Initializing Size of Stack and topIndex to -1
     * 
     * @param sizeOfStack
     */
    public StackUsingArray(int sizeOfStack) {
        stack = new int[sizeOfStack];
        top = -1;
    }

    /**
     * Insert element in Stack
     */
    public void push(int data) {
        if (top == stack.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Stack is Full");
        }
        ++top;
        stack[top] = data;
    }

    /**
     * Remove element from Stack
     */
    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is Empty");
        }
        return stack[top--];
    }

    /**
     * Returns top Element of Stack
     */
    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Stack is Empty");
        }
        return stack[top];
    }

    /**
     * It returns true if stack is empty otherwise false
     */
    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }
}