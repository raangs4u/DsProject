package com.company.Array;

/**
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that
 * every positive number is followed by negative and vice-versa.
 * Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.
 * http://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/
 *
 * @author rmandada
 */
public class RearrangeArrayAlternatingPositiveAndNegativeItems {

    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrangeOrderNotPreserved(arr);
        System.out.println();
    }

    public static void rearrangeOrderPreserved(int[] arr) {
        int n = arr.length;
        int outOfPlace = -1;

        for (int i = 0; i <n ; i++) {
            if (outOfPlace >=0) {
                if ((arr[i] >=0 && arr[outOfPlace] <0 ) || (arr[i] <0 && arr[outOfPlace]>=0)) {
                    rightRotate(arr, outOfPlace, i);
                    if(i-outOfPlace >2) {
                        outOfPlace +=2;
                    } else {
                        outOfPlace = -1;
                    }
                }
            }

            if (outOfPlace==-1) {
                if((arr[i] >=0 && i%2==0) || (arr[i] < 0 && i%2==1)) {
                    outOfPlace=i;
                }
            }
        }
    }

    public static void rightRotate(int[] arr, int outOfPlace, int curr) {
        int temp = arr[curr];
        for (int i = curr; i>outOfPlace ; i--) {
            arr[i] = arr[i-1];
        }
        arr[outOfPlace] = temp;
    }

    public static void rearrangeOrderNotPreserved(int[] arr) {
        int n = arr.length;
        int i=0, j=n-1;

        while (i<j) {
            while (arr[i] >= 0) {
                i++;
            }

            while (arr[j] < 0) {
                j--;
            }
            if (i<j) {
                int temp= arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i==0 || i==n) {
            return;
        }

        int k=0;

        while (k<n && i<n) {
            int temp= arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            k = k+2;
            i = i+1;
        }


    }
}
