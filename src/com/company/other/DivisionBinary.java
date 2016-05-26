package com.company.other;

/**
 * Created by RANGA on 3/21/2016.
 */
public class DivisionBinary {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        long quotient = 0;
        int k = 0;
        int divisorSign = 1;
        int dividentSign = 1;
        long divsor = (long) divisor;
        long divdnt = (long) dividend;
        if (divdnt<0){
            dividentSign = -1;
            divdnt = -divdnt;
        }
        if (divsor <0) {
            divisorSign = -1;
            divsor = -divsor;
        }
        while (divsor <= divdnt && divsor > 0) {
            divsor <<= 1;
            k++;
        }
        /*if (divsor == Integer.MIN_VALUE) {
            divisor = Integer.MAX_VALUE;
        }*/

        while (k-- > 0) {
            divsor >>= 1;
            if (divsor <= divdnt) {
                divdnt -= divsor;
                quotient = (quotient << 1) + 1;
            }
            else quotient <<= 1;
        }
        quotient = dividentSign * divisorSign * quotient;
        if(quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)quotient;
    }
}
