package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class StocksWithKTransactions {
    public static void main(String[] args) {
        int[] p = new int[]{1833291, 7227481, 8289951,2389102, 9102789, 8585135, 1869227, 4082835, 8447466, 4985240, 4176179};
        System.out.println(maxProfit(2,p));
    }
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];

        for (int i = 1; i <k+1 ; i++) {
            int tempMax = dp[i-1][0]-prices[0];
            for (int j = 1; j <n ; j++) {
                tempMax = Math.max(tempMax, dp[i-1][j-1]-prices[j]);
                dp[i][j] = Math.max(dp[i][j-1], tempMax+prices[j]);
            }
        }

        return dp[k][n-1];
    }
}
