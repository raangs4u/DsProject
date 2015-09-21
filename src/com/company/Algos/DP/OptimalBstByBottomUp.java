package com.company.Algos.DP;

/**
 * Created by RANGA on 9/21/2015.
 */
public class OptimalBstByBottomUp {

    public static void main(String[] args) {
        double[] p = new double[]{0.0,.15,.10,.05, .10, .20};
        double[] q = new double[]{0.05,0.10,0.05,0.05,0.05,0.10};
        int n = 5;
        optimalBST(p,q,n);
    }

    public static void optimalBST(double[] p, double[] q, int n) {
        double[][] e = new double[n+2][n+1];
        double[][] w = new double[n+2][n+1];
        int[][] root = new int[n+1][n+1];

        for (int i = 1; i <n+2 ; i++) {
            e[i][i-1] = q[i-1];
            w[i][i-1] = q[i-1];
        }

        for (int l = 1; l <n+1 ; l++) {
            for (int i = 1; i <=n-l+1 ; i++) {
                int j = i+l-1;
                e[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j-1]+p[j]+q[j];
                for (int r = i; r <j+1 ; r++) {
                    double t = e[i][r-1]+e[r+1][j]+w[i][j];
                    if (t<e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }

        System.out.println("min cost is : "+e[1][n]);
        System.out.println("root is: "+root[1][n]);
    }
}
