package com.company.Strings;

import java.math.BigInteger;

/**
 * Created by rmandada on 9/3/16.
 */
public class PowerOf2 {

    public static void main(String[] args) {
        System.out.println(power("1"));
    }

    private static final double LOG2 = Math.log(2.0);

    public static int power(String a) {
        BigInteger integer = new BigInteger(a);
        if (integer.equals(BigInteger.ONE) || integer.equals(BigInteger.ZERO)) {
            return 0;
        }
        while (integer.compareTo(BigInteger.ONE) == 1) {
            integer = integer.divide(BigInteger.valueOf(2));
            int x = integer.divideAndRemainder(BigInteger.valueOf(10))[1].intValue();
            if ( x!= 1 && x%2!= 0) {
                return 0;
            }
        }
        return 1;
        /*double x = logOfBigInteger(integer)/Math.log10(2.0);
        if (x == Math.floor(x) && x>=1) {
            return 1;
        }
        return 0;*/
    }

    public static double logOfBigInteger(BigInteger val) {
        int blex = val.bitLength() - 1022; // any value in 60..1023 is ok
        if (blex > 0)
            val = val.shiftRight(blex);
        double res = Math.log10(val.doubleValue());
        return blex > 0 ? res + blex * LOG2 : res;
    }
}
