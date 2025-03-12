public class CustomMath {

    /**
     * Method to caculate the HCF of two numbers
     * 
     * @param num1 should be of int type
     * @param num2 should be of int type
     * @return HCF of num1 and num2
     */
    public int getHCF(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        int dividend = num1;
        int divisor = num2;
        int remainder = dividend % divisor;
        return getHCF(divisor, remainder);
    }

    /**
     * Method to caculate the LCM of two numbers
     * 
     * @param num1 should be of int type
     * @param num2 should be of int type
     * @return HCF of num1 and num2
     */
    public int getLCM(int num1, int num2) {
        int hcf = getHCF(num1, num2);
        return (num1 * num2) / hcf;
    }
}
