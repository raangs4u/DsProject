package com.company.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author rmandada
 */
public class TopologicalSortDigraph {

    public static void main(String[] args) {
        DirectedAdjacencyListGraph  g = new DirectedAdjacencyListGraph(8);
        g.addEdge(2, 5);
        g.addEdge(0,3);
        g.addEdge(3, 7);
        g.addEdge(6, 7);
       // g.addEdge(2, 3);
       // g.addEdge(3, 1);

        System.out.println(topologicalSortByInDegree(g));
    }

    public static List<Integer> topologicalSort(DirectedAdjacencyListGraph graph) {
        Stack<Integer> res = new Stack<>();
        int[] visited = new int[graph.getVertexCount()];
        for (int i = 0; i <graph.getVertexCount() ; i++) {
            if (visited[i]==0) {
                topologicalSortUtil(graph, i, visited, res);
            }
        }

        return res;
    }

    public static void topologicalSortUtil(DirectedAdjacencyListGraph graph, int v, int[] visited, Stack<Integer> res) {
        visited[v]=1;
        for (int i: graph.getAdjacentVertices(v)) {
            if (visited[i]==0) {
                topologicalSortUtil(graph, i, visited, res);
            }
        }

        res.push(v);
    }

    public static List<Integer> topologicalSortByInDegree(DirectedAdjacencyListGraph graph) {
        int V = graph.getVertexCount();
        int[] inDegree = new int[V];
        //int[] visited
        for (int i = 0; i <V ; i++) {
            Set<Integer> ad = graph.getAdjacentVertices(i);
            for (int x: ad) {
                inDegree[x] = inDegree[x]+1;
            }
        }
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<V;i++) {
            if (inDegree[i]==0) {
                stack.push(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()){
            int top = stack.pop();
            res.add(top);
            for (int x : graph.getAdjacentVertices(top)) {
                inDegree[x] = inDegree[x]-1;
                if (inDegree[x]==0) {
                    stack.push(x);
                }
            }
        }

        return res;
    }
}
