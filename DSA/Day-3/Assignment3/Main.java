
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfBallers;
        int bowlerQuota;
        int i = 1;
        Captain captain;

        while (true) {
            try {
                System.out.println("Enter the  number of bowlers");
                numOfBallers = Integer.parseInt(scanInput.nextLine());
                captain = new Captain(numOfBallers);
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }
        }
        while (i <= numOfBallers) {
            try {
                System.out.println("Enter the name of the bowler");
                String bowlerName = scanInput.nextLine();
                System.out.println("Enter the number of balls Bowler " + i + " have");
                bowlerQuota = Integer.parseInt(scanInput.nextLine());
                Bowler bowlerObj = new Bowler(bowlerName, bowlerQuota);
                captain.addToQueue(bowlerObj);
                i++;
            } catch (Exception e) {
                System.out.println("Please enter valid details");
                continue;
            }
        }
        System.out.println();
        captain.assignBowlers();

    }
}