package com.company.Array;

/**
 * Given two arrays which are duplicates of each other except one element, that is one element from one of the array is missing,
 * we need to find that missing element.
 * http://www.geeksforgeeks.org/find-lost-element-from-a-duplicated-array/
 *
 * @author rmandada
 */
public class FindLostElementFromDuplicateArray {

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5, 7, 9};
        int arr2[] = {1, 5, 7, 9};
        System.out.println(findMissingElementByBitOperators(arr1,arr2));
    }

    public static int findLostElement(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (m<n) {
            int[] t = a;
            a = b;
            b = t;
            m = a.length;
            n = b.length;
        }
        if (a[0]!=b[0]) {
            return a[0];
        }
        int st = 0, en = m-1;

        while (st < en) {
            int mid = (st + en)/2;
            if (a[mid] == b[mid]) {
                st = mid;
            } else {
                en = mid;
            }

            if (st == en-1) {
                break;
            }
        }

        return a[en];
    }

    public static int findMissingElementByBitOperators(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int res = 0;
        for (int i = 0; i <m ; i++) {
            res = res ^ a[i];
        }

        for (int i = 0; i <n ; i++) {
            res = res ^ b[i];
        }

        return res;
    }
}
