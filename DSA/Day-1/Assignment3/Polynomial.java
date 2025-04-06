import java.util.List;

public class Polynomial {
    int coeificient;
    int termCount;
    List<PolyTerm> polynomialList;


    /**
     * Constructor to create a polynomial
     * @param coeficient should be of int type
     * @param termCount should be of int type
     * @param polynomialList should be of List type holding the Single polynomial list
     */
    public Polynomial(int coeficient, int termCount, List<PolyTerm> polynomialList){
        this.coeificient=coeficient;
        this.termCount=termCount;
        this.polynomialList=polynomialList;
    }   


    /**
     * Method to return the Single polynomial list
     * @return Single polynomial list
     */
    public List<PolyTerm> getPolynomialList() {
        return polynomialList;
    }

    /**
     * Method to get the coeficient of a polynomial term
     * @return coeficient of a polynomial term 
     */
    public int getCoeificient() {
        return coeificient;
    }


    /**
     * Method to get the count of variable in a single polynomial term
     * @return count of variable in a single polynomial term
     */
    public int getTermCount() {
        return termCount;
    }
}
