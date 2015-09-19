package com.company.Algos.DP;

/**
 * Created by RANGA on 9/19/2015.
 */
public class MatrixChainOrderByTopDown {

    public static void main(String[] args) {
        int[] p = new int[] {30,35,15,5,10,20,25};
        System.out.println("optimal cost for multiplication is: "+memoizedMatrixChain(p));
    }

    public static int memoizedMatrixChain(int[] p) {
        int n = p.length-1;
        int[][] m = new int[n+1][n+1];
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        return lookUpChain(m,p,1,n);
    }

    public static int lookUpChain(int[][] m, int[] p, int i, int j) {
        if (m[i][j] < Integer.MAX_VALUE){
            return m[i][j];
        }

        if (i==j) {
            m[i][j] = 0;
        } else {
            for (int k = i; k <j ; k++) {
                int q = lookUpChain(m,p,i,k)+lookUpChain(m,p,k+1,j)+p[i-1]*p[k]*p[j];
                if (q < m[i][j]) {
                    m[i][j] = q;
                }
            }
        }
        return m[i][j];
    }
}
