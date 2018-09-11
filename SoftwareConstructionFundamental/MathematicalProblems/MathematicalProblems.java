/**
 * It will compute Mathematical Problems
 */
public class MathematicalProblems {

    /**
     * It will compute Greatest Common Divisor between two numbers
     * 
     * @param firstNumber
     * @param secondNumber
     * @return int
     */
    int gcd(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            return 0;
        }
        if (firstNumber == secondNumber) {
            return firstNumber;
        }
        if (firstNumber > secondNumber) {
            return gcd(firstNumber - secondNumber, secondNumber);
        }
        return gcd(firstNumber, secondNumber - firstNumber);
    }

    /**
     * It will compute Least Common Multiple between two numbers
     * 
     * @param firstNumber
     * @param secondNumber
     * @return int
     */
    int lcm(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber) / gcd(firstNumber, secondNumber);
    }
}
