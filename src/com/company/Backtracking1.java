package com.company;

import java.math.BigInteger;

/**
 * @author rmandada
 */
public class Backtracking1 {

    public static void main(String[] args) {
        Mod(71045970, 41535484, 64735492);
    }

    public static int Mod(int a, int b, int c) {
        if(b==0) {
            return 1%c;
        }
        int temp;
        BigInteger x;
        if(b %2 ==0) {
            temp = (Mod(a, b/2, c)%c);
            x = BigInteger.valueOf(temp);
            x = x.multiply(x);
            x = x.remainder(BigInteger.valueOf(c));
            return x.intValue();
        } else {
            temp = (Mod(a, (b-1)/2, c)%c);
            x = BigInteger.valueOf(temp);
            x = x.multiply(x);
            x = x.multiply(BigInteger.valueOf(a));
            x = x.add(BigInteger.valueOf(a));
            x = x.remainder(BigInteger.valueOf(c));
            return x.intValue();
        }
    }
}
