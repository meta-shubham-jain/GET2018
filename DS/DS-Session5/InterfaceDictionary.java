import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Interface to implement Dictionary
 * 
 * @author Shubham Jain
 *
 */
public interface InterfaceDictionary {

    /**
     * Add word to Dictionary
     * 
     * @param key
     * @param value
     */
    public boolean addWord(String key, String value);

    /**
     * Delete word from Dictionary
     * 
     * @param key
     * @return
     */
    public boolean deleteWord(String key);

    /**
     * 
     * @param key
     * @return
     */
    public String getValue(String key);

    /**
     * Sorts Dictionary in Ascending Order
     * 
     * @return
     */
    public Map<String, String> sortDictionary();

    /**
     * Returns the sorted list of key value pairs for all the keys >=K1 and <=K2
     * 
     * @param k1
     * @param K2
     * @return
     */
    public Map<String, String> sortDictionaryInRange(String k1, String K2);
}