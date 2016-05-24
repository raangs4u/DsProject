package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class Stairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
    public static int climbStairs(int a) {
        int[] dp = new int[a+1];
        dp[a] = 1;
        for (int i = a-1; i >=0 ; i--) {
            int ans = 0;
            ans += dp[i+1];
            if (i+2<=a) {
                ans += dp[i+2];
            }
            dp[i] = ans;
        }

        return dp[0];
    }
}
