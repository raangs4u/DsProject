package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RANGA.
 */
public class MinCostRodCutting {

    public  void solve(int A, List<Integer> B) {
        B.add(A);
        B.add(0,0);

        int n = B.size();

    }

    public int lis( ArrayList<Integer> arr )
    {
        int n = arr.size();
        int i,j, max=0;
        int[] lis = new int[n];

   /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

   /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr.get(i) > arr.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

   /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

   /* Free memory to avoid memory leak */
        //free( lis );

        return max;
    }
}
