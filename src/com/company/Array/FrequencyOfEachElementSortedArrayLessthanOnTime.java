package com.company.Array;

/**
 * Given an sorted array of positive integers, count number of occurrences for each element in the array.
 * Assume all elements in the array are less than some constant M.Do this without traversing the complete array.
 * i.e. expected time complexity is less than O(n).
 * http://www.geeksforgeeks.org/find-frequency-of-each-element-in-a-limited-range-array-in-less-than-on-time/
 *
 * @author rmandada
 */
public class FrequencyOfEachElementSortedArrayLessthanOnTime {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 3, 3, 5, 5,
                8, 8, 8, 9, 9, 10 };
        findFrequency(arr);
    }

    public static void findFrequency(int[] arr) {
        int n = arr.length;
        int[] freq = new int[arr[n-1]+1];
        findFrequencyUtil(arr,0,n-1,freq);
        for (int i = 0; i <freq.length ; i++) {
            if (freq[i]!=0) {
                System.out.println("Element "+i+ " occurs "+freq[i]+ " times");
            }
        }
    }

    public static void findFrequencyUtil(int[] arr, int low, int high, int[] freq) {
        if (arr[low]==arr[high]) {
            freq[arr[low]] += high-low+1;
        } else {
            int mid = (low+high)/2;
            findFrequencyUtil(arr, low, mid, freq);
            findFrequencyUtil(arr, mid+1, high, freq);
        }
    }
}
