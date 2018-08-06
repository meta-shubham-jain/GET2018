import java.security.acl.LastOwnerException;
import java.util.InputMismatchException;

/**
 * It will convert Infix Expression into Postfix Expression
 * 
 * @author Shubham Jain
 *
 */
public class InfixToPostFixExpression {
    StackUsingLinkedList<String> stack = new StackUsingLinkedList<String>();

    /**
     * It checks whether input String is operator or not
     * 
     * @param input
     * @return
     */
    boolean isOperator(String input) {
        if ("+".equals(input) || "-".equals(input) || "*".equals(input)
                || "/".equals(input) || "==".equals(input)
                || "!=".equals(input) || "<".equals(input) || ">".equals(input)
                || "<=".equals(input) || ">=".equals(input)
                || "&&".equals(input) || "!".equals(input)
                || "||".equals(input)) {
            return true;
        }
        return false;
    }

    /**
     * It checks whether input string is operand or not
     * 
     * @param input
     * @return
     */
    boolean isOperand(String input) {
        if ((input.matches("[0-9]+")) || (input.matches("[a-zA-Z]+"))) {
            return true;
        }
        return false;
    }

    /**
     * It returns the precedence of operator
     * 
     * @param input
     * @return
     */
    int precedence(String input) {
        switch (input) {
        case "&&":
        case "||":
            return 1;
        case "==":
        case "!=":
            return 2;
        case "<":
        case ">":
        case "<=":
        case ">=":
            return 3;
        case "+":
        case "-":
            return 4;
        case "*":
        case "/":
            return 5;
        case "!":
            return 6;
        }
        return -1;
    }

    /**
     * It will convert infix expression into postfix expression
     * 
     * @param input
     * @return
     */
    public String infixToPostFix(String input) {
        String[] expression = input.split(" ");
        String postfix = "";
        for (int i = 0; i < expression.length; i++) {
            if (isOperand(expression[i])) {
                postfix += expression[i];
                postfix += " ";
            } else if ("(".equals(expression[i])) {
                stack.push("(");
            } else if (")".equals(expression[i])) {
                while (stack.peek() != "(") {
                    postfix += stack.pop();
                    postfix += " ";
                }
                if ("(".equals(stack.peek())) {
                    stack.pop();
                }
            } else if (isOperator(expression[i])) {
                while (!stack.isEmpty()
                        && (precedence(expression[i]) <= precedence(stack
                                .peek()))) {
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.push(expression[i]);
            } else {
                throw new InputMismatchException("Invalid Expression");
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == "(") {
                throw new InputMismatchException("Invalid Expression");
            }
            postfix += stack.pop();
            if (!stack.isEmpty()) {
                postfix += " ";
            }
        }
        if (postfix.charAt(postfix.length() - 1) == ' ') {
            String postExpression = postfix.substring(0, postfix.length() - 1);
            return postExpression;
        }
        return postfix;
    }
}