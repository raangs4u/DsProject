package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rmandada
 */
public class MinJumpArray {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{2,3,1,1,4});
        jump1(a);
    }

    public static int jump1(List<Integer> a){
        if (a == null || a.size() == 0)
            return 0;

        if (a.size()==1) {
            return 0;
        }
        int lastReach = 0;
        int reach = 0;
        int step = 0;

        for (int i = 0; i <= reach && i < a.size(); i++) {
            //when last jump can not read current i, increase the step by 1
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            //update the maximal jump
            reach = Math.max(reach, a.get(i) + i);
        }

        if (reach < a.size() - 1)
            return -1;

        return step;
    }
    public static int jump(List<Integer> a) {
        int n = a.size();
        int[] dp = new int[n];
        dp[n-1] = 0;
        for (int i = n-2; i >=0 ; i--) {
            int jumps = a.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <=jumps ; j++) {
                if(i+j<=n-1) {
                    if (dp[i+j]==-1) {
                        //min = -1;
                        continue;
                    } else {
                        if (min<0) {
                            min = 1 + dp[i + j];
                        } else {
                            min = Math.min(min, 1 + dp[i + j]);
                        }
                    }
                } else {
                    min = 1;
                }
            }
            if (min==Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min;
            }

        }
        if (dp[0]>=0) {
            return dp[0];
        }
        return -1;
    }
}
