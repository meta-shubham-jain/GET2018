/**
 * It implements Stack interface and it performs stack operations using linked
 * list Node is implemented in Node class
 * 
 * @author Shubham Jain
 *
 */
public class StackUsingLinkedList implements Stack {
    private Node top;

    public StackUsingLinkedList() {
        top = null;
    }

    /**
     * Insert element in Stack
     */
    @Override
    public void push(int value) {
        Node newNode = new Node(value, null);
        newNode.setData(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    /**
     * Remove element from Stack
     */
    @Override
    public int pop() {
        int data;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Underflow");
        } else {
            Node pointer = top;
            top = pointer.getNext();
            data = pointer.getData();
            pointer = null;
        }
        return data;
    }

    /**
     * Returns top Element of Stack
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Underflow");
        }
        return top.getData();
    }

    /**
     * It returns true if stack is empty otherwise false
     */
    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
}