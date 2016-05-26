package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author RANGA.
 */
public class EqualAveragePartition {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{1, 7, 15, 29, 11, 9});
        System.out.println(avgset(s));
    }
    public static ArrayList<ArrayList<Integer>> avgset(List<Integer> a) {
        Collections.sort(a);
        int totalSize = a.size();
        int totalSum =0;
        for (int v: a){
            totalSum +=v;
        }
        boolean[][][] dp = new boolean[totalSize][totalSum+1][totalSize];

        for (int i = 0; i <totalSize ; i++) {
            for (int j = 0; j <=totalSum ; j++) {
                for (int k = 0; k <totalSize ; k++) {
                    dp[i][j][k] = true;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <totalSize ; i++) {
            if ((totalSum*i)%totalSize!=0){
                continue;
            }
            int currentSum = (totalSum*i)/totalSize;
            ArrayList<Integer> s1 = new ArrayList<Integer>();
            if (isPossible(0,currentSum, i,totalSize,dp, s1,a)){
                ArrayList<Integer> s2 = new ArrayList<Integer>();
                int ptr1=0,ptr2=0;
                while (ptr1 <a.size() || ptr2 < s1.size()) {
                    if (ptr2<s1.size() && a.get(ptr1)== s1.get(ptr2)) {
                        ptr1++;
                        ptr2++;
                        continue;
                    }
                    s2.add(a.get(ptr1));
                    ptr1++;
                }

                res.add(s1);
                res.add(s2);
                return res;
            }
        }

        return res;
    }

    public static boolean isPossible(int idx, int currentSum, int size, int totalSize, boolean[][][] dp, List<Integer> s, List<Integer> a) {
        if (size==0) {
            return currentSum==0;
        }

        if (idx>=totalSize) {
            return false;
        }

        if (dp[idx][currentSum][size] == false) {
            return false;
        }

        if (currentSum >=a.get(idx)) {
            s.add(a.get(idx));
            if (isPossible(idx+1, currentSum-a.get(idx), size-1, totalSize, dp, s,a)) {
                return true;
            }
            s.remove(a.get(idx));
        }

        if (isPossible(idx+1, currentSum, size,totalSize, dp,s,a)) {
            return true;
        }

        return dp[idx][currentSum][size]=false;
    }


}
