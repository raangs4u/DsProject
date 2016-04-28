package com.company.Strings;

import java.math.BigInteger;

/**
 * Created by rmandada on 8/3/16.
 */
public class Atoi {
    public static void main(String[] args) {
        System.out.println(atoi("-54332872018247709407 4 54"));
    }

    public static int atoi(final String a) {
        StringBuilder sb = new StringBuilder();
        //sb.append(0);
        boolean numaricFound = false;
        int n = a.length();
        int i=0;
        while (i<n) {
            if (isNumeric(a.charAt(i))) {
                sb.append(a.charAt(i));
                if (!numaricFound) {
                    numaricFound = true;
                }
                i++;
            } else {
                if(numaricFound) {
                    return toInt(sb.toString());
                } else {
                    if (a.charAt(i) == ' ') {
                        if (sb.length() == 0){
                            i++;
                        } else {
                            return 0;
                        }

                    } else if(a.charAt(i) == '-' || a.charAt(i) == '+'){
                        if (sb.indexOf("-")!= -1 || sb.indexOf("+") !=-1) {
                            return 0;
                        } else {
                            sb.append(a.charAt(i));
                            i++;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        }

        if(!numaricFound) {
            return 0;
        } else {
            return toInt(sb.toString());
        }
    }

    public static boolean isNumeric(char a) {
        if (a >='0' && a<= '9') {
            return true;
        }
        return false;
    }

    public static int toInt(String s) {
        try {
            BigInteger l = new BigInteger(s);
            if (l.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >=0) {
                return Integer.MAX_VALUE;
            } else if(l.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) <=0) {
                return Integer.MIN_VALUE;
            } else {
                return l.intValue();
            }
        } catch (Exception e) {
            return 0;
        }

    }
}
