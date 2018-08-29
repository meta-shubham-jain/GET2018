/**
 * This class is implementing Priority queue and performs function on Priority
 * queue
 * 
 * @author Shubham Jain
 *
 */
public class PriorityQueue implements InterfacePriorityQueue {
    private Bowler[] heap;
    private int heapSize;
    private int capacity;

    PriorityQueue(int capacity) {
        this.capacity = capacity + 1;
        heap = new Bowler[this.capacity];
    }

    public void add(int key, String name) {
        if (isFull()) {
            throw new AssertionError("Priority Queue Is Full");
        }
        Bowler newNode = new Bowler(key, name);
        heap[++heapSize] = newNode;
        int position = heapSize;
        while (position != 1
                && newNode.getNoOfBalls() > heap[position / 2].getNoOfBalls()) {
            heap[position] = heap[position / 2];
            position /= 2;
        }
        heap[position] = newNode;
    }

    public String remove() {
        if (isEmpty()) {
            throw new AssertionError("Priority Queue is Empty");
        }
        Bowler value = heap[1];
        heap[1] = heap[heapSize];
        heapSize = heapSize - 1;
        maxHeapify(1);
        return value.getName();
    }

    /**
     * It will rearrange the position of element in queue according to key
     * 
     * @param parentIndex
     */
    void maxHeapify(int parentIndex) {
        int leftChildrenIndex = 2 * parentIndex;
        int rightChildrenIndex = 2 * parentIndex + 1;
        int largest = 0;
        if (leftChildrenIndex <= heapSize
                && heap[leftChildrenIndex].getNoOfBalls() > heap[parentIndex]
                        .getNoOfBalls()) {
            largest = leftChildrenIndex;
        } else {
            largest = parentIndex;
        }
        if (rightChildrenIndex <= heapSize
                && heap[rightChildrenIndex].getNoOfBalls() > heap[largest]
                        .getNoOfBalls()) {
            largest = rightChildrenIndex;
        }
        if (largest != parentIndex) {
            swap(parentIndex, largest);
            maxHeapify(largest);
        }
    }

    /**
     * It will swap the elements
     * 
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        Bowler temporary = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temporary;
    }

    public Bowler peek() {
        if (isEmpty()) {
            throw new AssertionError("Priority Queue is Empty");
        }
        return heap[1];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == capacity - 1;
    }
}