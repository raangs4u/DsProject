package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class NthFibonacciByBottomUp {

    public static void main(String[] args) {
        System.out.println("nth fib is: "+ nthFib(10));
    }

    public static int nthFib(int n) {
        int[] f = new int[n+1];
        if(n == 1) return 0;
        else if (n==2) return 1;
        else {
            f[0] = 0;
            f[1] = 0;
            f[2] = 1;
            for (int i = 3; i <n+1 ; i++) {
                f[i] = f[i-1] + f[i-2];
            }
            return f[n];
        }

    }
}
