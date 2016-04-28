package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 22/3/16.
 */
public class MergeArrays {
    public static void main(String[] args) {
        List<Integer> a = /*Arrays.asList(new Integer[]{-4, 3});*/new ArrayList<Integer>();
        List<Integer> b = /*Arrays.asList(new Integer[]{-2, -2});*/ new ArrayList<Integer>();
        a.add(-4);
        a.add(3);
        b.add(-2);
        b.add(4);
        System.out.println();
        merge(a,b);
    }

    public static void merge(List<Integer> a, List<Integer> b) {
        int i=0;
        int j=0;
        int m = a.size();
        int n = b.size();
        while(j<n && i<m){
            if((b.get(j)<=a.get(i))){
                a.add(i,b.get(j));
                j++;
                m++;
            }
            i++;
        }

        if(j<n) {
            for(int k=j;k<n;k++){
                a.add(b.get(k));
            }
        }
    }
}
