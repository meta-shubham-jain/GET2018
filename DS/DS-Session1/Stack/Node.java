/**
 * It is defining a Node which has data and a next which points to other node
 * 
 * @author Shubham
 *
 */
public class Node {
    private int data;
    private Node next;

    public Node() {
        data = 0;
        next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Inserting data in node
     * 
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Inserting address of other node
     * 
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * It returns value of data in node
     * 
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     * It returns reference of node
     * 
     * @return
     */
    public Node getNext() {
        return next;
    }
}