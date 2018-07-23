import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class JUnit {
    ArrOperation operation = new ArrOperation();
    int maxSizeMirror;
    int noOfClumps;
    int splitIndex;

    @Test(expected = AssertionError.class)
    public void assertErrorMirror() {
        assertEquals( "" , operation.maxMirror(new int[] {}) );     
    }
    
    @Test
    public void mirrorTest() {
        assertEquals(3,
                operation.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }));
        assertEquals(2, operation.maxMirror(new int[] { 7, 1, 4, 9, 7, 4, 1 }));

        assertNotEquals(6, operation.maxMirror(new int[] { 1, 2, 1, 4 }));
        assertNotEquals(3,
                operation.maxMirror(new int[] { 1, 4, 5, 3, 5, 4, 1 }));
    }
    
    @Test(expected = AssertionError.class)
    public void assertErrorClump() {
        assertEquals( "" , operation.countClumps(new int[] {}) );     
    }
    
    @Test
    public void clumpTest() {
        assertEquals(2, operation.countClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
        assertEquals(1, operation.countClumps(new int[] { 1, 1, 1, 1, 1 }));
        assertNotEquals(1, operation.countClumps(new int[] { 1, 1, 2, 1, 1 }));
    }

    @Test(expected = AssertionError.class)
    public void assertErrorFixXY() {
        assertEquals( "" , operation.fixXY(4, 5, new int[] {}) );  
        assertEquals( "" , operation.fixXY(4, 5, new int[] {4, 5, 6, 7, 4, 2}));  
        assertEquals( "" , operation.fixXY(4, 5, new int[] {5, 6, 4, 4, 2}));
        assertEquals( "" , operation.fixXY(4, 5, new int[] {5, 6, 6, 6, 6, 4}));  
    }
    
    @Test
    public void fixXYTest() {
        assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 },
                operation.fixXY(4, 5, new int[] { 5, 4, 9, 4, 9, 5 }));
        assertArrayEquals(new int[] { 1, 4, 5, 1 },
                operation.fixXY(4, 5, new int[] { 1, 4, 1, 5 }));
        assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 },
                operation.fixXY(4, 5, new int[] { 1, 4, 1, 5, 5, 4, 1 }));
        assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 },
                operation.fixXY(4, 5, new int[] { 5, 4, 9, 4, 9, 5 }));
    }

    @Test(expected = AssertionError.class)
    public void assertErrorSplitArray() {
        assertEquals( "" , operation.splitArray(new int[]{}) );     
    }
    
    @Test
    public void splitArrayTest() {
        assertEquals(3, operation.splitArray(new int[] { 1, 1, 1, 2, 1 }));
        assertEquals(-1, operation.splitArray(new int[] { 2, 1, 1, 2, 1 }));
        assertNotEquals(4, operation.splitArray(new int[] { 10, 10 }));
    }
}