

public class Poly {
    public int coefficient;
    public int degree;

    Poly(int coefficient, int degree){
        this.coefficient=coefficient;
        this.degree=degree;
    }

    public float evaluate(float xValue){
        return this.coefficient*((float)Math.pow(xValue, this.degree));
    }

    Poly addPoly(Poly polyObj){
        Poly addedPolyObj=new Poly(this.coefficient+polyObj.coefficient, polyObj.degree);
        return addedPolyObj;
    }


}
