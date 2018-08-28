/**
 * It will represent Data with key
 * 
 * @author Shubham Jain
 *
 */
public class Data {
    private int value;
    private int key;

    Data(int key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * It will returns the value of data
     * 
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * It will returns the key of data
     * 
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * It will set the value of data
     * 
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * It will set the key of data
     * 
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }
}