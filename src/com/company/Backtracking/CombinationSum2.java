package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rmandada
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{1,2});
        combinationSum(s,8);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(List<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> res  = new ArrayList<ArrayList<Integer>>();
        if (a.size() == 0) {
            return res;
        }
        combinatios(b, a, res, new ArrayList<Integer>());
        return res;
    }

    public static void combinatios( int sum, List<Integer> a, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (sum<0) {
            return;
        }
        if (sum == 0) {
            Collections.sort(temp);
            ArrayList<Integer> t = (ArrayList<Integer>) temp.clone();
            if (!res.contains(t)) {
                res.add(t);
            }
            return ;
        }

        if (a.size() == 0) {
            return;
        }

        for (int i = 0; i <a.size() ; i++) {
            int x = a.get(i);
            int times = sum /x;
            int j = times;
            while (j> 0) {
                for (int k = 0; k <j ; k++) {
                    temp.add(x);
                }
                combinatios(sum-j*x, a.subList(i+1, a.size()), res, temp);
                for (int k = 0; k <j ; k++) {
                    temp.remove(temp.size()-1);
                }
                j--;
            }
        }


    }
}
