package com.company.Hashing;

import javax.xml.soap.SAAJResult;
import java.util.HashMap;

/**
 * Created by RANGA on 4/17/2016.
 */
public class Fraction {
    public static void main(String[] args) {
        fractionToDecimal(87, 22);
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        /*if(numerator ==0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }

        String result = "";
        if (numerator <0 ^ denominator <0) {
            result = result + "-";
        }

        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        result = result + String.valueOf(res);

        long rem = num % den * 10;
        if (rem == 0) {
            return result;
        }
        result = result + ".";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int st = map.get(rem);
                String p1 = result.substring(0,st);
                String p2 = result.substring(st, result.length());
                result = p1 + "(" + p2 + ")";
                return result;
            }
            map.put(rem, result.length());
            res = rem / den;
            result = result + String.valueOf(res);
            rem = (rem % den) * 10;
        }
        return result;*/

        if(numerator ==0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }

        //String result = "";
        StringBuilder sb = new StringBuilder();
        if (numerator <0 ^ denominator <0) {
            //result = result + "-";
            sb.append("-");
        }

        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long res = num / den;
        //result = result + String.valueOf(res);
        sb.append(String.valueOf(res));

        long rem = (num % den) * 10;
        if (rem == 0) {
            return sb.toString();
        }
        //result = result + ".";
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int st = map.get(rem);
                sb.append(')');
                sb.insert(st, '(');
                return sb.toString();
                /*String p1 = result.substring(0,st);
                String p2 = result.substring(st, result.length());
                result = p1 + "(" + p2 + ")";
                return result;*/
            }
            map.put(rem, sb.length());
            res = rem / den;
            //result = result + String.valueOf(res);
            sb.append(String.valueOf(res));
            rem = (rem % den) * 10;
        }
        return sb.toString();
    }
}
