package com.company.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 *
 * @author rmandada
 */
public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1} ;
        System.out.println(countPairs(arr,2));
    }
    
    public static int countPairs(int[] arr, int sum) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        int result = 0;
        for (int i = 0; i <n ; i++) {
            if (map.containsKey(sum-arr[i])) {
                result += map.get(sum-arr[i]);
            }

            /*if (sum-arr[i]==arr[i]) {
                result--;
            }*/
        }

        return result/2;
    }
}
