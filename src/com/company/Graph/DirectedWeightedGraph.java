package com.company.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public class DirectedWeightedGraph implements Graph {

    private Map<Integer, Set<Edge>> adjList;

    public DirectedWeightedGraph() {
        adjList = new HashMap<>();
    }

    public DirectedWeightedGraph(int V) {
        adjList = new HashMap<>(V);
        for (int i = 0; i <V ; i++) {
            adjList.put(i, new HashSet<>());
        }
    }

    @Override
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    @Override
    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return null;
    }

    @Override
    public boolean areAdjacent(Integer u, Integer v) {
        return false;
    }

    @Override
    public void addVertex(Integer v) {
        adjList.put(v, new HashSet<>());
    }

    @Override
    public void addEdge(Integer u, Integer v) {

    }

    public void addEdge(Integer u, Integer v, Integer weight) {
        Edge e = new Edge(u,v,weight);
        if (!adjList.containsKey(u)) {
            addVertex(u);
        }

        if (!adjList.containsKey(v)) {
            addVertex(v);
        }

        adjList.get(u).add(e);
    }

    @Override
    public void removeVertex(Integer v) {

    }

    @Override
    public void removeEdge(Integer u, Integer v) {

    }

    @Override
    public Integer getDegree(Integer v) {
        return null;
    }

    @Override
    public Integer getVertexCount() {
        return adjList.size();
    }

    @Override
    public Integer getEdgeCount() {
        return null;
    }

    @Override
    public Set<Integer> getAdjacentVertices(Integer v) {
        return null;
    }

    public Set<Edge> allEdges() {
        Set<Edge> edges = new HashSet<>();
        for (Map.Entry<Integer, Set<Edge>> entry: adjList.entrySet()) {
            edges.addAll(entry.getValue());
        }

        return edges;
    }

    public Set<Edge> getOutGoingEdges(Integer u) {
        return adjList.get(u);
    }
}
