package com.company.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public class DirectedAdjacencyListGraph implements Graph {

    private Map<Integer, Set<Integer>> adjList;

    private Map<Integer, Integer> inDegree;

    public DirectedAdjacencyListGraph() {
        adjList = new HashMap<>();
        inDegree = new HashMap<>();
    }

    public DirectedAdjacencyListGraph(int size) {
        adjList = new HashMap<>(size);
        inDegree = new HashMap<>(size);
        for (int i = 0; i <size ; i++) {
            adjList.put(i, new HashSet<>());
            inDegree.put(i,0);
        }
    }

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
    public void addVertex(Integer v) {
        adjList.put(v, new HashSet<>());
        inDegree.put(v,0);
    }

    @Override
    public void addEdge(Integer u, Integer v) {
        if (!adjList.containsKey(u)) {
            addVertex(u);
        }

        if (!adjList.containsKey(v)) {
            addVertex(v);
        }
        
        adjList.get(u).add(v);
        inDegree.put(v, inDegree.get(v)+1);
    }

    @Override
    public void removeVertex(Integer v) {
        
    }

    @Override
    public void removeEdge(Integer u, Integer v) {
        adjList.get(u).remove(v);
        inDegree.put(v, inDegree.get(v)-1);
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

    @Override
    public Set<Integer> getAdjacentVertices(Integer v) {
        return adjList.get(v);
    }

    public int getInDegree(int v) {
        return inDegree.get(v);
    }
}
