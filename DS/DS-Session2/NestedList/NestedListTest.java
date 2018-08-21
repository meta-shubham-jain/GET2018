import static org.junit.Assert.*;
import java.io.IOException;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;

public class NestedListTest {
	NestedList nestedList;

	@Before
	public void init() throws IOException, ParseException, org.json.simple.parser.ParseException {
		nestedList = new NestedList("list.json");
	}

	@Test
	public void getSumTest() {
		assertEquals(91, nestedList.getSum());
	}

	@Test
	public void getLargestValueTest() {
		assertEquals(13, nestedList.getLargestValue());
	}

	@Test
	public void searchTest() {
		assertTrue(nestedList.search(7));
		assertFalse(nestedList.search(15));
	}

	@Test
	public void getValueTest() throws Exception {
		assertEquals(7, nestedList.getValue("TTH"));
	}

	@Test
	public void getValueErrorTest() {
		try {
			nestedList.getValue("TH");
		} catch (Exception ex) {
			assertEquals("List found at Head", ex.getMessage());
		}
	}

	@Test
	public void getValueErrorTest2() {
		try {
			nestedList.getValue("TT");
		} catch (Exception ex) {
			assertEquals("List found at Tail", ex.getMessage());
		}
	}

	@Test
	public void addListWithNull() {
		try {
			NestedList list = new NestedList(null);
		} catch (Exception ex) {
			assertEquals("FileName Can't be Empty", ex.getMessage());
		}
	}

	@Test
	public void fileNotFoundTest() {
		try {
			NestedList list = new NestedList("listed.json");
		} catch (Exception ex) {
			assertEquals("File not Found", ex.getMessage());
		}
	}
}