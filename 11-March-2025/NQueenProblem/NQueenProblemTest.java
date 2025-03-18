import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class NQueenProblemTest {

    @Test
    public void getQueenPlacedArrayTest1() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 4;
        nQueenObj.initialiseNQueenBoard(dimension);
        int[][] placedQueensBoardArray = new int[dimension][dimension];
        assertEquals(true, nQueenObj.getQueenPlacedArray(placedQueensBoardArray, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayTest2() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 3;
        nQueenObj.initialiseNQueenBoard(dimension);
        int[][] placedQueensBoardArray = new int[dimension][dimension];
        assertEquals(false, nQueenObj.getQueenPlacedArray(placedQueensBoardArray, 1, dimension));
    }

    @Test
    public void getQueenPlacedArrayTest3() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 2;
        nQueenObj.initialiseNQueenBoard(dimension);
        int[][] placedQueensBoardArray = new int[dimension][dimension];
        assertEquals(false, nQueenObj.getQueenPlacedArray(placedQueensBoardArray, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayTest4() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 1;
        nQueenObj.initialiseNQueenBoard(dimension);
        int[][] placedQueensBoardArray = new int[dimension][dimension];
        assertEquals(true, nQueenObj.getQueenPlacedArray(placedQueensBoardArray, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayTest5() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 5;
        nQueenObj.initialiseNQueenBoard(dimension);
        int[][] placedQueensBoardArray = new int[dimension][dimension];
        assertEquals(true, nQueenObj.getQueenPlacedArray(placedQueensBoardArray, 3, dimension));
    }
}
