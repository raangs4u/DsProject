package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 22/3/16.
 */
public class ArrayIntersection {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{10000000});
        List<Integer> b = Arrays.asList(new Integer[]{10000000});
        System.out.println(intersect(a,b));
    }

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        List<Integer> x = a;
        List<Integer> y = b;
        int m = x.size();
        int n = y.size();

        if(m<n){
            int t = m;
            m = n;
            n = t;
            List<Integer> temp = x;
            x = y;
            y = temp;
        }

        int i=0;
        int j=0;

        while(i<m && j<n) {
            if(x.get(i).equals(y.get(j))){
                res.add(x.get(i));
                i++;
                j++;
            } else if(x.get(i) < y.get(j)){
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}
