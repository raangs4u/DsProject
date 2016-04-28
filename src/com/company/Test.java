package com.company;

/**
 * Created by rmandada on 15/12/15.
 */
public class Test {
    public static void main(String[] args) {
        double x = 0;
        for (int i = 1; i < 23; i++) {
            double pow =  Math.pow(i, i);
            pow = pow%7;
            x+=pow;
            System.out.println(pow);
        }
        System.out.println(x);
    }
}
