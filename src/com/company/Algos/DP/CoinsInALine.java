package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class CoinsInALine {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{1, 100, 500, 10});
        System.out.println(maxcoin(a));
    }

    public static int maxcoin(List<Integer> a) {
        int n = a.size();
        if(n==0) {
            return n;
        } else if(n==1) {
            return a.get(0);
        }

        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++) {
            dp[i][1] = a.get(i);
        }
        for(int l=2;l<=n;l++) {

            for(int i=0;i<=n-l;i++) {
                int j = i+l-1;
                int res = Integer.MIN_VALUE;
                int x = a.get(i)+ (a.get(i+1)> a.get(j) ? (i+2>=n ? 0:dp[i+2][l-2]): (i+1>=n ? 0:dp[i+1][l-2]));
                res =Math.max(x,res);
                x = a.get(j)+ (a.get(i)> a.get(j-1) ? (i+1>=n ? 0:dp[i+1][l-2]): dp[i][l-2]);
                res = Math.max(res,x);
                dp[i][l]=res;
            }

        }

       // return dp[0][n];
        int[][][] dp1 = new int[2][n][n];
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 0; k <n ; k++) {
                    dp1[i][j][k] = -1;
                }
            }
        }
        return maxCoin(a,dp1, 0, 0, n-1);
    }

    public static int maxCoin(List<Integer> a, int[][][] dp, int i, int start, int end) {
        if(start > end) {
            return 0;
        }
        if (dp[i][start][end] >=0) {
            return dp[i][start][end];
        }
        if (i==0&& start == end) {
            dp[i][start][end] = a.get(start);
            return a.get(start);
        }
        int res = 0;
        int res1;
        int res2 ;
        if (i==0) {
            res1 = a.get(end) + maxCoin(a, dp, 1, start, end-1);
            res2 = a.get(start) + maxCoin(a,dp, 1, start+1, end);
            res=  Math.max(res1,res2);
        } else {
            res1 = maxCoin(a,dp,0,start,end-1);
            res2 = maxCoin(a,dp,0,start+1,end);
            res = Math.min(res1, res2);
        }
        dp[i][start][end] = res;
        return res;
    }
}
