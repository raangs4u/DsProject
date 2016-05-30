package com.company.Graph;

/**
 * @author rmandada
 */
public class Edge implements Comparable<Edge> {

    int src, dest, weight;

    public Edge() {
    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.weight = weight;
        this.dest = dest;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return src + " -- " + dest + " == " + weight;
    }

    public int getOther(int x) {
        if (src == x) {
            return dest;
        }

        return src;
    }
}
