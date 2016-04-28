package com.company.Backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class KthPermutation {

    public static void main(String[] args) {
        getPermutation(3,2);
    }

    public  static String getPermutation(int n, int k ) {
        //int[] nf = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
        BigInteger[] bnf = new BigInteger[n+1];
        bnf[0] = BigInteger.ONE;
        bnf[1] = BigInteger.ONE;
        for (int i = 2; i <=n ; i++) {
            bnf[i] = BigInteger.valueOf(i).multiply(bnf[i-1]);
        }
        List<String> s = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            s.add(String.valueOf(i));
        }
        int st = 0;
        k = k-1;
        getP(s, st,n,k,bnf);
        StringBuilder sb = new StringBuilder();
        for (String l : s) {
            sb.append(l);
        }

        return sb.toString();
    }

    public static void getP(List<String> in, int st, int n, int k, BigInteger[] bnf) {
        if (k==0 || st > n-1) {
            return;
        }

        BigInteger[] l = BigInteger.valueOf(k).divideAndRemainder(bnf[n-st-1]);
        String p = in.remove(st+l[0].intValue());
        in.add(st,p);
        k= l[1].intValue();
        getP(in, st+1, n, k, bnf);
    }
}
