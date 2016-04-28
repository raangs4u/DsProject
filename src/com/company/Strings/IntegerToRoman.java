package com.company.Strings;

/**
 * Created by rmandada on 9/3/16.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(integerToRoman(891));


    }

    public static String integerToRoman(int num) {
        if (num > 3999) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String n = String.valueOf(num);
        int len = n.length();
        for (int i = 0; i <len ; i++) {
            int x = (int) (Character.getNumericValue(n.charAt(i)) * Math.pow(10, len-1-i));
            sb.append(getRomanString(x));
        }

        return sb.toString();
    }

    public static String getRomanString(int n) {
        if (n>=1000) {
            int i = n/1000;
            String res = "";
            for (int j = 0; j <i ; j++) {
                res = res + "M";
            }
            return  res;
        } else if (n==900) {
            return "CM";
        } else if (n>=500) {
            return "D" + getRomanString(n-500);
        } else if (n==400) {
            return "CD";
        } else if (n>=100){
            int i = n/100;
            String res = "";
            for (int j = 0; j <i ; j++) {
                res = res + "C";
            }
            return  res;
        } else if(n==90) {
            return "XC";
        } else if (n>=50) {
            return "L" + getRomanString(n-50);
        } else if (n==40) {
            return "XL";
        } else if (n>=10){
            int i = n/10;
            String res = "";
            for (int j = 0; j <i ; j++) {
                res = res + "X";
            }
            return  res;
        } else if(n==9) {
            return "IX";
        } else if (n>=5) {
            return "V" + getRomanString(n-5);
        } else if (n==4){
            return "IV";
        } else if (n>=1){
            int i = n;
            String res = "";
            for (int j = 0; j <i ; j++) {
                res = res + "I";
            }
            return  res;
        }
        return "";
    }
}
