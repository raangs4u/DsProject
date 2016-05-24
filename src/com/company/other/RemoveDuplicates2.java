package com.company.other;

import java.util.ArrayList;

/**
 * Created by RANGA on 3/22/2016.
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        System.out.println(removeDuplicates(a));
    }
    public static int removeDuplicates(ArrayList<Integer> a) {
        int x = 1;
        int i=0;
        int j=1;
        int n = a.size();
        int count = 0;
        boolean flag = false;
        while(j<n) {
            if(a.get(i).equals(a.get(j))){
                j++;
                if(!flag) {
                    flag = true;
                    a.set(x++, a.get(i));
                } else {
                    count++;
                }
            } else {
                i = j;
                flag = false;
                a.set(x++, a.get(i));
                j++;
            }
        }

        return n-count;
    }
}
