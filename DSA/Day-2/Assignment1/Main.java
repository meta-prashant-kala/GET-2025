package Assignment1;
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Enter the expression you want to evaluate");
        String expression = scanInput.nextLine();

        try {
            ExpressionEvaluator expEvaluatorObj = new ExpressionEvaluator();
            int evaluatedValue = expEvaluatorObj.evaluateExpression(expression);
            System.out.println(evaluatedValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
