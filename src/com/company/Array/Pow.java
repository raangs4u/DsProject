package com.company.Array;

import java.math.BigInteger;

/**
 * Created by rmandada on 3/3/16.
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(pow(-1, 2, 20));
    }

    public static int pow(int x, int n, int d) {
        return pow1(BigInteger.valueOf(x), BigInteger.valueOf(n), BigInteger.valueOf(d)).intValue();
    }

    public static BigInteger pow1(BigInteger x, BigInteger n, BigInteger d) {
        if(n.equals(BigInteger.valueOf(0))) {
            return BigInteger.ONE.divideAndRemainder(d)[1];
        }
        if(n.divideAndRemainder(BigInteger.valueOf(2))[1].equals(BigInteger.valueOf(0))) {
            BigInteger m = (pow1(x, n.divide(BigInteger.valueOf(2)), d).divideAndRemainder(d)[1]);
            if(m.intValue()<0){
                m = m.add(d).divideAndRemainder(d)[1];
            } else {
                m = m.divideAndRemainder(d)[1];
            }
            m =m.multiply(m);
            m = m.divideAndRemainder(d)[1];
            return m;
        } else {
            BigInteger p = (pow1(x, (n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2))), d).divideAndRemainder(d)[1]);
            if(p.intValue()<0){
                p = p.add(d).divideAndRemainder(d)[1];
            } else {
                p = p.divideAndRemainder(d)[1];
            }
            p =p.multiply(p);
            p = p.multiply(x.add(d).divideAndRemainder(d)[1]);
            p = p.divideAndRemainder(d)[1];
            return p;
        }
    }
}
