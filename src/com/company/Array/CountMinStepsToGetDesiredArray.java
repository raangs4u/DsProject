package com.company.Array;

/**
 * Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.
 * Incremental operations:Choose 1 element from the array and increment its value by 1.
 * Doubling operation: Double the values of all the elements of array.
 * We are given desired array target[] containing n elements.
 * Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.
 * http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
 *
 * @author rmandada
 */
public class CountMinStepsToGetDesiredArray {

    public static void main(String[] args) {
        int arr[] = {16, 16, 16};
        System.out.println(findMinSteps(arr));
    }

    public static int findMinSteps(int[] arr) {
        int n = arr.length;
        int result = 0;

        while (true) {
            int zeroCount = 0;

            int i;

            for (i=0; i<n; i++) {
                if (arr[i] %2 == 1) {
                    break;
                } else if (arr[i]==0) {
                    zeroCount++;
                }
            }

            if (zeroCount==n) {
                return result;
            }

            if (i==n) {
                for (int j = 0; j <n ; j++) {
                    arr[j] = arr[j]/2;
                }
                result++;
            }

            for (int j = i; j <n ; j++) {
                if (arr[j] %2 ==1) {
                    arr[j]--;
                    result++;
                }
            }
        }
    }
}
