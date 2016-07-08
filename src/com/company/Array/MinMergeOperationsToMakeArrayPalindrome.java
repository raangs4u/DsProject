package com.company.Array;

/**
 * Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on array is merge.
 * Merging two adjacent elements means replacing them with their sum. The task is to find minimum number of merge operations required to make given array a ‘Palindrome’.
 * To make an array a palindromic we can simply apply merging operations n-1 times where n is the size of array (Note a single element array is always palindrome similar to single character string).
 * In that case, size of array will be reduced to 1. But in this problem we are asked to do it in minimum number of operations.
 * http://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 *
 * @author rmandada
 */
public class MinMergeOperationsToMakeArrayPalindrome {

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 9, 1};
        System.out.println(findMinOps(arr));
    }

    public static int findMinOps(int[] arr) {
        int n = arr.length;

        int res = 0;

        int i=0,j=n-1;

        while (i<=j) {
            if (arr[i]==arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                arr[j-1] += arr[j];
                j--;
                res++;
            } else {
                arr[i+1] += arr[i];
                i++;
                res++;
            }
        }

        return res;
    }
}
