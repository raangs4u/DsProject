package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(minCut("abbbaaba"));
    }
    public static int minCut(String a) {
        int n = a.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return memo(a, n-1, dp);
    }

    public static int memo(String a, int idx, int[] dp) {
        if (idx<0) {
            return 0;
        }
        if (isPalindrome(a.substring(0,idx+1))) {
            dp[idx] = 0;
            return dp[idx];
        }


        if (dp[idx]>=0) {
            return dp[idx];
        }
        int res = idx;
        for (int i = idx; i >=1 ; i--) {
            String s = a.substring(i,idx+1);
            if(isPalindrome(s)) {
                res = Math.min(res, 1+memo(a,i-1,dp));
            }
        }
        dp[idx] = res;
        return res;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        if (n<=0) {
            return true;
        }
        int st = 0;
        int end = n-1;
        while (st<end) {
            if (s.charAt(st)!=s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }

        return true;
    }

}
