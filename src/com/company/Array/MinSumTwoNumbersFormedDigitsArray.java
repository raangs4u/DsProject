package com.company.Array;

import java.util.Arrays;

/**
 * @author rmandada
 */
public class MinSumTwoNumbersFormedDigitsArray {

    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 5, 2, 3};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        Arrays.sort(arr);
        int a=0,b=0;
        for (int i = 0; i <arr.length ; i++) {
            if (i %2 ==0) {
                a = a*10+arr[i];
            } else {
                b = b*10+arr[i];
            }
        }
        return a+b;
    }
}
