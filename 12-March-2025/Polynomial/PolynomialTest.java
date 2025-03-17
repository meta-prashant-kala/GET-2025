import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolynomialTest {

    @Test
    public void evaluate() {

        Poly polyTerm1Deg2Obj = new Poly(2, 2);
        Poly polyTerm1Deg0Obj = new Poly(2, 0);
        Poly[] polyObjsArray = { polyTerm1Deg2Obj, polyTerm1Deg0Obj };

        Polynomial polynomialObj = new Polynomial(polyObjsArray);

        assertEquals(2, polynomialObj.evaluate(0));
        assertEquals(4, polynomialObj.evaluate(1));
        assertEquals(10, polynomialObj.evaluate(2));
    }

    @Test
    public void degree() {
        Poly polyTermDeg2Obj1 = new Poly(2, 2);
        Poly polyTermDeg0Obj2 = new Poly(2, 0);
        Poly[] polyObjsArray1 = { polyTermDeg2Obj1, polyTermDeg0Obj2 };
        Polynomial polynomialObj1 = new Polynomial(polyObjsArray1);

        Poly polyTerm1Deg1Obj1 = new Poly(2, 1);
        Poly polyTerm1Deg0Obj2 = new Poly(2, 0);
        Poly[] polyObjsArray2 = { polyTerm1Deg1Obj1, polyTerm1Deg0Obj2 };
        Polynomial polynomialObj2 = new Polynomial(polyObjsArray2);

        Poly polyTerm1Deg0Obj3 = new Poly(2, 0);
        Poly[] polyObjsArray3 = { polyTerm1Deg0Obj3 };
        Polynomial polynomialObj3 = new Polynomial(polyObjsArray3);

        assertEquals(2, polynomialObj1.degree());
        assertEquals(1, polynomialObj2.degree());
        assertEquals(0, polynomialObj3.degree());
    }

    @Test
    public void add() {
        Poly polyTermDeg2Obj1 = new Poly(2, 2);
        Poly polyTermDeg0Obj2 = new Poly(2, 0);
        Poly[] polyObjsArray1 = { polyTermDeg2Obj1, polyTermDeg0Obj2 };
        Polynomial polynomialObj1 = new Polynomial(polyObjsArray1);

        Poly polyTerm1Deg1Obj1 = new Poly(2, 1);
        Poly polyTerm1Deg0Obj2 = new Poly(1, 0);
        Poly[] polyObjsArray2 = { polyTerm1Deg1Obj1, polyTerm1Deg0Obj2 };
        Polynomial polynomialObj2 = new Polynomial(polyObjsArray2);

        Poly expectedPolyTerm1Deg1Obj1 = new Poly(2, 2);
        Poly expectedPolyTerm2Deg0Obj2 = new Poly(2, 1);
        Poly expectedPolyTerm3Deg0Obj3 = new Poly(3, 0);
        Poly[] expectedPolyObjsArray1 = { expectedPolyTerm1Deg1Obj1, expectedPolyTerm2Deg0Obj2,
                expectedPolyTerm3Deg0Obj3 };
        Polynomial exxpectedPolynomialObj1 = new Polynomial(expectedPolyObjsArray1);

        assertEquals( exxpectedPolynomialObj1,polynomialObj1.add(polynomialObj2));
    }


    @Test
    public void multiply() {
        Poly polyTermDeg2Obj1 = new Poly(2, 2);
        Poly polyTermDeg0Obj2 = new Poly(2, 0);
        Poly[] polyObjsArray1 = { polyTermDeg2Obj1, polyTermDeg0Obj2 };
        Polynomial polynomialObj1 = new Polynomial(polyObjsArray1);

        Poly polyTerm1Deg1Obj1 = new Poly(2, 1);
        Poly polyTerm1Deg0Obj2 = new Poly(1, 0);
        Poly[] polyObjsArray2 = { polyTerm1Deg1Obj1, polyTerm1Deg0Obj2 };
        Polynomial polynomialObj2 = new Polynomial(polyObjsArray2);

        Poly expectedPolyTerm1Deg3Obj1 = new Poly(4, 3);
        Poly expectedPolyTerm2Deg2Obj2 = new Poly(2, 2);
        Poly expectedPolyTerm2Deg1Obj3 = new Poly(4, 1);
        Poly expectedPolyTerm3Deg0Obj4 = new Poly(2, 0);
        Poly[] expectedPolyObjsArray1 = { expectedPolyTerm1Deg3Obj1, expectedPolyTerm2Deg2Obj2,
            expectedPolyTerm2Deg1Obj3, expectedPolyTerm3Deg0Obj4  };
        Polynomial exxpectedPolynomialObj1 = new Polynomial(expectedPolyObjsArray1);

        assertEquals(exxpectedPolynomialObj1, polynomialObj1.multiply(polynomialObj2));
    }
}
