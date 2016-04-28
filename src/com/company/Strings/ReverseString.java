package com.company.Strings;

import java.util.List;
import java.util.Stack;

/**
 * Created by rmandada on 7/3/16.
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseWords("t"));
    }

    public static String reverseWords(String a) {
        Stack<String> strings = new Stack<String>();
        int st = -1;
        int en = -1;
        for (int i = 0; i <a.length() ; i++) {
            if(a.charAt(i) != ' ') {
                if(st == -1) {
                    st = i;
                    en = i;
                } else {
                    en = i;
                }
            } else {
                if (st != -1) {
                    strings.add(a.substring(st, en+1));
                    st = -1;
                    en = -1;
                }
            }
        }
        if (st >=0 && en>=0) {
            strings.add(a.substring(st, en+1));
        }
        if(strings.size()==0) {
            return null;
        } else if(strings.size()==1) {
            return strings.get(0);
        }

        StringBuilder sb = new StringBuilder();
        int n = strings.size()-1;
        for (int i = 0; i < n; i++) {
            sb.append(strings.pop());
            sb.append(' ');
        }

        sb.append(strings.pop());

        return sb.toString();
    }
}
