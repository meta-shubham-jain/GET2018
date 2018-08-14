import java.util.HashMap;
import java.util.Map;

/**
 * This class will calculate number of unique characters in string and store the
 * result in cache
 * 
 * @author Shubham Jain
 *
 */
public class CalculateUniqueCharacters {
	Map<String, Integer> cache = new HashMap<String, Integer>();

	/**
	 * It will count number of unique characters in string and store result string
	 * and its result in cache
	 * 
	 * @param input
	 * @return
	 */
	int noOfUniqueCharacters(String input) {
		if (input == null) {
			throw new NullPointerException("String is Empty");
		}
		Map<Character, Integer> hashMap = new HashMap<>();
		input = input.trim();
		if (cache.containsKey(input)) {
			return cache.get(input);
		}
		for (int i = 0; i < input.length(); i++) {
			if (hashMap.containsKey(input.charAt(i))) {
				hashMap.put(input.charAt(i), hashMap.get(input.charAt(i)) + 1);
			} else {
				hashMap.put(input.charAt(i), 1);
			}
		}
		int noOfUniqueCharacters = 0;
		for (Integer value : hashMap.values()) {
			if (value == 1) {
				noOfUniqueCharacters++;
			}
		}
		cache.put(input, noOfUniqueCharacters);
		return noOfUniqueCharacters;
	}
}