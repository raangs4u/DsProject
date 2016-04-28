package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 22/3/16.
 */
public class Diffk {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{1, 3, 5, 5});
        System.out.println(diffPossible(a, 0));
    }

    public static int diffPossible(List<Integer> a, int b) {
        int n = a.size();
        for (int i = 0; i <n-1 ; i++) {
            int x = b + a.get(i);
            int start = i+1;
            int end = n-1;
            while (start<=end) {
                int mid = (start+end)/2;
                if (a.get(mid) == x) {
                    return 1;
                } else if (a.get(mid) < x) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return 0;
    }
}
