package com.company.Strings;

/**
 * Created by rmandada on 7/3/16.
 */
public class LastString {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hell w  "));
    }

    public static int lengthOfLastWord(final String a) {
        if (a.length() ==0) {
            return 0;
        }
        int idx = -1;
        for (int i = 0; i <a.length()-1 ; i++) {
            if(a.charAt(i) == ' ' && a.charAt(i+1) != ' '){
                idx = i;
            }
        }

        if(idx == -1 && a.indexOf(' ') != -1) {
            return a.substring(idx+1, a.indexOf(' ')).length();
        }

        int lIdx = a.substring(idx+1).indexOf(' ');
        if(lIdx == -1) {
            return a.substring(idx+1).length();
        } else {
            String b = a.substring(idx+1);
            b = b.substring(0, lIdx);
            return b.length();
        }


    }
}
