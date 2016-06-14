package com.company.Array;

/**
 * @author rmandada
 */
public class RearrangeArrayAlternatingPositiveAndNegativeItems {

    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(arr);
        System.out.println();
    }

    public static void rearrange(int[] arr) {
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
}
