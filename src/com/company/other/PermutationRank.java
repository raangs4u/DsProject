package com.company.other;

import java.math.BigInteger;

/**
 * Created by RANGA on 2/27/2016.
 */
public class PermutationRank {

    public static void main(String[] args) {
        System.out.println(findRank("acb"));
    }

    public static int findRank(String a) {
        BigInteger rank =BigInteger.valueOf(1);
        int s = a.length();
        for(int i=0; i<s;i++){
            BigInteger y = BigInteger.valueOf(findNoOfChars(a.substring(i).toCharArray(), a.charAt(i))).multiply(factorial(s - 1 - i));
            rank = rank.add(y);
        }
        BigInteger[] r = rank.divideAndRemainder(BigInteger.valueOf(1000003));
        return r[1].intValue();
    }

    public static BigInteger factorial(int n) {
        BigInteger a = BigInteger.valueOf(1);
        for(int i=2; i<=n; i++){
            a = a.multiply(BigInteger.valueOf(i));
        }
        return a;
    }

    public static int findNoOfChars(char[] c, char x) {
        int count = 0;
        for(int i=0;i<c.length;i++){
            if((int)c[i] < (int)x){
                count++;
            }
        }
        return count;
    }
}
