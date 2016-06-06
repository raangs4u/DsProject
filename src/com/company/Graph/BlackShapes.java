package com.company.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class BlackShapes {

    public static void main(String[] args) {
        List<String> in = new ArrayList<>();
        in.add("OOOXOOO");
        in.add("OOXXOXO");
        in.add("OXOOOXO");
        System.out.println(black(in));
    }

    public static int black(List<String> a) {
        int m = a.size();
        int n = a.get(0).length();
        int[][] p = new int[m][n];
        int val = 0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(a.get(i).charAt(j)=='X') {
                    p[i][j] = val++;
                } else {
                    p[i][j] = -1;
                }
            }
        }
        UndirectedAdjacencyListGraph graph = new UndirectedAdjacencyListGraph(val);
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] != -1) {
                    if (i<m-1 && p[i+1][j] != -1) {
                        graph.addEdge(p[i][j], p[i+1][j]);
                    }
                    if (j<n-1 && p[i][j+1] != -1) {
                        graph.addEdge(p[i][j], p[i][j+1]);
                    }

                    if (i>0 && p[i-1][j] != -1) {
                        graph.addEdge(p[i][j], p[i-1][j]);
                    }
                    if (j>0 && p[i][j-1] != -1) {
                        graph.addEdge(p[i][j], p[i][j-1]);
                    }

                }
            }
        }

        int[] visited = new int[graph.getVertexCount()];
        List<Integer> res = new ArrayList<>();
        int V = visited.length;
        int shapes = 0;
        for (int i = 0; i <V ; i++) {
            if (visited[i]==0) {
                DFS.dfsByRecursionUtil(graph, i, visited, res);
                shapes++;
            }
        }
        return shapes;
    }
}
