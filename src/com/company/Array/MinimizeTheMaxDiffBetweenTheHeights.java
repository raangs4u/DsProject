package com.company.Array;

import java.util.Arrays;

/**
 * Given heights of n towers and a value k. We need to either increase or decrease height of every tower by k (only once) where k > 0.
 * The task is to minimize the difference between the heights of the longest and the shortest tower after modifications, and output this difference.
 * http://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 *
 * @author rmandada
 */
public class MinimizeTheMaxDiffBetweenTheHeights {
    public static void main(String[] args) {
        int arr[] = {1, 15, 10} ;
        System.out.println(getMinDiff(arr,6));
    }

    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n<=1) {
            return 0;
        }

        Arrays.sort(arr);

        int max = arr[n-1];
        int min = arr[0];

        if (k>= (max-min)) {
            for (int i = 0; i <n ; i++) {
                arr[i] += (max-min);
            }
            return (max-min);
        }

        arr[0] += k;
        arr[n-1] -= k;

        int newMax = Math.max(arr[0], arr[n-1]);
        int newMin = Math.min(arr[0], arr[n-1]);

        for (int i = 1; i <n-1 ; i++) {
            if (arr[i] < newMin) {
                arr[i] += k;
            } else if (arr[i] > newMax) {
                arr[i] -= k;
            } else if ((arr[i]-newMin) > (newMax-arr[i])) {
                arr[i] -= k;
            } else {
                arr[i] += k;
            }

            newMax = Math.max(newMax, arr[i]);
            newMin = Math.min(newMin, arr[i]);
        }

        return (newMax-newMin);
    }
}
