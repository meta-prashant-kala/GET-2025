import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class NQueenProblemTest {

    @Test
    public void getQueenPlacedArrayListTest1() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 4;
        nQueenObj.initialiseNQueenBoard(dimension);
        ArrayList<ArrayList<Integer>> placedQueensBoardArrayList = new ArrayList<ArrayList<Integer>>();
        assertEquals(true, nQueenObj.getQueenPlacedArrayList(placedQueensBoardArrayList, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayListTest2() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 3;
        nQueenObj.initialiseNQueenBoard(dimension);
        ArrayList<ArrayList<Integer>> placedQueensBoardArrayList = new ArrayList<ArrayList<Integer>>();
        assertEquals(false, nQueenObj.getQueenPlacedArrayList(placedQueensBoardArrayList, 1, dimension));
    }

    @Test
    public void getQueenPlacedArrayListTest3() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 2;
        nQueenObj.initialiseNQueenBoard(dimension);
        ArrayList<ArrayList<Integer>> placedQueensBoardArrayList = new ArrayList<ArrayList<Integer>>();
        assertEquals(false, nQueenObj.getQueenPlacedArrayList(placedQueensBoardArrayList, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayListTest4() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 1;
        nQueenObj.initialiseNQueenBoard(dimension);
        ArrayList<ArrayList<Integer>> placedQueensBoardArrayList = new ArrayList<ArrayList<Integer>>();
        assertEquals(true, nQueenObj.getQueenPlacedArrayList(placedQueensBoardArrayList, 0, dimension));
    }

    @Test
    public void getQueenPlacedArrayListTest5() {
        NQueenProblem nQueenObj = new NQueenProblem();
        int dimension = 5;
        nQueenObj.initialiseNQueenBoard(dimension);
        ArrayList<ArrayList<Integer>> placedQueensBoardArrayList = new ArrayList<ArrayList<Integer>>();
        assertEquals(true, nQueenObj.getQueenPlacedArrayList(placedQueensBoardArrayList, 3, dimension));
    }
}
