package com.company.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public class UndirectedAdjacencyListGraph implements Graph {

    private Map<Integer, Set<Integer>> adjList;

    public UndirectedAdjacencyListGraph(int size) {
        adjList = new HashMap<>(size);
        for (int i = 0; i <size ; i++) {
            adjList.put(i, new HashSet<>());
        }
    }

    public UndirectedAdjacencyListGraph() {
        adjList = new HashMap<>();
    }

    @Override
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    @Override
    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return adjList;
    }

    public Set<Integer> getEdges(Integer v) {
        return adjList.get(v);
    }

    @Override
    public boolean areAdjacent(Integer u, Integer v) {
        return adjList.get(u).contains(v);
    }

    @Override
    public void addVertex(Integer v) {
        adjList.put(v, new HashSet<>());
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
        adjList.get(v).add(u);
    }

    @Override
    public void removeVertex(Integer v) {
        Set<Integer> edges = getEdges(v);
        for (Integer u : edges) {
            removeEdge(v, u);
        }

        adjList.remove(v);
    }

    @Override
    public void removeEdge(Integer u, Integer v) {
        adjList.get(u).remove(v);
        adjList.get(v).remove(u);
    }

    @Override
    public Integer getDegree(Integer v) {
        return adjList.get(v).size();
    }

    @Override
    public Integer getVertexCount() {
        return adjList.size();
    }

    @Override
    public Integer getEdgeCount() {
        Integer size = 0;
        for (Integer vertex : adjList.keySet()) {
            size += getDegree(vertex);
        }

        return size/2;
    }

    @Override
    public Set<Integer> getAdjacentVertices(Integer v) {
        return adjList.get(v);
    }
}
