import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Dictionary implements InterfaceDictionary {
    private Map<String, String> dictionary = new TreeMap<String, String>();

    /**
     * It will read the Json file and add key and value in dictionary
     * 
     * @param fileName
     * @throws FileNotFoundException
     */
    public Dictionary(String fileName) throws FileNotFoundException {
        if (fileName == null) {
            throw new NullPointerException("File Name can't be Null");
        }
        try {
            File jsonInputFile = new File(fileName);
            InputStream input = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(input);
            JsonObject jsonObj = reader.readObject();
            reader.close();
            Set<String> keys = jsonObj.keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                dictionary.put(key, jsonObj.get(key).toString());
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File Name not Found");
        }
    }

    /**
     * Add word in dictionary
     */
    public boolean addWord(String key, String value) {
        if (key == null || value == null) {
            throw new NullPointerException(
                    "Key or Value to be Added can't be Null");
        }
        if (dictionary.containsKey(key)) {
            return false;
        }
        dictionary.put(key, value);
        return true;
    }

    /**
     * Delete word from dictionary
     */
    public boolean deleteWord(String key) {
        if (key == null) {
            throw new NullPointerException("Key to be Deleted can't be Null");
        }
        if ((dictionary.remove(key) == null)) {
            return false;
        }
        return true;
    }

    /**
     * It returns value of word
     */
    public String getValue(String key) {
        if (key == null) {
            throw new NullPointerException("Key to be Deleted can't be Null");
        }
        return dictionary.get(key);
    }

    /**
     * Returns list of dictionary sorted in ascending order
     */
    public Map<String, String> sortDictionary() {
        Map<String, String> sortedDictionary = new HashMap<String, String>();
        Set<String> set = dictionary.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            sortedDictionary.put(key, dictionary.get(key));
        }
        return sortedDictionary;
    }

    /**
     * Returns the sorted list of key value pairs for all the keys >=K1 and <=K2
     */
    public Map<String, String> sortDictionaryInRange(String key1, String Key2) {
        if (key1 == null || Key2 == null) {
            throw new NullPointerException("Key1 or Key2 can't be Null");
        }
        Map<String, String> sortedDictionary = new HashMap<String, String>();
        Set<String> set = dictionary.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.compareTo(key1) >= 0 && key.compareTo(Key2) <= 0) {
                sortedDictionary.put(key, dictionary.get(key));
            }
        }
        return sortedDictionary;
    }

    /**
     * Returns size of Dictionary
     * 
     * @return
     */
    public int sizeOfDictionary() {
        return dictionary.size();
    }
}