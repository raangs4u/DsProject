package com.company.other;

/**
 * Created by RANGA on 3/3/2016.
 */
public class Squrt {

    public static void main(String[] args) {
        System.out.println(sqrt(5));
    }
    public static int sqrt(int a) {
        /*if(a<=1) {
            return a;
        }
        int low = 1;
        int high = a;
        int result = 0;

        while(low<=high) {
            int mid = (low+high)/2;
            int x = mid*mid;
            if(x == a) {
                return mid;
            } else if(x<a){
                result = low;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;*/
        return sqrt1((long)a);
    }

    public static int sqrt1(long a) {
        if(a<=1) {
            return (int)a;
        }
        long low = 1;
        long high = a;
        long result = 0;

        while(low<=high) {
            long mid = (low+high)/2;
            long x = mid*mid;
            if(x == a) {
                return (int)mid;
            } else if(x<a){
                result = mid;
                low = mid+1;

            } else {
                high = mid-1;
            }
        }
        return (int)result;
    }
}
