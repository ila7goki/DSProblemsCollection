package Graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class GraphNode {
    private int id;
    private LinkedList<GraphNode> adjacentNodes;
    private NodeState state;

    public GraphNode(int id) {
        this.id = id;
        adjacentNodes = new LinkedList<>();
    }

    public int getId() {
        return this.id;
    }

    public List<GraphNode> getAdjacentNodeList() {
        return this.adjacentNodes;
    }

    public String getAdjacentNodesStr() {

        StringBuilder adjacentNodeListStr = new StringBuilder();
        for (int i = 0; i < adjacentNodes.size(); i++) {
            adjacentNodeListStr.append(adjacentNodes.get(i).id);
            if (i < adjacentNodes.size() - 1) {
                adjacentNodeListStr.append(", ");
            }
        }
        return adjacentNodeListStr.toString();
    }

    public void addAdjacentNode(GraphNode node) {
        this.adjacentNodes.addFirst(node);
    }

    public NodeState getState() {
        return this.state;
    }

    public void setState(NodeState s) {
        this.state = s;
    }
}
