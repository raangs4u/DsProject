package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class RodCuttingByBottomUp {

    public static void main(String[] args) {
        int[] p = new int[]{0,1,5,8,9,10,17,17,20,24,30};
        System.out.println("max price for cut rod of length: 4 is "+ cutRod(p,10));
    }
    
    public static int cutRod(int[] p, int n) {
        int[] r = new int[n+1];
        int[] s = new int[n+1];
        r[0] = 0;
        s[0] = 0;
        for (int i = 1; i <n+1 ; i++) {
            r[i] = Integer.MIN_VALUE;
            s[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n+1; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <=i ; j++) {
                if(q < p[j]+r[i-j]) {
                    q = p[j]+r[i-j];
                    s[i] = j;
                }
            }
            r[i] = q;
        }
        return r[n];
    }
}
