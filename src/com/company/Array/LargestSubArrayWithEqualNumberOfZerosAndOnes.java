package com.company.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rmandada
 */
public class LargestSubArrayWithEqualNumberOfZerosAndOnes {

    public static void main(String[] args) {
        int arr[] =  {1, 0, 0, 1, 0, 1, 1};
        findSubArray(arr);
    }
    public static int findSubArray(int[] arr) {
        int sum=0;
        int maxSize = -1;
        int startIndex = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            sum += (arr[i]==0) ? -1 : 1;
            if (sum == 0) {
                maxSize = i+1;
                startIndex  = 0;
            } else {
                if (map.containsKey(sum)) {
                    int x = map.get(sum);
                    int size = i-x;
                    if (size>maxSize) {
                        maxSize = size;
                        startIndex = x+1;
                    }
                } else {
                    map.put(sum, i);
                }
            }
        }

        if (maxSize == -1) {
            System.out.println("No such subarray");
        } else {
            System.out.println(startIndex + " to " + (startIndex+maxSize-1));
        }

        return maxSize;
    }
}
