package com.company.Graph;

import java.util.Set;

/**
 * @author rmandada
 */
public class ShotestPathForWeightedGraphs {

    public static void main(String[] args) {
        int V = 5;
        DirectedWeightedGraph graph = new DirectedWeightedGraph(V);
        graph.addEdge(0,1,6);
        graph.addEdge(0,4,7);
        graph.addEdge(1,2,5);
        graph.addEdge(1,3,-4);
        graph.addEdge(1,4,8);
        graph.addEdge(2,1,-2);
        graph.addEdge(3,0,2);
        graph.addEdge(4,2,-3);
        graph.addEdge(4,3,9);

        double[] d = new double[V];
        int[] pi = new int[V];

        if (shortestPathByBellmanFord(graph, 0, d, pi)) {
            for (int i = 0; i <V ; i++) {
                System.out.println("For "+ i+ " : weight = " + d[i]);
                getPath(pi, 0, i);
                System.out.println();
            }
        } else {
            System.out.println("Source can reach a negative-weighted cycle");
        }
    }

    public static void getPath(int[] pi, int s, int v) {
        if (v==s) {
            System.out.print(s + " ");
        } else if (pi[v] == -1) {
            System.out.println("No path from "+ s+ " to " + v+ " exists");
        } else {
            getPath(pi, s, pi[v]);
            System.out.print(v + " ");
        }
    }

    public static void initializeSingleSourceGraph(DirectedWeightedGraph graph, int s, double[] d, int[] pi) {
        for (int i = 0; i <d.length ; i++) {
            d[i]=Double.POSITIVE_INFINITY;
            pi[i] = -1;
        }
        d[s] = 0;
    }

    public static void relax(Edge e, double[] d, int[] pi) {
        if(d[e.dest] > d[e.src] + e.weight) {
            d[e.dest] = d[e.src] + e.weight;
            pi[e.dest] = e.src;
        }
    }

    public static boolean shortestPathByBellmanFord(DirectedWeightedGraph graph, int s, double[] d, int[] pi) {
        int V = graph.getVertexCount();
        initializeSingleSourceGraph(graph, s, d, pi);

        Set<Edge> allEdges = graph.allEdges();
        for (int i = 1; i <=V-1 ; i++) {
            for (Edge e: allEdges) {
                relax(e, d, pi);
            }
        }

        for (Edge e: allEdges) {
            if (d[e.dest] > d[e.src] + e.weight) {
                return false;
            }
        }

        return true;
    }
}
