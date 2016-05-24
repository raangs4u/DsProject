package com.company.other;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RANGA on 2/27/2016.
 */
public class PermRankRepeated {

    public static void main(String[] args) {
        System.out.println(findRank("asasdsdsadasdadsadasdsa"));
    }
    public static int findRank(String a) {
        if(a.length() == 1) {
            return 1;
        }
        Set<Character> charSet = new HashSet<Character>();
        for (char c: a.toCharArray()) {
            charSet.add(c);
        }
        BigInteger res = BigInteger.valueOf(0);
        for (char c : charSet) {
            if((int)c < (int) a.charAt(0)){
                BigInteger f = factorial(a.length()-1);
                StringBuilder sb = new StringBuilder(a);
                int i = a.indexOf(c);
                sb.deleteCharAt(i);
                BigInteger e = noOfRepeatedChars(sb.toString());
                f = f.multiply(e);
                BigInteger[] z = f.divideAndRemainder(BigInteger.valueOf(1000003));
                res = res.add(z[1]);
            }
        }
        res = res.add(BigInteger.valueOf(findRank(a.substring(1))));
        return res.intValue();
        /*BigInteger rank =BigInteger.valueOf(0);
        int s = a.length();
        for(int i=0; i<s;i++){
            BigInteger x = noOfRepeatedChars(a.substring(i+1));
            int z = findNoOfChars(a.substring(i).toCharArray(), a.charAt(i));
            for (int j = 0; j <; j++) {



            }
            BigInteger y = BigInteger.valueOf(findNoOfChars(a.substring(i).toCharArray(),a.charAt(i)))
                    .multiply(factorial(s-1-i)).divide(x);
            if(!y.equals(BigInteger.valueOf(0))){
                y=y.add(BigInteger.valueOf(1));
            }
            rank = rank.add(y);
           // rank= rank.add();
        }
        BigInteger[] r = rank.divideAndRemainder(BigInteger.valueOf(1000003));
        return r[1].intValue();*/
    }

    public static BigInteger noOfRepeatedChars(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        BigInteger fact = BigInteger.valueOf(1);
        for(int i=0;i<s.length();){
            int count = 1;
            for(int j=i+1;j<s.length();j++){
                if(c[i]==c[j]) {
                    count++;
                } else {
                    break;
                }
            }
            i+=count;
            fact = fact.multiply(factorial(count));
        }
        //fact = fact.pow(1000001);
        //BigInteger[] y = fact.divideAndRemainder(BigInteger.valueOf(1000003));
        return findInverse(fact);
    }

    public static BigInteger findInverse(BigInteger base) {
        int MOD = 1000003;
        BigInteger ans = BigInteger.valueOf(1);
        int power = MOD - 2;
        while (power > 0) {
            if (power == 1) {
                BigInteger[] x = ans.multiply(base).divideAndRemainder(BigInteger.valueOf(MOD));
                return x[1];
            }
            if (power % 2 == 0) {
                base = base.multiply(base);
                base = base.divideAndRemainder(BigInteger.valueOf(MOD))[1];
                power /= 2;
            } else {
                ans = ans.multiply(base).divideAndRemainder(BigInteger.valueOf(MOD))[1];
                power--;
            }
        }
        return ans;
    }

    public static BigInteger factorial(int n) {
        BigInteger a = BigInteger.valueOf(1);
        for(int i=2; i<=n; i++){
            a = a.multiply(BigInteger.valueOf(i));
        }
        BigInteger[] b = a.divideAndRemainder(BigInteger.valueOf(1000003));
        return b[1];
    }

    public static int findNoOfChars(char[] c, char x) {
        int count = 0;
        Arrays.sort(c);
        char b = '\0';
        for(int i=0;i<c.length;i++){
            if((int)c[i] < (int)x && c[i] != b){
                b=c[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
