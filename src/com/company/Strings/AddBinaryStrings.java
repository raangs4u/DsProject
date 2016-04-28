package com.company.Strings;

/**
 * Created by rmandada on 9/3/16.
 */
public class AddBinaryStrings {

    public static void main(String[] args) {
        System.out.println(addBinary("111", ""));
    }

    public static String addBinary(String a, String b) {


        // a is smaller

        int m = a.length();
        int n = b.length();
        if (m == 0) {
            return b;
        } else if (n==0) {
            return a;
        }
        if(m>n) {
            String tmp = a;
            a = b;
            b = tmp;
            m = a.length();
            n = b.length();
        }

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i <m ; i++) {
            int sum = carry + Character.getNumericValue(a.charAt(m-1-i)) + Character.getNumericValue(b.charAt(n-1-i));
            sb.append(sum%2);
            carry = sum/2;
        }

        if (carry == 0) {
            for (int i = m; i <n ; i++) {
                sb.append(b.charAt(n-1-i));
            }
        } else {
            for (int i = m; i <n ; i++) {
                int sum = carry + Character.getNumericValue(b.charAt(n-1-i));
                sb.append(sum%2);
                carry = sum/2;
            }
        }

        if (carry==1) {
            sb.append('1');
        }

        return sb.reverse().toString();

    }
}
