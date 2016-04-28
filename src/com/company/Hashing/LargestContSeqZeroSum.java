package com.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rmandada
 */
public class LargestContSeqZeroSum {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[] {0, -10, 20, 3, 23, 10, -20, 2, 19, -29, 0});
        lszero(s);
    }

    public static ArrayList<Integer> lszero(List<Integer> A) {
        /*int n = a.size();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ar = new int[n];
        ar[0] =  a.get(0);
        for(int i=1;i<n;i++) {
            ar[i]=  a.get(i)+ar[i-1];
        }
        int len = 0;
        int c = 0;
        int b = 0;
        for(int i=0;i<n;i++) {
            if (ar[i] ==0) {
                int tc = 0;
                int tb = i;
                if (tb - tc > b-c) {
                    len = tb-tc+1;
                    b = tb;
                    c = tc;
                }
            } else {
                if (map.containsKey(ar[i])) {
                    int j = map.get(ar[i])+1;
                    int l = i - j+1;
                    if (l > len) {
                        len = l;
                        c = j;
                        b = i;
                    } else if (l== len && j < c) {
                        c = j;
                        b = i;
                    }
                } else {
                    map.put(ar[i], i);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(c>=0 && b >=0 && len>0) {
            for(int i=c; i<=b;i++) {
                res.add(a.get(i));
            }
        }
        return res;*/

        ArrayList<Integer> rst = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(A == null) return rst;
        int len = 0;
        int sum = 0;
        int l = -1, r = -1;
        map.put(0, -1);
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);
            if(!map.containsKey(sum))
                map.put(sum, i);
            else{
                if(i - map.get(sum) > len){
                    l = map.get(sum) + 1;
                    r = i;
                    len = i - map.get(sum);
                }
            }
        }
        if(l >=0 && r >= 0){
            for(int i = l; i <= r; i++){
                rst.add(A.get(i));
            }
        }
        return rst;

    }
}
