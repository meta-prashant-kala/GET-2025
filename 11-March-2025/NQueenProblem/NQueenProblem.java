import java.util.ArrayList;

public class NQueenProblem {

    ArrayList<ArrayList<Integer>> chessBoardArrayList = new ArrayList<ArrayList<Integer>>();

    NQueenProblem(int dimension) {
        for (int i = 0; i < dimension; i++) {
            ArrayList<Integer> eachRowChessBoardArrayList = new ArrayList<Integer>();
            for (int j = 0; j < dimension; j++) {
                eachRowChessBoardArrayList.add(0);
            }
            chessBoardArrayList.add(eachRowChessBoardArrayList);
        }

    }

    boolean isUpRowPossible(int row, int column) {
        if (row < 0) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isUpRowPossible(row - 1, column);
        } else {
            return false;
        }
    }

    boolean isDownRowPossible(int row, int column) {
        if (row == chessBoardArrayList.size()) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isDownRowPossible(row + 1, column);
        } else {
            return false;
        }
    }

    boolean isRightColumnPossible(int row, int column) {
        if (column == chessBoardArrayList.size()) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isRightColumnPossible(row, column + 1);
        } else {
            return false;
        }
    }

    boolean isLeftColumnPossible(int row, int column) {
        if (column < 0) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isLeftColumnPossible(row, column - 1);
        } else {
            return false;
        }
    }

    boolean isLeftUpDiagonalPossible(int row, int column) {
        if (column < 0 || row < 0) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isLeftUpDiagonalPossible(row - 1, column - 1);
        } else {
            return false;
        }
    }

    boolean isLeftDownDiagonalPossible(int row, int column) {
        if (column < 0 || row == chessBoardArrayList.size()) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isLeftDownDiagonalPossible(row + 1, column - 1);
        } else {
            return false;
        }
    }

    boolean isRightUpDiagonalPossible(int row, int column) {
        if (column == chessBoardArrayList.size() || row < 0) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isRightUpDiagonalPossible(row - 1, column + 1);
        } else {
            return false;
        }
    }

    boolean isRightDownDiagonalPossible(int row, int column) {
        if (column == chessBoardArrayList.size() || row == chessBoardArrayList.size()) {
            return true;
        }
        if ((chessBoardArrayList.get(row)).get(column) == 0) {
            return isRightDownDiagonalPossible(row + 1, column + 1);
        } else {
            return false;
        }
    }

    boolean isSafe(int row, int column) {
        boolean isPossible = isUpRowPossible(row, column) && isDownRowPossible(row, column)
                && isRightColumnPossible(row, column) && isLeftColumnPossible(row, column)
                && isLeftUpDiagonalPossible(row, column) && isLeftDownDiagonalPossible(row, column)
                && isRightUpDiagonalPossible(row, column) && isRightDownDiagonalPossible(row, column)
                && isRightDownDiagonalPossible(row, column);
        return isPossible;
    }

    public boolean placeQueens(ArrayList<ArrayList<Integer>> placedQueensChessBoardArrayList, int startRow,
            int rowsCovered, int dimension, boolean isAllRowsCovered) {

        // Base case if all the rows covered push the array in the input array
        if (rowsCovered == dimension && !isAllRowsCovered) {
            for (int i = 0; i < dimension; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j < chessBoardArrayList.size(); j++) {
                    temp.add((chessBoardArrayList.get(i).get(j)));
                }
                placedQueensChessBoardArrayList.add(temp);
            }
            return isAllRowsCovered = true;
        }

        
        for (int column = 0; column < dimension; column++) {
            if (isAllRowsCovered) {
                return true;
            }
            if (isSafe(startRow, column) && !isAllRowsCovered) {
                (chessBoardArrayList.get(startRow)).set(column, 1);
                placeQueens(placedQueensChessBoardArrayList, (startRow + 1) % dimension,
                        rowsCovered + 1, dimension, isAllRowsCovered);
                if (isAllRowsCovered) {
                    return true;
                }
                (chessBoardArrayList.get(startRow)).set(column, 0);
            }
        }
        return isAllRowsCovered;
    }

    boolean getQueenPlacedArrayList(ArrayList<ArrayList<Integer>> placedQueensChessBoardArrayList, int startIndex,
            int dimension) {
        int rowsCovered = 0;
        boolean isAllRowsCovered = false;
        isAllRowsCovered = placeQueens(placedQueensChessBoardArrayList, startIndex, rowsCovered, dimension,
                isAllRowsCovered);
        for (ArrayList<Integer> temp : placedQueensChessBoardArrayList) {
            System.out.println(temp);
        }
        return isAllRowsCovered;
    }
}
