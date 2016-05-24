package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("a", "b"));
    }
    public static int minDistance(String a, String b) {
        if(a.length()> b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0) {
                    dp[i][j] = j;
                } else if(j==0) {
                    dp[i][j] = i;
                } else if(a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1+ min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }

    static int min(int x, int y, int z)
    {
        return Math.min((Math.min(x, y)), z);
    }
}
