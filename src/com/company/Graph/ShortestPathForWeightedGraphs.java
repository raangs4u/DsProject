package com.company.Graph;

import com.company.Tree.MinHeap;

import java.util.*;

/**
 * @author rmandada
 */
public class ShortestPathForWeightedGraphs {

    public static void main(String[] args) {
        int V = 5;
        DirectedWeightedGraph graph = new DirectedWeightedGraph(V);
        graph.addEdge(0,1,6);
        graph.addEdge(0,4,7);
        graph.addEdge(1,2,5);
        graph.addEdge(1,3,4);
        graph.addEdge(1,4,8);
        graph.addEdge(2,1,2);
        graph.addEdge(3,0,2);
        graph.addEdge(4,2,3);
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

        System.out.println();
        System.out.println("By Dijkstras: ");
        List<Vertex> vertices = shortestPathByDijkstrasWithHeap(graph, 0);
        for (int i = 0; i <V ; i++) {
            System.out.println("For "+ i + " : weight = " + vertices.get(i).key);
            getPath(vertices, 0, vertices.get(i));
            System.out.println();
        }
    }

    public static void getPath(List<Vertex> vertexes, int s, Vertex v) {
        if (s==v.value) {
            System.out.print(s + " ");
        } else if (v.pi == -1) {
            System.out.println("No path from "+ s+ " to " + v.value+ " exists");
        } else {
            getPath(vertexes, s, vertexes.get(v.pi));
            System.out.print(v.value + " ");
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

    public static List<Vertex> shortestPathByDijkstras(DirectedWeightedGraph graph, int s) {
        int V = graph.getVertexCount();
        //initializeSingleSourceGraph(graph, s, d, pi);
        PriorityQueue<Vertex> queue = new PriorityQueue<>(V);
        List<Vertex> vertexes = new ArrayList<>();
        for (int i=0;i<V;i++) {
            vertexes.add(new Vertex(i, Double.POSITIVE_INFINITY, -1));
        }

        vertexes.get(s).key = 0.0;
        queue.addAll(vertexes);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge e :graph.getOutGoingEdges(v.value)){
                Vertex u = vertexes.get(e.getOther(v.value));
                if (u.key > v.key + e.weight) {
                    u.key = v.key + e.weight;
                    u.pi = v.value;
                }
            }
        }

        return vertexes;

    }

    public static List<Vertex> shortestPathByDijkstrasWithHeap(DirectedWeightedGraph graph, int s) {
        int V = graph.getVertexCount();


        Vertex[] vertexes = new Vertex[V];
        for (int i=0;i<V;i++) {
            vertexes[i] = new Vertex(i, Double.POSITIVE_INFINITY, -1);
        }
        vertexes[s].key = 0.0;
        Vertex[] vertices1 = vertexes.clone();
        MinHeap<Vertex> heap = new MinHeap<>(vertexes, V, 100);
        heap.buildHeap();

        while (!heap.isEmpty()) {
            Vertex v= heap.removeMin();
            for (Edge e :graph.getOutGoingEdges(v.value)){
                Vertex u = vertices1[e.getOther(v.value)];
                if (u.key > v.key + e.weight) {
                    u.key = v.key + e.weight;
                    u.pi = v.value;
                    int pos = heap.indexOf(u);
                    heap.siftUp(pos);
                }
            }
        }

        return Arrays.asList(vertices1);
    }

    static class Vertex implements Comparable<Vertex>{
        int value;
        Double key ;
        int pi;

        public Vertex(int value, Double key, int pi) {
            this.value = value;
            this.key = key;
            this.pi = pi;
        }

        @Override
        public int compareTo(Vertex o) {
            return key.compareTo(o.key);
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}