package com.company.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by RANGA on 4/16/2016.
 */
public class Equal {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(new Integer[]{9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5});
        equal(l);
    }

    public static ArrayList<Integer> equal(List<Integer> a) {
        int n = a.size();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<n-3;i++) {
            for(int j=i+1; j<n-2;j++) {
                int b = a.get(i)+a.get(j);
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                int p = Integer.MAX_VALUE;
                int q = Integer.MAX_VALUE;
                boolean found = false;
                for (int k = i+1; k < a.size(); k++) {
                    if(k==j) continue;
                    if (map.containsKey(a.get(k))) {
                        int index = map.get(a.get(k));
                        found = true;
                        if(index < p) {
                            p = index;
                            q = k;
                        } else if(index == p) {
                            if(k<q) {
                                q = k;
                            }
                        }
                    } else {
                        if (!map.containsKey(b - a.get(k))) {
                            map.put(b - a.get(k), k);
                        }
                    }
                }
                if (found) {
                    temp.add(i);
                    temp.add(j);
                    temp.add(p);
                    temp.add(q);
                    return temp;
                }
            }
        }
        return temp;
    }
}
