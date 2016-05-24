package com.company.Algos.DP;

import java.math.BigInteger;

/**
 * @author RANGA.
 */
public class CountPermutationsofBST {

    public static void main(String[] args) {
        System.out.println(countPermBSTByDP(35,7));
    }

    public static int cntPermBST(int A, int B) {

        if(A<=1) {
            if (B==0) {
                return 1;
            }else {
                return 0;
            }
        }

        int res1 =0;
        for (int i = 1; i <=A ; i++) {
            int x = i-1;
            int y = A-i;

            int res=0;
            for (int j = 0; j <=B-2 ; j++) {
                res += cntPermBST(x,j)*cntPermBST(y,B-1);
            }

            for (int j = 0; j <=B-2 ; j++) {
                res += cntPermBST(x,B-1) * cntPermBST(y, j);
            }

            res += cntPermBST(x,B-1)*cntPermBST(y,B-1);
            res1 = res1 + res * choose(x+y,y).intValue();
        }

        return res1;
    }

    public static BigInteger choose(int x, int y){
        BigInteger res = fact(x);
        res = res.divide(fact(x-y));
        res = res.divide(fact(y));
        res = res.remainder(BigInteger.valueOf(1000000007));
        return res;
    }

    public static BigInteger fact(int x) {
        BigInteger temp = BigInteger.ONE;
        for (int i = 1; i <=x ; i++) {
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }

    public static int countPermBSTByDP(int A, int B) {
        int[][] dp = new int[A+1][B+1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 1; i <=B ; i++) {
            dp[0][i] = 0;
            dp[1][i]=0;
        }

        int rem = 1000000007;

        for (int i = 2; i <=A ; i++) {
            for (int j = 1; j <=B && j<i ; j++) {
                BigInteger res1=BigInteger.ZERO;

                for (int k = 1; k <=i ; k++) {
                    int x =k-1;
                    int y = i-k;

                    BigInteger res=BigInteger.ZERO;
                    for (int l = 0; l <=j-2 ; l++) {
                        res = res.add (BigInteger.valueOf(dp[x][l]).multiply(BigInteger.valueOf(dp[y][j-1])));
                    }

                    for (int l = 0; l <=j-2 ; l++) {
                        res = res.add (BigInteger.valueOf(dp[x][j-1]).multiply(BigInteger.valueOf(dp[y][l])));
                    }
                    res = res.add (BigInteger.valueOf(dp[x][j-1]).multiply(BigInteger.valueOf(dp[y][j-1])));
                    res1 = res1.add(res.multiply(choose(x+y,y)));

                }
                res1 = res1.remainder(BigInteger.valueOf(rem));
                dp[i][j] = res1.intValue();
            }
        }

        return dp[A][B];
    }
}
