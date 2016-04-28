package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class Combinations {

    public static void main(String[] args) {
        combine(4, 2);
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        List<Integer> s = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <n ; i++) {
            s.add(i+1);
        }
        getCombinations(res, k, s, 0, new ArrayList<Integer>());
        return res;
    }

    public static void getCombinations(ArrayList<ArrayList<Integer>> res, int target, List<Integer> s, int index, ArrayList<Integer> temp) {
        if (index> s.size()) {
            return;
        }

        if (target == 0) {
            ArrayList<Integer> t = (ArrayList<Integer>) temp.clone();
            res.add(t);
            return;
        }

        for (int i = index; i <s.size() ; i++) {
            int x = s.get(i);
            temp.add(x);
            getCombinations(res, target-1, s, index+1, temp);
            temp.remove(temp.size()-1);
            index++;
        }
    }
}
