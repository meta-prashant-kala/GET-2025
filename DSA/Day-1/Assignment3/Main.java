
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String[] args) {

        // List of the sample multivariant polynomial
        List<Polynomial> sampleMultivariatePolynomialList = Util.getMultivariatePolynomial();

        MultivariatePolynomial sampleMultivariatePolynomialObj;

        MultivariatePolynomial inputMultivariatePolynomialObj;

        List<Polynomial> inputMultivariatePolynomialList = new ArrayList<Polynomial>();

        int i = 0;
        int polynomialTermsCount;
        int polyTermsCount;
        int coeficient = 0;
        char variable;
        int degree;
        int degreeCountOfSamplePolynomial = 0;
        int degreeCountOfInputPolynomial = 0;

        // Creating object from the sample polynomial list
        System.out.println();
        sampleMultivariatePolynomialObj = new MultivariatePolynomial(sampleMultivariatePolynomialList);
        System.out.println();
        System.out.println("This is sample Multivarient Polynomial");
        System.out.println();

        // displaying the multivarient polynomial
        sampleMultivariatePolynomialObj.displayMultivarientPolynomial();
        degreeCountOfSamplePolynomial = sampleMultivariatePolynomialObj.getHighestDegree();
        System.out.println();

        // Displaying the highest degree of the multivarient polynomial
        System.out.println("Higest degree = " + degreeCountOfSamplePolynomial);
        System.out.println();

        // Taking number of terms in the multivarient polynomial as input 
        while (true) {
            try {
                System.out.println("Enter the number of terms in a polynomials");
                polynomialTermsCount = Integer.parseInt(scanInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
                continue;
            }
        }

        while (i < polynomialTermsCount) {
            int j = 0;
            while (true) {
                try {

                    // Taking the number of varialbles in single polyterm as input
                    System.out.println("Enter the number of terms in PolyTerm - " + (i + 1));
                    polyTermsCount = Integer.parseInt(scanInput.nextLine());

                    // Taking coeficient of the sinlge polyterm as input  
                    System.out.println("Enter the coeficient of the polyterm");
                    coeficient = Integer.parseInt(scanInput.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer");
                    continue;
                }
            }
            List<PolyTerm> polyTermList = new ArrayList<PolyTerm>();
            while (j < polyTermsCount) {
                try {

                    //Taking the character of variable of the polyterm as input
                    System.out.println("Enter the " + (j + 1) + " character of the Polyterm");
                    variable = scanInput.nextLine().charAt(0);

                    // Taking the degree of that variable as input
                    System.out.println("Enter the degree of the character");
                    degree = Integer.parseInt(scanInput.nextLine());

                    // Creating polyterm object and pushing the object in polyterm list
                    PolyTerm polyTerm = new PolyTerm(variable, degree);
                    polyTermList.add(polyTerm);

                    j++;

                } catch (Exception e) {
                    System.out.println("Please provide valid polyterm details");
                    continue;
                }
            }

            // Creating the Polynomial object with above data and pushing it in the list
            Polynomial polynomial = new Polynomial(coeficient, polyTermsCount, polyTermList);
            inputMultivariatePolynomialList.add(polynomial);
            i++;
        }

        // Creating the object of input multivarient polynomial from the polynomial list 
        inputMultivariatePolynomialObj = new MultivariatePolynomial(inputMultivariatePolynomialList);
        System.out.println();

        // Displaying the input multivarient polynomial object
        System.out.print("Polynomial = ");
        inputMultivariatePolynomialObj.displayMultivarientPolynomial();
        degreeCountOfInputPolynomial = inputMultivariatePolynomialObj.getHighestDegree();
        System.out.println();

        // Displaying the highest degree of the input multivarient polynomial object
        System.out.println("Higest degree = " + degreeCountOfInputPolynomial);
        System.out.println();
    }
}
