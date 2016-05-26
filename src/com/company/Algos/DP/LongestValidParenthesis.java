package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
    }

    public static int longestValidParentheses1(String a) {
        int n = a.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return memo(a,dp,0,n-1);
    }

    public static int memo(String a, int[][] dp, int i, int j) {
        if(i>j) {
            return 0;
        }
        if(i==j) {
            return 0;
        }
        if(dp[i][j]>=0){
            return dp[i][j];
        }
        int res1=0;
        int res2 = 0;
        int res =0;
        /*if(a.charAt(i)=='('&& a.charAt(j)==')') {
            int x = memo(a,dp,i+1,j-1);
            if(x>0) {
                res1 =x+2;
            }
        } else if(a.charAt(i)!='('&& a.charAt(j)!=')'){
            dp[i][j] = memo(a,dp,i+1,j-1);
            return dp[i][j];
        }*/

        if (a.charAt(i)==')') {
            dp[i][j] = memo(a,dp,i+1,j);
            return dp[i][j];
        }
        if (a.charAt(j)=='(') {
            dp[i][j] = memo(a,dp,i,j-1);
            return dp[i][j];
        }

        if(a.charAt(i)=='('&& a.charAt(j)==')') {
            int x = memo(a,dp,i+1,j-1);
            if(x>0 || i+1==j) {
                x =x+2;
            }
            res2 = Math.max(memo(a,dp,i+1,j), memo(a,dp,i,j-1));
            res = Math.max(x,res2);
        }

        /*res2 = Math.max(memo(a,dp,i+1,j), memo(a,dp,i,j-1));
        res = Math.max(res1,res2);*/
        dp[i][j] = res;
        return res;

    }

    public static int longestValidParentheses(String a) {
        int n = a.length();
        int[] longest = new int[n];
        longest[0] = 0;
        int max =0;
        for (int i = 1; i <n ; i++) {
            int res = 0;
            if (a.charAt(i)=='(') {
                res = 0;
            } else {
                if (a.charAt(i-1)=='(') {
                    res = i-2>=0 ?longest[i-2] + 2: 2;
                } else {
                    if (a.charAt(i-longest[i-1]-1)=='(') {
                        res = longest[i-1]+2;
                        if (i-longest[i-1]-2 >=0) {
                            res += longest[i-longest[i-1]-2];
                        }
                    }
                }
            }
            max = Math.max(res, max);

            longest[i]=res;
        }

        return max;
    }
}
