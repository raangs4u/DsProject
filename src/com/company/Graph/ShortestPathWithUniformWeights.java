package com.company.Graph;

import java.util.*;

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

        System.out.println(shortestPathByBFS(graph,2, 1));
    }

    public static List<Integer> shortestPathByBFS(Graph graph, int u, int v) {
        int V = graph.getVertexCount();
        int[] dist = new int[V];
        int[] predes = new int[V];
        for (int i = 0; i <V ; i++) {
            dist[i]=-1;
        }
        dist[u]=0;
        predes[u]= -1;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(u);
        while (!queue.isEmpty()) {
            int x = queue.removeFirst();
            for (Integer y: graph.getAdjacentVertices(x)) {
                if (dist[y]==-1) {
                    dist[y] = dist[x]+1;
                    predes[y]=x;
                    queue.addLast(y);
                }
            }
        }

        for (int i=0;i<V;i++){
            System.out.println(dist[i]);
        }

        //System.out.println("Shortest path: ");
        List<Integer> res = new ArrayList<>();
        int t=v;
        while (t!=-1) {
            //System.out.println(t);
            res.add(t);
            t = predes[t];
        }

        Collections.reverse(res);

        return res;
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
