package util;

public class Util {

    public static boolean isStringEqual(String string1, String string2) {
        int lenOfstring1 = string1.length();
        int lenOfstring2 = string2.length();
        if (lenOfstring1 != lenOfstring2) {
            return false;
        }
        for (int i = 0; i < lenOfstring1; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}