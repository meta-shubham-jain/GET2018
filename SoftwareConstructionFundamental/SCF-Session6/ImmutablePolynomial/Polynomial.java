import java.util.*;

/**
 * This immutable class performs various operations on polynomial equation
 * 
 * @author Shubham Jain
 *
 */
final public class Polynomial {
    final private int arrayPolynomial[][];

    /**
     * It will remove elements with zero coefficient and then sort the array and
     * then it will initialize the object
     * 
     * @param inputArray
     */
    Polynomial(int inputArray[][]) {
        int noOfNonZeroCoefficients;
        int coefficientIndex;
        int degreeIndex;
        noOfNonZeroCoefficients = nonZeroCoefficients(inputArray);
        arrayPolynomial = new int[noOfNonZeroCoefficients][2];
        sort(inputArray);
        for (int i = 0, j = 0; i < inputArray.length; i++) {
            if (!(inputArray[i][0] == 0)) {
                arrayPolynomial[j][0] = inputArray[i][0];
                arrayPolynomial[j++][1] = inputArray[i][1];
            }
        }
    }

    /**
     * It will sort the 2D array
     * 
     * @param array
     */
    static private void sort(int array[][]) {
        int length = array.length;
        int temporary;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - i - 1; j++) {
                if (array[j][1] > array[j + 1][1]) {
                    temporary = array[j][1];
                    array[j][1] = array[j + 1][1];
                    array[j + 1][1] = temporary;
                    temporary = array[j][0];
                    array[j][0] = array[j + 1][0];
                    array[j + 1][0] = temporary;
                }
            }
        }
    }

    /**
     * It will count number of non zero coefficients
     * 
     * @param array
     * @return int number of non zero coefficients
     */
   private int nonZeroCoefficients(int array[][]) {
        int noOfNonZeroCoefficients = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] != 0) {
                noOfNonZeroCoefficients++;
            }
        }
        return noOfNonZeroCoefficients;
    }

    /**
     * It will evaluate the value of a polynomial on given value
     * 
     * @param valueOfvariable
     * @return double value of polynomial
     */
    double evaluate(double valueOfvariable) {
        double valueOfPolynomial = 0;
        for (int i = 0; i < arrayPolynomial.length; i++) {
            valueOfPolynomial += arrayPolynomial[i][0]
                    * Math.pow(valueOfvariable, arrayPolynomial[i][1]);
        }
        return valueOfPolynomial;
    }

    /**
     * It will determine the degree of polynomial
     * 
     * @return int
     */
    int degree() {
        int degreeOfPolynomial = 0;
        for (int i = 0; i < arrayPolynomial.length; i++) {
            if (degreeOfPolynomial < arrayPolynomial[i][1]) {
                degreeOfPolynomial = arrayPolynomial[i][1];
            }
        }
        return degreeOfPolynomial;
    }

    /**
     * It will add two polynomials
     * 
     * @param poly1 Polynomial 1
     * @param poly2 Polynomial 2
     * @return int[][] contains new polynomial after adding two polynomials
     */
    static int[][] addpoly(Polynomial poly1, Polynomial poly2) {
        int indexPoly1 = 0;
        int indexPoly2 = 0; 
        int sumIndex = 0;
        int count = 0;
        int sumPoly[][] = new int[poly1.arrayPolynomial.length + poly2.arrayPolynomial.length][2];
         
        while (indexPoly1 < poly1.arrayPolynomial.length
                && indexPoly2  < poly2.arrayPolynomial.length) {
            if (poly1.arrayPolynomial[indexPoly1][1] < poly2.arrayPolynomial[indexPoly1][1]) {
                sumPoly[sumIndex][0] = poly1.arrayPolynomial[indexPoly1][0];
                sumPoly[sumIndex][1] = poly1.arrayPolynomial[indexPoly1][1];
                indexPoly1++;
                sumIndex++;
            } else if (poly1.arrayPolynomial[indexPoly1][1] > poly2.arrayPolynomial[indexPoly2][1]) {
                sumPoly[sumIndex][0] = poly2.arrayPolynomial[indexPoly2][0];
                sumPoly[sumIndex][1] = poly2.arrayPolynomial[indexPoly2][1];
                indexPoly1++;
                sumIndex++;
            } else {
                sumPoly[sumIndex][0] = poly1.arrayPolynomial[indexPoly1][0]
                        + poly2.arrayPolynomial[indexPoly2][0];
                sumPoly[sumIndex][1] = poly2.arrayPolynomial[indexPoly2][1];
                indexPoly1++;
                indexPoly2++;
                sumIndex++;
            }
            count++;
        }
        while (indexPoly1 < poly1.arrayPolynomial.length) {
            sumPoly[sumIndex][0] = poly1.arrayPolynomial[indexPoly1][0];
            sumPoly[sumIndex][1] = poly1.arrayPolynomial[indexPoly1][1];
            indexPoly1++;
            sumIndex++;
            count++;
        }
        while (indexPoly2 < poly2.arrayPolynomial.length) {
            sumPoly[sumIndex][0] = poly2.arrayPolynomial[indexPoly2][0];
            sumPoly[sumIndex][1] = poly2.arrayPolynomial[indexPoly2][1];
            indexPoly2++;
            sumIndex++;
            count++;
        }
        int addPolynomial[][] = new int[count][2];
        for (int i = 0; i < count; i++) {
            addPolynomial[i][0] = sumPoly[i][0];
            addPolynomial[i][1] = sumPoly[i][1];
        }
        return addPolynomial;
    }

    /**
     * It will multiply two polynomials
     * 
     * @param poly1 Polynomial 1
     * @param poly2 Polynomial 2
     * @return int[][] contains new polynomial after multiplying two polynomials
     */

    static int[][] multiplyPoly(Polynomial poly1, Polynomial poly2) {
        int multiplyPolynomial[][] = new int[poly1.arrayPolynomial.length
                * poly2.arrayPolynomial.length][2];
        int noOfElements = 0;
        int index = 0;
        for (int i = 0; i < poly1.arrayPolynomial.length; i++) {
            for (int j = 0; j < poly2.arrayPolynomial.length; j++) {
                multiplyPolynomial[index][1] = poly1.arrayPolynomial[i][1]
                        + poly2.arrayPolynomial[j][1];
                multiplyPolynomial[index++][0] = poly1.arrayPolynomial[i][0]
                        * poly2.arrayPolynomial[j][0];
            }
        }
        
        sort(multiplyPolynomial);
        int sum = 0;
        int indexPoly1 = 0;
        int indexPoly2 = 0;
        for (indexPoly1 = 0; indexPoly1 < multiplyPolynomial.length - 1; indexPoly1++) {
            if (multiplyPolynomial[indexPoly1][1] != multiplyPolynomial[indexPoly1 + 1][1]) {
                multiplyPolynomial[indexPoly2][1] = multiplyPolynomial[indexPoly1][1];
                multiplyPolynomial[indexPoly2][0] = multiplyPolynomial[indexPoly1][0] + sum;
                sum = 0;
                indexPoly2++;
                noOfElements++;
            } else {
                sum += multiplyPolynomial[indexPoly1][0];
            }
        }
        multiplyPolynomial[indexPoly2][1] = multiplyPolynomial[multiplyPolynomial.length - 1][1];
        multiplyPolynomial[indexPoly2][0] = multiplyPolynomial[multiplyPolynomial.length - 1][0] + sum;
        indexPoly2++;
        noOfElements++;
        int arrayMultiply[][] = new int[noOfElements][2];
        for (int i = 0; i < arrayMultiply.length; i++) {
            arrayMultiply[i][0] = multiplyPolynomial[i][0];
            arrayMultiply[i][1] = multiplyPolynomial[i][1];
        }
        return arrayMultiply;
    }
}
