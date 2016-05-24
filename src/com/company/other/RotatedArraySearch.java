package com.company.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 3/5/2016.
 */
public class RotatedArraySearch {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(5);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        System.out.println(search(a,2));
    }

    public static int search(final List<Integer> a, int b) {
        return search(a, b , a.size());
    }

    public static int search(List<Integer> a, int b, int n) {
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) > b){
                if(a.get(low)<= a.get(mid)) {
                    if (a.get(low)<= b) {
                        high = mid -1;
                    } else {
                        low = mid+1;
                    }
                } else {
                    high = mid -1;
                }
            } else {
                /*if(a.get(low)<= a.get(mid)) {
                    low = mid+1;
                } else {
                    low = mid+1;
                }*/
                low = mid+1;
            }
        }

        return -1;
    }
}
