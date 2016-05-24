package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class MaxSumWithoutAdjacentElements {
    public int adjacent(ArrayList<ArrayList<Integer>> a) {
        List<Integer> s = a.get(0);
        List<Integer> s1 = a.get(1);
        int c = s.size();
        for (int i = 0; i <c ; i++) {
            s.set(i, Math.max(s.get(i),s1.get(i)));
        }

        int[][] dp = new int[c][2];
        dp[0][0] = 0;
        dp[0][1] = s.get(0);

        for (int i = 1; i <c ; i++) {
            dp[i][1] = s.get(i)+dp[i-1][0];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        }

        return Math.max(dp[c-1][0], dp[c-1][1]);

    }
}
