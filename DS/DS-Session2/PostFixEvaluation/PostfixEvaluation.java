/**
 * It evaluates postfix expression value
 * 
 * @author Shubham Jain
 *
 */
public class PostfixEvaluation {
    StackUsingLinkedList stack;

    public PostfixEvaluation() {
        stack = new StackUsingLinkedList();
    }

    /**
     * It checks whether the character is digit or not
     * 
     * @param character
     * @return
     */
    boolean isDigit(Character character) {
        if (character >= 48 && character <= 57) {
            return true;
        }
        return false;
    }

    /**
     * It checks whether input String is operator or not
     * 
     * @param input
     * @return
     */
    boolean isOperator(String input) {
        Character character = input.charAt(0);
        if (input.length() == 1
                && ((character == '+') || (character == '-')
                        || (character == '*') || (character == '/'))) {
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
        for (int i = 0; i < input.length(); i++) {
            if (!(isDigit(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * It validates whether given input is valid or not
     * 
     * @param expression
     * @return
     */
    boolean isValidateExpression(String[] expression) {
        int noOfOperator = 0;
        int noOfOperand = 0;
        for (int i = 0; i < expression.length; i++) {
            if (isOperand(expression[i])) {
                noOfOperand++;
            } else if (isOperator(expression[i])) {
                noOfOperator++;
            } else {
                return false;
            }
        }
        if (!(noOfOperand == noOfOperator + 1)) {
            return false;
        }
        return true;
    }

    /**
     * It performs operation on given input with specified operator
     * 
     * @param num1
     * @param num2
     * @param operator
     * @return
     * @throws Exception
     */
    int operate(int num1, int num2, Character operator) throws Exception {
        int result;
        switch (operator) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            try {
                result = num1 / num2;
            } catch (Exception ex) {
                throw new Exception("Divide By zero exception");
            }
            break;
        default:
            throw new Exception("String Invalid");
        }
        return result;
    }

    /**
     * It evaluates the value of postfix expression
     * 
     * @param input
     * @return
     * @throws Exception
     */
    int evaluatePostfix(String input) throws Exception {
        String[] expression = input.split(" ");
        if (!(isValidateExpression(expression))) {
            throw new Exception("Invalid Expression");
        }
        int value1;
        int value2;
        Character operator;
        for (int i = 0; i < expression.length; i++) {
            if (isOperator(expression[i])) {
                value1 = stack.pop();
                value2 = stack.pop();
                operator = expression[i].charAt(0);
                stack.push(operate(value2, value1, operator));
            } else {
                stack.push(Integer.parseInt(expression[i]));
            }
        }
        return stack.pop();
    }
}