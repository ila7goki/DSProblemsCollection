package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Goki_PC on 11/3/2017.
 */
public class GraphSearchProblems {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 4);

        GraphSearchProblems p1 = new GraphSearchProblems();

        System.out.println("Path between 1 -> 4 : " + p1.isPathExists(1, 4, g));
        System.out.println("Path between 4 -> 1 : " + p1.isPathExists(3, 1, g));

    }

    public boolean isPathExists(int start, int end, Graph graph) {
        GraphNode startNode = graph.getNode(start);
        GraphNode endNode = graph.getNode(end);

        if (startNode == null || endNode == null) return false;

        Queue<GraphNode> visitedQ = new LinkedList<>();

        //Set all nodes default state to be unvisited
        for (GraphNode node : graph.getAllGraphNodes()) {
            node.setState(NodeState.UNVISITED);
        }

        visitedQ.add(startNode);
        while (!visitedQ.isEmpty()) {
            GraphNode currNode = visitedQ.remove();

            for (GraphNode node : currNode.getAdjacentNodeList()) {
                if (node.getState() == NodeState.UNVISITED) {
                    if (node == endNode) {
                        return true;
                    } else {
                        node.setState(NodeState.VISITING);
                        visitedQ.add(node);
                    }
                }
            }
            currNode.setState(NodeState.VISITED);
        }

        return false;
    }
}
