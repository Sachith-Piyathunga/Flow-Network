package FlowNetwork.algorithm;

import FlowNetwork.model.Edge;
import FlowNetwork.model.Graph;
import java.util.*;

/**
 * Implements the Ford-Fulkerson algorithm to complete the maximum flow in the flownetwork
 */
public class FordFulkerson {
    private final Graph graph;      // Graph that representing the flownetwork
    private final int source;       // Add source node
    private final int sink;         // Add sink node
    private List<String> steps;     // List to record steps that then during computation (for debugging and visualization)

    /**
     * This constructor initializing the graph, source and the sink.
     * Assumes the source node is 0 and sink is the last node.
     *
     * @param graph The flownetwork graph
     */
    public FordFulkerson(Graph graph) {
        this.graph = graph;
        this.source = 0;
        this.sink = graph.getNodes() - 1;
        this.steps = new ArrayList<>();
    }

    /**
     * Computing the maximum flow from source to sink using the Ford-Flukerson method.
     *
     * @return The value of the maximum flow
     */
    public int computeMaxFlow() {
        int maxFlow = 0;    // Initializing the max flow to 0

        while (true) {
            // Perform Breadth-First Search (BFS) to find out an augment path
            Queue<Integer> queue = new LinkedList<>();
            Edge[] parent = new Edge[graph.getNodes()];     // Store the Edges found during the BFS
            queue.add(source);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (Edge edge : graph.getAdjacencyList().get(current)) {
                    // If the node has not been visited and there is an available capacity
                    if (parent[edge.to] == null && edge.residualCapacity() > 0) {
                        parent[edge.to] = edge;     // Mark the path
                        queue.add(edge.to);
                        if (edge.to == sink) break;     // Stop if sink is reached
                    }
                }
            }

            // If no path to sink was found, algorithm get terminates
            if (parent[sink] == null) break;

            // Find the minimum bottleneck along the path found
            int bottleneck = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v].reverse.to) {
                bottleneck = Math.min(bottleneck, parent[v].residualCapacity());
            }

            // Augment the flow along with the path by the bottleneck amount
            for (int v = sink; v != source; v = parent[v].reverse.to) {
                parent[v].augment(bottleneck);
            }
            // Add bottleneck to the overall max flow
            maxFlow += bottleneck;

            // Recording the step
            steps.add("Augmenting path found with bottleneck " + bottleneck + ". Total flow: " + maxFlow);
        }

        return maxFlow;
    }

    /**
     * Return the recorded steps of the algorithum.
     *
     * @return List of steps
     */
    public List<String> getSteps() {
        return steps;
    }
}