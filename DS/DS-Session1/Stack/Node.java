/**
 * It is defining a Node which has data and a link which points to other node
 * 
 * @author Shubham
 *
 */
public class Node {
    private int data;
    private Node link;

    public Node() {
        data = 0;
        link = null;
    }

    public Node(int data, Node link) {
        this.data = data;
        this.link = link;
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
     * @param link
     */
    public void setLink(Node link) {
        this.link = link;
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
    public Node getLink() {
        return link;
    }
}
