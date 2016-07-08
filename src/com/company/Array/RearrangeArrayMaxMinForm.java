package com.company.Array;

/**
 * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value,
 * second minimum value, third second max, fourth second min and so on.
 * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 *
 * @author rmandada
 */
public class RearrangeArrayMaxMinForm {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrange(arr);
        System.out.println(arr);
    }

    public static void rearrange(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <n ; i++) {
            int temp = arr[i];

            while (temp > 0) {
                int j = (i<n/2) ? 2*i + 1 : 2 * (n-1-i);

                if (i==j) {
                    arr[i] = -temp;
                    break;
                }

                int te = temp;
                temp = arr[j];
                arr[j] = te;
                arr[j] = -arr[j];

                i = j;
            }
        }

        for (int i = 0; i <n ; i++) {
            arr[i] = -arr[i];
        }
    }
}
