package com.company.Graph;

import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public interface Graph {

    Set<Integer> getVertices();

    Map<Integer, Set<Integer>> getAdjacencyList();

    boolean areAdjacent(Integer u, Integer v);

    void insertVertex(Integer v);

    void insertEdge(Integer u, Integer v);

    void removeVertex(Integer v);

    void removeEdge(Integer u, Integer v);

    Integer getDegree(Integer v);

    Integer getVertexCount();

    Integer getEdgeCount();

}
