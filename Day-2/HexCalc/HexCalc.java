import java.util.HashMap;

public class HexCalc {
    HashMap<Character, Integer> charToIntMap = new HashMap<Character, Integer>();
    HashMap<Integer, Character> intToCharMap = new HashMap<Integer, Character>();

    // Mapped the hexadecimal number with decimal Number
    HexCalc() {
        charToIntMap.put('0', 0);
        charToIntMap.put('1', 1);
        charToIntMap.put('2', 2);
        charToIntMap.put('3', 3);
        charToIntMap.put('4', 4);
        charToIntMap.put('5', 5);
        charToIntMap.put('6', 6);
        charToIntMap.put('7', 7);
        charToIntMap.put('8', 8);
        charToIntMap.put('9', 9);
        charToIntMap.put('A', 10);
        charToIntMap.put('B', 11);
        charToIntMap.put('C', 12);
        charToIntMap.put('D', 13);
        charToIntMap.put('E', 14);
        charToIntMap.put('F', 15);

        intToCharMap.put(0, '0');
        intToCharMap.put(1, '1');
        intToCharMap.put(2, '2');
        intToCharMap.put(3, '3');
        intToCharMap.put(4, '4');
        intToCharMap.put(5, '5');
        intToCharMap.put(6, '6');
        intToCharMap.put(7, '7');
        intToCharMap.put(8, '8');
        intToCharMap.put(9, '9');
        intToCharMap.put(10, 'A');
        intToCharMap.put(11, 'B');
        intToCharMap.put(12, 'C');
        intToCharMap.put(13, 'D');
        intToCharMap.put(14, 'E');
        intToCharMap.put(15, 'F');

    }

    /**
     * Method to convert hexa decimal number to decimal number
     * 
     * @param number should be hexadecimal number of String type
     * @return the decimal value of the given hexadecimal number of int type
     */
    public int hexToDec(String number) {
        int num = 0;
        for (int i = number.length() - 1; i >= 0; i--) {

            // Gets decimal value from hex hashmap
            int n = charToIntMap.get(number.charAt(i)) * (int) Math.pow(16, (number.length() - 1) - i);
            num += n;
        }
        return num;
    }

    /**
     * Method to convert decimal number to hexa decimal number
     * 
     * @param number should be decimal number of int type
     * @return hexadecimal number of the given decimal number of String type
     */
    public String decToHex(int number) {
        String hexNumber = "";

        // 15 beacuse base in hex is 16
        while (number >= 15) {
            hexNumber = intToCharMap.get(number % 16) + hexNumber;
            number /= 16;
        }
        if (number != 0) {
            hexNumber = intToCharMap.get(number % 16) + hexNumber;
        }
        return hexNumber;
    }

    /**
     * Method to add two hexa decimal number
     * 
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return result after the addition of two hexadecimal number
     */
    public String addition(String num1, String num2) {

        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Null values not accepted.");
        } else if (num1.isBlank() || num2.isBlank()) {
            throw new IllegalArgumentException("blank values are not allowed.");
        }

        int n1 = hexToDec(num1);
        int n2 = hexToDec(num2);
        int sum = n1 + n2;
        String HexSum = decToHex(sum);
        return HexSum;
    }

    /**
     * Method to subtract two hexa decimal number. Subtracts the first hexadecimal
     * number from the second hexadecimal number
     * 
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return result after the subtraction of First hexdecimal number from second
     *         hexadecimal number
     */
    public String subtract(String num1, String num2) {
        int n1 = hexToDec(num1);
        int n2 = hexToDec(num2);
        String HexSub = decToHex(n1 - n2);
        if (n1 < n2) {
            HexSub = '-' + HexSub;
        }
        return HexSub;
    }

    /**
     * Method to multiply two hexa decimal number
     * 
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return result after multiplying the give hexadecimal numbers
     */
    public String multiply(String num1, String num2) {
        int n1 = hexToDec(num1);
        int n2 = hexToDec(num2);
        int sum = n1 * n2;
        String HexSum = decToHex(sum);
        return HexSum;
    }

    /**
     * Method to divide two hexa decimal numbers. Divides first number with second.
     * 
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return Result after division as string
     */
    public String divide(String num1, String num2) {
        if (num2 == "0") {
            throw new IllegalArgumentException("Division by zero.");
        }
        int n1 = hexToDec(num1);
        int n2 = hexToDec(num2);

        int sum = n1 / n2;
        String HexSum = decToHex(sum);
        return HexSum;
    }

    /**
     * Method to check two hexa decimal numbers are equal or not
     * 
     * @param num1 First number as String
     * @param num2 Second number as String
     * @return true if the numbers are equal, false if the numbers are different
     */
    public Boolean isEqual(String num1, String num2) {
        String n1 = Util.removeLeadingZeros(num1);
        String n2 = Util.removeLeadingZeros(num2);
        if (n1.length() > n2.length()) {
            return false;
        }
        if (n2.length() > n1.length()) {
            return false;
        }
        for (int i = 0; i < n1.length(); i++) {
            if (n1.charAt(i) != n2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if the first hexa decimal number is greater than second
     * 
     * @param num1 First number as String
     * @param num2 Second number as String
     * @return true if the first number is greater than the second, false if the
     *         first number is smaller than second
     */
    public Boolean isGreater(String num1, String num2) {
        String n1 = Util.removeLeadingZeros(num1);
        String n2 = Util.removeLeadingZeros(num2);
        if (n1.length() > n2.length()) {
            return true;
        }
        if (n2.length() > n1.length()) {
            return false;
        }
        for (int i = 0; i < n1.length(); i++) {
            if (n1.charAt(i) > n2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check first hexa decimal number is smaller than second
     * 
     * @param num1 First number as String
     * @param num2 Second number as String
     * @return true if the first number is smaller than the second, false if the
     *         first number is greater than second
     */
    public Boolean isSmaller(String num1, String num2) {
        String n1 = Util.removeLeadingZeros(num1);
        String n2 = Util.removeLeadingZeros(num2);
        if (n1.length() < n2.length()) {
            return true;
        }
        if (n2.length() < n1.length()) {
            return false;
        }
        for (int i = 0; i < n1.length(); i++) {
            if (n1.charAt(i) < n2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

}