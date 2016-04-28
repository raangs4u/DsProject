package com.company;

/**
 * Created by rmandada on 18/3/16.
 */
public class BitManipulation {
    public static void main(String[] args) {
        System.out.println(reverseBits(3));
    }

    public static long reverseBits(long n) {
        long revNum = 0;
        int count = 0;
        while (n!=0){
            revNum<<=1;
            revNum|=( n &1);
            n>>=1;
            count++;
        }
        revNum <<= 32-count;
        return revNum;
    }
}
