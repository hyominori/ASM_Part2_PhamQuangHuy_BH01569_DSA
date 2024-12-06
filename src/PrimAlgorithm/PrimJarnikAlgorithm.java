package PrimAlgorithm;
import java.util.*;

// Edge class representing an edge in the graph
class Edge implements Comparable<Edge> {
    int target, weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}
public class PrimJarnikAlgorithm {
    public static void primAlgorithm(List<List<Edge>> graph, int startNode) {
        int n = graph.size();
        boolean[] visited = new boolean[n]; // To keep track of visited nodes
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();

        // To store the MST edges
        List<Edge> mstEdges = new ArrayList<>();

        // Add initial edges of the starting node
        minHeap.add(new Edge(startNode, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();

            // If the node is already visited, skip it
            if (visited[current.target]) {
                continue;
            }

            // Mark the node as visited
            visited[current.target] = true;

            // Add the edge to the MST (ignore the first edge as it has weight 0)
            if (current.weight != 0) {
                mstEdges.add(current);
            }

            // Explore all adjacent nodes of the current node
            for (Edge edge : graph.get(current.target)) {
                if (!visited[edge.target]) {
                    minHeap.add(edge);
                }
            }
        }

        // Print the edges of the MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mstEdges) {
            System.out.println(edge.target + " - Weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int numberOfNodes = 5;

        // Initialize the graph as an adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        // Run Prim's algorithm starting from node 0
        primAlgorithm(graph, 0);
    }
}
