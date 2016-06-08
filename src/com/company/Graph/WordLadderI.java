package com.company.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rmandada
 */
public class WordLadderI {

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength("hit", "hit", dict));
    }

    public static int ladderLength(String start, String end, ArrayList<String> dictV) {
        Deque<String> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        dictV.add(start);
        dictV.add(end);
        for (String s: dictV) {
            visited.put(s,0);
            dist.put(s,-1);
        }
        visited.put(start,1);
        queue.addLast(start);
        dist.put(start,0);
        while (!queue.isEmpty()) {
            String s = queue.removeFirst();
            if (s.equals(end)) {
                break;
            }
            for (String v : dictV) {
                if (visited.get(v)==0 && adjacent(s,v)) {
                    queue.addLast(v);
                    visited.put(v,1);
                    dist.put(v, dist.get(s)+1);
                }
            }
        }

        if(dist.get(end)>=0) {
            return dist.get(end)+1;
        }
        return 0;
    }

    public static boolean adjacent(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i <s1.length() ; i++) {
            if (diff >1) {
                return false;
            }
            if (s1.charAt(i)!=s2.charAt(i)) {
                diff++;
            }
        }
        if (diff==1) {
            return true;
        }

        return false;
    }
}
