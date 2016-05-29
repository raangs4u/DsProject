package com.company.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author RANGA.
 */
public class StroglyConnectedComponents {

    public static void main(String[] args) {
        DirectedAdjacencyListGraph graph = new DirectedAdjacencyListGraph(8);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,2);
        graph.addEdge(1,4);
        graph.addEdge(4,0);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,5);
        graph.addEdge(6,7);
        graph.addEdge(7,7);
        graph.addEdge(1,5);
        graph.addEdge(2,6);
        graph.addEdge(3,7);
        System.out.println(stroglyConnectedComponents(graph));
    }

    public static List<List<Integer>> stroglyConnectedComponents(DirectedAdjacencyListGraph graph) {
        int[] time = new int[1];
        int V = graph.getVertexCount();
        int[] visited = new int[V];
        int[] finishTime = new int[V];
        time[0]=0;
        for(int i=0;i<V;i++) {
            if (visited[i]==0){
                dfsVisit(graph, i, visited, finishTime, time);
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <V ; i++) {
            map.put(finishTime[i],i);
        }

        List<Integer> ft = new ArrayList<>(map.keySet());
        Collections.sort(ft);
        Collections.reverse(ft);

        DirectedAdjacencyListGraph tGraph = transposeGraph(graph);
        List<List<Integer>> res = new ArrayList<>();
        int[] visited2 = new int[V];
        for (Integer x: ft) {
            if (visited2[map.get(x)]==0) {
                List<Integer> r = new ArrayList<>();
                dfsTransposeGraph(tGraph, visited2, map.get(x), r);
                res.add(r);
            }
        }

        return res;

    }

    public static void dfsTransposeGraph(DirectedAdjacencyListGraph graph, int[] visited, int u, List<Integer> res) {
        visited[u] = 1;
        res.add(u);
        for (Integer v: graph.getAdjacentVertices(u)) {
            if (visited[v]==0) {
                //visited[v]=1;
                dfsTransposeGraph(graph, visited, v, res);
            }
        }
    }

    public static DirectedAdjacencyListGraph transposeGraph(DirectedAdjacencyListGraph graph) {
        DirectedAdjacencyListGraph newGraph = new DirectedAdjacencyListGraph(graph.getVertexCount());
        for (Integer u: graph.getVertices()) {
            for (Integer v: graph.getAdjacentVertices(u)) {
                newGraph.addEdge(v,u);
            }
        }

        return newGraph;
    }

    public static void dfsVisit(DirectedAdjacencyListGraph graph, int u, int[] visited, int[] finishTime, int[] time) {
        time[0] += 1;
        visited[u] = 1;
        for (Integer v: graph.getAdjacentVertices(u)) {
            if (visited[v]==0) {
                dfsVisit(graph, v, visited, finishTime, time);
            }
        }

        time[0] += 1;
        finishTime[u] = time[0];
    }
}
