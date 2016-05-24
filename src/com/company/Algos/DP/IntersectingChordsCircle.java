package com.company.Algos.DP;

import java.math.BigInteger;

/**
 * @author rmandada
 */
public class IntersectingChordsCircle {

    public static void main(String[] args) {
        System.out.println(chordCnt(20));
    }

    public static int chordCnt(int A) {
        BigInteger[] dp = new BigInteger[A+1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        for(int i=2;i<=A;i++) {
            BigInteger ans = BigInteger.ZERO;
            int x = i-1;
            for(int j=0; j<= (x-1)/2; j++) {
                BigInteger z = BigInteger.valueOf(2);
                z = z.multiply(dp[j]);
                z = z.multiply(dp[x-j]);
                ans = ans.add(z);
            }
            if(x%2==0) {

                //ans = ans.multiply(dp[x/2]);
                ans = ans.add(dp[x/2].multiply(dp[x/2]));
            }
            dp[i] = ans;
        }

        return (dp[A].remainder(BigInteger.valueOf(1000000007))).intValue();
    }
}
