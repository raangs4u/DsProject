package com.company.Algos.Greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author rmandada
 */
public class MicesNHoles {
    public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <a.size() ; i++) {
            max = Math.max(max, Math.abs(a.get(i)-b.get(i)));
        }
        return max;
    }
}
