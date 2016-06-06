package com.company.Graph;

import java.util.ArrayList;

/**
 * @author rmandada
 */
public class WordSearchBoard {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("ABCE");
        a.add("SFCS");
        a.add("ADEE");
        System.out.println(exist(a, "ABCD"));
    }

    public static int exist(ArrayList<String> a, String b) {
        int m = a.size();
        int n = a.get(0).length();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (a.get(i).charAt(j) == b.charAt(0)) {
                    int res = dfs(new Pair(i,j), a, b, b.length()-1);
                    if (res ==1) {
                        return res;
                    }
                }
            }
        }
        return 0;
    }

    public static int dfs(Pair p, ArrayList<String> a, String b, int len) {
        int m = a.size();
        int n = a.get(0).length();
        if (len<=0) {
            return 1;
        }
        int res = 0;

        if (p.first <m-1 && a.get(p.first+1).charAt(p.second) == b.charAt(b.length()-len)) {
            res = dfs(new Pair(p.first+1, p.second), a, b, len-1);
            if (res==1) {
                return res;
            }
        }

        if (p.second <n-1 && a.get(p.first).charAt(p.second+1) == b.charAt(b.length()-len)) {
            res =  dfs(new Pair(p.first, p.second+1), a, b, len-1);
            if (res==1) {
                return res;
            }
        }

        if (p.first >0 && a.get(p.first-1).charAt(p.second) == b.charAt(b.length()-len)) {
            res =  dfs(new Pair(p.first-1, p.second), a, b, len-1);
            if (res==1) {
                return res;
            }
        }

        if (p.second >0 && a.get(p.first).charAt(p.second-1) == b.charAt(b.length()-len)) {
            res =  dfs(new Pair(p.first, p.second-1), a, b, len-1);
            if (res==1) {
                return res;
            }
        }
        return 0;
    }
}
