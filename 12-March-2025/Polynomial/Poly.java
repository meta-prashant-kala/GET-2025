
public class Poly {
    public int coefficient;
    public int degree;

    /**
     * Constructor to create a Poly objects
     * 
     * @param coefficient should be of integer type
     * @param degree      should be of integer type
     */
    Poly(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    /**
     * Method that evaluates a single polynomial term for a value of x
     * 
     * @param xValue should be of int type
     * @return the calculated value of polynomial term for a value of x
     */
    public float evaluate(float xValue) {
        return this.coefficient * ((float) Math.pow(xValue, this.degree));
    }

    /**
     * Method that adds two polynomial terms and returns the added value of the two
     * polynomial terms as a single Poly objects
     * 
     * @param polyObj should be of Poly type
     * @return a Poly object with added value of two Poly objects
     */
    Poly addPoly(Poly polyObj) {
        Poly addedPolyObj = new Poly(this.coefficient + polyObj.coefficient, polyObj.degree);
        return addedPolyObj;
    }

    /**
     * Method that multiplies two polynomial terms and returns the multiplied value
     * of the two polynomial terms as a single Poly objects
     * 
     * @param polyObj should be of Poly type
     * @return a Poly object with multiplied value of two Poly objects
     */
    Poly multiplyPoly(Poly polyObj) {
        Poly multPolyObj = new Poly(((this.coefficient) * (polyObj.coefficient)), (this.degree + polyObj.degree));
        return multPolyObj;
    }

}
