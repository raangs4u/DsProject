package com.company.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public class DirectedAdjacencyListGraph implements Graph {

    private Map<Integer, Set<Integer>> adjList;

    @Override
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    @Override
    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return adjList;
    }

    @Override
    public boolean areAdjacent(Integer u, Integer v) {
        return adjList.get(u).contains(v);
    }

    @Override
    public void insertVertex(Integer v) {
        adjList.put(v, new HashSet<>());
    }

    @Override
    public void insertEdge(Integer u, Integer v) {
        if (!adjList.containsKey(u)) {
            insertVertex(u);
        }

        if (!adjList.containsKey(v)) {
            insertVertex(v);
        }
        
        adjList.get(u).add(v);
    }

    @Override
    public void removeVertex(Integer v) {
        
    }

    @Override
    public void removeEdge(Integer u, Integer v) {
        adjList.get(u).remove(v);
    }

    @Override
    public Integer getDegree(Integer v) {
        return 0;
    }

    @Override
    public Integer getVertexCount() {
        return adjList.size();
    }

    @Override
    public Integer getEdgeCount() {
        return 0;
    }
}
