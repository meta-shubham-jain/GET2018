import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitStringOperations {
	StringOperations string = new StringOperations();

	@Test
	void testStringEqual() {
		assertEquals(1, string.isEqual("Shubham", "Shubham"));
		assertEquals(0, string.isEqual("India is my Country", "India is the Country"));
		assertNotEquals(1, string.isEqual("Shubham Jain", "Shubham Agarwal"));
	}

	@Test
	void testReverse() {
		assertEquals("Rahul", string.reverse("luhaR"));
		assertEquals("niaj naman", string.reverse("naman jain"));
		assertNotEquals("Metacube", string.reverse("metacube"));
	}

	@Test
	void testChangeCase() {
		assertEquals("shubham", string.changeCase("SHUBHAM"));
		assertEquals("JaIn", string.changeCase("jAiN"));
		assertNotEquals("MetaCube", string.changeCase(" METACUBE"));
	}

	@Test
	void testLargestWord() {
		assertEquals("longest", string.largestWord("This is longest word"));
		assertEquals("slever", string.largestWord("clever ever slever"));
		assertNotEquals("no", string.largestWord("A girl has no name"));
	}
}
