/**
 * This class is implementing queue using Linked list and has Node from Node Class
 * 
 * @author Shubham Jain
 *
 */
public class QueueUsingLinkedList {
    Node front;
    Node rear;

    public QueueUsingLinkedList() {
        front = null;
        rear = null;
    }

    /**
     * Inserting an element in Queue
     * 
     * @param data
     */
    public void enQueue(int data) {
        Node newNode = new Node(data, null);
        newNode.setData(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    /**
     * Removing an element from queue
     * 
     * @return
     */
    public int deQueue() {
        int value;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        } else if (front == rear) {
            value = front.getData();
            front = null;
            rear = null;
        } else {
            value = front.getData();
            front = front.getNext();
        }
        return value;
    }

    /**
     * Checking whether queue is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }
}