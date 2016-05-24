package com.company.Algos.DP;

/**
 * @author RANGA.
 */
public class ScrambleStrings {
    public static void main(String[] args) {
        System.out.println(isScrambleByRecursion("ABCDE", "CAEBD"));
    }
    public static int isScrambleByRecursion(final String a, final String b) {
        int n = a.length();
        if (a.length()!=b.length()) {
            return 0;
        }

        if (a.equals(b)) {
            return 1;
        }
        int[] c = new int[256];
        for (int i = 0; i <n ; i++) {
            c[a.charAt(i)]++;
            c[b.charAt(i)]--;
        }

        for (int i = 0; i <n ; i++) {
            if (c[i]!=0) {
                return 0;
            }
        }

        for (int l = 1; l <n ; l++) {
            String s11 = a.substring(0,l);
            String s12 = a.substring(l,n);
            String s21 = b.substring(0,l);
            String s22 = b.substring(l,n);
            if (isScrambleByRecursion(s11, s21)==1 && isScrambleByRecursion(s12, s22)==1) {
                return 1;
            }
            s21 = b.substring(0, n-l);
            s22 = b.substring(n-l, n);
            if (isScrambleByRecursion(s11, s22)==1 && isScrambleByRecursion(s12, s21)==1) {
                return 1;
            }
        }
        return 0;
    }

    public static int isScramble(final String a, final String b) {
        int n = a.length();
        if (a.length()!=b.length()) {
            return 0;
        }

        if (a.equals(b)) {
            return 1;
        }

        int[][][] dp = new int[n][n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (a.charAt(i)==b.charAt(j)) {
                    dp[i][j][0] = 1;
                }
            }
        }

        for (int k = 2; k <=n ; k++) {
            for (int i = n-k; i >=0 ; i--) {
                for (int j = n-k; j >=0 ; j--) {
                    int res = 0;
                    for (int l = 1; l <k ; l++) {
                        if((dp[i][j][l-1]==1 && dp[i+l][j+l][k-l-1] ==1)|| (dp[i+l][j][k-l-1]==1 && dp[i][j+k-l][l-1]==1)){
                            res = 1;
                            break;
                        }
                    }
                    dp[i][j][k-1] = res;
                }
            }
        }

        return dp[0][0][n-1];
    }
}
