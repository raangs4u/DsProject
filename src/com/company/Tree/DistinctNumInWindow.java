package com.company.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author rmandada
 */
public class DistinctNumInWindow {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[]{1, 2, 1, 3, 4, 3});
        dNums(A, 3);
    }

    public static ArrayList<Integer> dNums(List<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int j = 0; j <B ; j++) {
            if(!map.containsKey(A.get(j))){
                map.put(A.get(j), 1);
            } else {
                map.put(A.get(j), 1+map.get(A.get(j)));
            }
        }

        res.add(map.size());
        for(int i=B; i<n; i++) {
            int pk = A.get(i-B);
            if (map.get(pk)>1) {
                map.put(pk, map.get(pk)-1);
            } else {
                map.remove(pk);
            }
            if(!map.containsKey(A.get(i))){
                map.put(A.get(i), 1);
            } else {
                map.put(A.get(i), 1+map.get(A.get(i)));
            }
            res.add(map.size());
        }

        return res;

        /*Deque q = new ArrayDeque<>();
        Map m = new HashMap<>();
        m.re*/
    }
}
