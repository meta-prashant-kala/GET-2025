import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> placedQueensChessBoardArrayList = new ArrayList<ArrayList<Integer>>();

        Scanner scanInput = new Scanner(System.in);
        NQueenProblem nQueenObj = new NQueenProblem();

        int dimension = 0;
        int startIndex = 0;

        while (true) {
            // Taking Dimension as input
            System.out.println("Enter the dimension of the Queen board ");
            try {
                dimension = Integer.parseInt(scanInput.nextLine());
                if (dimension == 0) {
                    System.out.println("Dimension cannot be 0");
                    continue;
                }
                if (dimension < 0) {
                    System.out.println("Dimension cannot be negetive");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid dimension number");
                continue;
            }
        }

        while (true) {
            // Taking starting index as input
            System.out.println("Enter the starting row");
            try {
                startIndex = Integer.parseInt(scanInput.nextLine());
                if (startIndex >= dimension) {
                    System.out.println("Starting index cannot be greater than dimension");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid starting index");
                continue;
            }
        }

        // Initializing the NQueenBoard with 0
        nQueenObj.initialiseNQueenBoard(dimension);

        System.out.println();

        // Calling to check if possibe to place queen in every row
        if (nQueenObj.getQueenPlacedArrayList(placedQueensChessBoardArrayList, startIndex, dimension)) {
            System.out.println("Queen is placed in every row succesfully");
            for (ArrayList<Integer> temp : placedQueensChessBoardArrayList) {
                System.out.println(temp);
            }
        } else {
            System.out.println("Cannot place Queen in every row");
        }

        scanInput.close();
    }
}