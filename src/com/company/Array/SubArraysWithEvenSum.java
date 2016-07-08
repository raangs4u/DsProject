package com.company.Array;

/**
 * @author rmandada
 */
public class SubArraysWithEvenSum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 1};
        System.out.println(countEvenSum(arr));
    }

    public static int countEvenSum(int[] arr) {
        int result = 0, sum=0, n=arr.length;
        int[] temp = {1,0};
        for (int i = 0; i <n ; i++) {
            sum = (((sum+arr[i])%2)+2)%2;
            temp[sum]++;
        }
        result = result + (temp[0]*(temp[0]-1))/2;
        result = result + (temp[1]*(temp[1]-1))/2;

        return result;
    }
}
