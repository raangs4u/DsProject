package com.company.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static com.company.Graph.UnionFindAlgo.find;
import static com.company.Graph.UnionFindAlgo.union;

/**
 * @author rmandada
 */
public class MinimumSpanningTrees {

    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph(4);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        System.out.println(kruskalMST(graph));
        primsMST(graph, 0);
    }

    public static List<Edge> kruskalMST(UndirectedWeightedGraph graph) {
        List<Edge> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>(graph.allEdges());
        Collections.sort(edges);
        int V = graph.getVertexCount();
        Subset[] subsets = new Subset[V];
        for (int i = 0; i <V ; i++) {
            Subset set = new Subset();
            set.parent = i;
            set.rank = 0;
            subsets[i]= set;
        }
        int i=0;
        while (result.size() < V-1) {

            Edge e = edges.get(i++);

            int x = find(subsets, e.src);
            int y = find(subsets, e.dest);

            if (x!=y) {
                result.add(e);
                union(subsets, e.src, e.dest);
            }
        }

        return result;
    }

    public static void  primsMST(UndirectedWeightedGraph graph, int u) {
        int V = graph.getVertexCount();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(V);
        List<Vertex> vertexes = new ArrayList<>();
        for (int i=0;i<V;i++) {
            vertexes.add(new Vertex(i, Integer.MAX_VALUE, -1));
        }

        vertexes.get(u).key = 0;

        queue.addAll(vertexes);

        while (!queue.isEmpty()) {
            Vertex min = queue.poll();

            for (Edge e: graph.getAdjacentEdges(min.value)) {
                Vertex v = vertexes.get(e.getOther(min.value));
                if (queue.contains(v) && e.weight < v.key) {
                    v.key = e.weight;
                    v.pi = min.value;
                }
            }
        }

        for (int i = 0; i <V ; i++) {
            if (vertexes.get(i).pi != -1) {
                System.out.println(vertexes.get(i).pi + " -- " + i);
            }
        }

    }

    static class Vertex implements Comparable<Vertex>{
        int value;
        int key ;
        int pi;

        public Vertex(int value, int key, int pi) {
            this.value = value;
            this.key = key;
            this.pi = pi;
        }

        @Override
        public int compareTo(Vertex o) {
            return key - o.key;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
