/**
 * It will compute whether N chess queens on an N×N chessboard can be placed so
 * that no two queens attack each other
 * 
 * @author Shubham Jain
 */
public class NQueens {

    /**
     * This function is to check if a queen can be placed on board[row][column]
     * This function is called when "row" number of queens are already placed in board
     *
     * @param board
     * @param row
     * @param column
     * @return
     */
    boolean isSafe(int board[][], int row, int column) {
        int rowIndex;
        int columnIndex;

        /* Check this column on upper side */
        for (rowIndex = 0; rowIndex < row; rowIndex++) {
            if (board[rowIndex][column] == 1) {
                return false;
            }
        }

        /* Check upper diagonal on left side */
        for (rowIndex = row, columnIndex = column; rowIndex >= 0
                && columnIndex >= 0; rowIndex--, columnIndex--) {
            if (board[rowIndex][columnIndex] == 1) {
                return false;
            }
        }

        /* Check upper diagonal on right side */
        for (rowIndex = row, columnIndex = column; columnIndex < board.length
                && rowIndex >= 0; rowIndex--, columnIndex++)
            if (board[rowIndex][columnIndex] == 1) {
                return false;
            }
        return true;
    }

    /**
     * This method will solve the N Queens problem
     * 
     * @param board
     * @param startRow
     * @param dimensionOfMatrix
     * @return true if queens can be placed otherwise false
     */
    Boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {

        /*
         * base case: If all queens are placed then return true
         */
        if (startRow >= dimensionOfMatrix) {
            return true;
        }

        /*
         * Consider this row and try placing this queen in all columns one by one
         */
        for (int i = 0; i < dimensionOfMatrix; i++) {
            if (isSafe(board, startRow, i)) {
                board[startRow][i] = 1;
                if (nQueen(board, startRow + 1, dimensionOfMatrix)) {
                    return true;
                }
                board[startRow][i] = 0;
            }
        }
        return false;
    }
}
