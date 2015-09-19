package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class LCSLengthByBottomUp {

    public static void main(String[] args) {
        char[] x = new char[] {'#','A','B','C','B','D','A','B'};
        char[] y = new char[] {'#','B','D','C','A','B','A'};
        System.out.println("LCS is: "+LCSLength(x,y));
    }

    public static int LCSLength(char[] x, char[] y) {
        int m = x.length-1;
        int n = y.length-1;
        
        int[][] c = new int[m+1][n+1];
        char[][] b = new char[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            c[i][0] = 0;
        }

        for (int j = 0; j < n+1; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = '\\';
                } else if(c[i-1][j] >= c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    b[i][j] = '|';
                } else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '-';
                }
            }
        }
        return c[m][n];
    }
}
