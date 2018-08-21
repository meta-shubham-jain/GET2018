import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * It will perform operations on nested list
 * 
 * @author Shubham Jain
 *
 */
public class NestedList implements InterfaceNestedList {
	private LinkedList<Object> nestedList = new LinkedList<Object>();
	private long valueAtPosition;

	public NestedList(String fileName) throws IOException, ParseException {
		addList(fileName);
	}

	/**
	 * It will read data from Json file and store in list
	 */
	public boolean addList(String fileName) throws IOException, ParseException {
		if (fileName == null) {
			throw new NullPointerException("FileName Can't be Empty");
		}
		try {
			JSONObject rootJSON = (JSONObject) new JSONParser().parse(new FileReader(fileName));
			JSONArray dataList = (JSONArray) rootJSON.get("List");
			for (int i = 0; i < dataList.size(); i++) {
				if (dataList.get(i) instanceof JSONArray) {
					nestedList.add(addData((JSONArray) dataList.get(i)));
				} else {
					nestedList.add((long) dataList.get(i));
				}
			}
		} catch (FileNotFoundException ex) {
			throw new FileNotFoundException("File not Found");
		}
		return true;
	}

	/**
	 * It will recursively traverse the Json Array and store data in list
	 * 
	 * @param dataList
	 * @return list
	 */
	LinkedList<Object> addData(JSONArray dataList) {
		LinkedList<Object> list = new LinkedList<>();
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i) instanceof JSONArray) {
				list.add(addData((JSONArray) dataList.get(i)));
			} else {
				list.add((long) dataList.get(i));
			}
		}
		return list;
	}

	/**
	 * It will return sum of all the elements in list
	 */
	public long getSum() {
		long sum = 0;
		return findSum(nestedList, sum);
	}

	/**
	 * It will calculate sum of elements in list
	 * 
	 * @param list
	 * @param sum
	 * @return
	 */
	private long findSum(LinkedList<Object> list, long sum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof LinkedList) {
				sum = findSum((LinkedList<Object>) list.get(i), sum);
			} else {
				sum += (Long) list.get(i);
			}
		}
		return sum;
	}

	/**
	 * It will find the largest value in list
	 */
	public long getLargestValue() {
		long largestValue = Long.MIN_VALUE;
		return findLargest(nestedList, largestValue);
	}

	/**
	 * It will search largest value in list
	 * 
	 * @param list
	 * @param largestValue
	 * @return
	 */
	public long findLargest(LinkedList<Object> list, long largestValue) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof LinkedList) {
				largestValue = findLargest((LinkedList<Object>) list.get(i), largestValue);
			} else {
				if ((long) list.get(i) > largestValue) {
					largestValue = (long) list.get(i);
				}
			}
		}
		return largestValue;
	}

	/**
	 * It will search the element in list
	 * 
	 * @param elementToSearch
	 * @return true if element is found otherwise false
	 */
	public boolean search(long elementToSearch) {
		boolean result = false;
		return findValue(nestedList, elementToSearch, result);
	}

	/**
	 * It will find the value in list
	 * 
	 * @param list
	 * @param elementToSearch
	 * @param result
	 * @return true if value is found otherwise false
	 */
	private boolean findValue(LinkedList<Object> list, long elementToSearch, boolean result) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof LinkedList) {
				result = findValue((LinkedList<Object>) list.get(i), elementToSearch, result);
			} else {
				if ((Long) list.get(i) == elementToSearch) {
					result = true;
				}
			}
		}
		return result;
	}

	/**
	 * It will extract the value from the list at given specified position
	 * 
	 * @param position
	 * @return
	 * @throws Exception
	 */
	public long getValue(String position) throws Exception {
		return extractValue(nestedList, position);
	}

	/**
	 * It will find value at specified position
	 * 
	 * @param list
	 * @param position
	 * @return
	 * @throws Exception
	 */
	private long extractValue(LinkedList<Object> list, String position) throws Exception {
		if (position.charAt(0) == 'T' && position.length() == 1) {
			throw new Exception("List found at Tail");
		} else if (position.charAt(0) == 'H' && position.length() == 1) {
			if (list.get(0) instanceof List) {
				throw new Exception("List found at Head");
			} else {
				valueAtPosition = (long) list.get(0);
			}
		} else if (position.charAt(0) == 'T') {
			list.remove(0);
			extractValue((LinkedList<Object>) list, position.substring(1, position.length()));
		} else if (position.charAt(0) == 'H') {
			extractValue((LinkedList<Object>) list.get(0), position.substring(1, position.length()));
		}
		return valueAtPosition;
	}
}