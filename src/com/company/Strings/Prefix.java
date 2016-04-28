package com.company.Strings;

import java.util.ArrayList;

/**
 * Created by rmandada on 7/3/16.
 */
public class Prefix {

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<String>();
        s.add("asd");
        s.add("asefd");
        s.add("adefg");
        System.out.println(longestCommonPrefix(s));
    }

    public  static String longestCommonPrefix(ArrayList<String> a) {
        if(a.size()==0) {
            return null;
        } else if(a.size()==1) {
            return a.get(0);
        }
        String one = a.get(0);
        String two = a.get(1);
        StringBuilder sb = new StringBuilder();

        int l1 = one.length();
        int l2 = two.length();
        for (int i = 0; i < Math.min(l1,l2); i++) {
            if (one.charAt(i) == two.charAt(i)){
                sb.append(one.charAt(i));
            } else {
                break;
            }
        }

        if (a.size()==2) {
            return sb.toString();
        }

        boolean done = true;
        while (done) {
            boolean conti = false;
            for (int i = 2; i <a.size() ; i++) {
                if(a.get(i).indexOf(sb.toString())!=0) {
                    sb.deleteCharAt(sb.length()-1);
                    conti = true;
                    break;
                }

            }
            if (!conti || sb.length() == 0) {
                done = false;
            }

        }
        return sb.toString();
    }
}
