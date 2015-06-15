package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by RANGA on 1/14/2015.
 */
public class TowerOfHonoi {
    public static void main(String[] args) {

        Stack l = new Stack();
        for (int i = 1; i <5 ; i++) {
            l.add(i);
        }
        Stack m = new Stack();
        Stack n = new Stack();
        System.out.println(l.peek());
        moveplates(4,l,m,n);
        for (int i = 0; i <m.size() ; i++) {
            System.out.println(m.get(i));
        }


    }

    public static void moveplates(int n, Stack origin, Stack destin, Stack buffer) {
        if (n > 0) {
            moveplates(n - 1, origin, buffer, destin);
            destin.push(origin.pop());
            moveplates(n - 1, buffer, destin, origin);
        } else return;
    }
}
