import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.AssertionError;

public class JUnitSparseMatrix {

    @Test(expected = AssertionError.class)  
    public void testassertionError() {
        int array2[][] = new int[][] { {} };
        SparseMatrix obj2 = new SparseMatrix(array2);
        assertFalse(obj2.isSymmetrical());

    }

    @Test
    public void testIsSymmertic1() {
        int array2[][] = new int[][] { { 1, 2, 0 }, { 2, 0, 0 }, { 0, 2, 1 } };

        SparseMatrix obj2 = new SparseMatrix(array2);
        assertTrue(obj2.isSymmetrical());
    }

    @Test
    public void testtranspose() {
        int matrix1[][] = new int[][] { { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 },
                { 1, 0 } };

        SparseMatrix obj1 = new SparseMatrix(matrix1);
        assertArrayEquals(new int[][] { { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } },
                obj1.transpose());
    }

    @Test
    public void testaddition1() {
        int matrix1[][] = new int[][] { { 0, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 },
                { 1, 1 } };
        int matrix2[][] = new int[][] { { 0, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 },
                { 0, 0 } };
        
        SparseMatrix obj1 = new SparseMatrix(matrix1);
        SparseMatrix obj2 = new SparseMatrix(matrix2);

        assertArrayEquals(new int[][] { { 0, 1 }, { 0, 1 }, { 1, 1 }, { 0, 2 },
                { 1, 1 } }, SparseMatrix.addition(obj1, obj2));
    }

    @Test
    public void testaddition2() {
        int matrix1[][] = new int[][] { { 1, 1, 0, 2 }, { 1, 1, 0, 2 },
                { 1, 1, 0, 2 }, { 1, 1, 0, 2 }, { 1, 1, 0, 2 } };
        int matrix2[][] = new int[][] { { 1, 1, 0, 2 }, { 1, 1, 0, 2 },
                { 1, 1, 0, 2 }, { 1, 1, 0, 2 }, { 1, 1, 0, 2 } };
       
        SparseMatrix obj1 = new SparseMatrix(matrix1);
        SparseMatrix obj2 = new SparseMatrix(matrix2);

        assertArrayEquals(new int[][] { { 2, 2, 0, 4 }, { 2, 2, 0, 4 },
                { 2, 2, 0, 4 }, { 2, 2, 0, 4 }, { 2, 2, 0, 4 } },
                SparseMatrix.addition(obj1, obj2));
    }

    @Test
    public void checkSparseMatrixMultiplication() {
        int matrix1[][] = new int[][] { { 1, 0, 3 }, { 0, 2, 0 }, { 1, 0, 0 } };
        int matrix2[][] = new int[][] { { 1, 0, 0 }, { 0, 2, 0 }, { 1, 0, 3 } };
        
        SparseMatrix obj1 = new SparseMatrix(matrix1);
        SparseMatrix obj2 = new SparseMatrix(matrix2);
        assertArrayEquals(
                new int[][] { { 4, 0, 9 }, { 0, 4, 0 }, { 1, 0, 0 } },
                SparseMatrix.multiplySparseMatrix(obj1, obj2));
    }

}
