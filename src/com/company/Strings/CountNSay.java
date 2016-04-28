package com.company.Strings;

/**
 * Created by rmandada on 7/3/16.
 */
public class CountNSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int a) {
        if(a<=0) {
            return null;
        }
        String s = "1";
        a--;
        while (a>0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <s.length() ; ) {
                int count = 1;
                for (int j = i+1; j <s.length() ; j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
                sb.append(count);
                sb.append(s.charAt(i));
                i += count;
            }
            a--;
            s = sb.toString();
        }
        return s;
    }
}
