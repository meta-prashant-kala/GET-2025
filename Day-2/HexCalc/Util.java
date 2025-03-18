public class Util {

    private Util() {
    }

    public static String removeLeadingZeros(String s1) {
        int i = 0;
        int stringLength = s1.length();
        String removedZeroString = "";
        while (i < stringLength && s1.charAt(i) == '0') {
            i++;
        }
        while (i < stringLength) {
            removedZeroString += s1.charAt(i);
            i++;
        }
        return removedZeroString;
    }
}
