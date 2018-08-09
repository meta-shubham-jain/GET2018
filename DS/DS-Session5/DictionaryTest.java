import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {
    Dictionary dictionary;

    @Before
    public void init() throws FileNotFoundException {
        dictionary = new Dictionary("File.json");
    }

    @Test
    public void addWordTest() {
        // Adding Word and its Meaning to Dictionary
        assertTrue(dictionary.addWord("Dog", "Type of Animal"));
        assertEquals(7, dictionary.sizeOfDictionary());
        assertTrue(dictionary.addWord("Orange", "Type of Fruit"));
        assertTrue(dictionary.addWord("Java", "Programming Language"));
        assertEquals(9, dictionary.sizeOfDictionary());
    }

    @Test
    public void deleteWordTest() {
        // Deleting Word Attitude from Dictionary
        assertTrue(dictionary.deleteWord("Attitude"));
    }

    @Test
    public void getValueTest() {
        // Getting Meaning of word Attitude
        assertEquals("a feeling or opinion about something or someone",
                dictionary.getValue("Attitude"));
    }

    @Test
    public void sortDictionaryTest() {
        // Sorting Dictionary
        Map<String, String> sortedWords = new HashMap<String, String>();
        sortedWords.put("Anticipate",
                "to imagine or expect that something will happen");
        sortedWords.put("Attitude",
                "a feeling or opinion about something or someone");
        sortedWords.put("Attribute",
                "a quality or characteristic that someone or something has");
        sortedWords.put("Content",
                "pleased with your situation and not hoping for change");
        sortedWords.put("Culture", "the general customs and beliefs");
        sortedWords.put("Sophisticated",
                "having a good understanding of the way people behave");
        assertEquals(sortedWords, dictionary.sortDictionary());
    }

    @Test
    public void sortDictionaryInRangeTest() {
        // Sorting Dictionary in Range Attitude to Content
        Map<String, String> sortedWords = new HashMap<String, String>();
        sortedWords.put("Attitude",
                "a feeling or opinion about something or someone");
        sortedWords.put("Attribute",
                "a quality or characteristic that someone or something has");
        sortedWords.put("Content",
                "pleased with your situation and not hoping for change");
        assertEquals(sortedWords,
                dictionary.sortDictionaryInRange("Attitude", "Content"));
    }

    @Test
    public void initWithNull() throws FileNotFoundException {
        // Adding fileName as Null
        try {
            dictionary = new Dictionary(null);
        } catch (NullPointerException ex) {
            assertEquals("File Name can't be Null", ex.getMessage());
        }
    }

    @Test
    public void initWithFileNotFound() throws FileNotFoundException {
        // Adding a File that doesn't exist
        try {
            dictionary = new Dictionary("Input.json");
        } catch (FileNotFoundException ex) {
            assertEquals("File Name not Found", ex.getMessage());
        }
    }

    @Test
    public void addWordWithNull() throws FileNotFoundException {
        // Adding a null word
        try {
            dictionary.addWord(null, "Input");
        } catch (NullPointerException ex) {
            assertEquals("Key or Value to be Added can't be Null",
                    ex.getMessage());
        }
    }

    @Test
    public void deleteWordWithNullKey() throws FileNotFoundException {
        // Deleting a Null Word
        try {
            dictionary.deleteWord(null);
        } catch (NullPointerException ex) {
            assertEquals("Key to be Deleted can't be Null", ex.getMessage());
        }
    }

    @Test
    public void getValueWithNullKey() throws FileNotFoundException {
        // Getting a Null Word meaning
        try {
            dictionary.deleteWord(null);
        } catch (NullPointerException ex) {
            assertEquals("Key to be Deleted can't be Null", ex.getMessage());
        }
    }

    @Test
    public void sortDictionaryInRangeWithNullKey() throws FileNotFoundException {
        // Sorting Dictionary in Range from Null to Null
        try {
            dictionary.sortDictionaryInRange(null, null);
        } catch (NullPointerException ex) {
            assertEquals("Key1 or Key2 can't be Null", ex.getMessage());
        }
    }
}