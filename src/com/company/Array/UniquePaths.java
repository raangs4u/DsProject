package com.company.Array;

import java.math.BigInteger;

/**
 * Created by rmandada on 29/2/16.
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(15,9));
    }

    public static int uniquePaths(int a, int b) {
        if(a==1 || b==1) {
            return 1;
        }
        BigInteger ans = factorial(a+b-2).divide(factorial(a-1).multiply(factorial(b-1)));
        return ans.intValue();
    }

    public static BigInteger factorial(int a) {
        if(a ==0) {
            return BigInteger.ONE;
        }
        BigInteger ans =BigInteger.ONE;
        for(int i=1; i<=a; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
}
