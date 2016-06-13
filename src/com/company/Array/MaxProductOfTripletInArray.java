package com.company.Array;

/**
 * @author rmandada
 */
public class MaxProductOfTripletInArray {

    public static void main(String[] args) {
        int arr[] = { 1, -4, 3, -6, 7, 0 };
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] arr) {
        int n = arr.length;
        if (n<3) {
            return -1;
        }

        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i <n ; i++) {
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            } else if (arr[i] > maxB) {
                maxC = maxB;
                maxB = arr[i];
            } else if (arr[i] > maxC) {
                maxC = arr[i];
            }


            if (arr[i]<minA) {
                minB = minA;
                minA = arr[i];
            } else if (arr[i] < minB) {
                minB = arr[i];
            }
        }

        return Math.max((maxA*maxB*maxC), (maxA*minA*minB));
    }
}
