package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class EvaluateExpressionToTrue {
    //not the correct one
    public int cnttrue(String a) {
        int n = a.length();
        if(n%2 ==0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i <n ; i++) {
            if(a.charAt(i)=='T') {
                dp[i][i] = 1;
            }
        }
        return 0;
    }
}
