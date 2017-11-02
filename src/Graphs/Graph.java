package Graphs;

import java.util.LinkedList;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class Graph {
    public LinkedList<Integer> adjacentNodes[];
    public int vertices;

    public Graph(int vertices)
    {
        this.vertices = vertices;
        adjacentNodes = new LinkedList[vertices];
    }
}
