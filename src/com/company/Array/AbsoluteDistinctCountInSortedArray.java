package com.company.Array;

/**
 * @author rmandada
 */
public class AbsoluteDistinctCountInSortedArray {

    public static void main(String[] args) {
        int arr[] = {-2, -1, 0, 1, 1};

        System.out.println(distinctCount(arr));
    }

    public static int distinctCount(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int count = n;
        int sum = 0;

        while (left < right) {
            while (left != right && arr[left]==arr[left+1]) {
                count--;
                left++;
            }

            while (left != right && arr[right]==arr[right-1]) {
                count--;
                right--;
            }
            if (left==right) {
                break;
            }

            sum = arr[left]+arr[right];

            if (sum==0) {
                left++;
                right--;
                count--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
