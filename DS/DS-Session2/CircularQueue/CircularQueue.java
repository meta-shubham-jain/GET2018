/**
 * It is implementing Queue interface which has methods related to queue and it
 * has implemented using LinkedList. Front is for removal and Rear is for
 * insertion in Queue
 * 
 * @author Shubham Jain
 *
 */
public class CircularQueue implements Queue {
    int queue[];
    int front;
    int rear;

    public CircularQueue(int sizeOfQueue) {
        queue = new int[sizeOfQueue];
        front = -1;
        rear = -1;
    }

    /**
     * Inserting an element in Queue
     */
    public void enQueue(int data) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Full");
        } else if (rear == -1) {
            front++;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = data;
    }

    /**
     * Removing an element from queue
     */
    public int deQueue() {
        int value;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        } else if (front == rear) {
            value = queue[front];
            front = -1;
            rear = -1;
        } else {
            value = queue[front];
            front = (front + 1) % queue.length;
        }
        return value;
    }

    /**
     * Checking whether queue is empty
     */
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    /**
     * Checking whether queue is full
     */
    public boolean isFull() {
        if (front == ((rear + 1) % queue.length)) {
            return true;
        }
        return false;
    }
}