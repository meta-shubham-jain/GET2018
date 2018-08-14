import static org.junit.Assert.*;
import org.junit.Test;

public class CalculateUniqueCharactersTest {
	CalculateUniqueCharacters object = new CalculateUniqueCharacters();

	@Test
	public void test() {
		assertEquals(3, object.noOfUniqueCharacters("Shubh"));
		assertEquals(4, object.noOfUniqueCharacters("hello hi"));
		assertEquals(1, object.noOfUniqueCharacters("hello hello"));
		assertEquals(8, object.noOfUniqueCharacters("Shubham Jain"));
		assertEquals(26, object.noOfUniqueCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals(0, object.noOfUniqueCharacters("AAAAAAAAAAAAAAA1111111111111"));
		assertEquals(3, object.noOfUniqueCharacters("123444444"));
	}

	@Test
	public void testForCache() {
		assertEquals(3, object.noOfUniqueCharacters("Shubh"));
		assertEquals(4, object.noOfUniqueCharacters("hello hi"));
		assertEquals(4, object.noOfUniqueCharacters("hello hi"));
		assertEquals(2, object.cache.size());
	}

	@Test
	public void testForNullString() {
		try {
			object.noOfUniqueCharacters(null);
		} catch (NullPointerException ex) {
			assertEquals("String is Empty", ex.getMessage());
		}
	}
}
