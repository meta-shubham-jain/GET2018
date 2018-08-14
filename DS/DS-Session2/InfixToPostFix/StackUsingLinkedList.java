/**
 * It implements Stack interface and it performs stack operations using linked
 * list Node is implemented in Node class
 * 
 * @author Shubham Jain
 *
 */
public class StackUsingLinkedList<Type> implements Stack<Type> {
    private Node<Type> top;

    public StackUsingLinkedList() {
        top = null;
    }

    /**
     * Insert element in Stack
     */
    @Override
    public void push(Type value) {
        Node<Type> newNode = new Node(value, null);
        newNode.setData(value);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setLink(top);
            top = newNode;
        }
    }

    /**
     * Remove element from Stack
     */
    @Override
    public Type pop() {
        Type data;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Underflow");
        } else {
            Node<Type> pointer = top;
            top = pointer.getLink();
            data = pointer.getData();
            pointer = null;
        }
        return data;
    }

    /**
     * Returns top Element of Stack
     */
    @Override
    public Type peek() {
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