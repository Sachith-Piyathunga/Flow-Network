package FlowNetwork.parser;

import FlowNetwork.model.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Utilize the class to parse the flow network from a test file.
 * The file format first specify the number of nodes followed by lines,
 * that discribing eddges in the format from capacity.
 */
public class NetworkParser {

    /**
     * Parses a text file to crate and return the graph object.
     *
     * @param filePath Path to the input file
     * @return The parsed graph object
     * @throws FileNotFoundException If the file does not exist at the given path
     */
    public static Graph parse(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Read the number of nodes from it to the graph
        int nodes = Integer.parseInt(scanner.nextLine().trim());
        Graph graph = new Graph(nodes);

        // Read each edge lines and add it to the grapj
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;   // Skip the empty lines

            // Split the lines into parts: from, to and capacity
            String[] parts = line.split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);

            // Add edge to the graph
            graph.addEdge(from, to, capacity);
        }

        scanner.close();    // Close the scanner to free the resources
        return graph;
    }
}