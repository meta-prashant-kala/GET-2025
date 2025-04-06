import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MultivariatePolynomialTest {

    @Test
    public void getHighestDegree1() {
        List<PolyTerm> polyTerms1 = new ArrayList<>();
        polyTerms1.add(new PolyTerm('x', 2));
        polyTerms1.add(new PolyTerm('y', 3));

        Polynomial polynomial1 = new Polynomial(5, 2, polyTerms1);

        List<PolyTerm> polyTerms2 = new ArrayList<>();
        polyTerms2.add(new PolyTerm('x', 1));
        polyTerms2.add(new PolyTerm('z', 4));

        Polynomial polynomial2 = new Polynomial(3, 2, polyTerms2);

        List<Polynomial> polynomialList = new ArrayList<>();
        polynomialList.add(polynomial1);
        polynomialList.add(polynomial2);

        MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial(polynomialList);

        int highestDegree = multivariatePolynomial.getHighestDegree();
        assertEquals(5, highestDegree);
    }

    @Test
    public void getHighestDegre2() {
        List<PolyTerm> polyTerms1 = new ArrayList<>();
        polyTerms1.add(new PolyTerm('x', 3));
        polyTerms1.add(new PolyTerm('y', 3));

        Polynomial polynomial1 = new Polynomial(5, 2, polyTerms1);

        List<PolyTerm> polyTerms2 = new ArrayList<>();
        polyTerms2.add(new PolyTerm('x', 5));
        polyTerms2.add(new PolyTerm('z', 4));

        Polynomial polynomial2 = new Polynomial(3, 2, polyTerms2);

        List<Polynomial> polynomialList = new ArrayList<>();
        polynomialList.add(polynomial1);
        polynomialList.add(polynomial2);

        MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial(polynomialList);

        int highestDegree = multivariatePolynomial.getHighestDegree();
        assertEquals(9, highestDegree);
    }

    @Test
    public void getHighestDegre3() {
        List<PolyTerm> polyTerms = new ArrayList<>();
        polyTerms.add(new PolyTerm('x', 0));

        Polynomial polynomial1 = new Polynomial(5, 2, polyTerms);

        List<Polynomial> polynomialList = new ArrayList<>();
        polynomialList.add(polynomial1);

        MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial(polynomialList);

        int highestDegree = multivariatePolynomial.getHighestDegree();
        assertEquals(0, highestDegree);
    }
}