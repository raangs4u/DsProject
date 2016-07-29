package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class RobotMovements {

    public static final int[] DX = {0, 0, 1, -1};
    public static final int[] DY = {1, -1, 0, 0};

    public static void main(String[] args) {
        uniqueWays(4,4);
    }

    public static void uniqueWays(int m, int n) {
        int[][] visited = new int[m][n];
        int[] count = new int[1];
        count[0] = 0;
        uniqueWaysUtils(visited, 0, 0, count);
        System.out.println(count[0]);
    }



    public static void uniqueWaysUtils(int[][] visited, int i, int j, int[] count) {
        int m = visited.length;
        int n = visited[0].length;
        if (i == m-1 && j == n-1) {
            count[0]++;
            return;
        }

        visited[i][j] = 1;
        for (int k = 0; k <4 ; k++) {
            int p = i + DX[k];
            int q = j + DY[k];
            if (isValid(p,q,visited)) {
                uniqueWaysUtils(visited, p, q, count);
                // backtrack
                visited[p][q] = 0;
            }
        }
    }

    public static boolean isValid(int i, int j, int[][] vis) {
        int m = vis.length;
        int n = vis[0].length;
        return i>=0 && i<m && j>=0 && j<n && vis[i][j] == 0;
    }
}
