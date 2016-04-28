package com.company.Strings;

/**
 * Created by rmandada on 9/3/16.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiplyStrings("5555555555", "0"));
    }

    public static String multiplyStrings(String a, String b) {
        int i =0;
        while (i< a.length() && a.charAt(i) == '0') {
            i++;
        }
        a =a.substring(i);
        i=0;
        while (i<b.length() && b.charAt(i) == '0') {
            i++;
        }
        b =b.substring(i);
        int m = a.length();
        int n = b.length();
        if (m == 0 || n==0) {
            return "0";
        }
        if(m>n) {
            String tmp = a;
            a = b;
            b = tmp;
            m = a.length();
            n = b.length();
        }

        StringBuilder s = new StringBuilder(a);
        a = s.reverse().toString();
        s = new StringBuilder(b);
        b = s.reverse().toString();

        String res = "";
        for (int j = 0; j <m ; j++) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k <n ; k++) {
                int mul = Character.getNumericValue(a.charAt(j)) * Character.getNumericValue(b.charAt(k)) + carry;
                sb.append(mul%10);
                carry = mul /10;
            }

            if (carry != 0) {
                sb.append(carry);
            }

            sb = sb.reverse();

            for (int k = 0; k <j ; k++) {
                sb.append('0');
            }
            res = addStrings(res, sb.toString());
        }

        return res;


    }

    public static String addStrings(String a, String b) {
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
            sb.append(sum%10);
            carry = sum/10;
        }

        if (carry == 0) {
            for (int i = m; i <n ; i++) {
                sb.append(b.charAt(n-1-i));
            }
        } else {
            for (int i = m; i <n ; i++) {
                int sum = carry + Character.getNumericValue(b.charAt(n-1-i));
                sb.append(sum%10);
                carry = sum/10;
            }
        }

        if (carry!=0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
