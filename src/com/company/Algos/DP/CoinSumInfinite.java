package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class CoinSumInfinite {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{1, 2, 3});
        coinchange2(a,4);
    }
    public static int coinchange2(List<Integer> a, int b) {
        return count(a, a.size(), b);
    }

    public static int count(List<Integer> a, int m, int n) {
        int i,j,x,y;
        int[][] table = new int[n+1][m];

        for (i = 0; i <m ; i++) {
            table[0][i] = 1;
        }

        for (i = 1; i <n+1 ; i++) {
            for (j = 0; j <m ; j++) {
                x = (i-a.get(j)) >=0 ? table[i-a.get(j)][j] : 0;
                y = (j>=1) ? table[i][j-1] :0;
                table[i][j] = x+y;
            }
        }

        return table[n][m-1];
    }
}
