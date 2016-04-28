package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rmandada
 */
public class Subset2 {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{6, 6, 3, 3, 6, 5});
        subsets1(s);
    }

    public static ArrayList<ArrayList<Integer>> subsets(List<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (a.size() == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }

        ArrayList<ArrayList<Integer>> temp = subsets( a.subList(1, a.size()));
        res.add(new ArrayList<Integer>());
        for (ArrayList<Integer> l : temp) {
            ArrayList<Integer> t = (ArrayList<Integer>) l.clone();
            if (!t.isEmpty()) {
                t.add(0, a.get(0));
                res.add(t);
            }
        }
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(a.get(0));
        temp.remove(0);
        res.addAll(temp);
        if (res.contains(x)) {
            res.remove(x);
        }
        res.add(1,x);
        return res;
    }

    public static ArrayList<ArrayList<Integer>> subsets1(List<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (a.size() == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }

        ArrayList<ArrayList<Integer>> temp = subsets1( a.subList(1, a.size()));
        res.add(new ArrayList<Integer>());
        for (ArrayList<Integer> l : temp) {
            ArrayList<Integer> t = (ArrayList<Integer>) l.clone();
            t.add(0,a.get(0));
            res.add(t);
        }
        temp.remove(0);
        //res.addAll(temp);
        final ArrayList<ArrayList<Integer>> finalRes = res;
        temp.forEach(t -> {
            if (!finalRes.contains(t)) {
                finalRes.add(t);
            }
        });
        return finalRes;
    }
}
