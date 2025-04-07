import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OrganicChemistry {
    Map<Character, Integer> compoundToWeightMap;

    public OrganicChemistry() {
        compoundToWeightMap = new HashMap<Character, Integer>();
        compoundToWeightMap.put('C', 12);
        compoundToWeightMap.put('O', 16);
        compoundToWeightMap.put('H', 1);
    }

    public boolean isNum(String str) {
        return true;
    }

    public int calculateMolecularWeight(String inputString) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        int weight = 0;
        int tempWait=0;
        while (i < inputString.length()) {
            if (inputString.charAt(i) == '(') {
                stack.push(inputString.charAt(i));
            }
            if (stack.empty()) {
                weight += compoundToWeightMap.get(inputString.charAt(i));
            } else {
                while (!stack.empty() && inputString.charAt(i) != ')') {
                    stack.push(inputString.charAt(i));
                }
                if (isNum(Character.toString(inputString.charAt(i + 1)))) {
                    int num = 1;
                    while (!stack.empty() && inputString.charAt(i) != '(') {
                        weight += compoundToWeightMap.get(inputString.charAt(i));
                    }
                    weight *= num;
                    i++;
                } else {
                    while (!stack.empty() && inputString.charAt(i) != '(') {
                        weight += compoundToWeightMap.get(inputString.charAt(i));
                    }
                }
                stack.push((String))
            }
        }
    }
}
