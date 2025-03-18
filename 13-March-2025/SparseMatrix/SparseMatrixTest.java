import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SparseMatrixTest {
    @Test
    public void transposeTest1() {
        int[][] inputArr = {
                { 0, 0, 2, 0 },
                { 0, 4, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 2, 2 }
        };
        SparseMatrix inputMatrix = new SparseMatrix(inputArr);

        int[][] expectedArr = {
                { 0, 0, 1, 0 },
                { 0, 4, 0, 0 },
                { 2, 0, 0, 2 },
                { 0, 0, 0, 2 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix.transposeMatrix());
    }

    @Test
    public void transposeTest2() {
        int[][] inputArr = {
                { 0, 0, 2, 0, 5 },
                { 0, 4, 0, 0, 0 },
                { 1, 0, 0, 0, 2 },
                { 0, 0, 2, 2, 8 }
        };
        SparseMatrix inputMatrix = new SparseMatrix(inputArr);

        int[][] expectedArr = {
                { 0, 0, 1, 0 },
                { 0, 4, 0, 0 },
                { 2, 0, 0, 2 },
                { 0, 0, 0, 2 },
                { 5, 0, 2, 8 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix.transposeMatrix());
    }

    @Test
    public void isSymmetricTest1() {
        int[][] inputArr = {
                { 0, 0, 2, 0 },
                { 0, 4, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 2, 2 }
        };
        SparseMatrix inputMatrix = new SparseMatrix(inputArr);

        assertEquals(false, inputMatrix.isSymetric());
    }

    @Test
    public void isSymmetricTest2() {
        int[][] inputArr = {
                { 0, 0, 2, 0 },
                { 0, 4, 0, 0 },
                { 2, 0, 0, 2 },
                { 0, 0, 2, 2 }
        };
        SparseMatrix inputMatrix = new SparseMatrix(inputArr);

        assertEquals(true, inputMatrix.isSymetric());
    }

    @Test
    public void addMatrixTest1() {
        int[][] inputArr1 = {
                { 0, 0, 2 },
                { 0, 4, 0 },
                { 1, 0, 2 },
        };
        SparseMatrix inputMatrix1 = new SparseMatrix(inputArr1);

        int[][] inputArr2 = {
                { 0, 2, 0 },
                { 0, 0, 0 },
                { 3, 0, 4 },
        };
        SparseMatrix inputMatrix2 = new SparseMatrix(inputArr2);
        int[][] expectedArr = {
                { 0, 2, 2 },
                { 0, 4, 0 },
                { 4, 0, 6 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix1.add(inputMatrix2));
    }

    @Test
    public void addMatrixTest2() {
        int[][] inputArr1 = {
                { 0, 0, 2 },
                { 0, 4, 0 },
                { 1, 0, 2 },
        };
        SparseMatrix inputMatrix1 = new SparseMatrix(inputArr1);

        int[][] inputArr2 = {
                { 0, 2, 0 },
                { 0, 0, 0 },
                { 3, 0, 4 },
        };
        SparseMatrix inputMatrix2 = new SparseMatrix(inputArr2);
        int[][] expectedArr = {
                { 0, 2, 2 },
                { 0, 4, 0 },
                { 4, 0, 6 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix1.add(inputMatrix2));
    }

    @Test
    public void multiplyMatrixTest1() {
        int[][] inputArr1 = {
                { 0, 2 },
                { 2, 0 },
        };
        SparseMatrix inputMatrix1 = new SparseMatrix(inputArr1);

        int[][] inputArr2 = {
                { 2 },
                { 0 }
        };
        SparseMatrix inputMatrix2 = new SparseMatrix(inputArr2);
        int[][] expectedArr = {
                { 0 },
                { 4 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix1.multiply(inputMatrix2));
    }

    @Test
    public void multiplyMatrixTest2() {
        int[][] inputArr1 = {
                { 1, 2, 3 },
                { 0, 1, 2 },
                { 0, 0, 1 }
        };
        SparseMatrix inputMatrix1 = new SparseMatrix(inputArr1);

        int[][] inputArr2 = {
                { 1, 2 },
                { 1, 2 },
                { 1, 2 }
        };
        SparseMatrix inputMatrix2 = new SparseMatrix(inputArr2);
        int[][] expectedArr = {
                { 6, 12 },
                { 3, 6 },
                { 1, 2 }
        };
        SparseMatrix expectedMatrix = new SparseMatrix(expectedArr);
        assertEquals(expectedMatrix, inputMatrix1.multiply(inputMatrix2));
    }
}
