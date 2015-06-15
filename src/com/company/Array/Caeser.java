package com.company.Array;

import java.util.Scanner;

/**
 * Created by RANGA on 1/13/2015.
 */
public class Caeser {

    public static final int SIZE = 26;
    public static final char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static String encrypt(String s){
        char[] ar = s.toCharArray();
        for (int i=0;i<ar.length;i++) {
            ar[i] = alpha[(ar[i]-'A'+3)%26];
        }
        return new String(ar);
    }
    public static String decrypt(String s) {
        char[] ar = s.toCharArray();
        for (int i = 0; i <ar.length ; i++) {
            ar[i] = alpha[(ar[i]-'A'-3)%26];
        }
        return new String(ar);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your secret to encrypt: ");
        String en = encrypt(in.next());
        System.out.println(en);
        System.out.println(decrypt(en));
    }
}
