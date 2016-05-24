package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class JumpGameArray {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{3,2,1,0,4});
        canJump(a);
    }
    public static int canJump(List<Integer> a) {
        int n = a.size();
        int[] dp = new int[n];
        dp[n-1] = n-1;
        for (int i = n-2; i >=0 ; i--) {
            int idx = dp[i+1];
            if (i+a.get(i) >=idx) {
                dp[i] = i;
            } else {
                dp[i] = dp[i+1];
            }
        }

        if(a.get(0)>= dp[0]) {
            return 1;
        } else {
            return 0;
        }

    }
}
