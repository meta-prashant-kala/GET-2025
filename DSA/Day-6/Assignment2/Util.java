package Assignment2;

public class Util {
    public static EdgeListGraphRepresentation<String> getInitialData() {
        EdgeListGraphRepresentation<String> edgeListGraphRepresentationObj = new EdgeListGraphRepresentation<>();
        edgeListGraphRepresentationObj.addToGraph("A", "B", 1);
        edgeListGraphRepresentationObj.addToGraph("A", "C", 6);
        edgeListGraphRepresentationObj.addToGraph("A", "D", 3);
        edgeListGraphRepresentationObj.addToGraph("B", "D", 2);
        edgeListGraphRepresentationObj.addToGraph("C", "D", 5);
        edgeListGraphRepresentationObj.addToGraph("E", "F", 5);
        return edgeListGraphRepresentationObj;
    }
}
