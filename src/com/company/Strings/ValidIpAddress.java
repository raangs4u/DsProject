package com.company.Strings;

import java.util.ArrayList;

/**
 * Created by rmandada on 8/3/16.
 */
public class ValidIpAddress {

    public static void main(String[] args) {
        ValidIpAddress v = new ValidIpAddress();
        v.restoreIpAddresses("0100100");
    }

    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> aa = new ArrayList<String>();
        calc(a, 3, "", aa);
        System.out.println(aa.size());
        return aa;
    }

    public void calc(String s, int l, String str, ArrayList<String> arr) {
        if (l == 0) {
            if(s != "" && isValid(s)) {
                String ss = str + s;
                arr.add(ss);
            }
            return;
        } else if (s.length() < l+1){
            return;
        } else {
            for (int i = 1; s.length()-i > l-1 && i<=3; i++) {
                //int num = Integer.parseInt(s.substring(0, i));
                if( isValid(s.substring(0,i))) {
                    String ss = str + s.substring(0, i)+".";
                    calc(s.substring(i), l-1, ss, arr);
                }
            }
        }
    }

    public boolean isValid(String s) {
        int num = Integer.parseInt(s);
        if (s.length() > 3 || (s.indexOf('0') == 0 &&  s.length()>1) || num > 255) {
            return false;
        }
        return true;
    }
}
