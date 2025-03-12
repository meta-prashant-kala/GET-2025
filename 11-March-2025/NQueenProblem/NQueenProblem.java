import java.util.ArrayList;

public class NQueenProblem {

    ArrayList<ArrayList<Integer>> nQueenBoardArrayList = new ArrayList<ArrayList<Integer>>();

    /**
     * Method to initialise the NQueen Board
     * 
     * @param dimension should be of type integer
     */
    public void initialiseNQueenBoard(int dimension) {
        for (int i = 0; i < dimension; i++) {
            ArrayList<Integer> eachRowNQueenBoardArrayList = new ArrayList<Integer>();
            for (int j = 0; j < dimension; j++) {
                eachRowNQueenBoardArrayList.add(0);
            }
            nQueenBoardArrayList.add(eachRowNQueenBoardArrayList);
        }

    }

    /**
     * Method to check if queen is placed previously in the upper rows of same
     * column
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queens are placed in the upper rows of same column, false
     *         if queen is placed in one of the upper row of same colun
     */
    boolean isUpRowPossible(int row, int column) {
        if (row < 0) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isUpRowPossible(row - 1, column);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed in the next rows of same column
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queens are placed in any next row of same column, false if
     *         queen is placed in one of next row of same colun
     */
    boolean isDownRowPossible(int row, int column) {
        if (row == nQueenBoardArrayList.size()) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isDownRowPossible(row + 1, column);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed in any of the next columns of same
     * row
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queens are placed in the next right column of same row,
     *         false
     *         if queen is placed in one of the next right column of same row
     */
    boolean isRightColumnPossible(int row, int column) {
        if (column == nQueenBoardArrayList.size()) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isRightColumnPossible(row, column + 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed previously in the left column of same row
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queens are placed in the left columns of same row, false
     *         if queen is placed in one of the left column of same row
     */
    boolean isLeftColumnPossible(int row, int column) {
        if (column < 0) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isLeftColumnPossible(row, column - 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed previously in the upper left diagonal
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queen is placed in the upper left diagonal, false if queen
     *         is placed in any of the upper left diagonal
     */
    boolean isLeftUpDiagonalPossible(int row, int column) {
        if (column < 0 || row < 0) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isLeftUpDiagonalPossible(row - 1, column - 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed previously in the lower left diagonal
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queen is placed in the lower left diagonal, false if queen
     *         is placed in any of the lower left diagonal
     */
    boolean isLeftDownDiagonalPossible(int row, int column) {
        if (column < 0 || row == nQueenBoardArrayList.size()) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isLeftDownDiagonalPossible(row + 1, column - 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed previously in the upper right diagonal
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queen is placed in the upper right diagonal, false if
     *         queen is placed in any of the upper right diagonal
     */
    boolean isRightUpDiagonalPossible(int row, int column) {
        if (column == nQueenBoardArrayList.size() || row < 0) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isRightUpDiagonalPossible(row - 1, column + 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if queen is placed previously in the lower right diagonal
     * 
     * @param row    should be of type integer
     * @param column should be of type integer
     * @return true is no queen is placed in the lower right diagonal, false if
     *         queen is placed in any of the lower right diagonal
     */
    boolean isRightDownDiagonalPossible(int row, int column) {
        if (column == nQueenBoardArrayList.size() || row == nQueenBoardArrayList.size()) {
            return true;
        }
        if ((nQueenBoardArrayList.get(row)).get(column) == 0) {
            return isRightDownDiagonalPossible(row + 1, column + 1);
        } else {
            return false;
        }
    }

    /**
     * Method to check if it is safe to place a queen at the given row, column index
     * by checking every direction till end if queen is previously placed or not
     * 
     * @param row    should be of intger type
     * @param column should be of integer type
     * @return true if no queen is previously placed in any of the eight direction,
     *         false if queen is placed
     *         previously in any of the eight direction
     */
    boolean isSafe(int row, int column) {
        boolean isPossible = isUpRowPossible(row, column) && isDownRowPossible(row, column)
                && isRightColumnPossible(row, column) && isLeftColumnPossible(row, column)
                && isLeftUpDiagonalPossible(row, column) && isLeftDownDiagonalPossible(row, column)
                && isRightUpDiagonalPossible(row, column) && isRightDownDiagonalPossible(row, column)
                && isRightDownDiagonalPossible(row, column);
        return isPossible;
    }

    /**
     * Method to traverse every column of each row, staring from the startRow row
     * index. If it is possible to place queen in every row, the method updates the
     * input arraylist with placed queen indexes
     * 
     * @param placedQueensChessBoardArrayList input ArrayList<Integer> in which
     *                                        queen should be placed
     * @param startRow                        index of the starting row
     * @param rowsCovered                     count of rows covered
     * @param dimension                       is the size of the board
     * @param isAllRowsCovered                checks if every row is covered, shows
     *                                        we found an answer
     * @return
     */
    boolean placeQueens(ArrayList<ArrayList<Integer>> placedQueensBoardArrayList, int startRow,
            int rowsCovered, int dimension, boolean isAllRowsCovered) {

        // Base case if all the rows covered push the array in the input array
        if (rowsCovered == dimension) {
            for (ArrayList<Integer> eachRowOfNQueenBoard : nQueenBoardArrayList) {
                placedQueensBoardArrayList.add(eachRowOfNQueenBoard);
            }
            return true;
        }

        // Checking for every column of possible rows
        for (int column = 0; column < dimension; column++) {
            if (isSafe(startRow, column)) {
                (nQueenBoardArrayList.get(startRow)).set(column, 1);
                isAllRowsCovered = placeQueens(placedQueensBoardArrayList, (startRow + 1) % dimension,
                        rowsCovered + 1, dimension, isAllRowsCovered);
                if (isAllRowsCovered) {
                    return true;
                }
                (nQueenBoardArrayList.get(startRow)).set(column, 0);
            }

        }
        return false;
    }

    /**
     * Method that fills the input arraylistboard with queen places if possible
     * 
     * @param placedQueensBoardArrayList input ArrayList<Integer> in which queen
     *                                   should be placed
     * @param startRow                   index of the starting row
     * @param dimension                  is the size of the board
     * @return return true if queen is placed in every row with updated input
     *         placedQueenArrayList with queen places and false if queen is not
     *         placed in every row
     */
    public boolean getQueenPlacedArrayList(ArrayList<ArrayList<Integer>> placedQueensBoardArrayList, int startIndex,
            int dimension) {
        int rowsCovered = 0;
        boolean isAllRowsCovered = false;
        isAllRowsCovered = placeQueens(placedQueensBoardArrayList, startIndex, rowsCovered, dimension,
                isAllRowsCovered);
        return isAllRowsCovered;
    }
}
