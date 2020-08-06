package PVL9_Tobias;

import java.util.List;

public interface Graph_III {
    Boolean setEdge(int source, int destin);
    List<List<Integer>> getEdges();
    Boolean hasCircle();
    List<Integer> topSort();
    List<List<Integer>> getStronglyConnectedComponents();
}
