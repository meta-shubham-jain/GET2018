import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitIntSet {

    @Test(expected = AssertionError.class)
    public void assertError() {
        intSet set = new intSet(new int[] { -1, 3, 5, 5, 5, 5, 5, 7, 9, 10 });
        System.out.println("Input should be in between 0 and 100");

    }

    @Test
    public void testIsMember() {
        intSet set = new intSet(new int[] { 3, 5, 5, 5, 5, 5, 7, 9, 10 });
        assertTrue(set.isMember(5));
    }

    @Test
    public void testSize() {
        intSet set = new intSet(new int[] { 3, 5, 5, 5, 5, 5, 7, 9, 10 });
        assertEquals(5, set.size());

    }

    @Test()
    public void testSubSet() {
        intSet set = new intSet(new int[] { 3, 5, 5, 5, 5, 5, 7, 9, 10 });
        intSet set1 = new intSet(new int[] {});
        assertTrue(set.isSubSet(set1));

    }

    @Test()
    public void testComplemented() {
        // intSet set = new intSet(new int[] {3,5,5,5,5,5,7,9,10});
        intSet set1 = new intSet(new int[] {});
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15 },
                set1.getComplement());

    }

    @Test()
    public void testUnion() {
        intSet set = new intSet(new int[] { 1, 2 });
        intSet set1 = new intSet(new int[] {});
        intSet set2 = new intSet(new int[] {});
        assertArrayEquals(new int[] {}, set.union(set1, set2));
    }
}
