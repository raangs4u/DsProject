package com.company.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 3/21/2016.
 */
public class DifferentBitSumPairWise {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(7);
        System.out.println(cntBits(a));
    }

    public static int cntBits(List<Integer> A) {
        long sum = 0;
        int mod = 1000000007;
        int n = A.size();
        for (int i = 0; i <32 ; i++) {
            long count= 0;
            for (int j = 0; j <n ; j++) {
                if ((A.get(j) & (1 << i)) != 0){
                    count++;
                }
            }
            sum += ((count * (n-count) *2)%mod);
            sum %= mod;
        }
        return (int)sum;
        /*for (int i = 0; i <A.size() ; i++) {
            for (int j = i; j <A.size() ; j++) {
                if (i==j) continue;
                sum = (sum + functionValue(A.get(i), A.get(j)))%mod;
            }
        }

        return (sum *2)%mod;*/
    }

    public static int functionValue(int x, int y) {
        return noOfSetBits(x^y);
    }

    public static int noOfSetBits(int n) {
        //n = n << 1;
        int count = 0;
        while (n >0) {
            if ((n & 1) != 0) {
                count++;
            }
            n>>=1;
        }
        return count;
    }
}
