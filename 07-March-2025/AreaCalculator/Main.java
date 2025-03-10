import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        AreaCalculator areaCalculator = new AreaCalculator();

        int option = 1;
        while (option != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To Calculate area of triangle");
            System.out.println("2. To Calculate area of rectangle");
            System.out.println("3. To Calculate area of square");
            System.out.println("4. To Calculate area of circle");
            System.out.println("0. To exit from the app");

            try {
                option = intInput.nextInt();
            } catch (Exception e) {
                System.out.println("Plese select a valid option");
            }

            // Hanlding option selected by the user
            switch (option) {

                // Calculate area of triangle
                case 1:
                    System.out.println();
                    System.out.println("Enter the height of the triangle");
                    double triHeight = intInput.nextInt();
                    System.out.println("Enter the base of the triangle");
                    double triBase = intInput.nextInt();
                    System.out.println("Area of triangle: " + areaCalculator.areaOfTriangle(triBase, triHeight));
                    System.out.println();
                    break;

                // Calculate area of rectangle
                case 2:
                    System.out.println();
                    System.out.println("Enter the height of the rectangle");
                    double recHeight = intInput.nextInt();
                    System.out.println("Enter the width of the rectangle");
                    double recWidth = intInput.nextInt();
                    System.out.println("Area of rectangle: " + areaCalculator.areaOfRectangle(recHeight, recWidth));
                    System.out.println();
                    break;

                // Calculate area of square
                case 3:
                    System.out.println();
                    System.out.println("Enter the width of the Square");
                    double sqrWidth = intInput.nextInt();
                    System.out.println("Area of square: " + areaCalculator.areaOfSquare(sqrWidth));
                    System.out.println();
                    break;

                // Calculate area of circle
                case 4:
                    System.out.println();
                    System.out.println("Enter the readius of circle");
                    double cirRadius = intInput.nextInt();
                    System.out.println("Area of square: " + areaCalculator.areaOfCircle(cirRadius));
                    System.out.println();
                    break;

                default:
                    break;
            }
        }

        intInput.close();
        stringInput.close();
    }
}