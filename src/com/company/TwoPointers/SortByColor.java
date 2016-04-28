package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 23/3/16.
 */
public class SortByColor {

    public static void main(String[] args) {
        /*List<Integer> s = Arrays.asList(new Integer[]{2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2});*/
        List<Integer> s = new ArrayList<Integer>();
        s.add(0);
        s.add(1);
        sortColors(s);
        sortColors(s);
    }

    public static void sortColors(List<Integer> a) {

        int n= a.size();
        int i=0;
        int j = n-1;
        int k=0;
        while(k<n) {
            if(a.get(k)!=1){
                if(a.get(k)==0){
                    if (a.get(i).equals(a.get(k))) {
                        i++;
                    } else if(i<k) {
                        int t = a.get(i);
                        a.set(i, a.get(k));
                        a.set(k, t);
                        i++;
                        //k++;
                    } else {
                        k++;
                    }
                    //i++;
                } else {
                    if (a.get(j).equals(a.get(k))) {
                        j--;
                    } else if(j>k){
                        int t = a.get(j);
                        a.set(j, a.get(k));
                        a.set(k, t);
                        j--;
                        //k++;
                    } else {
                        k++;
                    }
                }
            } else {
                k++;
            }
        }

    }
}
