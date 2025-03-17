
public class Polynomial {
    private final Poly[] polynomialArray;

    private int highestDegree;

    /**
     * Constructor that takes an array of Poly objects and creates a Polynomial
     * object representing a Polynomial
     * 
     * @param polyArray should be an array of Poly objects
     */
    Polynomial(Poly[] polyArray) {
        int polynomialArraySize = 0;
        for (Poly polyObj : polyArray) {
            if (polyObj.coefficient != 0) {
                polynomialArraySize++;
                this.highestDegree = Math.max(polyObj.degree, this.highestDegree);
            }
        }
        polynomialArray = new Poly[polynomialArraySize];
        int polynomialArrayIterator = 0;
        for (Poly polyObj : polyArray) {
            if (polyObj.coefficient != 0) {
                polynomialArray[polynomialArrayIterator] = polyObj;
                polynomialArrayIterator++;
            }

        }

    }

    /**
     * Method to display a Polynomial expression stored in Polynomial object
     */
    public void displayPolynomial() {
        for (Poly polyObj : this.polynomialArray) {
            if (polyObj.coefficient >= 0) {
                System.out.print(" +" + polyObj.coefficient + "x^" + polyObj.degree);
            } else {
                System.out.print(" -" + polyObj.coefficient + "x^" + polyObj.degree);
            }
        }
    }

    /**
     * Method to calculate the value of whole polynomial expression stored in
     * Polynomial object for a value of X
     * 
     * @param xValue should be of type float
     * @return the calculated value of a polynomial expression for a value of x
     */
    public float evaluate(float xValue) {
        float val = 0;
        for (Poly polyObj : polynomialArray) {
            val += polyObj.evaluate(xValue);
        }
        return val;
    }

    /**
     * Method to get the highest degree of a polynomial expression stored in
     * Polynomial object
     * 
     * @return the highest degree of a polynomial expression stored in Polynomial
     *         object
     */
    public int degree() {
        return highestDegree;
    }

    /**
     * Method to add two polynomial expressions stored in Polynomial object
     * 
     * @param polynomialObj is the polynomial expression (stored in Polynomial
     *                      object)
     *                      that would be added to the polynomial expression(stored
     *                      in Polynomial object) on which the method is called
     * @return Polynomial expression stored in Polynomial object with added value of
     *         two Polynomail expressions(stored in Polynomial object)
     */
    public Polynomial add(Polynomial polynomialObj) {
        int highDegOfAddedPoly = (int) Math.max(this.highestDegree, polynomialObj.highestDegree);
        Poly[] addedPolyArray = new Poly[highDegOfAddedPoly + 1];
        for (Poly polyObj : this.polynomialArray) {
            if (addedPolyArray[highDegOfAddedPoly - polyObj.degree] == null) {
                addedPolyArray[highDegOfAddedPoly - polyObj.degree] = polyObj;
            } else {
                addedPolyArray[highDegOfAddedPoly - polyObj.degree] = polyObj
                        .addPoly(addedPolyArray[highDegOfAddedPoly - polyObj.degree]);
            }
        }
        for (Poly polyObj : polynomialObj.polynomialArray) {
            if (addedPolyArray[highDegOfAddedPoly - polyObj.degree] == null) {
                addedPolyArray[highDegOfAddedPoly - polyObj.degree] = polyObj;
            } else {
                addedPolyArray[highDegOfAddedPoly - polyObj.degree] = polyObj
                        .addPoly(addedPolyArray[highDegOfAddedPoly - polyObj.degree]);
            }
        }
        Polynomial addedPolynomialObj = new Polynomial(addedPolyArray);
        return addedPolynomialObj;
    }

    /**
     * Method to multiply two polynomial expressions stored in Polynomial object
     * 
     * @param polynomialObj is the polynomial expression (stored in Polynomial
     *                      object)
     *                      that would be multiplied to the polynomial
     *                      expression(stored
     *                      in Polynomial object) on which the method is called
     * @return Polynomial expression stored in Polynomial object with multiplied
     *         value of
     *         two Polynomail expressions(stored in Polynomial object)
     */
    public Polynomial multiply(Polynomial polynomialObj) {
        int highDegOfMultPoly = this.degree() + polynomialObj.degree();
        Poly[] multPolyArray = new Poly[highDegOfMultPoly + 1];
        for (Poly polyObj1 : this.polynomialArray) {

            for (Poly polyObj2 : polynomialObj.polynomialArray) {
                Poly multPolyObj = polyObj1.multiplyPoly(polyObj2);
                if (multPolyArray[highDegOfMultPoly - (polyObj1.degree + polyObj2.degree)] == null) {
                    multPolyArray[highDegOfMultPoly - (polyObj1.degree + polyObj2.degree)] = multPolyObj;
                } else {
                    multPolyArray[highDegOfMultPoly - (polyObj1.degree + polyObj2.degree)] = multPolyObj
                            .addPoly(multPolyArray[highDegOfMultPoly - (polyObj1.degree + polyObj2.degree)]);
                }
            }
        }
        Polynomial multPolynomialObj = new Polynomial(multPolyArray);
        return multPolynomialObj;
    }


    /**
     * Overriding Equals method to compare the objects
     */
    @Override
    public boolean equals(Object o) {
        Polynomial polynomialObj = (Polynomial) o;
        if (this.degree() != polynomialObj.degree()) {
            return false;
        }
        if (this.polynomialArray.length != polynomialObj.polynomialArray.length) {
            return false;
        }
        for (int i = 0; i < this.polynomialArray.length; i++) {
            if (this.polynomialArray[i].coefficient != polynomialObj.polynomialArray[i].coefficient) {
                return false;
            }
            if (this.polynomialArray[i].degree != polynomialObj.polynomialArray[i].degree) {
                return false;
            }
        }
        return true;
    }
}
