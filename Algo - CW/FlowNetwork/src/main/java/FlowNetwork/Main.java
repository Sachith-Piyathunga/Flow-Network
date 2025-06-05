package FlowNetwork;

import FlowNetwork.algorithm.FordFulkerson;
import FlowNetwork.model.Graph;
import FlowNetwork.parser.NetworkParser;

/**
 * Main class to run the Ford-Fulkerson algorithm on a given flownetwork.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Parse the graph from the specified input file
            Graph graph = NetworkParser.parse("src/main/resources/bridge_1.txt");

            // Create the FordFulkerson instance with the parse graph
            FordFulkerson ff = new FordFulkerson(graph);

            // Compute the maximum flow from the source to sink
            int maxFlow = ff.computeMaxFlow();

            // Print the maximum flow value
            System.out.println("\nMaximum Flow Value: " + maxFlow);

            // Print the  detailed steps taken during the computation
            System.out.println("\nSteps:\n");
            ff.getSteps().forEach(System.out::println);

        } catch (Exception e) {
            // Catch and print any exception that occer
            e.printStackTrace();
        }
    }
}