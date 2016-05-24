package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RANGA.
 */
public class SubSet {
    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        s.add(2);
        s.add(1);
        s.add(3);
        subsets(s);
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
            t.add(0,a.get(0));
            res.add(t);
        }
        temp.remove(0);
        res.addAll(temp);
        return res;
    }
}
