package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class InterleavingStrings {

    public static void main(String[] args) {
        System.out.println(isInterleave("LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh", "Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf","Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh"));
    }
    public static int isInterleave(String a, String b, String c) {
        int m = a.length();
        int n = b.length();
        int k = c.length();
        if(k!=m+n) {
            return 0;
        }
        int[][] dp = new int[k+1][m+1];
        dp[0][0] = 1;
        for (int i = 1; i <=n ; i++) {
            dp[i][0] = c.substring(0,i).equals(b.substring(0,i)) ? 1: 0;
        }
        for (int i = 1; i <=k ; i++) {
            for (int j = 1; j <=m && j<=i ; j++) {
                int x = i-j;
                if (x <0 || x>n) {
                    continue;
                } else {
                    if (x==0 && a.substring(0,j).equals(c.substring(0,i))) {
                        dp[i][j] = 1;
                    } else if (x!=0 && a.charAt(j-1) == b.charAt(x-1) && a.charAt(j-1) == c.charAt(i-1)) {
                        if (dp[i-1][j-1] ==1) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                    } else if (x!=0 && a.charAt(j-1) == c.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (x!=0 && b.charAt(x-1) == c.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[k][m];
    }
}
