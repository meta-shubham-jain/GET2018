/**
 * It contains name and capacity of Program
 * 
 * @author Shubham Jain
 *
 */
public class Program {
    private String name;
    private int capacity;

    /**
     * It returns capacity of program
     * 
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * It returns name of program
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * It sets capacity of program
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * It sets name of program
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}