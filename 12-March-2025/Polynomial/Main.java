import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ArrayList<Poly> poly1ArrayList = new ArrayList<Poly>();
        // ArrayList<Poly> poly2ArrayList = new ArrayList<Poly>();

        int coefficient;
        float x;
        Scanner scanInput = new Scanner(System.in);

        System.out.println("Enter the highest degree of first polynomial");
        int firstPolyHighDeg = Integer.parseInt(scanInput.nextLine());
        Poly[] poly1Array = new Poly[firstPolyHighDeg + 1];

        System.out.println("Write Polynomial From hightest polynomial degree to lowest");

        for (int i = 0; i <= firstPolyHighDeg; i++) {
            System.out.println("Enter the coeficient of degree:" + (firstPolyHighDeg - i));
            coefficient = Integer.parseInt(scanInput.nextLine());

            Poly polyObj = new Poly(coefficient, firstPolyHighDeg - i);

            poly1Array[i] = polyObj;
        }

        Polynomial polynomial1Obj = new Polynomial(poly1Array);
        polynomial1Obj.highestDegree = firstPolyHighDeg;

        System.out.println("Enter the highest degree of Second polynomial");
        int secondPolyHighDeg = Integer.parseInt(scanInput.nextLine());
        Poly[] poly2Array = new Poly[secondPolyHighDeg + 1];

        System.out.println("Write Polynomial From hightest polynomial degree to lowest");

        for (int i = 0; i <= secondPolyHighDeg; i++) {
            System.out.println("Enter the coeficient of degree:" + (secondPolyHighDeg - i));
            coefficient = Integer.parseInt(scanInput.nextLine());

            Poly polyObj = new Poly(coefficient, secondPolyHighDeg - i);
            poly2Array[i] = polyObj;
        }

        Polynomial polynomial2Obj = new Polynomial(poly2Array);
        polynomial2Obj.highestDegree = secondPolyHighDeg;

        int selectedOption = 1;

        while (selectedOption != 0) {

            // Providing menu to the user
            System.out.println();
            System.out.println(" --------- Please Select an option --------- ");
            System.out.println("1. To evaluate 1st polynomial");
            System.out.println("2. To evaluate 2nd polynomial");
            System.out.println("3. To get degree of a 1st polynomial");
            System.out.println("4. To get degree of a 2nd polynomial");
            System.out.println("5. To add two polynomials");
            System.out.println("6. To multiply two polynomials");
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
                    System.out.println("Enter the value of x: ");
                    x = Integer.parseInt(scanInput.nextLine());
                    System.out.print("Evaluated value of ");
                    polynomial1Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial1Obj.evaluate(x));
                    break;

                case 2:
                    System.out.println("Enter the value of x: ");
                    x = Integer.parseInt(scanInput.nextLine());
                    System.out.print("Evaluated value of ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial2Obj.evaluate(x));
                    break;
                case 3:
                    System.out.println("Degree of ");
                    polynomial1Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial1Obj.highestDegree);
                    break;
                case 4:
                    System.out.println("Degree of ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial2Obj.highestDegree);
                    break;

                case 5:
                    polynomial1Obj.displayPolynomial();
                    System.out.print("    ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    Polynomial addedPolynomial = polynomial1Obj.add(polynomial2Obj);
                    addedPolynomial.displayPolynomial();
                    break;
                default:
                    break;
            }

        }

        scanInput.close();
    }

}