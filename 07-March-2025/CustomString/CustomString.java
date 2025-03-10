public class CustomString{

    /**
     * Method to compare two strings
     * @param s1 should be String type
     * @param s2 should be Strng type
     * @return returns true if the given string are same and false if the given strings are different
     */
    public boolean cmpStrings(String s1, String s2){
        int lenOfS1=s1.length();
        int lenOfS2=s2.length();
        if(lenOfS1!=lenOfS2){
            return false;
        }
        for(int i=0;i<lenOfS1;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Method to reverse a string
     * @param s1 should be String type
     * @return return the reverse of the input string
     */
    public String rverseString(String s1){
        String reversedString="";
        for(int i=0;i<s1.length();i++){
            reversedString=s1.charAt(i)+reversedString;
        }
        return reversedString;
    }


    /**
     * Method to switch lowercase char to upper and uppercase to lower
     * @param str should be String type
     * @return returns a string with lowercase char to upper and uppercase to lower
     */
    public String stringCaseViceVersa(String str){
        String switchedCaseStr="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>=65 && str.charAt(i)<=90){
                switchedCaseStr=switchedCaseStr+(char)(str.charAt(i)-'A'+'a');
            }else if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                switchedCaseStr=switchedCaseStr+(char)(str.charAt(i)-'a'+'A');
            }else{
                switchedCaseStr=switchedCaseStr+str.charAt(i);
            }
        }
        return switchedCaseStr;
    }

    
    /**
     * Method to get the largest word in the string
     * @param str should be String type
     * @return largest word from the string
     */
    public String largestWord(String str){
        int maxLen=0;
        String largestWord="";
        String[] wordArry=str.split("\\b");
        for(String word: wordArry){
            if(maxLen<=word.length()){
                maxLen=Math.max(maxLen, word.length());
                largestWord=word;
            }
        }
        return largestWord;

    }

}