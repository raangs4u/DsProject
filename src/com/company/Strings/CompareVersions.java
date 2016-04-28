package com.company.Strings;

import java.math.BigInteger;

/**
 * Created by rmandada on 8/3/16.
 */
public class CompareVersions {
    public static void main(String[] args) {
        System.out.println(compareVersion("a", "01"));
    }
    public static int compareVersion(String a, String b) {
        int m = a.length();
        int n = b.length();
        int i = 0;
        int j = 0;
        while(i<m && j<n) {
            int p = i;
            while (i<m && a.charAt(i) != '.') {
                i++;
            }
            String first;
            if (i>=m){
                first = a.substring(p);
            } else {
                first = a.substring(p, i);
            }

            BigInteger integer1 = new BigInteger(first);
            int q = j;
            while (j<n && b.charAt(j) != '.') {
                j++;
            }
            String second;
            if (j>=n) {
                second = b.substring(q);
            } else {
                second = b.substring(q, j);
            }
            BigInteger integer2 = new BigInteger(second);
            int res = integer1.compareTo(integer2);
            if(res == 0) {
                if (i==m && j==n) {
                    return 0;
                }
                i++;
                j++;
            } else {
                return res;
            }
        }

        if(m== n) {
            return 0;
        } else if (i< m){
            String s = a.substring(i);
            BigInteger integer = new BigInteger(s);
            return BigInteger.ZERO.equals(integer) ? 0 : 1;
        } else {
            String s = b.substring(j);
            BigInteger integer = new BigInteger(s);
            return BigInteger.ZERO.equals(integer) ? 0 : -1;
        }
    }
}
