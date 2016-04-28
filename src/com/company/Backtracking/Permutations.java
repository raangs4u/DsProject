package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rmandada
 */
public class Permutations {

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(2);
        s.add(2);
        permutations(s);
    }

    public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> s) {
        Collections.sort(s);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permutationUtil1(s,res, new ArrayList<>());
        return res;
    }

    public static void permutationUtil1(List<Integer> s, ArrayList<ArrayList<Integer>> res, List<Integer> t ) {

        int n = s.size();
        if (s.size() == 0) {
            ArrayList<Integer> te = (ArrayList<Integer>) ((ArrayList<Integer>)t).clone();
            res.add( te);
            return;
        }

        for (int i = 0; i <n ; i++) {
            int x = s.remove(i);
            t.add(x);
            permutationUtil1(s, res, t);
            s.add(i,x);
            t.remove(t.size()-1);
        }

    }

    public static void permutationUtil(ArrayList<Integer> s, int idx, ArrayList<ArrayList<Integer>> res) {
        if (idx == s.size()-1) {
            ArrayList<Integer> t = (ArrayList<Integer>) s.clone();
            res.add(t);
            return;
        }

        for (int i = idx; i <s.size() ; i++) {
            swap(s, idx, i);
            permutationUtil(s, idx+1, res);
            swap(s, idx, i);
        }

    }

    public static void swap(ArrayList<Integer> s, int i, int j) {
        int temp = s.get(i);
        s.set(i, s.get(j));
        s.set(j, temp);
    }
}
