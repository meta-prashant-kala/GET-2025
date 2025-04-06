import java.util.List;

public class MultivariatePolynomial {

    List<Polynomial> multivariatePolynomialList;

    public MultivariatePolynomial(List<Polynomial> multivariatePolynomialList){
        this.multivariatePolynomialList=multivariatePolynomialList;
    }

    /**
     * Method to get the highest degree of a multivarient polynomial
     * @return  highest degree of a multivarient polynomial
     */
    public int getHighestDegree(){
        int maxDegCount=0;
        for(Polynomial polynomial:multivariatePolynomialList){
            int degCount=0;
            for(PolyTerm polyTerm:polynomial.getPolynomialList()){
                degCount+=polyTerm.getDegree();
            }
            if(maxDegCount<degCount){
                maxDegCount=degCount;
            }
        }
        return maxDegCount;
    }


    /**
     * Method to display the mulitvarient polynomial
     */
    public void displayMultivarientPolynomial(){
        for(Polynomial polynomial:multivariatePolynomialList){
            if(polynomial.getCoeificient()>0){
                System.out.print("+");
            }
            System.out.print(polynomial.coeificient);
            for(PolyTerm polyTerm:polynomial.getPolynomialList()){
                if(polyTerm.getDegree()>0){
                    System.out.print(polyTerm.getName()+"^");
                    System.out.print(polyTerm.getDegree()+" ");
                }
            }
            System.out.print(" ");
        }
    }
}