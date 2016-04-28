package com.company.Backtracking;

import java.util.ArrayList;

/**
 * @author rmandada
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        partition("abaaba");
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        if (a.length() == 0) {
            return new ArrayList<ArrayList<String>>();
        }
        if (a.length() == 1) {
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            ArrayList<String> x = new ArrayList<String>();
            x.add(a);
            list.add(x);
            return list;
        }
        int count = 1;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        while (count<=a.length()) {
            ArrayList<String> t = new ArrayList<String>();
            if (isPalindrome(a.substring(0, count))) {
                t.add(a.substring(0, count));
                ArrayList<ArrayList<String>> rem = partition(a.substring(count));
                for(ArrayList<String> l : rem) {
                    l.add(0, a.substring(0, count));
                }

                if (count == a.length()) {
                    ArrayList<String> y = new ArrayList<String>();
                    y.add(a);
                    rem.add(y);
                }

                res.addAll(rem);
            }
            count++;
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
