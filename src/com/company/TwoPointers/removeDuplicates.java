package com.company.TwoPointers;

import java.util.ArrayList;

/**
 * Created by rmandada on 22/3/16.
 */
public class removeDuplicates {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5000);
        a.add(5000);
        a.add(5000);
        /*a.add(2);
        a.add(2);
        a.add(3);*/
        System.out.println(removeDuplicates(a));
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        int x = 0;
        int i=1;
        int n = a.size();
        if(n<2) {
            return n;
        }
        int current = 0;
        while(i<n){
            if(a.get(current).equals(a.get(i))){
                i++;
                //a.remove(i);
                //n--;
            } else {
                current = i;
                a.set(++x, a.get(i));
                i++;
            }
        }
        return x+1;

        /*int i=1;
        int n = a.size();
        if(n<2) {
            return n;
        }
        int current = 0;
        while(i<n){
            if(a.get(current).equals(a.get(i))){
                a.remove(i);
                n--;
            } else {
                current = i;
                i++;
            }
        }
        return n;*/
    }
}
