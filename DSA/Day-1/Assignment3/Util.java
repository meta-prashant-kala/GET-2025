import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<Polynomial> getMultivariatePolynomial() {
        PolyTerm polyTerm1_1 = new PolyTerm('x', 2);
        PolyTerm polyTerm1_2 = new PolyTerm('y', 4);
        List<PolyTerm> polyTermList1 = new ArrayList<PolyTerm>(Arrays.asList(polyTerm1_1, polyTerm1_2));
        Polynomial polynomial1 = new Polynomial(3, 2, polyTermList1);

        PolyTerm polyTerm2_1 = new PolyTerm('z', 2);
        List<PolyTerm> polyTermList2 = new ArrayList<PolyTerm>(Arrays.asList(polyTerm2_1));
        Polynomial polynomial2 = new Polynomial(-5, 1, polyTermList2);

        PolyTerm polyTerm3_1 = new PolyTerm('x', 1);
        List<PolyTerm> polyTermList3 = new ArrayList<PolyTerm>(Arrays.asList(polyTerm3_1));
        Polynomial polynomial3 = new Polynomial(1, 1, polyTermList3);

        PolyTerm polyTerm4_1 = new PolyTerm('y', 1);
        List<PolyTerm> polyTermList4 = new ArrayList<PolyTerm>(Arrays.asList(polyTerm4_1));
        Polynomial polynomial4 = new Polynomial(-1, 1, polyTermList4);

        PolyTerm polyTerm5_1 = new PolyTerm('x', 0);
        List<PolyTerm> polyTermList5 = new ArrayList<PolyTerm>(Arrays.asList(polyTerm5_1));
        Polynomial polynomial5 = new Polynomial(20, 0, polyTermList5);

        List<Polynomial> multivariatePolynomialList = new ArrayList<Polynomial>(
                Arrays.asList(polynomial1, polynomial2, polynomial3, polynomial4, polynomial5));
                
        return multivariatePolynomialList;
    }
}
