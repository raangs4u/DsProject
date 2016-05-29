package com.company.Array;

import java.util.ArrayList;

/**
 * Created by RANGA on 2/2/2016.
 */
public class MaxSet {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1967513926);
        a.add(1540383426);
        a.add(-1303455736);
        a.add(-521595368);

        maxset(a);
    }
    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = -1,n = -1;
        long s=0,d =0;
        int i=0,j=0;
        for(int k=0;k<a.size();k++){
            if(a.get(k)<0){
                d=0;
                i = k+1;
                j = k+1;
            } else{
                d+=(long)a.get(k);
                if(j==i){
                    j=k;
                }else{
                    j++;}
            }
            if(s<d){
                s=d;
                m=i;
                n=j;
            } else if(s==d) {
                if(n-m<j-i){
                    m=i;
                    n=j;
                } else if(n-m==j-i){
                    if(m>i){
                        m=i;
                        n=j;
                    }
                }
            }
        }
        if(m>=0&&n>=0){
            for(int k=m;k<=n;k++){
                res.add(a.get(k));
            }
        }

        return res;
    }
}
