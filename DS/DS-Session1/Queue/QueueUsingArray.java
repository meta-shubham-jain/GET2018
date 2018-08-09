/**
 * It is implementing Queue interface which has methods related to queue and it has
 * implemented using array. Front is for removal and Rear is for insertion in Queue
 * 
 * @author Shubham Jain
 *
 */
public class QueueUsingArray implements Queue {
    int queue[];
    int front;
    int rear;

    public QueueUsingArray(int sizeOfQueue) {
        queue = new int[sizeOfQueue];
        front = -1;
        rear = -1;
    }

    /**
     * Inserting an element in Queue
     */
    @Override
    public void enQueue(int data) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Full");
        } else if (rear == -1) {
            front++;
            queue[++rear] = data;
        } else {
            queue[++rear] = data;
        }
    }

    /**
     * Removing an element from queue
     */
    @Override
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
            front++;
        }
        return value;
    }

    /**
     * Checking whether queue is empty
     */
    @Override
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    /**
     * Checking whether queue is full
     */
    @Override
    public boolean isFull() {
        if (rear == queue.length - 1) {
            return true;
        }
        return false;
    }
}
