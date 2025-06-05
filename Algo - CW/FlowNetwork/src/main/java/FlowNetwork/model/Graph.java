package FlowNetwork.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directed graph used for flownetworks.
 * Each node has a list of outgoing edges.
 */
public class Graph {
    private final int nodes;                        // Total number of nodes in the graph
    private final List<List<Edge>> adjacencyList;   // Adjacency list  representing the outgoing edges for each  node

    /**
     * Constructor to initialize a graph with the given number of nodes.
     * Each node initially has an empty list of edges.
     *
     *
     * @param nodes Number of nodes in the graph
     */
    public Graph(int nodes) {
        this.nodes = nodes;
        this.adjacencyList = new ArrayList<>(nodes);
        // Initialize an ampty list for each node
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    /**
     * Adding a directed edges from 'from' node to 'to' node with the given capacity.
     * Add a reverse edge to support the residual graph operations.
     *
     * @param from The source node
     * @param to The destination node
     * @param capacity The capacity of the forward edge
     */
    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(to, capacity);  // Forward edge with given capacity
        Edge backward = new Edge(from, 0);  // Reverse edge with 0 initial capacity

        // Ste up reverse links between the edges
        forward.reverse = backward;
        backward.reverse = forward;

        // Add forward edge to 'from' node list and backward edge to 'to' node list
        adjacencyList.get(from).add(forward);
        adjacencyList.get(to).add(backward);
    }

    /**
     * Return the adjacency list of the graph.
     *
     * @return The adjacency list
     */
    public List<List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    /**
     * Return number of nodes in to the graph.
     *
     * @return Number of nodes
     */
    public int getNodes() {
        return nodes;
    }
}