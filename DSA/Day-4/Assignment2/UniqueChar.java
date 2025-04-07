import java.util.HashMap;
import java.util.Map;

public class UniqueChar {

    Map<Character, Integer> strToUniqueValCountMap;
    Map<String,Integer> cache;

    public UniqueChar(){
        strToUniqueValCountMap=new HashMap<Character, Integer>();
        cache=new HashMap<String,Integer>();
    }

    public int countUniqueChars(String inputString){
        if(cache.containsKey(inputString)){
            return cache.get(inputString);
        }
        int uniqueCharCount=0;
        for(char ch:inputString.toCharArray()){
            strToUniqueValCountMap.put(ch, strToUniqueValCountMap.getOrDefault(ch, 0)+1);
        }
        for(int charCount: strToUniqueValCountMap.values()){
            if(charCount==1){
                uniqueCharCount++;
            }
        }
        cache.put(inputString, uniqueCharCount);
        return uniqueCharCount;
    }
}
