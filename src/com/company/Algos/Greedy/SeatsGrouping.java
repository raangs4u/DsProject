package com.company.Algos.Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rmandada
 */
public class SeatsGrouping {

    public static void main(String[] args) {
        System.out.println(seats1("....x..xx...x.."));
    }

    public static int seats(String a) {
        int median = findMedian(a.toCharArray());
        int jumps = shiftToPosition(a.toCharArray(), median);
        return jumps%10000003;
    }

    public static int findMedian(char[] a) {
        int count1=0;
        for(char c:a) {
            if (c=='x') {
                count1++;
            }
        }
        if (count1==0) {
            return -1;
        }

        count1 = (count1+1)/2;
        int count2=0;
        for (int i = 0; i <a.length ; i++) {
            if (a[i]=='x') {
                count2++;
            }
            if (count1==count2) {
                return i;
            }
        }

        return -1;
    }

    public static int shiftToPosition(char[] a, int idx) {
        int i=0;
        int k=idx;
        int count=0;
        while (i<k) {
            if (a[i]=='.') {
                i++;
            } else if (a[k]=='x') {
                k--;
            } else {
                a[k]=a[i];
                a[i]='.';
                count += k-i;
                i++;
                k--;
            }
        }

        i = a.length-1;
        k=idx;

        while (i>k) {
            if (a[i]=='.') {
                i--;
            } else if (a[k]=='x') {
                k++;
            } else {
                a[k]=a[i];
                a[i]='.';
                count += i-k;
                i--;
                k++;
            }
        }

        return count;
    }

    public static int seats1(String a) {
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i <a.length() ; i++) {
            if (a.charAt(i)=='x') {
                s.add(i);
            }
        }

        int med = s.size()/2;
        int lcount = 0;
        int rcount = 0;
        for (int i = med-1; i >=0 ; i--) {
            lcount += s.get(med)-s.get(i)-(med-i);
        }

        for (int i = med+1; i <s.size() ; i++) {
            rcount += s.get(i)-s.get(med)-(i-med);
        }

        return lcount+rcount;
    }
}
