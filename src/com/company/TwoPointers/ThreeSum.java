package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rmandada on 22/3/16.
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{-1, 0, 1, 2, -1, -4});
        System.out.println(threeSumClosest(a, 0));
    }

    public static int threeSumClosest(List<Integer> a, int b) {
        //long sum = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int res = 0;
        int n = a.size();
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<n; i++) {
            //int ss = b - a.get(i);

            int j = i+1;
            int k = n-1;
            while (j<k) {
                int sum = a.get(i) + a.get(j) + a.get(k);
                int diff = Math.abs(sum - b);
                if (diff == 0) {
                    //return sum;
                    ArrayList<Integer> x = new ArrayList<Integer>();
                    x.add(a.get(i));
                    x.add(a.get(j));
                    x.add(a.get(k));
                    r.add(x);
                }
                if (diff < min) {
                    min = diff;
                    res = sum;
                }

                if (sum <= b) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        return res;
    }
}
