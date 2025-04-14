import java.util.List;

public class Util {
    public static String getInitialJson() {
        String json = " [ {9:Ankit}, {8:Prashant}, {12:Binod}," +
                "{5:Piyush}, {10:Manish}, {11:Rishabh}, {3:Digamber}," +
                "{4:Manav}, {2:Rahul}, {1:Nishant}, {5:Palash} ] ";
        return json;
    }

    public static void displayList(List<Pair<Integer, String>> sortedKeyValueList) {
        for (Pair<Integer, String> pairObj : sortedKeyValueList) {
            System.out.println(pairObj.getKey() + " : " + pairObj.getValue());
        }
    }
}
