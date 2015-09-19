package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class MatrixChainOrderByBottomUp {

    public static void main(String[] args) {
        int[] p = new int[] {30,35,15,5,10,20,25};
        matrixChainOrder(p);
    }

    public static void matrixChainOrder(int[] p) {
        int n = p.length-1;
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n][n+1];

        for (int i = 1; i <n+1 ; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <n+1 ; l++) {
            for (int i = 1; i <n-l+2 ; i++) {
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <j ; k++) {
                    int q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q <m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("finished");
        printOptimalParens(s,1,6);

    }

    public static void printOptimalParens(int[][] s, int i, int j) {
        if (i==j) {
            System.out.print("A"+i);
        } else {
            System.out.print("(");
            printOptimalParens(s,i,s[i][j]);
            printOptimalParens(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
