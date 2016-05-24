package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RANGA.
 */
public class GrayCode {

    public static void main(String[] args) {
        grayCode(10);
    }

    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<ArrayList<Integer>> t = recUtil(a);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(ArrayList<Integer> l: t) {
            int x = binaryToInt(l);
            res.add(x);
        }

        return res;
    }

    public static ArrayList<ArrayList<Integer>> recUtil(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(a==1) {
            ArrayList<Integer> o = new ArrayList<Integer>();
            o.add(0);
            ArrayList<Integer> o1 = new ArrayList<Integer>();
            o1.add(1);
            res.add(o);
            res.add(o1);
            return res;
        }
        ArrayList<ArrayList<Integer>> temp = recUtil(a-1);
        for(int i=0;i<temp.size();i++){
            ArrayList<Integer> x = new ArrayList<Integer>();
            x.addAll(temp.get(i));
            x.add(0);
            res.add(x);
        }

        for(int i=temp.size()-1;i>=0;i--){
            ArrayList<Integer> y = new ArrayList<Integer>();
            y.addAll(temp.get(i));
            y.add(1);
            res.add(y);
        }

        return res;

    }

    public static int binaryToInt(List<Integer> s) {
        int sum = 0;
        for(int i=0;i<s.size();i++){
            sum = sum + (int)(s.get(i)*Math.pow(2,i));
        }

        return sum;
    }
}
