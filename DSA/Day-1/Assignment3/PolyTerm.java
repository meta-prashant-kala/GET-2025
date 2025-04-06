public class PolyTerm{
    int degree;
    char name;


    /**
     * COnstructor create a single polyterm
     * @param name should be of char type holding the character of the varaible
     * @param degree should be of int type holding the degree of the varaible
     */
    public PolyTerm(char name, int degree){
        this.name=name;
        this.degree=degree;
    }

    /**
     * Method to get the degree of the polyterm variable
     * @return degree of the polyterm variable
     */ 
    public int getDegree() {
        return degree;
    }

    /**
     * Method to get the character variable of the polynomial
     * @return character variable of the polynomial
     */
    public char getName() {
        return name;
    }
}