package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class RegularExpression {
    public static void main(String[] args) {
        System.out.println(isMatchByGreedy("ab","?*"));
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
            for (int j = 0; j <= n; j++) {
                if (p.charAt(i-1)!='*') {
                    if (j!=0 && (p.charAt(i-1)=='?' || p.charAt(i-1) == s.charAt(j-1))) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    int idx = j-1;
                    boolean found = false;
                    while (idx >=0) {
                        if (dp[i-1][idx+1] == 1) {
                            found=true;
                            dp[i][j] =1;
                            break;
                        }
                        idx--;
                    }
                    if (!found) {
                        dp[i][j] = dp[i-1][idx+1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static int isMatchByGreedy(final String str, final String pattern) {
        int m = str.length();
        int n = pattern.length();

        int s = 0; // cursor for traversal in str.
        int p = 0; // cursor for traversal in pattern.
        int starIdx = -1; // once we found a star, we want to record the place of the star.
        int match = 0;

        while (s < str.length()){
            // 1. case 1: we are not currently at any *,
            if (p < pattern.length() && (pattern.charAt(p) == str.charAt(s) || pattern.charAt(p) == '?')){
                p++;
                s++;
            }// 2. case 2: we are currently at a '*'
            else if (p < pattern.length() && pattern.charAt(p) == '*' ){
                starIdx = p;
                p++;
                match = s;
            } // 3. case 3: they do not match, we do not currently at a *, but the last matched is a *
            else if (starIdx != -1){
                match++;
                s = match;
                p = starIdx + 1;
            } // 4. case 4: they do not match, do not currently at a *, and last matched is not a *, then the answer is false;
            else{
                return 0;
            }
        }
        // when we finish matching all characters in str, is pattern also finished? we could only allow '*' at the rest of pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        if(p == pattern.length()) {
            return 1;
        }
        return 0;
    }
}
