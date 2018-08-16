import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * Interface for Nested List
 * 
 * @author Shubham Jain
 *
 */
public interface InterfaceNestedList {

	/**
	 * It will read data from Json File and store in nested List
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public boolean addList(String fileName) throws IOException, ParseException;

	/*
	 * It will return sum of all values in list
	 */
	public long getSum();

	/**
	 * It will return largest value in list
	 * 
	 * @return
	 */
	public long getLargestValue();

	/**
	 * It will search the element in list
	 * 
	 * @param elementToSearch
	 * @return true if element is found otherwise false
	 */
	public boolean search(long elementToSearch);
}