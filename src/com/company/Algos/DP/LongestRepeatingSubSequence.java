package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class LongestRepeatingSubSequence {

    public static void main(String[] args) {
        System.out.println(anytwo("abba"));
    }

    public static int anytwo(String a) {
        int n = a.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        // Longest Common sequence between a1 and a2(=a1) where a1[i]!=a2[i]
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j && a.charAt(i-1)==a.charAt(j-1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        if(dp[n][n] > 1) {
            return 1;
        }

        return 0;
    }
}
