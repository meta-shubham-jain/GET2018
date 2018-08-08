import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitPolynomial {

    @Test
    public void testEvaluate() {
        int[][] array = { { 5, 0 }, { 10, 2 }, { 13, 7 }, { 5, 6 } };
        Polynomial object = new Polynomial(array);
        assertEquals(2029, object.evaluate(2), 0.00);
    }

    @Test
    public void testDegree() {
        int[][] array = { { 5, 0 }, { 10, 2 }, { 13, 7 }, { 5, 6 } };
        Polynomial object = new Polynomial(array);
        assertEquals(7, object.degree());
    }

    @Test
    public void testaddPolynomial() {
        int[][] array1 = { { 5, 1 }, { 10, 2 }, { 13, 7 }, { 5, 8 } };
        int[][] array2 = { { 0, 0 }, { 10, 2 }, { 13, 7 }, { 4, 8 } };
        int[][] answer = { { 5, 1 }, { 20, 2 }, { 26, 7 }, { 9, 8 } };
        
        Polynomial p1 = new Polynomial(array1);
        Polynomial p2 = new Polynomial(array2);
        assertArrayEquals(answer, Polynomial.addpoly(p1, p2));
    }

    @Test
    public void testmultiplyPolynomial() {
        int[][] array1 = { { 5, 1 }, { 3, 2 }, { 2, 7 }, { 5, 8 } };
        int[][] array2 = { { 1, 1 }, { 3, 3 }, };
        int[][] answer = { { 5, 2 }, { 3, 3 }, { 15, 4 }, { 9, 5 }, { 2, 8 },
                { 5, 9 }, { 6, 10 }, { 15, 11 }, };
        
        Polynomial poly1 = new Polynomial(array1);
        Polynomial poly2 = new Polynomial(array2);
        assertArrayEquals(answer, Polynomial.multiplyPoly(poly1, poly2));
    }
}