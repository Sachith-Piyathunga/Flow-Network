package FlowNetwork.model;

/**
 * Represents the edge in the flownetwork.
 * Each edge has a destination node, a capacity, a current flow and a reference to its reverse edge.
 */
public class Edge {
    public final int to;        // Destination node for this edge
    public int capacity;        // Maximum capacity for this edge
    public int flow;            // Current flow through for this edge
    public Edge reverse;        // This is reverse edge (this edge used for residual graph calculations)

    /**
     * Constructor to the initialize an edge with a destination and capacity.
     *
     * @param to Destination node
     * @param capacity Capacity of the edge
     */
    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    /**
     * Calculates and return the residual capacity of the edge.
     * Residual capacity = capacity - current flow.
     *
     * @return The residual capacity
     */
    public int residualCapacity() {
        return capacity - flow;
    }

    /**
     * Arguments the flow along with this edge by the given bottleneck value.
     * Also updates the flow of the reverse edge accordingly to maintain the flow.
     *
     * @param bottleneck The amount by which to increese the flow
     */
    public void augment(int bottleneck) {
        flow += bottleneck;             // Increse by flow in the forward edge
        reverse.flow -= bottleneck;     // Decrese by flow in the reverse edge
    }
}