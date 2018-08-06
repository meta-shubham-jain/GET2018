import static org.junit.Assert.*;
import org.junit.Test;

public class InfixToPostFixTest {
    InfixToPostFixExpression post = new InfixToPostFixExpression();

    @Test
    public void testExpression() {
        assertEquals("2 3 + 4 +", post.infixToPostFix("2 + 3 + 4"));
        assertEquals("2 3 + 4 +", post.infixToPostFix("( 2 ) + 3 + 4"));
        assertEquals("3 2 * 4 A B + * +",
                post.infixToPostFix("3 * 2 + 4 * ( A + B )"));
        assertEquals("2 3 +", post.infixToPostFix("( ( ( 2 + 3 ) ) )"));
        assertEquals("2 3 * 4 +", post.infixToPostFix("2 * 3 + 4"));
        assertEquals("5 6 7 8 * + ||", post.infixToPostFix("5 || 6 + 7 * 8"));
        assertEquals("5 6 || 7 8 * &&", post.infixToPostFix("5 || 6 && 7 * 8"));
    }

    @Test
    public void testInvalidExpression1() {
        try {
            post.infixToPostFix("( 2 ) + 3 ) ) + 4");
        } catch (Exception ex) {
            assertEquals("Underflow",ex.getMessage());
        }
    }

    @Test
    public void testInvalidExpression2() {
        try {
            post.infixToPostFix("( 2 ) + ( ( ( 3 ) ) ) + 4 )");
        } catch (Exception ex) {
            assertEquals("Underflow",ex.getMessage());
        }
    }

    @Test
    public void testInvalidExpression3() {
        try {
            post.infixToPostFix("( 2 ) + ( ( ( 3 * @ $ % 7 8 ) ) ) + 4 )");
        } catch (Exception ex) {
            assertEquals("Invalid Expression",ex.getMessage());
        }
    }
}
