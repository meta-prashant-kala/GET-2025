import java.util.HashMap;
import java.util.Map;

public class UniqueChar {

    Map<Character, Integer> strToUniqueValCountMap;
    Map<String, Integer> cache;

    /**
     * Constructor to initialise the class
     */
    public UniqueChar() {
        strToUniqueValCountMap = new HashMap<Character, Integer>();
        cache = new HashMap<String, Integer>();
    }

    /**
     * Method to count the unique characters in a string
     * 
     * @param inputString should be of string type
     * @return count of unique characters
     */
    public int countUniqueChars(String inputString) {
        // Checking if there exist an answer for the input string and returning the
        // count if yes
        if (cache.containsKey(inputString)) {
            return cache.get(inputString);
        }

        int uniqueCharCount = 0;
        // Counting the frequency of every character of a string
        for (char ch : inputString.toCharArray()) {
            strToUniqueValCountMap.put(ch, strToUniqueValCountMap.getOrDefault(ch, 0) + 1);
        }

        // Increasing the unique character count for elements have frequency only 1 in
        // the map
        for (int charCount : strToUniqueValCountMap.values()) {
            if (charCount == 1) {
                uniqueCharCount++;
            }
        }

        // Storing the result for the input string for future input
        cache.put(inputString, uniqueCharCount);
        return uniqueCharCount;
    }
}
