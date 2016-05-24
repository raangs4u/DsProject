package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class DistinctSubSequences {

    public static void main(String[] args) {
        System.out.println(numDistinct("aaaababbababbaabbaaababaaabbbaaabbb", "bbababa"));
    }

    public static int numDistinct(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = 1;
        }
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i<j) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<=m;i++) {
            for(int j=i; j<=n; j++) {
                if(T.charAt(i-1)==S.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
