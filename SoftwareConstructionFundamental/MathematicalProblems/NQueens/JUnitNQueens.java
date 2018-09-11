import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitNQueens {
    NQueens nQueen = new NQueens();

    @Test
    public void test() {

        assertEquals(true, nQueen.nQueen(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }, 0, 4));

        assertEquals(false, nQueen.nQueen(new int[][] { { 0, 0, 0 }, { 0, 0, 0 },
                        { 0, 0, 0 } }, 0, 3));
    
        assertNotEquals(true, nQueen.nQueen(new int[][] { { 0, 0 }, { 0, 0 }}, 0, 2));
    }
}
