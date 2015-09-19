package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class RodCuttingByTopDown {

    public static void main(String[] args) {
        int[] p = new int[]{0,1,5,8,9,10,17,17,20,24,30};
        System.out.println("max price for cut rod of length: 4 is "+ memoizedCutRod(p,10));

    }

    public static int memoizedCutRod(int[] p, int n) {
        int[] r = new int[n+1];
        int[] s = new int[n+1];
        for (int i = 0; i <n+1 ; i++) {
            r[i] = Integer.MIN_VALUE;
            s[i] = Integer.MIN_VALUE;
            //System.out.println(r[i]);
        }
        return memoizedCutRodAux(p,n,r,s);
    }

    public static int memoizedCutRodAux(int[] p, int n, int[] r, int[] s) {
        if(r[n] >= 0) {
            return r[n];
        }
        int q;
        if(n==0){
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <=n ; i++) {
                //q = Math.max(q, p[i]+ memoizedCutRodAux(p,n-i,r,s));
                int x = p[i]+ memoizedCutRodAux(p,n-i,r,s);
                if(q < x){
                    q = x;
                    s[n] = i;
                }
            }
        }
        r[n] = q;
        return q;
    }
}
