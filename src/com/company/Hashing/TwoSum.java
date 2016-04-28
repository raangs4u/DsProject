package com.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rmandada
 */
public class TwoSum {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[] {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8});
        twoSum(s, -3);
    }

    public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        int n = a.size();
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        /*HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++) {
            map.put(i,a.get(i));
        }

        for(int i=0;i<n;i++) {
            int z = b-a.get(i);
            if(map.containsValue(z)) {

                int p = i+1;
                int q = map.+1;
                *//*res.add(x);
                res.add(y);
                return res;*//*
                //break;
                *//*if(p>q) {
                    int t = p;
                    p = q;
                    q = t;
                }*//*
                if(q<y) {
                    x = p;
                    y = q;
                } else if(q==y && p<x) {
                    x = p;
                    y = q;
                }
            }
        }

        if(x != Integer.MAX_VALUE && y != Integer.MAX_VALUE ) {
            res.add(x);
            res.add(y);
        }
        return res;*/
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                int index = map.get(a.get(i));
                res.add(index+1);
                res.add(i+1);
                break;
            } else {
                if (!map.containsKey(b - a.get(i))) {
                    map.put(b - a.get(i), i);
                }
            }
        }

        return res;
    }
}
