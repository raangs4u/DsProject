package com.company.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmandada on 9/3/16.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("    aXI V"));
    }

    public static int romanToInt(String a) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int start = 0;
        while (a.charAt(start) == ' ') {
            start++;
        }

        a = a.substring(start);

        if (a.length()==0) {
            return 0;
        }


        int res = 0;
        /*if(!isValid(a.charAt(0))) {
            return  0;
        }*/

        if (isValid(a.charAt(a.length()-1))) {
            res += map.get(a.charAt(a.length()-1)) ;
        }


        for (int i = a.length()-2; i>=0 ; i--) {
            if (isValid(a.charAt(i))) {

                if (!isValid(a.charAt(i+1)) || map.get(a.charAt(i)) >= map.get(a.charAt(i + 1))) {
                    res += map.get(a.charAt(i));
                } else {
                    res -= map.get(a.charAt(i));
                }

            } else if (a.charAt(i) == ' ') {
                res = 0;
            }
        }
        return res;
    }

    public static boolean isValid(char c) {
        String romanLetters = "IVXLCDM";
        return romanLetters.indexOf(c) != -1;
    }


}
