import java.lang.AssertionError;

/**
 * It will store the sparse matrix in compact form and performs operation on
 * compact matrix to reduce time complexity
 * 
 * @author Shubham Jain
 *
 */
final public class SparseMatrix {
    final private int compactMatrix[][];
    final private int row;
    final private int column;

    /**
     * It will initialize the object with non zero elements in compact matrix
     * Compact matrix has three fields-row 1 for row index, row 2 for column
     * index and row 3 for value
     * 
     * @param sparseMatrix 2D matrix
     */
    SparseMatrix(int sparseMatrix[][]) {
        if (sparseMatrix == null) {
            throw new AssertionError("Input Matrix is Null");
        }
        if (sparseMatrix.length == 0) {
            throw new AssertionError("Matrix is Empty");
        }

        int nonZeroElements = countNonZeroElements(sparseMatrix);
        row = sparseMatrix.length;
        column = sparseMatrix[0].length;
        compactMatrix = new int[3][nonZeroElements];
        int compactMatrixIndex = 0;
        for (int i = 0; i < sparseMatrix.length; i++) {
            for (int j = 0; j < sparseMatrix[0].length; j++) {
                if (sparseMatrix[i][j] != 0) {
                    compactMatrix[0][compactMatrixIndex] = i;
                    compactMatrix[1][compactMatrixIndex] = j;
                    compactMatrix[2][compactMatrixIndex] = sparseMatrix[i][j];
                    compactMatrixIndex++;
                }
            }
        }
    }

    /**
     * It will count the number of non-zero elements in sparse matrix
     * 
     * @param matrix
     * @return int number of non-zero elements
     */
    private int countNonZeroElements(int matrix[][]) {
        int nonZeroElements = 0;
        int zeroElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    nonZeroElements++;
                } else {
                    zeroElements++;
                }
            }
        }
        return nonZeroElements;
    }

    /**
     * It will sort the 2D matrix 
     * 
     * @param array
     * @return
     */
    private int[][] sort(int array[][]) {
        for (int index = 0; index < array.length; index++) {
            for (int index2 = 0; index2 < (array.length - 1) - index; index2++) {
                if (array[index2][0] > array[index2 + 1][0]) {
                    for (int index3 = 0; index3 < 3; index3++) {
                        // swapping for row index2 and column index3
                        int temp = array[index2][index3];
                        array[index2][index3] = array[index2 + 1][index3];
                        array[index2 + 1][index3] = temp;
                    }
                }
                if (array[index2][0] == array[index2 + 1][0]
                        && array[index2][1] > array[index2 + 1][1]) {
                    for (int index3 = 1; index3 < 3; index3++) {
                        // swapping for row index2 and column index3
                        int temp = array[index2][index3];
                        array[index2][index3] = array[index2 + 1][index3];
                        array[index2 + 1][index3] = temp;
                    }
                }
            }
        }
        return array;
    }

    /**
     * It will transpose the matrix 
     * The time complexity of transposing a matrix is O(n)
     * where n is number of column of matrix
     * 
     * @return int[][] transpose of matrix
     */

    public int[][] transpose() {
        int compactTransposeMatrix[][] = new int[3][compactMatrix[0].length];
        int transposeMatrix[][] = new int[column][row];
        for (int i = 0; i < compactMatrix[0].length; i++) {
            compactTransposeMatrix[0][i] = compactMatrix[1][i];
            compactTransposeMatrix[1][i] = compactMatrix[0][i];
            compactTransposeMatrix[2][i] = compactMatrix[2][i];
        }
        for (int i = 0; i < transposeMatrix.length; i++) {
            for (int j = 0; j < transposeMatrix[0].length; j++) {
                transposeMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < compactTransposeMatrix[0].length; i++) {
            transposeMatrix[compactTransposeMatrix[0][i]][compactTransposeMatrix[1][i]] = compactTransposeMatrix[2][i];
        }
        return transposeMatrix;
    }

    /**
     * It will check whether matrix is symmetric or not 
     * The time complexity for checking a matrix to be symmetric is O(n)
     * where n is number of column 
     * 
     * @return boolean
     */
    boolean isSymmetrical() {
        boolean isMatrixSymmetrical = true;
        if (row != column) {
            throw new AssertionError(
                    "Matrix should be Square for checking Symmetricity");
        }
        int compactTransposeMatrix[][] = new int[3][compactMatrix[0].length];
        for (int i = 0; i < compactMatrix[0].length; i++) {
            compactTransposeMatrix[0][i] = compactMatrix[1][i];
            compactTransposeMatrix[1][i] = compactMatrix[0][i];
            compactTransposeMatrix[2][i] = compactMatrix[2][i];
        }

        compactTransposeMatrix = sort(compactTransposeMatrix);
        for (int i = 0; i < compactMatrix.length; i++) {
            if (compactMatrix[i][0] != compactTransposeMatrix[i][0]
                    && compactMatrix[i][1] != compactTransposeMatrix[i][1]) {
                isMatrixSymmetrical = false;
            }
        }
        return isMatrixSymmetrical;
    }

    /**
     * It will add two matrices 
     * The time complexity for addition of two matrix is O(m+n) where 
     * m is number of columns in first matrix and n is number of
     * columns in second matrix
     * 
     * @param matrix1
     * @param matrix2
     * @return int[][] addition of two matrices
     */
    public static int[][] addition(SparseMatrix matrix1, SparseMatrix matrix2) {
        if ((matrix1.row != matrix2.row) || (matrix1.column != matrix2.column)) {
            throw new AssertionError("Matrix size should be Equal");
        }
        int additionMatrix[][] = new int[3][matrix1.compactMatrix[0].length
                + matrix2.compactMatrix[0].length];
        int resultantMatrix[][] = new int[matrix1.row][matrix2.column];
        int i = 0;
        int j = 0;
        int count = 0;
        int k = 0;
        while (i < matrix1.compactMatrix[0].length
                && j < matrix2.compactMatrix[0].length) {
            if (matrix1.compactMatrix[0][i] < matrix2.compactMatrix[0][j]) {
                count++;
                additionMatrix[0][k] = matrix1.compactMatrix[0][i];
                additionMatrix[1][k] = matrix1.compactMatrix[1][i];
                additionMatrix[2][k] = matrix1.compactMatrix[2][i];
                i++;
                k++;
            } else if (matrix1.compactMatrix[0][i] > matrix2.compactMatrix[0][j]) {
                count++;
                additionMatrix[0][k] = matrix2.compactMatrix[0][j];
                additionMatrix[1][k] = matrix2.compactMatrix[1][j];
                additionMatrix[2][k] = matrix2.compactMatrix[2][j];
                j++;
                k++;
            } else if (matrix1.compactMatrix[1][i] < matrix2.compactMatrix[1][j]) {
                count++;
                additionMatrix[0][k] = matrix1.compactMatrix[0][i];
                additionMatrix[1][k] = matrix1.compactMatrix[1][i];
                additionMatrix[2][k] = matrix1.compactMatrix[2][i];
                i++;
                k++;
            } else if (matrix1.compactMatrix[1][i] > matrix2.compactMatrix[1][j]) {
                count++;
                additionMatrix[0][k] = matrix2.compactMatrix[0][j];
                additionMatrix[1][k] = matrix2.compactMatrix[1][j];
                additionMatrix[2][k] = matrix2.compactMatrix[2][j];
                j++;
                k++;
            } else {
                count++;
                additionMatrix[0][k] = matrix1.compactMatrix[0][i];
                additionMatrix[1][k] = matrix1.compactMatrix[1][i];
                additionMatrix[2][k] = matrix1.compactMatrix[2][i]
                        + matrix2.compactMatrix[2][j];
                i++;
                j++;
                k++;

            }
        }

        while (i < matrix1.compactMatrix[0].length) {
            count++;
            additionMatrix[0][k] = matrix1.compactMatrix[0][i];
            additionMatrix[1][k] = matrix1.compactMatrix[1][i];
            additionMatrix[2][k] = matrix1.compactMatrix[2][i];
            i++;
            k++;
        }

        while (j < matrix2.compactMatrix[0].length) {
            count++;
            additionMatrix[0][k] = matrix1.compactMatrix[0][j];
            additionMatrix[1][k] = matrix1.compactMatrix[1][j];
            additionMatrix[2][k] = matrix1.compactMatrix[2][j];
            j++;
            k++;
        }

        k = 0;
        for (i = 0; i < resultantMatrix.length; i++) {
            for (j = 0; j < resultantMatrix[0].length; j++) {
                if (additionMatrix[0][k] == i && additionMatrix[1][k] == j) {
                    resultantMatrix[i][j] = additionMatrix[2][k++];
                } else {
                    resultantMatrix[i][j] = 0;
                }
            }
        }
        return resultantMatrix;
    }

    /**
     * It will multiply two matrices 
     * The time complexity of multiplying two matrices is O(m*n) where 
     * m is number of columns in first matrix and n is number of columns in second matrix 
     * 
     * @param matrix1
     * @param matrix2
     * @return multiplication of two matrix
     */
    public static int[][] multiplySparseMatrix(SparseMatrix matrix1,
            SparseMatrix matrix2) {
        if (matrix1.column != matrix2.row) {
            throw new AssertionError(
                    "No of Columns of Matrix1 should be equal to No of Rows in Matrix2 for multiplication");
        }
        int multiplyMatrix[][] = new int[matrix1.row][matrix2.column];
        for (int i = 0; i < matrix1.compactMatrix[0].length; i++) {
            for (int j = 0; j < matrix2.compactMatrix[0].length; j++) {
                if (matrix1.compactMatrix[1][i] == matrix2.compactMatrix[0][j]) {
                    multiplyMatrix[matrix1.compactMatrix[0][i]][matrix2.compactMatrix[1][j]] += matrix1.compactMatrix[2][i]
                            * matrix2.compactMatrix[2][j];
                }
            }
        }
        return multiplyMatrix;
    }
}
