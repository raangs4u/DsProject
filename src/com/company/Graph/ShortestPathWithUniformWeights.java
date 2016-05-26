package com.company.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author rmandada
 */
public class ShortestPathWithUniformWeights {
    public static void main(String[] args) {
        Graph graph = new DirectedAdjacencyListGraph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        System.out.println(shprtestPath(graph,2, 1));
    }

    public static List<Integer> shprtestPath(Graph graph, int u, int v) {
        int V = graph.getVertexCount();
        int[] visited = new int[V];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(u);
        visited[u]=1;
        List<Integer> res = new ArrayList<>();

        while (!deque.isEmpty()) {
            int x = deque.removeFirst();
            res.add(x);
            if (x == v) {
               return res;
            }

            List<Integer> temp = new ArrayList<>();
            for (Integer y : graph.getAdjacentVertices(x)) {
                int vis = 0;
                if (visited[y]==0) {
                    visited[y]=1;
                    if (y==v) {
                        res.add(y);
                        return res;
                    }
                    temp.add(y);
                } else {
                    vis++;
                    if (vis==graph.getAdjacentVertices(x).size()) {
                        res.remove(y);
                    }
                }
            }
            for (int y: temp) {
                deque.addLast(y);
            }
        }

        return new ArrayList<>();
    }
}
