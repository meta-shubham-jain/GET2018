import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitHexCalculator {
    HexCalc calculator = new HexCalc();

    @Test(expected = AssertionError.class)
    public void assertError() {
        calculator.addition("22@", "22@"); 
        calculator.division("234","0");
    }
    
    @Test
    public void testAddition() {
        assertEquals("44", calculator.addition("22", "22"));
    }

    @Test
    public void testSubtraction() {
        assertEquals("10", calculator.subtraction("32", "22"));
    }

    @Test
    public void testMultiplication() {
        assertEquals("4C68A11", calculator.multiplication("22ef", "22ff"));
    }

    @Test
    public void testDivision() {
        assertEquals("1", calculator.division("22ff", "22ff"));
    }

    @Test
    public void testComparisionForEqual() {
        assertTrue(calculator.comparisionForEqual("234", "234"));
    }

    @Test
    public void testComparisionForGreater() {
        assertTrue(calculator.comparisionForGreater("234", "123"));
    }

    @Test
    public void testComparisionForSmaller() {
        assertFalse(calculator.comparisionForSmaller("7654", "4321"));
    }
}
