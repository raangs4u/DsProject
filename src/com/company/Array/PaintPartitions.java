package com.company.Array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rmandada on 4/3/16.
 */
public class PaintPartitions {

    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(1);
        c.add(10);
        System.out.println(paint(1, 5, c));
    }

    public static int paint(int a, int b, ArrayList<Integer> c) {
        long start = 0;
        long end = 0;
        long d = 10000003;
        for (int x : c) {
            end += (long) x;
        }
        long res = Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start+end)/2;
            if(isPossible(mid, a, c)) {
                res = Math.min(res, mid);
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return (int)(((res%d) *(b%d))%d);
    }

    public static boolean isPossible(long mid, long a, ArrayList<Integer> c) {
        long max = Collections.max(c);
        if(max > mid) {
            return false;
        }

        int n = c.size();
        long sum = 0;
        int count = 1;

        for (int i = 0; i <n ;) {
            if(sum + (long)c.get(i) > mid ) {
                sum = 0;
                count++;
            } else {
                sum += c.get(i);
                i++;
            }
        }

        if(count <= a) {
            return true;
        }

        return false;
    }
}
