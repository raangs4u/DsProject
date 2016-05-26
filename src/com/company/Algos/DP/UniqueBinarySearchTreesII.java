package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int a) {
        int[] dp = new int[a+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=a ; i++) {
            int res = 0;
            int x = i/2;
            for (int j = 1; j <=x ; j++) {
                res += 2* dp[j-1] * dp[i-j];
            }
            if (i%2==1) {
                res += dp[x]*dp[x];
            }
            dp[i]=res;
        }

        return dp[a];
    }
}
