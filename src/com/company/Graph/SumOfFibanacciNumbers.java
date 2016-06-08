package com.company.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class SumOfFibanacciNumbers {

    public static void main(String[] args) {
        System.out.println(fibsum(23));
    }

    public static int fibsum(int a) {
        /*int[] dp = new int[a+1];
        for (int i = 0; i <=a ; i++) {
            dp[i]=-1;
        }
        return momoiz(a, getFibNumTillN(a), dp);*/
        return fibsumByGreedy(a, getFibNumTillN(a));
    }

    public static int momoiz(int num, List<Integer> fib, int[] dp) {
        if (num == 0) {
            return 0;
        }

        if (dp[num]>=0) {
            return dp[num];
        }
        int res = Integer.MAX_VALUE;
        int i=0;
        while (i<fib.size() && fib.get(i)<= num) {
            int min = 1 + momoiz(num-fib.get(i),fib,dp);
            res = Math.min(res,min);
            i++;
        }
        dp[num] = res;
        return res;

    }

    public static List<Integer> getFibNumTillN(int n) {
        List<Integer> res = new ArrayList<>();
        int first = 1;
        int second =1;


        while (second <=n) {
            res.add(second);
            int t = first;
            first = second;
            second += t;
        }

        return res;
    }

    public static int fibsumByGreedy(int a, List<Integer> fib) {
        if (a==0) {
            return 0;
        }
        int x = getLargeFib(a,fib);
        return fibsumByGreedy(a-x, fib)+1;
    }

    public static int getLargeFib(int a, List<Integer> fib) {
        int n = fib.size();
        for (int i =n-1 ; i >=0 ; i--) {
            if (fib.get(i)<=a){
                return fib.get(i);
            }
        }
        return 0;
    }
}
