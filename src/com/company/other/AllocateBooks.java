package com.company.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by RANGA on 3/4/2016.
 */
public class AllocateBooks {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        //Arrays.asList(new int[]{12, 34, 67, 90});
       /* a.add(73);
        a.add(58);
        a.add(30);
        a.add(72);
        a.add(44);
        a.add(78);
        a.add(23);
        a.add(9);*/
        a.add(22);
        /*a.add(34);
        a.add(67);
        a.add(90);*/
        System.out.println(books(a,1));
    }
    public static int books(ArrayList<Integer> c, int a) {
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
        return (int)res;
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
