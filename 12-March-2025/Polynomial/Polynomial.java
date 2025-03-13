
public class Polynomial {
    private final Poly[] polynomialArray;

    int highestDegree;

    Polynomial(Poly[] polyArray) {
        int polynomialArraySize = 0;
        for (Poly polyObj : polyArray) {
            if (polyObj.coefficient != 0) {
                polynomialArraySize++;
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

    public void displayPolynomial() {
        for (Poly polyObj : this.polynomialArray) {
            if (polyObj.coefficient >= 0) {
                System.out.print(" +" + polyObj.coefficient + "x^" + polyObj.degree);
            } else {
                System.out.print(" -" + polyObj.coefficient + "x^" + polyObj.degree);
            }
        }
    }

    public float evaluate(float xValue) {
        float val = 0;
        for (Poly polyObj : polynomialArray) {
            val += polyObj.evaluate(xValue);
        }
        return val;
    }

    public int degree() {
        return highestDegree;
    }

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

    public Polynomial multiply(Polynomial polynomialObj){
        int highDegOfMultPoly=this.degree()+polynomialObj.degree();
        Poly[] multPolyArray = new Poly[highDegOfMultPoly + 1];
        for(Poly polyObj1 : this.polynomialArray){

            for(Poly polyObj2:polynomialObj.polynomialArray){
                int coefOfMultArr=(polyObj1.coefficient)*(polyObj2.coefficient);
                int degOfMultArr=polyObj1.degree+polyObj2.degree;
                Poly multPolyObj=new Poly(coefOfMultArr, degOfMultArr);
                multPolyArray[highDegOfMultPoly-degOfMultArr]=multPolyObj;
            }
        }
        Polynomial multPolynomialObj=new Polynomial(multPolyArray);
        return multPolynomialObj;
    }
}
