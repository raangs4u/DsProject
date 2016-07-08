package com.company.Array;

/**
 * Given an array of positive integers, find maximum possible value K such that the array has at-least K elements that are greater than or equal to K.
 * The array is unsorted and may contain duplicate values.
 * http://www.geeksforgeeks.org/maximum-value-k-such-that-array-has-at-least-k-elements-that-are-k/
 *
 * @author rmandada
 */
public class MaxValueOfKSuchThatArrayHasKElementsGreaterthanOrEqualToK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 8, 10 };
        System.out.println(findMaxNum(arr));
    }

    public static int findMaxNum(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n+1];

        for (int i = 0; i <n ; i++) {
            if (arr[i] <n) {
                freq[arr[i]]++;
            } else {
                freq[n]++;
            }
        }

        int sum = 0;

        for (int i = n; i >0 ; i--) {
            sum = sum+freq[i];
            if (sum>=i) {
                return i;
            }
        }

        return 0;
    }

}
