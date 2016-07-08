package com.company.Array;

import com.company.Graph.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array, print all subarrays in the array which has sum 0.
 * http://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 *
 * @author rmandada
 */
public class AllSubArraysWithZeroSum {

    public static void main(String[] args) {
        int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        findSubArrays(arr);
    }

    public static List<Pair> findSubArrays(int[] arr) {
        int n =  arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Pair> out = new ArrayList<>();

        int sum=0;
        for (int i = 0; i <n ; i++) {
            sum += arr[i];

            if (sum==0) {
                out.add(new Pair(0,i));
            }

            if (map.containsKey(sum)) {
                List<Integer> l = map.get(sum);
                for (int j = 0; j <l.size() ; j++) {
                    out.add(new Pair(l.get(j)+1, i));
                }
                map.get(sum).add(i);
            } else {
                map.put(sum, new ArrayList<>());
                map.get(sum).add(i);
            }

        }

        return out;
    }
}
