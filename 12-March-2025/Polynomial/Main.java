import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);

        int coefficient;
        float x;
        int firstPolyHighDeg;
        int secondPolyHighDeg;
        int i;

        // Taking highest degree of first polynomial as input
        System.out.println("Enter the highest degree of first polynomial");
        while (true) {
            try {
                firstPolyHighDeg = Integer.parseInt(scanInput.nextLine());
                if (firstPolyHighDeg < 0) {
                    System.out.println("Degree cannot be negetive");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
                continue;
            }
        }

        // Createing an array of Poly objects that will store a single complete
        // polynomial
        Poly[] poly1Array = new Poly[firstPolyHighDeg + 1];

        // Taking coeficient as input and creating the Poly objects of each coeficient
        System.out.println("Write Polynomial From hightest polynomial degree to lowest");
        i = 0;
        while (i <= firstPolyHighDeg) {
            System.out.println("Enter the coeficient of degree:" + (firstPolyHighDeg - i));

            try {
                coefficient = Integer.parseInt(scanInput.nextLine());

            } catch (Exception e) {
                System.out.println("Please enter a valid Integer");
                continue;
            }

            Poly polyObj = new Poly(coefficient, firstPolyHighDeg - i);

            poly1Array[i] = polyObj;

            i++;
        }

        // Creating a Polynomial object from array of Poly
        Polynomial polynomial1Obj = new Polynomial(poly1Array);

        // Taking highest degree of second polynomial as input
        System.out.println("Enter the highest degree of Second polynomial");
        while (true) {
            try {
                secondPolyHighDeg = Integer.parseInt(scanInput.nextLine());
                if (secondPolyHighDeg < 0) {
                    System.out.println("Degree cannot be negetive");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
                continue;
            }
        }

        // Createing an array of Poly objects that will store a single complete
        // polynomial
        Poly[] poly2Array = new Poly[secondPolyHighDeg + 1];

        System.out.println("Write Polynomial From hightest polynomial degree to lowest");
        i = 0;
        // Taking coeficient as input and creating the Poly objects of each coeficient
        while (i <= secondPolyHighDeg) {
            System.out.println("Enter the coeficient of degree:" + (secondPolyHighDeg - i));
            try {
                coefficient = Integer.parseInt(scanInput.nextLine());

            } catch (Exception e) {
                System.out.println("Please enter a valid Integer");
                continue;
            }

            Poly polyObj = new Poly(coefficient, secondPolyHighDeg - i);
            poly2Array[i] = polyObj;

            i++;
        }

        // Creating a Polynomial object from array of Poly
        Polynomial polynomial2Obj = new Polynomial(poly2Array);

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

                // Handling evaluate 1st polynomial
                case 1:
                    System.out.println("Enter the value of x: ");
                    x = Integer.parseInt(scanInput.nextLine());
                    System.out.print("Evaluated value of ");
                    polynomial1Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial1Obj.evaluate(x));
                    break;

                // Handling evaluate 2st polynomial
                case 2:
                    System.out.println("Enter the value of x: ");
                    x = Integer.parseInt(scanInput.nextLine());
                    System.out.print("Evaluated value of ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial2Obj.evaluate(x));
                    break;

                // Hanling get degree of a 1st polynomial
                case 3:
                    System.out.println("Degree of ");
                    polynomial1Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial1Obj.degree());
                    break;

                // Hanling get degree of a 2st polynomial
                case 4:
                    System.out.println("Degree of ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    System.out.println(polynomial2Obj.degree());
                    break;

                // Handling adding two polynomials
                case 5:
                    polynomial1Obj.displayPolynomial();
                    System.out.print("    ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    Polynomial addedPolynomial = polynomial1Obj.add(polynomial2Obj);
                    addedPolynomial.displayPolynomial();
                    break;

                // Handling multiplying two polynomials
                case 6:
                    polynomial1Obj.displayPolynomial();
                    System.out.print("  *  ");
                    polynomial2Obj.displayPolynomial();
                    System.out.print(" = ");
                    Polynomial multipliedPolynomial = polynomial1Obj.multiply(polynomial2Obj);
                    multipliedPolynomial.displayPolynomial();
                    break;

                // Handling exit from the app
                case 0:
                    System.exit(0);

                default:
                    System.out.println("Please select a valid option");
                    break;
            }

        }

        scanInput.close();
    }

}