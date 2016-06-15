package com.company.Array;

/**
 * Given an array of integers, find two non-overlapping contiguous sub-arrays such that the absolute
 * difference between the sum of two sub-arrays is maximum.
 * http://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/
 *
 * @author rmandada
 */
public class MaxAbsoluteDiffBetweenTwoContiguousSubArrays {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        MaxAbsoluteDiffBetweenTwoContiguousSubArrays subArrays = new MaxAbsoluteDiffBetweenTwoContiguousSubArrays();
        System.out.println(subArrays.findMaxAbsDiff(a));
    }

    public int findMaxAbsDiff(int[] arr) {
        int n = arr.length;

        int[] leftMaxSum = new int[n];
        int[] rightMaxSum = new int[n];
        int[] leftMinSum = new int[n];
        int[] rightMinSum = new int[n];
        leftSubArrayMaxSum(arr, leftMaxSum);
        rightSubArrayMaxSum(arr, rightMaxSum);

        // To find min sum in arr[0..i] just invert arr and find max sum using kadane
        int[] invertArray = new int[n];
        for (int i = 0; i <n ; i++) {
            invertArray[i] = -arr[i];
        }
        leftSubArrayMaxSum(invertArray, leftMinSum);
        for (int i = 0; i <n ; i++) {
            leftMinSum[i] = -leftMinSum[i];
        }
        rightSubArrayMaxSum(invertArray, rightMinSum);
        for (int i = 0; i <n ; i++) {
            rightMinSum[i] = -rightMinSum[i];
        }

        int maxAbsoluteDiff = Integer.MIN_VALUE;

        for (int i = 0; i <n-1 ; i++) {
            int abs = Math.max(Math.abs(leftMaxSum[i]-rightMinSum[i+1]), Math.abs(leftMinSum[i]-rightMaxSum[i+1]));
            maxAbsoluteDiff = Math.max(abs, maxAbsoluteDiff);
        }

        return maxAbsoluteDiff;
    }

    public int leftSubArrayMaxSum(int[] arr, int[] sum) {
        int n = arr.length;
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        sum[0] = maxSoFar;

        for (int i = 1; i <n ; i++) {
            currentMax = Math.max(arr[i], currentMax+arr[i]);
            maxSoFar = Math.max(currentMax, maxSoFar);
            sum[i] = maxSoFar;
        }

        return maxSoFar;
    }

    public int rightSubArrayMaxSum(int[] arr, int[] sum) {
        int n = arr.length;
        int maxSoFar = arr[n-1];
        int currentMax = arr[n-1];
        sum[n-1] = maxSoFar;

        for (int i = n-2; i >= 0 ; i--) {
            currentMax = Math.max(arr[i], currentMax+arr[i]);
            maxSoFar = Math.max(currentMax, maxSoFar);
            sum[i] = maxSoFar;
        }

        return maxSoFar;
    }
}


