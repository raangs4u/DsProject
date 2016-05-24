package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class MinRodCutting {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(5);
        rodCut(6,B);

    }
    public static ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        B.add(0,0);
        B.add(A);
        int n = B.size();
        long[][] dp = new long[n][n];
        int[][] s = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                dp[i][j] = -1;
                s[i][j] = -1;
            }
        }
        long best = rodCutWithMemoization(0, n-1, B, s, dp);
        /*for(int i=0;i<n-1;i++){
            dp[i][i]= 0;
            dp[i][i+1] = 0;
            s[i][i] = -1;
            s[i][i+1] = -1;
        }
        dp[n-1][n-1]=0;
        s[n-1][n-1]=0;
        *//*for(int i=0;i<n-2;i++){*//*
            for (int l = 2; l <n ; l++) {
                for(int i=0;i<n-l;i++){
                    int j = i+l;
                    int min = Integer.MAX_VALUE;
                    for(int k= i+1; k<j;k++){
                        int x = dp[i][k]+dp[k][j]+(B.get(j)-B.get(i));
                        if(min>x){
                            min = x;
                            s[i][j] = k;
                        }
                    }
                    dp[i][j] = min;
                }

            }*/

        ArrayList<Integer> res = new ArrayList<Integer>();
        getSolution(B, s, res, 0, n-1);
        return res;

    }

    public static long rodCutWithMemoization(int l, int r, ArrayList<Integer> B, int[][] s, long[][] dp) {
        if (l+1 >= r) {
            return 0;
        }

        if (dp[l][r]!= -1) {
            return dp[l][r];
        }

        long min = Long.MAX_VALUE;
        long x;
        for (int i = l+1; i <r ; i++) {
            x = rodCutWithMemoization(l,i,B,s,dp)+rodCutWithMemoization(i,r,B,s,dp)+B.get(r)-B.get(l);
            if (x<min){
                min = x;
                s[l][r] = i;
            }
        }
        dp[l][r] = min;

        return dp[l][r];
    }

    public static void getSolution(List<Integer> B, int[][] s, ArrayList<Integer> res, int i, int j) {
        if (i+1>= j)  {
            return;
        }
        res.add(B.get(s[i][j]));
        getSolution(B, s, res, i, s[i][j]);
        getSolution(B, s, res, s[i][j], j);
        /*if(s[i][j] == -1) {
            return;
        }

        int k = s[i][j];
        res.add(B.get(k));
        getSolution(B, s, res, i, k);

        getSolution(B, s, res, k, j);*/

    }
}
