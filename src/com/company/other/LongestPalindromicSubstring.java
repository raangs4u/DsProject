package com.company.other;

/**
 * Created by RANGA on 3/12/2016.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }

    public static String longestPalindrome(String a) {
        String res = String.valueOf(a.charAt(0));
        int resLength = 1;
        for (int i = 2; i <=a.length() ; i++) {
            for (int j = 0; j <=a.length()-i ; j++) {
                if (isPalindrome(a.substring(j, j+i))) {
                    res = a.substring(j, j+i);
                    resLength = i;
                    break;
                }
            }
        }

        return res;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().toString().equals(s)) {
            return true;
        }
        return false;
    }
}
