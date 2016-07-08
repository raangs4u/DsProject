package com.company.Array;

/**
 * @author rmandada
 */
public class CountThreeInversions {

    public static void main(String[] args) {
        int arr[] = {8, 4, 2, 1};
        System.out.println(getInversions(arr));
    }

    public static int getInversions(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 1; i <n-1 ; i++) {
            int smallRight = 0;
            for (int j = i+1; j <n ; j++) {
                if (arr[j]<arr[i]) {
                    smallRight++;
                }
            }

            int largeLeft=0;
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j] >arr[i]) {
                    largeLeft++;
                }
            }

            res += (smallRight*largeLeft);
        }

        return res;
    }
}
