package Graphs;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class Graph {

    private HashMap<Integer, GraphNode> lookupMap = new HashMap<>();

    public GraphNode getNode(int id)
    {
        return this.lookupMap.get(id);
    }

    public void addEdge(int src, int dest) {
        GraphNode s, d;
        if (!this.lookupMap.containsKey(src)) {
            s = new GraphNode(src);
            this.lookupMap.put(src, s);
        } else {
            s = this.lookupMap.get(src);
        }

        if (!this.lookupMap.containsKey(dest)) {
            d = new GraphNode(dest);
            this.lookupMap.put(dest, d);
        } else {
            d = this.lookupMap.get(dest);
        }

        s.adjacentNodes.addFirst(d);
    }


    public void DFS(Graph graph) {
        HashSet<Integer> visited = new HashSet<>();

        for (GraphNode gn : graph.lookupMap.values()) {
            if (!visited.contains(gn.getId())) {
                DFSUtil(gn, visited);
            }
        }
    }

    private void DFSUtil(GraphNode graphNode, HashSet<Integer> visited) {
        visited.add(graphNode.getId());
        System.out.println(graphNode.getId());

        //if(visited.contains(graphNode.getId())) return false;
        for (GraphNode aN : graphNode.grAdjacentNodeList()) {
            if (!visited.contains(aN.getId())) {
                DFSUtil(aN, visited);
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 7);
        g.addEdge(2, 6);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 5);
        g.addEdge(4, 3);

        for (GraphNode gn : g.lookupMap.values()) {
            System.out.println(gn.id + " -> " + gn.getAdjacentNodesStr());
        }

        System.out.println("Depth First Traversal: ");
        g.DFS(g);
    }

}
