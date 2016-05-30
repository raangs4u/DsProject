package com.company.Graph;

/**
 * Can be used to detect a cycle in undirected graph(without self cycles).
 *
 * @author rmandada
 */
public class UnionFindAlgo {

    public static void main(String[] args) {
        Graph graph = new UndirectedAdjacencyListGraph(3);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,2);

        System.out.println(isCycleWithRank(graph));
    }

    public static boolean isCycle(Graph graph) {
        int[] parent = new int[graph.getVertexCount()];
        for (int i = 0; i <parent.length ; i++) {
            parent[i] = -1;
        }

        for (int u = 0; u <graph.getVertexCount() ; u++) {
            for (Integer v: graph.getAdjacentVertices(u)) {
                int x = find(parent, u);
                int y = find(parent, v);

                if (x==y) {
                    return true;
                }
                union(parent, u, v);
            }
        }

        return false;
    }

    public static int find(int[] parent, int u) {
        if (parent[u]==-1) {
            return u;
        }

        return find(parent, parent[u]);
    }

    public static void union(int[] parent, int x, int y) {
        int xSet = find(parent,x);
        int ySet = find(parent,y);
        parent[xSet] = ySet;
    }

    public static int find(Subset[] subsets, int v) {
        // find root and make it as parent of v(path compression)
        if (subsets[v].parent != v) {
            subsets[v].parent = find(subsets, subsets[v].parent);
        }

        return subsets[v].parent;
    }

    public static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public static boolean isCycleWithRank(Graph graph) {
        int V= graph.getVertexCount();
        Subset[] subsets = new Subset[V];
        for (int i = 0; i <V ; i++) {
            Subset set = new Subset();
            set.parent = i;
            set.rank = 0;
            subsets[i]= set;
        }

        for (int u = 0; u <graph.getVertexCount() ; u++) {
            for (Integer v : graph.getAdjacentVertices(u)) {
                int x = find(subsets, u);
                int y = find(subsets, v);

                if (x==y) {
                    return true;
                }
                union(subsets, u, v);
            }
        }

        return false;
    }
}
