package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class RegularExpressionII {
    public static void main(String[] args) {
        System.out.println(isMatch("abbbc","ab*c"));
    }
    public static int isMatch(final String s, final String p) {
        int m = p.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <=n ; i++) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;

        for (int i = 1; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (p.charAt(i-1)!='*') {
                    if (j!=0 && (p.charAt(i-1)=='.' || p.charAt(i-1) == s.charAt(j-1))) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    char prev = p.charAt(i-2);
                    int idx = j - 1;
                    boolean found = false;
                    while ((idx>=0)&& (prev == s.charAt(idx) || (prev == '.' ))) {
                        if(dp[i-2][idx+1] == 1) {
                            found = true;
                            dp[i][j] = 1;
                            break;
                        }
                        idx--;
                    }
                    if (!found) {
                        dp[i][j] = dp[i-2][idx+1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
