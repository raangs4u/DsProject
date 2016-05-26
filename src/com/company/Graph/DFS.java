package com.company.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author rmandada
 */
public class DFS {

    public static void main(String[] args) {
        Graph graph = new UndirectedAdjacencyListGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        System.out.println(dfsByRecursionFromSource(graph,2));
    }

    public static List<Integer> dfsByRecursionFromSource(Graph graph, int v) {
        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();
        dfsByRecursionUtil(graph, v, visited, res);
        return res;
    }

    public static List<Integer> dfsByRecursionFromEveryNode(Graph graph) {
        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();
        int V = visited.length;

        for (int i = 0; i <V ; i++) {
            if (visited[i]==0) {
                dfsByRecursionUtil(graph, i, visited, res);
            }
        }
        return res;
    }

    public static void dfsByRecursionUtil(Graph graph, int v, int[] visited, List<Integer> res) {
        visited[v] =1;
        res.add(v);
        Set<Integer> adjacentVertices = graph.getAdjacentVertices(v);
        for (int u : adjacentVertices) {
            if (visited[u]==0) {
                dfsByRecursionUtil(graph, u, visited, res);
            }
        }
    }

    public static List<Integer> dfsByIterationUtil(Graph graph, int v, int[] visited, List<Integer> res) {

        Stack<Integer> stack = new Stack<>();

        visited[v] = 1;
        stack.push(v);
        while (!stack.isEmpty()) {
            int top = stack.pop();
            res.add(top);
            Set<Integer> adjacentVertices = graph.getAdjacentVertices(top);
            List<Integer> list = new ArrayList<>(adjacentVertices);
            for (int i=list.size()-1; i>=0;i--) {
                if (visited[list.get(i)] == 0) {
                    visited[list.get(i)] =1;
                    stack.push(list.get(i));
                }
            }

        }

        return res;

    }

    public static List<Integer> dfsByIterationFromEveryNode(Graph graph) {
        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();
        int V = visited.length;
        for (int i = 0; i <V ; i++) {
            if (visited[i]==0) {
                dfsByIterationUtil(graph, i, visited, res);
            }
        }

        return res;

    }

    public static List<Integer> dfsByIterationFromSource(Graph graph, int v) {
        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();
        dfsByIterationUtil(graph, v, visited, res);
        return res;
    }
}
