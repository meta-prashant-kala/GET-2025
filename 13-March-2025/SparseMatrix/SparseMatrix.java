public class SparseMatrix {

    private int[][] sparseMatrix;
    private int originalMatrixRows;
    private int originalMatrixColumns;

    public int[][] getSparseMatrix() {
        return sparseMatrix;
    }

    /**
     * Constructor to create a saprsematrix from the given input matrix
     * 
     * @param inputMatrix shlould be of type int, containing elements of sparse
     *                    matrix
     */
    SparseMatrix(int[][] inputMatrix) {
        this.originalMatrixRows = inputMatrix.length;
        this.originalMatrixColumns = inputMatrix[0].length;
        int numOfNonZeroEle = 0;
        for (int[] row : inputMatrix) {
            for (int column : row) {
                if (column != 0) {
                    numOfNonZeroEle++;
                }
            }
        }
        this.sparseMatrix = new int[3][numOfNonZeroEle];
        int sparseMatrixColIterator = 0;
        for (int row = 0; row < inputMatrix.length; row++) {
            for (int column = 0; column < inputMatrix[0].length; column++) {
                if (inputMatrix[row][column] != 0) {
                    sparseMatrix[0][sparseMatrixColIterator] = row;
                    sparseMatrix[1][sparseMatrixColIterator] = column;
                    sparseMatrix[2][sparseMatrixColIterator] = inputMatrix[row][column];
                    sparseMatrixColIterator++;
                }
            }
        }
    }

    /**
     * Method to display the Original matrix that is stored in the form of sparse
     * matrix
     */
    public void displayMatrix() {
        int rowElement;
        int columnElement;
        int value;
        int[][] matrix = new int[this.originalMatrixRows][this.originalMatrixColumns];

        for (int col = 0; col < this.sparseMatrix[0].length; col++) {
            rowElement = sparseMatrix[0][col];
            columnElement = sparseMatrix[1][col];
            value = sparseMatrix[2][col];
            matrix[rowElement][columnElement] = value;
        }

        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    /**
     * Method to construct the original matrix from the sparse matrix
     * 
     * @return original int matrix for the sparse matrix
     */
    public int[][] constructMatrix() {
        int rowElement;
        int columnElement;
        int value;
        int[][] matrix = new int[this.originalMatrixRows][this.originalMatrixColumns];

        for (int col = 0; col < this.sparseMatrix[0].length; col++) {
            rowElement = sparseMatrix[0][col];
            columnElement = sparseMatrix[1][col];
            value = sparseMatrix[2][col];
            matrix[rowElement][columnElement] = value;
        }

        return matrix;
    }

    /**
     * Method to transpose a matrix
     * 
     * @return object of Sparsematrix type holding the transposed sparse matrix
     */
    public SparseMatrix transposeMatrix() {
        int[][] transposeMatrix = new int[this.originalMatrixColumns][this.originalMatrixRows];
        for (int col = 0; col < this.sparseMatrix[0].length; col++) {
            transposeMatrix[this.sparseMatrix[1][col]][this.sparseMatrix[0][col]] += this.sparseMatrix[2][col];
        }
        SparseMatrix trasposedSparseMatrixObj = new SparseMatrix(transposeMatrix);
        return trasposedSparseMatrixObj;
    }

    /**
     * Method to check if a matrix is symmetrix or not
     * 
     * @return true if the matrix is symmetrix and false if the matrix is not
     *         symmetric
     */
    public boolean isSymetric() {
        SparseMatrix trasposedSparseMatrixObj = this.transposeMatrix();
        for (int col = 0; col < this.sparseMatrix.length; col++) {
            if (this.sparseMatrix[0][col] != trasposedSparseMatrixObj.sparseMatrix[0][col]) {
                return false;
            }
            if (this.sparseMatrix[1][col] != trasposedSparseMatrixObj.sparseMatrix[1][col]) {
                return false;
            }
            if (this.sparseMatrix[2][col] != trasposedSparseMatrixObj.sparseMatrix[2][col]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to add the input matrix to the matrix for which the method is called
     * 
     * @param secondSparseMatrixObj should be of int type
     * @return spareseMatrix object holding the sparse matrix of added values
     */
    public SparseMatrix add(SparseMatrix secondSparseMatrixObj) {

        if (this.originalMatrixRows != secondSparseMatrixObj.originalMatrixRows) {
            throw new IllegalArgumentException("Dimension must be equal to add to matrix");
        }
        if (this.originalMatrixColumns != secondSparseMatrixObj.originalMatrixColumns) {
            throw new IllegalArgumentException("Dimension must be equal to add to matrix");
        }

        int[][] addedMatrix = new int[this.originalMatrixRows][this.originalMatrixColumns];
        for (int col = 0; col < this.sparseMatrix[0].length; col++) {
            int rowValue = this.sparseMatrix[0][col];
            int columnValue = this.sparseMatrix[1][col];
            int value = this.sparseMatrix[2][col];
            addedMatrix[rowValue][columnValue] += value;
        }
        for (int col = 0; col < secondSparseMatrixObj.sparseMatrix[0].length; col++) {
            int rowValue = secondSparseMatrixObj.sparseMatrix[0][col];
            int columnValue = secondSparseMatrixObj.sparseMatrix[1][col];
            int value = secondSparseMatrixObj.sparseMatrix[2][col];
            addedMatrix[rowValue][columnValue] += value;
        }
        SparseMatrix addSparseMatrixObj = new SparseMatrix(addedMatrix);
        return addSparseMatrixObj;
    }

    /**
     * Method to Multiply the input matrix with the matrix for which the method is
     * called
     * 
     * @param secondSparseMatrixObj should be of int type
     * @return spareseMatrix object holding the sparse matrix of Multiplied values
     */
    public SparseMatrix multiply(SparseMatrix secondSparseMatrixObj) {
        int[][] matrix1 = this.constructMatrix();
        int[][] matrix2 = secondSparseMatrixObj.constructMatrix();

        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrix cannot be multiplied");
        }

        int[][] multipliedMatrix = new int[this.originalMatrixRows][secondSparseMatrixObj.originalMatrixColumns];

        for (int row = 0; row < matrix1.length; row++) {
            for (int column = 0; column < matrix2[0].length; column++) {
                int sum = 0;
                for (int k = 0; k < this.originalMatrixColumns; k++) {
                    System.out.println(this.sparseMatrix[row][k] + " " + secondSparseMatrixObj.sparseMatrix[k][column]);
                    sum += (matrix1[row][k]
                            * matrix2[k][column]);

                }
                multipliedMatrix[row][column] = sum;
            }
        }

        SparseMatrix multiplySparseMatrixObj = new SparseMatrix(multipliedMatrix);
        return multiplySparseMatrixObj;
    }


    @Override
    public boolean equals(Object o){
        SparseMatrix secondObj=(SparseMatrix)o;
        if(this.sparseMatrix.length!=secondObj.sparseMatrix.length){
            return false;
        }
        if(this.sparseMatrix[0].length!=secondObj.sparseMatrix[0].length){
            return false;
        }

        for(int i=0;i<this.sparseMatrix.length;i++){
            for(int j=0;j<secondObj.sparseMatrix[0].length;j++){
                if(this.sparseMatrix[i][j]!=secondObj.sparseMatrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}