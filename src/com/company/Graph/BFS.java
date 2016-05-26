package com.company.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;

/**
 * @author rmandada
 */
public class BFS {

    public static void main(String[] args) {
        Graph graph = new DirectedAdjacencyListGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        System.out.println(bfs(graph,2));
    }

    public static List<Integer> bfs(Graph graph, int v) {
        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] =1;
        queue.addLast(v);

        while (!queue.isEmpty()) {
            int x  = queue.removeFirst();
            res.add(x);
            Set<Integer> adjacentVertices = graph.getAdjacentVertices(x);
            for (int u : adjacentVertices) {
                if (visited[u]==0) {
                    visited[u] =1;
                    queue.addLast(u);
                }
            }
        }
        return res;
    }

}
