package com.company.Algos.DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author RANGA.
 */
public class StocksIII {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{1833291, 7227481, 8289951,2389102, 9102789, 8585135, 1869227, 4082835, 8447466, 4985240, 4176179});
        maxProfit(a);
    }

    public static int maxProfitOn(final List<Integer> a) {
        int n = a.size();
        if (n==0|| n==1) {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        int min= a.get(0);
        left[0] = 0;
        for (int i = 1; i <n ; i++) {
            min = Math.min(min, a.get(i));
            left[i] = Math.max(left[i-1], a.get(i)-min);
        }

        int max= a.get(n-1);
        right[n-1] = 0;
        for (int i = n-2; i >=0 ; i--) {
            max = Math.max(max, a.get(i));
            right[i] = Math.max(right[i+1], max-a.get(i));
        }

        int maxProfit = 0;
        for (int i = 0; i <n ; i++) {
            maxProfit = Math.max(maxProfit, left[i]+right[i]);
        }

        return maxProfit;
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
        int[] max = new int[n];
        max[n-1] = a.get(n-1);
        for (int i = n-2; i >=0 ; i--) {
            max[i] = Math.max(a.get(i), max[i + 1]);
        }
        dp[n-1][1] = 0;
        dp[n-1][2] = 0;
        for (int i = n-2; i >=0 ; i--) {
            int maxx = 0;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j) >= a.get(i)) {
                    int x = 0;
                    if (j == n - 1) {
                        x = (a.get(j) - a.get(i));
                    } else {
                        x = (a.get(j) - a.get(i)) + dp[j + 1][1];
                    }
                    maxx = Math.max(x, maxx);
                } else {
                    continue;
                }
            }
            maxx = Math.max(maxx, dp[i + 1][2]);
            dp[i][2] = maxx;
            int max1 = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                max1 = Math.max(max1, max[j]-a.get(j));
            }
            dp[i][1] = max1;
        }
        return dp[0][2];
    }
}
