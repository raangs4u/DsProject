package com.company.Array;

import java.util.ArrayList;

/**
 * Created by RANGA on 2/3/2016.
 */
public class Spiral2 {

    public static void main(String[] args) {

        generateMatrix(3);
    }
    public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int p=0;p<a;p++){
            res.add(new ArrayList<Integer>());
            for (int i = 0; i <a ; i++) {
                res.get(p).add(0);
            }
        }
        int i = a;
        int j= a;
        int m =0;
        int l =0;
        int x = 1;
        while(i>0 && j>0){
            for(int k=0; k<j;k++){
                res.get(m).set(l, x++);
                l++;
            }
            m++;
            l--;
            i--;
            j--;
            for(int k=0; k<i;k++){
                res.get(m).set(l, x++);
                m++;
            }
            m--;
            l--;
            for(int k=0; k<j;k++){
                res.get(m).set(l, x++);
                l--;
            }
            l++;
            m--;
            i--;
            j--;
            for(int k=0; k<i;k++){
                res.get(m).set(l, x++);
                m--;
            }
            m++;
            l++;
        }
        return res;
    }
}
