package com.company.other;

import com.company.Array.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 3/5/2016.
 */
public class FindMedian {
    public static void main(String[] args) {/*-49, 33, 35, 42 ]
        B : [ -26*/
        List<Integer> a = new ArrayList<Integer>();
        a.add(-49);
        /*a.add(-25);
        a.add(-18);
        a.add(-15);
        a.add(-10);*/
        a.add(33);
        a.add(35);
        a.add(42);
        List<Integer> b = new ArrayList<Integer>();
        b.add(-26);
        System.out.println(findMedian(a,b));
    }

    public static double findMedian(List<Integer> a, List<Integer> b) {
        int l1 = 0;
        int h1 = a.size()-1;
        int m = a.size();
        int n = b.size();
        if(m==0) {
            if(n%2==1) {
                return (double) b.get(n/2);
            } else {
                return ((double) b.get(n/2) + (double) b.get(n/2 -1))/2;
            }
        } else if(n==0) {
            if(m%2==1) {
                return (double) a.get(m/2);
            } else {
                return ((double) a.get(m/2) + (double) a.get(n/2 -1))/2;
            }
        }
        while (l1<=h1) {
            int i = (l1+h1)/2;
            int j= (m+n+1)/2 - i;

            if(j>n){
                l1=i+1;
                continue;
            } else if(j<0){
                h1 = i-1;
                continue;
            }

            if(j>0 && b.get(j-1) > a.get(i)) {
                l1 = i+1;
            } else if(i>0 && a.get(i-1) > b.get(j)) {
                h1 = i-1;
            } else {
              if((m+n) % 2 == 1) {
                  if(j==0) {
                      return (double) a.get(i-1);
                  } else if(i==0){
                      return (double) b.get(j-1);
                  } else {
                      return (double)Math.max(a.get(i-1), b.get(j-1));
                  }

              } else {
                  if(j==0) {
                      return ((double)a.get(i-1)+Math.min(a.get(i),b.get(j)))/2;
                  } else if(i==0){
                      return ((double)b.get(j-1)+Math.min(a.get(i),b.get(j)))/2;
                  } else {
                      return ((double)(Math.max(a.get(i-1), b.get(j-1))+Math.min(a.get(i),b.get(j)))/2);
                  }
                  //return ((double)(Math.max(a.get(i-1), b.get(j-1))+Math.min(a.get(i),b.get(j)))/2);
              }
            }
        }

        return 0;
    }
}
