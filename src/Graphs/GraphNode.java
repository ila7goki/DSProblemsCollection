package Graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class GraphNode {
    public int id;
    public LinkedList<GraphNode> adjacentNodes;

    public GraphNode(int id) {
        this.id = id;
        adjacentNodes = new LinkedList<>();
    }

    public int getId() {
        return this.id;
    }

    public List<GraphNode> grAdjacentNodeList() {
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
}
