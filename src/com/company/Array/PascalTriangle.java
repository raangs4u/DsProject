package com.company.Array;

import java.util.ArrayList;

/**
 * Created by RANGA on 2/3/2016.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        getRow(4);
    }
    public static ArrayList<Integer> getRow(int a) {
        a=a+1;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>(a);
        for(int i=0; i<a; i++){
            mat.add(new ArrayList<Integer>(i+1));
            for(int j=0;j<i+1;j++){
                mat.get(i).add(0);
            }

        }
        mat.get(0).set(0,1);
        for(int i=1;i<a;i++){
            for(int j=0; j<=i;j++){
                int b = 0;
                if(j>0 && j!=i){
                    b =mat.get(i-1).get(j)+mat.get(i-1).get(j-1);
                } else if (j==i) {
                    b =mat.get(i-1).get(j-1);
                } else {
                    b =  mat.get(i-1).get(j);
                }
                mat.get(i).set(j, b);
            }
        }

        return mat.get(a-1);
    }
}
