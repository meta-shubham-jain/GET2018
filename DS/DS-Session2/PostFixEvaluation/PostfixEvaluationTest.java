import static org.junit.Assert.*;

import org.junit.Test;
public class PostfixEvaluationTest {

    @Test
    public void testEvaluatePostfix() throws Exception {
        PostfixEvaluation expression = new PostfixEvaluation();
        assertEquals(-4, expression.evaluatePostfix("2 3 1 * + 9 -"));
        assertEquals(37, expression.evaluatePostfix("5 6 2 + * 9 3 / -"));
        assertEquals(50, expression.evaluatePostfix("20 30 +"));
    }

    @Test
    public void testInvalidExpression() {
        PostfixEvaluation expression = new PostfixEvaluation();
        try {
            expression.evaluatePostfix("5 6 2 3 + * 9 3 / -");
            expression.evaluatePostfix(" ) (5 6 2 3 + * 9 3 / -");
        } catch (Exception ex) {
            assertEquals("Invalid Expression", ex.getMessage());
        }
    }

    @Test
    public void testInvalidExpression2() {
        PostfixEvaluation expression = new PostfixEvaluation();
        try {
            expression.evaluatePostfix("5 6 @ 2 $ ( ( 3 ) ) + * 9 3 / -");
            expression.evaluatePostfix("5 6 2 3 + * 9 3 / -");
        } catch (Exception ex) {
            assertEquals("Invalid Expression", ex.getMessage());
        }
    }

    @Test
    public void testInvalidExpression3() {
        PostfixEvaluation expression = new PostfixEvaluation();
        try {
            expression.evaluatePostfix("5 6 2 3 + * 9 3 / / / -");
        } catch (Exception ex) {
            assertEquals("Invalid Expression", ex.getMessage());
        }
    }

    @Test
    public void testDivideByZeroException() {
        PostfixEvaluation expression = new PostfixEvaluation();
        try {
            expression.evaluatePostfix("4 0 /");
        } catch (Exception ex) {
            assertEquals("Divide By zero exception", ex.getMessage());
        }
    }
}