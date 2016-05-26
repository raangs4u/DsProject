package com.company.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RANGA on 3/12/2016.
 */
public class JustifiedText {

    public static void main(String[] args) {
        List<String> s = Arrays.asList( new String[] {"avtngldh", "whzqtnup", "unlmd", "donvganmjs", "lwwthymm", "tszixdap", "ocwwhhcino", "ccuejh", "qfacux", "a", "cep", "polvxet", "hyllx", "sfpc", "ga", "rxjxjlw", "dmaye", "ixdaas", "xutq", "vp", "xect", "xzlb", "tbclmdsrzl", "gfvku", "hvyavrpiu", "txd", "h", "ra", "ogruyvzknv", "hz", "imuft", "ardoyzgykd", "mnee", "ayceoj", "w", "wyoukkgv", "eqfbpzlkgl", "gpznhxncaf", "sngvcy", "gbg", "w", "ts", "j", "lepajgzfk", "kp", "joszb", "agpvxz", "jlzz", "fo", "vyhbzhxhx", "ouglmjc", "nvjwcpuvf", "ldhscmkpo", "sc", "fbxwcm", "wrwkwydzk", "z", "vf", "hmxwl", "al", "qv", "u", "zy", "wkm", "mtzrau", "mi", "ci", "bv", "xlhjyclpeq", "r", "hhroboeje", "nfcplkxhwe"});
        System.out.println(fullJustify(s,76));
    }

    public static List<String> fullJustify(List<String> a, int b) {

        int start = 1;
        int count = a.get(0).length();
        int i =1;
        int n = a.size();

        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        while (i<n) {
            if (i<n && count + a.get(i).length()+1 <= b) {
                count++;
                count += a.get(i).length();
                i++;
            } else {
                int end = i-1;
                //count -= (a.get(i).length()+1);
                int spaces = b-count;
                //int x = end - start;
                //int ss = spaces/x;
                sb.append(a.get(start-1));
                for (int j = start; j <= end ; j++) {
                    sb.append(' ');
                    sb.append(a.get(j));
                    //spaces--;
                }
                //sb.append(a.get(end));
                int k = 0;
                int d = end - start+1;
                if (end>=start) {
                    while (spaces > 0 && end < n - 1) {
                        spaces--;
                        sb.insert(sb.indexOf(" " + a.get(k + start)), ' ');
                        k++;
                        k = k % (d);
                    }
                } else {
                    for (int j = 0; j <spaces ; j++) {
                        sb.append(' ');
                    }
                }
                res.add(sb.toString());
                if (i==n) {
                    break;
                }
                start = i+1;
                sb = new StringBuilder();
                count = a.get(i).length();
                i++;
            }
        }

        sb = new StringBuilder();
        sb.append(a.get(start-1));
        count = a.get(start-1).length();

        for (int j = start; j <n ; j++) {
            sb.append(' ');
            sb.append(a.get(j));
            count = count+ 1+ a.get(j).length();
        }

        for (int j = 0; j <b-count ; j++) {
            sb.append(' ');
        }

        res.add(sb.toString());



        return res;
    }
}
