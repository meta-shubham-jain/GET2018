/**
 * This class is implementing priority queue using array and making it heap and
 * performs action
 * 
 * @author Shubham Jain
 *
 */
public class PriorityQueue implements InterfacePriorityQueue {
    private Data[] heap;
    private int heapSize;
    private int capacity;

    PriorityQueue(int capacity) {
        this.capacity = capacity + 1;
        heap = new Data[this.capacity];
    }

    /**
     * It will add the bowlers information in queue according to key
     * 
     * @param key
     * @param name
     */
    public void add(int key, int value) {
        if (isFull()) {
            throw new AssertionError("Priority Queue Is Full");
        }
        Data newNode = new Data(key, value);
        heap[++heapSize] = newNode;
        int position = heapSize;
        while (position != 1 && newNode.getKey() > heap[position / 2].getKey()) {
            heap[position] = heap[position / 2];
            position /= 2;
        }
        heap[position] = newNode;
    }

    /**
     * It will return the top element of priority queue
     * 
     * @return
     */
    public int remove() {
        if (isEmpty()) {
            throw new AssertionError("Priority Queue is Empty");
        }
        Data value = heap[1];
        heap[1] = heap[heapSize];
        heapSize = heapSize - 1;
        maxHeapify(1);
        return value.getValue();
    }

    /**
     * It will rearrange the position of element in queue according to key
     * 
     * @param parentIndex
     */
    private void maxHeapify(int parentIndex) {
        int leftChildrenIndex = 2 * parentIndex;
        int rightChildrenIndex = 2 * parentIndex + 1;
        int largest = 0;
        if (leftChildrenIndex <= heapSize
                && heap[leftChildrenIndex].getKey() > heap[parentIndex]
                        .getKey()) {
            largest = leftChildrenIndex;
        } else {
            largest = parentIndex;
        }
        if (rightChildrenIndex <= heapSize
                && heap[rightChildrenIndex].getKey() > heap[largest].getKey()) {
            largest = rightChildrenIndex;
        }
        if (largest != parentIndex) {
            swap(parentIndex, largest);
            maxHeapify(largest);
        }
    }

    /**
     * It will swap the values
     * 
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        Data temporary = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temporary;
    }

    /**
     * It will return the top element of queue
     * 
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new AssertionError("Priority Queue is Empty");
        }
        return heap[1].getValue();
    }

    /**
     * It will check whether queue is empty or not
     * 
     * @return
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * It will check whether queue is full
     * 
     * @return
     */
    public boolean isFull() {
        return heapSize == capacity - 1;
    }
}