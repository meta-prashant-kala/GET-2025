import java.util.HashMap;
import java.util.Map;

public class OrganicChemistry {
    Map<Character, Integer> compoundToWeightMap;

    /**
     * Constructor To initaite the Organic chemistry class for Carbon, Hydrogen,
     * Oxygen
     */
    public OrganicChemistry() {
        compoundToWeightMap = new HashMap<Character, Integer>();
        compoundToWeightMap.put('C', 12);
        compoundToWeightMap.put('O', 16);
        compoundToWeightMap.put('H', 1);
    }

    /**
     * Method to check if a String holds a number or not
     * 
     * @param str should be of string type
     * @return true if the string holds a number, otherwise false
     */
    public boolean isNumber(char value) {
        String digitInString = Character.toString(value);
        try {
            @SuppressWarnings("unused")
            int num = Integer.parseInt(digitInString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to check if the input organic compound having equal braskets
     * 
     * @return true if the organic compound have equal brackets, otherwise false
     */
    public boolean isValidOrganicCompound(String inputString) {
        int bracketCount = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') {
                bracketCount++;
            }
            if (inputString.charAt(i) == ')') {
                bracketCount--;
            }
        }
        if (bracketCount == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to get the compound weight from the hashmap
     * 
     * @param compound should be of char type
     * @return the compound weight of the compound
     */
    public int getCompoundWeight(char compound) {
        return compoundToWeightMap.get(compound);
    }

    /**
     * Checks if the string has bracket or not
     * 
     * @param start       starting index of the inputString
     * @param end         ending index of the inputString
     * @param inputString should be of String type
     * @return true if the input string has bracket, otherwise false
     */
    public boolean hasBracket(int start, int end, String inputString) {
        for (int i = start; i <= end; i++) {
            if (inputString.charAt(i) == '(' || inputString.charAt(i) == ')') {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to the calculate the Molecular weight for a input string having no
     * brackets
     * 
     * @param start       starting index of the inputString
     * @param end         ending index of the inputString
     * @param inputString should be of String type
     * @return the Molecular weight of the input string
     */
    public int getMolecularWeight(int start, int end, String inputString) {
        int i = start;
        int molecularWeight = 0;
        while (i <= end) {
            if ((i + 1) <= end && isNumber(inputString.charAt(i + 1))) {

                // this part is to check the number > 9
                int subStrEndIndex = i + 1;
                while (subStrEndIndex <= end && isNumber(inputString.charAt(subStrEndIndex))) {
                    System.out.println(inputString.charAt(subStrEndIndex));
                    subStrEndIndex++;
                }

                // we parse the whole number
                molecularWeight += getCompoundWeight(inputString.charAt(i))
                        * Integer.parseInt(inputString.substring(i + 1, subStrEndIndex));

                i = subStrEndIndex;
            } else {
                molecularWeight += getCompoundWeight(inputString.charAt(i));
                i++;
            }
        }
        return molecularWeight;
    }

    /**
     * Method to calculate the molcular weight of organic compound stored in string
     * using recurrsive approach. We are simply dividing the input string till it
     * reach to a simple string having no bracket and from that we'll solve the
     * string and just add them while back-tracking
     * 
     * @param start       starting index of the inputString
     * @param end         ending index of the inputString
     * @param inputString should be of String type
     * @return the Molecular weight of the organic compound sotred in input string
     */
    public int calculateMolecularWeight(int start, int end, String inputString) {
        if (start > end) {
            return 0;
        }

        if (isNumber(inputString.charAt(0))) {
            throw new IllegalArgumentException("Input Compound is not valid");
        }

        // If there is no brackets just calculate the weight of the compound
        if (!hasBracket(start, end, inputString)) {
            return getMolecularWeight(start, end, inputString);
        }
        int multiplier = 1;
        int leftEnd = end;
        int rightStart = end;

        // Checking if the input string starting with '(', If yes we'll start checking
        // for the last ')' which defines the dividing part for the string
        // We'll start by start+1 to skip the initial bracket
        if (inputString.charAt(start) == '(') {
            for (int i = start + 1; i <= end; i++) {
                if (inputString.charAt(i) == ')') {
                    leftEnd = i - 1;
                    if (i + 1 <= end && isNumber(inputString.charAt(i + 1))) {
                        int subStrEndIndex = i + 1;
                        while (subStrEndIndex <= end && isNumber(inputString.charAt(subStrEndIndex))) {
                            subStrEndIndex++;
                        }
                        multiplier = Integer.parseInt(inputString.substring(i + 1, subStrEndIndex));
                        rightStart = subStrEndIndex;

                    } else {
                        rightStart = i + 1;
                    }
                }
            }
            return multiplier * calculateMolecularWeight(start + 1, leftEnd, inputString)
                    + calculateMolecularWeight(rightStart, end, inputString);
        }
        // We'll simply look for first '(' and divide the string from this
        else {
            for (int i = start; i <= end; i++) {
                if (inputString.charAt(i) == '(') {
                    leftEnd = i - 1;
                    rightStart = i;
                    break;
                }
            }
            return calculateMolecularWeight(start, leftEnd, inputString)
                    + calculateMolecularWeight(rightStart, end, inputString);
        }
    }

}
