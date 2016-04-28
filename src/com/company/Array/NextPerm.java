package com.company.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmandada on 19/2/16.
 */
public class NextPerm {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        nextPermutation(a);
    }
    public static void nextPermutation(ArrayList<Integer> a) {
        int l = a.size();
        int j=0 ;
        if(l>=2){
            for(int i=l-1; i>=1; i--) {
                if(a.get(i-1) < a.get(i)) {
                    //found = true;
                    j=i;
                    break;
                }
            }
            if(j==0) {
                Collections.sort(a);
            } else {
                int min =Integer.MAX_VALUE;
                int m = 0;
                for(int k = j; k<l; k++) {
                    if(a.get(k) >= a.get(j-1)){
                        if(a.get(k) < m) {
                            m = a.get(k);
                            m=k;
                        }
                    }
                }
                int t = a.get(j-1);
                a.set(j-1,a.get(m));
                a.set(m, t);

                Collections.sort(a.subList(j,l));

            }

        }
    }


    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        int m = a.size();
        int n = a.get(0).size();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (a.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int j = 0; j <n ; j++) {
                a.get(row).set(j, 0);
            }
        }
        for (int col : cols) {
            for (int j = 0; j <m ; j++) {
                a.get(m).set(col, 0);
            }
        }
    }
}
