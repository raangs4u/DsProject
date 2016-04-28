package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rmandada
 */
public class LetterPhone {

    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static ArrayList<String> letterCombinations(String a) {
        HashMap<Character, String> map =new HashMap<Character, String>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return combinations(a,map);

    }

    public static ArrayList<String> combinations(String s,  HashMap<Character, String> map) {
        if (s.length() == 0) {
            return new ArrayList<String>();
        }
        if (s.length() == 1) {
            String x = map.get(s.charAt(0));
            ArrayList<String> res = new ArrayList<String>();
            for (int i = 0; i <x.length() ; i++) {
                res.add(String.valueOf(x.charAt(i)));
            }
            return res;
        }

        ArrayList<String> tem = combinations(s.substring(1), map);

        String x = map.get(s.charAt(0));
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i <x.length() ; i++) {
            for(String str : tem) {
                res.add(String.valueOf(x.charAt(i))+ str);
            }
        }
        return res;
    }
}
