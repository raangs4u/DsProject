package com.company.Algos.DP;

/**
 * @author rmandada
 */
public class HorseAndStables {

    public static void main(String[] args) {
        System.out.println(arrange("WBWB", 2));
    }

    public static int arrange(String a, int b) {
        int n = a.length();
        int[][] s = new int[n+1][b+1];
        s[0][0] = 0;
        for (int i = 1; i <=n ; i++) {
            s[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <=b ; i++) {
            s[0][i]= Integer.MAX_VALUE;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=b&& j<=i ; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k>=1 && k <= i-j+1 ; k++) {
                    if (s[i-k][j-1] == Integer.MAX_VALUE){
                        min = Integer.MAX_VALUE;
                    } else {
                        min = Math.min(min, cost(a, i, k) + s[i - k][j - 1]);
                    }
                }
                s[i][j] = min;
            }
        }

        return s[n][b];
    }

    public static int cost(String a, int n, int m) {
        int w = 0;
        int b = 0;
        for (int i = n-1; i>n-m-1 ; i--) {
            if(a.charAt(i)=='W'){
                w++;
            } else {
                b++;
            }
        }
        return w*b;
    }
}
