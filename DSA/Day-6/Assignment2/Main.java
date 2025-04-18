package Assignment2;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Scanner scanInput = new Scanner(System.in);

    public static void main(String args[]) {

        EdgeListGraphRepresentation<String> edgeListGraphRepresentationObj = Util.getInitialData();
        int selectedOption;
        String v1;
        String v2;

        while (true) {
            System.out.println();
            System.out.println("Please select an option");
            System.out.println("1. Add an edge to the graph");
            System.out.println("2. To check if the graph is connected or not");
            System.out.println("3. To get the list of all the verteces that are reachable through input vertex");
            System.out.println("4. To get the minimum spannig tree of the graph");
            System.out.println("5. To get the shortest path from source to destination");
            System.out.println();

            try {
                selectedOption = Integer.parseInt(scanInput.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer");
                continue;
            }

            switch (selectedOption) {
                case 1:
                    System.out.println("Enter the first vertex");
                    v1 = scanInput.nextLine();
                    System.out.println("Enter the second vertex");
                    v2 = scanInput.nextLine();
                    edgeListGraphRepresentationObj.addToGraph(v1, v2, selectedOption);
                    break;
                case 2:
                    boolean isConnected = edgeListGraphRepresentationObj.isConnected();
                    if (isConnected) {
                        System.out.println("Graph is Connected");
                    } else {
                        System.out.println("Graph is not connected");
                    }
                    break;

                case 3:
                    System.out.println("Enter the starting vertex");
                    String startVertex = scanInput.nextLine();
                    Set<String> reachableVertexList = edgeListGraphRepresentationObj.reachable(startVertex);
                    System.out.println(reachableVertexList);
                    break;

                case 4:
                    List<Edge<String>> mstVertexList = edgeListGraphRepresentationObj.mst();
                    System.out.println("Minimum spanning tree of the graph");
                    for (Edge<String> edge : mstVertexList) {
                        System.out.println(edge.source + " -> " + edge.destination);
                    }
                case 5:
                    System.out.println("Enter the first vertex");
                    v1 = scanInput.nextLine();
                    System.out.println("Enter the second vertex");
                    v2 = scanInput.nextLine();
                    List<String> shortestPathVertexList = edgeListGraphRepresentationObj.shortestPath(v1, v2);
                    System.out.println(shortestPathVertexList);
                    break;
                default:
                    System.out.println("Please select a valid option");
                    break;
            }
        }

    }
}
