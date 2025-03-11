import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AreaCalculator areaCalculator = new AreaCalculator();

        int selectedOption = 1;
        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To Calculate area of triangle");
            System.out.println("2. To Calculate area of rectangle");
            System.out.println("3. To Calculate area of square");
            System.out.println("4. To Calculate area of circle");
            System.out.println("0. To exit from the app");

            try {
                selectedOption = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Plese select a valid option");
            }

            // Hanlding option selected by the user
            switch (selectedOption) {

                // Calculate area of triangle
                case 1:
                    System.out.println();
                    System.out.println("Enter the height of the triangle");
                    double triHeight = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter the base of the triangle");
                    double triBase = Double.parseDouble(scan.nextLine());
                    System.out.println("Area of triangle: " + areaCalculator.areaOfTriangle(triBase, triHeight));
                    System.out.println();
                    break;

                // Calculate area of rectangle
                case 2:
                    System.out.println();
                    System.out.println("Enter the height of the rectangle");
                    double recHeight = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter the width of the rectangle");
                    double recWidth = Double.parseDouble(scan.nextLine());
                    System.out.println("Area of rectangle: " + areaCalculator.areaOfRectangle(recHeight, recWidth));
                    System.out.println();
                    break;

                // Calculate area of square
                case 3:
                    System.out.println();
                    System.out.println("Enter the width of the Square");
                    double sqrWidth = Double.parseDouble(scan.nextLine());
                    System.out.println("Area of square: " + areaCalculator.areaOfSquare(sqrWidth));
                    System.out.println();
                    break;

                // Calculate area of circle
                case 4:
                    System.out.println();
                    System.out.println("Enter the readius of circle");
                    double cirRadius = Double.parseDouble(scan.nextLine());
                    System.out.println("Area of square: " + areaCalculator.areaOfCircle(cirRadius));
                    System.out.println();
                    break;

                default:
                    break;
            }
        }

        scan.close();
    }
}