package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class WaysToDecode {

    public static void main(String[] args) {
        System.out.println(numDecodings("12321"));
    }

    public static int numDecodings(String a) {
        int n = a.length();
        int[] dp = new int[n];
        for (int i = 0; i <n ; i++) {
            dp[i] = -1;
        }

        if (a.charAt(n-1)=='0') {
            dp[n-1] = 0;
        } else {
            dp[n-1] = 1;
        }

        for (int i = n-2; i>=0 ; i--) {
            int total = 0;
            if (isValid(a.substring(i, i+1))){
                if (i+1 <=n-1) {
                    total += dp[i + 1];
                } else {
                    total += 1;
                }

                if (isValid(a.substring(i, i+2))){
                    if (i+2 <=n-1) {
                        total += dp[i + 2];
                    } else {
                        total += 1;
                    }
                }
            }
            dp[i] = total;
        }
        return dp[0];

        //memoization
        //return memoization(a, 0, n-1, dp);
    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        if (s.length()>1 && Integer.valueOf(s) > 26) {
            return false;
        }
        return true;
    }

    public static int memoization(String a, int l, int r, int[][] dp) {
        if (l> r) {
            return 1;
        }
        if (dp[l][r] > -1) {
            return dp[l][r];
        }
        if (a.charAt(l) == '0') {
            return 0;
        }
        int total = 0;
        if(Integer.valueOf(a.substring(l, l+1)) >0) {
            total += memoization(a, l+1, r, dp);
        }

        if(l<r &&Integer.valueOf(a.substring(l,l+2)) <27 && Integer.valueOf(a.substring(l,l+2))>0) {
            total += memoization(a, l+2, r, dp);
        }
        dp[l][r] = total;
        return total;
    }
}
