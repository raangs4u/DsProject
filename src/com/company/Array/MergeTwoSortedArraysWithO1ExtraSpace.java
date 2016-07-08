package com.company.Array;

/**
 * @author rmandada
 */
public class MergeTwoSortedArraysWithO1ExtraSpace {

    public static void main(String[] args) {
        int ar1[] = {1, 5, 9, 10, 15, 20};
        int ar2[] = {2, 3, 8, 13};
        merge(ar1,ar2);
        System.out.println(ar1);
    }

    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        for (int i = n-1; i >=0 ; i--) {
            int k=0, last = arr1[m-1];

            for (k = m-1; k >=0 && arr1[k] > arr2[i]; k--) {
                if (k!=m-1) {
                    arr1[k+1] = arr1[k];
                }
            }

            if (k!= m-1) {
                arr1[k+1] = arr2[i];
                arr2[i]= last;
            }
        }
    }
}
