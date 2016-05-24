package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class EvalExpressionToTrue {
    public static void main(String[] args) {
        System.out.println(cnttrue("T^T^T^F|F&F^F|T^F^T"));
    }

    public static int cnttrue(String a) {
        int n = a.length();
        if(n%2==0) {
            return 0;
        }

        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            for (int j = 0; j <n ; j++) {
                dp[i][j][1]=-1;
                dp[i][j][0]=-1;
            }
        }

        /*for(int l=3;l<=n;l=l+2) {
            for(int i=0;i<=n-l;i=i+2) {
                int j = i+l-1;
                int res=0;
                int res1 = 0;
                for(int k=i+1;k<j;k=k+2) {
                    res += eval(a, i, j, k, 1,dp);
                    res1 += eval(a, i, j, k, 0,dp);
                }

                dp[i][j][1] = res;
                dp[i][j][0] = res1;
            }
        }
        return dp[0][n-1][1]%1003;*/
        return tr(a,dp,0,n-1);
    }

    public static int tr(String a, int[][][] dp, int i, int j) {
        if(i>j) {
            return 0;
        }
        if(dp[i][j][1] >=0) {
            return dp[i][j][1];
        }

        if (i==j) {
            return a.charAt(i)=='T'?1:0;
        }

        int res = 0;
        for(int k=i+1;k<j;k=k+2) {
            switch (a.charAt(k)) {
                case '|':
                    res += (tr(a,dp,i,k-1) * fa(a,dp,k+1,j)+ fa(a,dp,i,k-1) * tr(a,dp,k+1,j) + tr(a,dp,i,k-1) * tr(a,dp,k+1,j));
                    break;
                case '&':
                    res += (tr(a,dp,i,k-1) * tr(a,dp,k+1,j));
                    break;
                case '^':
                    res += (tr(a,dp,i,k-1) * fa(a,dp,k+1,j)+ fa(a,dp,i,k-1) * tr(a,dp,k+1,j));
                    break;
            }
            //res1 += eval(a, i, j, k, 0,dp);
        }
        if(res>=1003) {
            res = res%1003;
        }
        dp[i][j][1]=res;
        return res;
    }

    public static int fa(String a, int[][][] dp, int i, int j) {
        if(i>j) {
            return 0;
        }
        if(dp[i][j][0] >=0) {
            return dp[i][j][0];
        }

        if (i==j) {
            return a.charAt(i)=='F'?1:0;
        }

        int res = 0;
        for(int k=i+1;k<j;k=k+2) {
            switch (a.charAt(k)) {
                case '|':
                    res += (fa(a,dp,i,k-1) * fa(a,dp,k+1,j));
                    break;
                case '&':
                    res += (fa(a,dp,i,k-1) * fa(a,dp,k+1,j) + tr(a,dp,i,k-1) * fa(a,dp,k+1,j)+fa(a,dp,i,k-1) * tr(a,dp,k+1,j));
                    break;
                case '^':
                    res += (tr(a,dp,i,k-1) * tr(a,dp,k+1,j)+ fa(a,dp,i,k-1) * fa(a,dp,k+1,j));
                    break;
            }
            //res1 += eval(a, i, j, k, 0,dp);
        }
        if(res>=1003) {
            res = res%1003;
        }
        dp[i][j][0]=res;
        return res;
    }



    public static int eval(String a, int i, int j, int k, int v, int[][][] dp) {
        //boolean res = false;
        int res=0;

        if (v==1) {
            switch (a.charAt(k)) {
                case '|':
                    res = dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][1];
                    break;
                case '&':
                    res = dp[i][k - 1][1] * dp[k + 1][j][1];
                    break;
                case '^':
                    res = dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1];
                    break;
            }
        } else {
            switch (a.charAt(k)) {
                case '|':
                    res = dp[i][k - 1][0] * dp[k + 1][j][0];
                    break;
                case '&':
                    res = dp[i][k - 1][1] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] +dp[i][k - 1][0] * dp[k + 1][j][0];
                    break;
                case '^':
                    res = dp[i][k - 1][1] * dp[k + 1][j][1] + dp[i][k - 1][0] * dp[k + 1][j][0];
                    break;
            }
        }

        return res;
    }
}
