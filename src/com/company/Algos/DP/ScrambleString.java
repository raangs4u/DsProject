package com.company.Algos.DP;

import java.util.Arrays;

/**
 * @author rmandada
 */
public class ScrambleString {
    public static void main(String[] args) {
        System.out.println(isScramble("qmfcwwzbqkf","wfcmbzwqqkf"));
    }
    public static int isScramble(final String a, final String b) {
        int n = a.length();
        if (a.length()!=b.length()) {
            return 0;
        }
        if (n==0) {
            return 1;
        }

        if (n==1) {
            if (a.charAt(0)==b.charAt(0)) {
                return 1;
            }
            return 0;
        }
        /*char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        if (x!=y) {
            return 0;
        }
        int[][][] dp = new int[n][n][n+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 1; k <=n ; k++) {

                }
            }
        }*/
        if (a.charAt(n-1)==b.charAt(n-1)) {
            return isScramble(a.substring(0,n-1), b.substring(0, n-1));
        } else {
            int idx = 0;
            while (idx<=n-1 && a.charAt(idx)!=b.charAt(n-1)) {
                idx++;
            }
            if (idx==n) {
                return 0;
            }
            int x = isScramble(a.substring(0,idx), b.substring(0, idx));
            int y = isScramble(a.substring(idx+1), b.substring(idx, n-1));
            if (x ==1 && y ==1) {
                return 1;
            }
            int p = isScramble(a.substring(0,idx), b.substring(n-1-idx,n-1));
            int q = isScramble(a.substring(idx+1), b.substring(0, n-idx-1));
            if (p==1 && q ==1) {
                return 1;
            }
        }

        return 0;
        /*int n = a.length();

        int[][][] dp = new int[n][n][n+1];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return isScramble(a,b,0,0,a.length(), dp);*/
    }

    public static int isScramble(final String a, final String b, int sidx1, int sidx2, int len, int[][][] dp) {
        if (len==0) {
            dp[sidx1][sidx2][len] = 1;
            return 1;
        }

        if (len==1) {
            if (a.charAt(sidx1)==b.charAt(sidx2)) {
                dp[sidx1][sidx2][len] = 1;
            } else {
                dp[sidx1][sidx2][len] = 0;
            }
            return dp[sidx1][sidx2][len];
        }

        /*char[] x = a.substring(sidx1,sidx1+len).toCharArray();
        char[] y = b.substring(sidx2,sidx2+len).toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        if (!new String(x).equals(new String(y))) {
            dp[sidx1][sidx2][len] = 0;
            return 0;
        }*/

        if (dp[sidx1][sidx2][len] >0) {
            return dp[sidx1][sidx2][len];
        }

        int res = 0;
        for (int i = 1; i <=len ; i++) {
            if (isScramble(a,b, 0, 0, i, dp)==1 && isScramble(a,b,i,i,len-i,dp)==1) {
                res = 1;
                break;
            }
            if (isScramble(a,b, 0, len-i, i,dp)==1 && isScramble(a,b, i, 0, len-i, dp)==1) {
                res = 1;
                break;
            }
        }
        dp[sidx1][sidx2][len] = res;
        return res;
    }
}
