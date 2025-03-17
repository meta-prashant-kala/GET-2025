import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);

        int[][] inputMatrix1;
        int matrix1Rows;
        int matrix1Columns;
        SparseMatrix sparseMatrixObj1;

        int[][] inputMatrix2;
        int matrix2Rows;
        int matrix2Columns;
        SparseMatrix sparseMatrixObj2;

        int row = 0;
        int column = 0;

        // Taking dimensions input for Matrix-1
        while (true) {
            try {
                System.out.println("Enter the number of rows");
                matrix1Rows = Integer.parseInt(scanInput.nextLine());

                System.out.println("Enter the number of columns");
                matrix1Columns = Integer.parseInt(scanInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid integers");
                continue;
            }
        }

        // Creating the (matrix1Rows * matrix1Columns) matrix for the input dimension
        inputMatrix1 = new int[matrix1Rows][matrix1Columns];

        // Taking the Matrix-1 elements as input
        while (row < matrix1Rows) {
            System.out.println("Enter all elements of row " + row);
            while (true) {

                // Taking whole row as input
                String rowElements = scanInput.nextLine();

                // Extracting digits of a row from the the string input
                String[] rowDigits = rowElements.split(" ");

                if (rowDigits.length != matrix1Columns) {
                    System.out.println("Digits in a row cannot be more than " + matrix1Columns);
                    continue;
                }

                // Parsing the digits to int and storing it to the matrix
                column = 0;
                while (column < matrix1Columns) {
                    try {
                        inputMatrix1[row][column] = Integer.parseInt(rowDigits[column]);
                        column++;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid row of integers");
                        continue;
                    }
                }

                break;
            }
            row++;
        }

        // Creating sparse matrix object
        System.out.println();
        sparseMatrixObj1 = new SparseMatrix(inputMatrix1);
        System.out.println();

        int selectedOption = 1;

        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To get the transpose of the given matrix");
            System.out.println("2. To check if the given matrix is symmetric");
            System.out.println("3. To add two matrix");
            System.out.println("4. To multiply two matrix");
            System.out.println("0. To exit from the app");

            // Taking selected option as input from the user
            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {
                case 1:
                    SparseMatrix transposedsparseMatrixObj = sparseMatrixObj1.transposeMatrix();
                    transposedsparseMatrixObj.displayMatrix();
                    break;

                case 2:
                    sparseMatrixObj1.displayMatrix();
                    if (sparseMatrixObj1.isSymetric()) {
                        System.out.println("is a symmetric matrix");
                    } else {
                        System.out.println("is a not symmetric matrix");

                    }
                    break;

                case 3:
                    while (true) {
                        try {
                            System.out.println("Enter the number of rows of second matrix");
                            matrix2Rows = Integer.parseInt(scanInput.nextLine());

                            System.out.println("Enter the number of columns of second matrix");
                            matrix2Columns = Integer.parseInt(scanInput.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid integer");
                            continue;
                        }
                    }

                    inputMatrix2 = new int[matrix2Rows][matrix2Columns];
                    row = 0;
                    column = 0;

                    while (row < matrix1Rows) {
                        System.out.println("Enter all elements of row " + row);
                        while (true) {
                            String rowElements = scanInput.nextLine();

                            String[] rowDigits = rowElements.split(" ");

                            if (rowDigits.length != matrix2Columns) {
                                System.out.println("Digits in a row cannot be more than " + matrix2Columns);
                                continue;
                            }

                            column = 0;
                            while (column < matrix2Columns) {
                                try {
                                    inputMatrix2[row][column] = Integer.parseInt(rowDigits[column]);
                                    column++;
                                } catch (NumberFormatException e) {
                                    System.out.println("Please enter a valid row of integers");
                                    continue;
                                }
                            }

                            break;
                        }
                        row++;
                    }
                    sparseMatrixObj2 = new SparseMatrix(inputMatrix2);
                    SparseMatrix addedSparseMatrixObj = sparseMatrixObj1.add(sparseMatrixObj2);
                    System.out.println();
                    System.out.println("Added Matrix");
                    System.out.println();
                    addedSparseMatrixObj.displayMatrix();
                    System.out.println();
                    break;

                case 4:
                    while (true) {
                        try {
                            System.out.println("Enter the number of rows of second matrix");
                            matrix2Rows = Integer.parseInt(scanInput.nextLine());

                            System.out.println("Enter the number of columns of second matrix");
                            matrix2Columns = Integer.parseInt(scanInput.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid integer");
                            continue;
                        }
                    }

                    inputMatrix2 = new int[matrix2Rows][matrix2Columns];
                    row = 0;
                    column = 0;

                    while (row < matrix1Rows) {
                        System.out.println("Enter all elements of row " + row);
                        while (true) {
                            String rowElements = scanInput.nextLine();

                            String[] rowDigits = rowElements.split(" ");

                            if (rowDigits.length != matrix2Columns) {
                                System.out.println("Digits in a row cannot be more than " + matrix2Columns);
                                continue;
                            }

                            column = 0;
                            while (column < matrix2Columns) {
                                try {
                                    inputMatrix2[row][column] = Integer.parseInt(rowDigits[column]);
                                    column++;
                                } catch (NumberFormatException e) {
                                    System.out.println("Please enter a valid row of integers");
                                    continue;
                                }
                            }

                            break;
                        }
                        row++;
                    }
                    sparseMatrixObj2 = new SparseMatrix(inputMatrix2);
                    SparseMatrix multipliedSparseMatrixObj = sparseMatrixObj1.multiply(sparseMatrixObj2);
                    System.out.println();
                    System.out.println("Multiplied Matrix");
                    System.out.println();
                    multipliedSparseMatrixObj.displayMatrix();
                    System.out.println();
                    break;

                default:
                    break;
            }

        }
        scanInput.close();
    }
}
