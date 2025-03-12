import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> placedQueensChessBoardArrayList = new ArrayList<ArrayList<Integer>>();
        Scanner scanInput=new Scanner(System.in);
        
        System.out.println("Enter the size of the chess board dimension");
        int dimension=Integer.parseInt(scanInput.nextLine());
        
        System.out.println("Enter the starting row");
        int startIndex=Integer.parseInt(scanInput.nextLine());

        NQueenProblem obj=new NQueenProblem(dimension);

        System.out.println(obj.getQueenPlacedArrayList(placedQueensChessBoardArrayList,startIndex,dimension));

        scanInput.close();
    }
}