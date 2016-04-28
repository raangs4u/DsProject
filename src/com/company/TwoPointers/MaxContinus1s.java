package com.company.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 23/3/16.
 */
public class MaxContinus1s {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{1, 0, 0, 0, 0, 0, 1, 0, 1, 1});
        maxone(s,2);
    }

    public static ArrayList<Integer> maxone(List<Integer> a, int b) {
        int n = a.size();
        int max= 0;
        int m = -1;
        int l = -1;
        int i=-1;
        int j=-1;
        int count=0;
        int flipCount=0;
        int first =-1;
        boolean flip =false;
        while(i<n && j<n-1) {
            if(a.get(++j) == 1){
                if(count==0){
                    i = j;
                }
                count++;
            } else {
                if(!flip && flipCount<b) {
                    count++;
                    flipCount++;
                    if (count==1) {
                        i=j;
                    }
                    if (flipCount == 1){
                        first = j;
                    }
                    if(flipCount == b) {
                        flip = true;
                    }
                } else {
                    count=0;
                    flipCount = 0;
                    flip=false;
                    if (first>=0) {
                        j = first;
                    }
                }
            }

            if(count>max){
                max = count;
                m = i;
                l = j;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int p = m; m>=0 && l>=0 && p<=l;p++){
            res.add(p);
        }

        return res;

    }
}
