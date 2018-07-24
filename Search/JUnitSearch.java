import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitSearch {
    Search search = new Search();
    
    @Test
    public void testLinearSearch() {
        assertEquals(4, search.linearSearch(new int[]{1,2,3,4,5}, 0, 5));      
        assertEquals(1, search.linearSearch(new int[]{5,6,4,3,7,8,9}, 0, 6));      
       
        assertNotEquals(-1, search.linearSearch(new int[]{1,2,3,4,5}, 0, 5));              
        assertNotEquals(5, search.linearSearch(new int[]{1,2,3,4,5}, 0, 5));              
    }

    @Test
    public void testBinarySearch() {
        assertEquals(1, search.binarySearch(new int[]{1, 2, 3, 4, 5}, 0, 4 , 2));
        assertEquals(4, search.binarySearch(new int[]{3, 4, 5, 8, 11}, 0, 4 , 11));
        assertEquals(-1, search.binarySearch(new int[]{1, 2, 3, 4, 5}, 0, 4 , 9));
    
        assertNotEquals(5, search.binarySearch(new int[]{1, 2, 3, 4, 5}, 0, 4 , 3));
        assertNotEquals(3, search.binarySearch(new int[]{1, 2, 3, 4, 5}, 0, 4 , 2));      
    }
}

