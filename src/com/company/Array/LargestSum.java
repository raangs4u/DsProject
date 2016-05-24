package com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by RANGA on 2/4/2016.
 */
public class LargestSum {

    public static void main(String[] args) {
        System.out.println(compare("999", "9998"));
        List<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(99);
        a.add(999);
        a.add(9999);
        a.add(9998);
        Integer[] b = new Integer[]{9,99,999,9999,9998};
        Collections.sort(a, new Tcomparator());
        Arrays.sort(b, new Tcomparator());
        for (int i = b.length-1; i >=0 ; i--) {
            System.out.println(b[i]);
        }
        System.out.println(a.toString());
        //Collections.sort();
    }
    public static String compare(String n1, String n2){
        int l1 = n1.length();
        int l2 = n2.length();
        int l = Math.max(l1,l2);

        int xy = Integer.parseInt(n1+n2);
        int yx = Integer.parseInt(n2+n1);
        if(xy > yx) {
            return n1;
        } else {
            return n2;
        }
        /*char x;
        char y;
        for(int i=0;i<l;i++){
            if(i<=l1-1){x = n1.charAt(i);}
            if(i<=l2-1){y = n2.charAt(i);}

            if(x!=y) {
                return Character.getNumericValue(x)>Character.getNumericValue(y)?n1:n2;
            } else {
                if(i>=l1-1){
                    if(l1==l2){
                        return n1;
                    }
                    int j = l1-1;
                    return Character.getNumericValue(x)>Character.getNumericValue(n2.charAt(i + 1))? n1:n2;
                }else if(i==l2-1){
                    return Character.getNumericValue(y)>Character.getNumericValue(n1.charAt(i + 1))? n2:n1;
                }
            }
        }*/
        //return null;
    }
}
