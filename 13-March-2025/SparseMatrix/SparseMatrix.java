public class SparseMatrix {

    private int[][] sparseMatrix;
    private int originalMatrixRows;
    private int originalMatrixColumns;

    SparseMatrix(int[][] inputMatrix) {
        this.originalMatrixRows = inputMatrix.length;
        this.originalMatrixColumns = inputMatrix[0].length;
        int numOfNonZeroEle = 0;
        for (int[] row : inputMatrix) {
            for (int column : row) {
                if (row[column] != 0) {
                    numOfNonZeroEle++;
                }
            }
        }
        this.sparseMatrix = new int[3][numOfNonZeroEle];
        int sparseMatrixColIterator = 0;
        for (int row = 0; row < inputMatrix.length; row++) {
            for (int column = 0; column < inputMatrix[row].length; column++) {
                if (inputMatrix[row][column] != 0) {
                    sparseMatrix[0][sparseMatrixColIterator] = row;
                    sparseMatrix[1][sparseMatrixColIterator] = column;
                    sparseMatrix[2][sparseMatrixColIterator] = inputMatrix[row][column];
                }
            }
        }
    }

    public void displayMatrix() {
        // int sparseMatrixRowIterator=0;
        int sparseMatrixColIterator = 0;
        for (int row = 0; row < originalMatrixRows; row++) {
            for (int column = 0; column < originalMatrixColumns; column++) {
                if (row == sparseMatrix[0][sparseMatrixColIterator]
                        && column == sparseMatrix[1][sparseMatrixColIterator]) {
                    System.out.print(sparseMatrix[2][sparseMatrixColIterator]);
                    sparseMatrixColIterator++;
                } else {
                    System.out.print(0);
                }
                System.out.println(" ");
            }
            System.out.println();
        }
    }

    public int[][] transposeMatrix() {
        int[][] transposeMatrix=new int[sparseMatrix.length][sparseMatrix[0].length];
        for (int col = 0; col < sparseMatrix.length; col++) {
            transposeMatrix[1][col] = sparseMatrix[0][col];
            transposeMatrix[0][col]=sparseMatrix[1][0];
            transposeMatrix[2][col]=sparseMatrix[2][col];
        }
        return transposeMatrix;
    }


}