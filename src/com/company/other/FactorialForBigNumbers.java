package com.company.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 2/27/2016.
 */
public class FactorialForBigNumbers {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        int n = 9358;
        a.add(1);
        int resSize = 1;
        for (int i = 2; i <=n ; i++) {
            resSize = multiply(i, a, resSize);
        }
        int count =0;
        for (int i = 0; i <resSize ; i++) {
            if(a.get(i)==0) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);

        /*for (int i = resSize-1; i >=0 ; i--) {
            System.out.print(a.get(i));
        }*/



    }


    public static int multiply(int x, List<Integer> res, int resSize) {
        int carry = 0;
        for (int i = 0; i <resSize ; i++) {
            int prod = res.get(i) * x + carry;
            res.set(i, prod % 10);
            carry = prod / 10;
        }
        while(carry != 0) {
            res.add(carry % 10);
            carry = carry /10;
            resSize++;
        }

        return resSize;
    }
}
