package Graphs;

import java.util.*;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class Graph {

    private HashMap<Integer, GraphNode> lookupMap = new HashMap<>();

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
            System.out.println(gn.getId() + " -> " + gn.getAdjacentNodesStr());
        }

        System.out.println("Depth First Traversal: ");
        g.DFS(g);

        System.out.println("Breadth First Traversal: ");
        g.BFS(g);
    }

    public List<GraphNode> getAllGraphNodes() {
        return new LinkedList<>(lookupMap.values());
        //return lookupMap.values().stream().collect(Collectors.toList()); // Java 8 feature
    }

    public GraphNode getNode(int id) {
        return this.lookupMap.get(id);
    }

    public GraphNode getFirstNode() {
        if (!this.lookupMap.isEmpty())
            return this.lookupMap.entrySet().iterator().next().getValue();
        else
            return null;
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

        s.addAdjacentNode(d);
    }

    /*** Traversal of Graph using Depth first approach. i.e. we look at deep into a child node before looking at other
     *   children/adjacent ndoes. ***/

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
        for (GraphNode aN : graphNode.getAdjacentNodeList()) {
            if (!visited.contains(aN.getId())) {
                DFSUtil(aN, visited);
            }
        }
    }

    /*** Traversal of the Graph using Breadth first approach. i.e. All nodes in a level are visited first
     *   before their child nodes. ***/

    public void BFS(Graph g) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<GraphNode> nextToVisit = new LinkedList<>();

        for (GraphNode node : g.getAllGraphNodes()) {

            if (!visited.contains(node.getId())) {
                nextToVisit.add(node);

                while (!nextToVisit.isEmpty()) {
                    GraphNode currNode = nextToVisit.remove();

                    if (visited.contains(currNode.getId())) continue;

                    visited.add(currNode.getId());
                    System.out.println(currNode.getId());

                    for (GraphNode gn : currNode.getAdjacentNodeList()) {
                        nextToVisit.add(gn);
                    }
                }
            }
        }
    }
}
