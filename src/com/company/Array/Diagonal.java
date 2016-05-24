package com.company.Array;

import java.util.ArrayList;

/**
 * Created by RANGA on 2/3/2016.
 */
public class Diagonal {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int i=1;
        for (int j = 0; j <3 ; j++) {
            res.add(new ArrayList<Integer>());
            for (int k = 0; k <3 ; k++) {
                res.get(j).add(i++);
            }
        }
        diagonal(res);
    }
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        int i=0,j=0;
        int l = a.size();
        int m=0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int k=0;k<l;k++){
            res.add(new ArrayList<Integer>());
            res.get(m).add(a.get(i).get(j));
            int p = i,q=j;
            p++;q--;
            while(q>=0 && p<=l-1){
                res.get(m).add(a.get(p).get(q));
                p++;q--;
            }
            j++;
            m++;
        }
        j--;
        i++;
        for(int k=0;k<l-1;k++){
            res.add(new ArrayList<Integer>());
            res.get(m).add(a.get(i).get(j));
            int p = i,q=j;
            p++;q--;
            while(q>=0 && p<=l-1){
                res.get(m).add(a.get(p).get(q));
                p++;q--;
            }
            i++;
            m++;
        }
        return res;
    }
}
