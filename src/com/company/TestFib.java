package com.company;

/**
 * Created by rmandada on 21/3/16.
 */
public class TestFib {

    public static void main(String[] args) {
        //int n = 7;
        System.out.println(div(55, 4));
    }

    public static int getNthFib(int n) {
        int a = 1;
        int b = 2;
        int c = 3;
        if (n<=3) {
            return n;
        }

        for(int i=0; i<n-3; i++) {
            int sum = (1000000007 + 1000000008)% 1000000007;
            sum  = 1000000007 + 1000000008;
            System.out.println(sum);
            a = b;
            b = c;
            c = sum;
        }

        return c;
    }

    public static int  div(int dividend, int divisor) {
        int quotient = 0;
        int k = 0;
        while (divisor <= dividend && divisor > 0) {
            divisor <<= 1;
            k++;
        }
        while (k-- > 0) {
            divisor >>= 1;
            if (divisor <= dividend) {
                dividend -= divisor;
                quotient = (quotient << 1) + 1;
            }
            else quotient <<= 1;
        }
        return quotient;
    }
}
