import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitMathematicalOperations {
    MathematicalProblems operation = new MathematicalProblems();


    @Test
    public void testLcm() {
        assertEquals(35, operation.lcm(7, 5));
        assertEquals(6, operation.lcm(2, 6));

        assertNotEquals(7, operation.lcm(4, 98));
        assertNotEquals(12, operation.lcm(2, 6));
    }

    @Test
    public void testGcd() {
        assertEquals(12, operation.gcd(36, 60));
        assertEquals(4, operation.gcd(20, 28));

        assertNotEquals(12, operation.gcd(35, 60));
        assertNotEquals(4, operation.gcd(28, 28));
    }
}
