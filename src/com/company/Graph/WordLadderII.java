package com.company.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rmandada
 */
public class WordLadderII {
    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(findLadders("hit", "cog", dict));
    }
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV) {
        Deque<Node> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();
        Map<String, Node> nodes = new HashMap<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        dictV.add(start);
        dictV.add(end);
        for (String s: dictV) {
            visited.put(s,0);
            nodes.put(s, new Node(s));
        }

        queue.addLast(nodes.get(start));
        while (!queue.isEmpty()) {
            Node s = queue.removeFirst();
            visited.put(s.val,1);
            for (Map.Entry<String, Node> entry : nodes.entrySet()) {
                if (entry.getKey()!=s.val && visited.get(entry.getKey())!=1 && adjacent(s,entry.getValue())) {
                    queue.addLast(entry.getValue());
                    int pathLen = s.dist+1;
                    if (entry.getValue().dist== -1) {
                        entry.getValue().parents.add(s);
                        entry.getValue().dist= pathLen;
                    } else if (entry.getValue().dist== pathLen) {
                        entry.getValue().parents.add(s);
                    }
                }
            }
        }

        getAllPaths(nodes.get(start), nodes.get(end), new ArrayList<>(), res);
        reverse(res);

        return res;
    }

    public static boolean adjacent(Node s1, Node s2) {
        int diff = 0;
        for (int i = 0; i <s1.val.length() ; i++) {
            if (diff >1) {
                return false;
            }
            if (s1.val.charAt(i)!=s2.val.charAt(i)) {
                diff++;
            }
        }
        if (diff==1) {
            return true;
        }

        return false;
    }

    static class Node {
        String val;
        Set<Node> parents;
        int dist;

        public Node(String val) {
            this.val = val;
            parents = new HashSet<>();
            dist = -1;
        }
    }

    public static void getAllPaths(Node start, Node end, ArrayList<String> temp, ArrayList<ArrayList<String>> res) {
        if (end.val.equals(start.val)) {
            temp.add(end.val);
            res.add((ArrayList<String>) temp.clone());
        } else {
            temp.add(end.val);
            for (Node p : end.parents) {
                getAllPaths(start,p,temp,res);
                temp.remove(temp.size()-1);
            }

        }

    }

    public static void reverse(ArrayList<ArrayList<String>> res) {
        for (ArrayList<String> list: res) {
            Collections.reverse(list);
        }
    }
}
