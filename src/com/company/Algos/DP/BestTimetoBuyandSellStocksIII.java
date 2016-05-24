package com.company.Algos.DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class BestTimetoBuyandSellStocksIII {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{7551982, 8124939, 4023780, 7868369, 4412570});
        maxProfit(a);
    }
    public static int maxProfit(final List<Integer> a) {
        int n = a.size();
        int[][] dp = new int[n][3];
        if (n==0|| n==1) {
            return 0;
        }
        for (int i = 0; i <n ; i++) {
            dp[i][0] = 0;
        }
        dp[n-1][1] = 0;
        dp[n-1][2] = 0;
        for (int i = n-2; i >=0 ; i--) {
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j) >= a.get(i)) {
                    int x = 0;
                    if (j == n - 1) {
                        x = (a.get(j) - a.get(i));
                    } else {
                        x = (a.get(j) - a.get(i)) + dp[j + 1][1];
                    }
                    max = Math.max(x, max);
                } else {
                    continue;
                }
            }
            max = Math.max(max, dp[i + 1][2]);
            dp[i][2] = max;
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j) > a.get(i)) {
                    maxIdx = j;
                }
            }
            dp[i][1] = a.get(maxIdx) - a.get(i);
        }
        return dp[0][2];
    }
}
