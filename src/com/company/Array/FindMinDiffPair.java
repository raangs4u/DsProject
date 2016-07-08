package com.company.Array;

import java.util.Arrays;

/**
 * Given an unsorted array, find the minimum difference between any pair in given array.
 * http://www.geeksforgeeks.org/find-minimum-difference-pair/
 *
 * @author rmandada
 */
public class FindMinDiffPair {

    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 19, 18, 25};
        System.out.println(findMinDiff(arr));
    }

    public static int findMinDiff(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <arr.length-1 ; i++) {
            minDiff = Math.min(minDiff, arr[i+1]-arr[i]);
        }

        return minDiff;
    }
}
