import java.util.List;

public class Util {
    public static String getInitialJson() {
        String json = " [ {9:Ankit}, {8:Prashant}, {12:Binod}," +
                "{5:Piyush}, {10:Manish}, {11:Rishabh}, {3:Digamber}," +
                "{4:Manav}, {2:Rahul}, {1:Nishant}, {5:Palash} ] ";
        String json2 = "[  { M : mangoo}, { A: apple}, {Manoj : abc}, {Maanoj: cde} ]";        
        
        return json2;
    }

    public static void displayList(List<Pair<String, String>> sortedKeyValueList) {
        for (Pair<String, String> pairObj : sortedKeyValueList) {
            System.out.println(pairObj.getKey() + " : " + pairObj.getValue());
        }
    }
}
