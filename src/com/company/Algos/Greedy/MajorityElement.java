package com.company.Algos.Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rmandada
 */
public class MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(final List<Integer> a) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = a.size();
        for (int i = 0; i <n ; i++) {
            if (map.containsKey(a.get(i))) {
                map.put(a.get(i), map.get(a.get(i))+1);
            } else {
                map.put(a.get(i),1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getKey()>n/2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int majorityElement1(final List<Integer> a) {
        int majorityIndex = 0;
        for (int count = 1, i = 1; i < a.size(); i++) {
            count += a.get(majorityIndex) == a.get(i) ? 1 : -1;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        return a.get(majorityIndex);
    }
}
