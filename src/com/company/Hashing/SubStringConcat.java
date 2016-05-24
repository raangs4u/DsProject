package com.company.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by RANGA on 4/17/2016.
 */
public class SubStringConcat {
    public static void main(String[] args) {
        List<String> s = new ArrayList<String>();
        s.add("cac");
        s.add("aaa");
        s.add("aba");
        s.add("aab");
        s.add("abc");
        findSubstring("abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa", s);
    }

    public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (b.size()==0) {
            return res;
        }
        int ls = b.size();
        int ws = b.get(0).length();
        int wl = ls * ws;
        int n = a.length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <ls ; i++) {
            if (map.containsKey(b.get(i))) {
                map.put(b.get(i), map.get(b.get(i))+1);
            } else {
                map.put(b.get(i), 1);
            }
        }

        HashMap<String, Integer> temp = (HashMap<String, Integer>) map.clone();

        for (int i = 0; i <=n-wl ; i++) {
            String s = a.substring(i, i + ws);
            if (map.containsKey(s)) {
                if (check(a.substring(i), ws, wl, temp)) {
                    res.add(i);
                }
                temp = (HashMap<String, Integer>) map.clone();
            }
        }
        return res;
    }

    public static boolean check(String s, int l, int n, HashMap<String, Integer> map) {
        String temp;
        for (int i = 0; i <n ; i=i+l) {
            temp = s.substring(i, i+l);
            if (map.containsKey(temp)) {
                if (map.get(temp) <1) {
                    return false;
                }
                map.put(temp, map.get(temp)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
