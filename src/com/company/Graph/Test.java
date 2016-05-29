package com.company.Graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by RANGA on 12/13/2015.
 */
public class Test {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int t = 2;
        int[] a1 = new int[]{1, -2, 3, -2, 5};
        int[] a2 = new int[]{-1,-2};
        while (t>0) {
            t--;
            int[] arr;
            if (t==1) {
                arr = a1;
            } else {
                arr= a2;
            }
            //int[] arr = new int[n];
            int n =arr.length;
            /*for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }*/
            if(allNegative(arr)) {
                Arrays.sort(arr);
                System.out.println(arr[arr.length-1]);
            } else {

                //int n = 5;
                //int[] arr = new int[]{1, -2, 3, -2, 5};
                int sum = Integer.MIN_VALUE;
                int maxSum = Integer.MIN_VALUE;
                int maxNeg = -1;
                boolean nfound = false;
                int cuNeg = Integer.MIN_VALUE;
                int maxStartIndex = 0;
                int maxStartIdxUntill = 0;
                int maxEndIdx = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] < 0) {
                        if (cuNeg == -1 || arr[i] < arr[cuNeg]) {
                            cuNeg = i;
                        }
                    }

                    if (sum < 0) {
                        sum = arr[i];
                        maxStartIdxUntill = i;
                        cuNeg = -1;
                    } else {
                        sum += arr[i];
                    }

                    if (maxSum < sum) {
                        maxSum = sum;
                        maxStartIndex = maxStartIdxUntill;
                        maxEndIdx = i;
                        if(cuNeg>=0){
                            maxSum+=Math.abs(arr[cuNeg]);
                        }
                        maxNeg = cuNeg;

                    }
                }

                if (maxNeg < 0) {
                    System.out.println(maxSum);
                } else {
                    System.out.println(maxSum - arr[maxNeg]);
                }
            }
        }
    }

    public static boolean allNegative(int[] a) {
        int n = a.length;
        for (int i = 0; i <n ; i++) {
            if (a[i]>=0) {
                return false;
            }
        }
        return true;
    }

}
