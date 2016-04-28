package com.company.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmandada on 9/3/16.
 */
public class JustifiedText {

    public static void main(String[] args) {
        String[] b = new String[]{"am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"};
        List<String> a = Arrays.asList(b);
        /*a.add("This");
        a.add("is");
        a.add("an");
        a.add("example");
        a.add("of");
       a.add("text");
        a.add("justification.");*/
        fullJustify(a, 14);
    }

    public static ArrayList<String> fullJustify(List<String> a, int b) {
        int start = 0;
        int count = 0;
        int i =0;
        int n = a.size();

        ArrayList<String> res = new ArrayList<String>();
        if (a.size() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        while (i<=n) {
            if (i<n && count + a.get(i).length() <= b) {
                count += a.get(i).length();
                count++;
                i++;
            } else {
                int end = i-1;
                count -= (end-start+1);
                int spaces = b-count;
                int x = end - start;
                //int ss = spaces/x;
                for (int j = start; j < end ; j++) {
                    sb.append(a.get(j));
                    sb.append(' ');
                    spaces--;
                }
                sb.append(a.get(end));
                int k = 0;
                while (spaces>0 && end< n-1) {
                    spaces--;
                    int idx = sb.indexOf(" " + a.get(start + k + 1));
                    if (idx != -1) {
                        sb.insert(idx, ' ');
                    } else {
                        sb.append(' ');
                    }
                    k++;
                    k = k% (end-start);
                }
                res.add(sb.toString());
                start = i;
                sb = new StringBuilder();
                count = 0;
                if (i==n) {
                    break;
                }
            }
        }



        return res;
    }
}
