package com.company.Strings;

/**
 * Created by rmandada on 8/3/16.
 */
public class ValidateNumber {
    public static void main(String[] args) {
        System.out.println(isNumber("    "));
    }

    public static int isNumber(final String a) {
        int n = a.length();
        int i = 0;

        boolean dotFound = false;
        boolean expFound =false;

        while (n>0 && a.charAt(n-i-1) == ' ') {
            n--;
        }

        while (i<n && a.charAt(i) == ' ') {
            i++;
        }

        if (i>=n) {
            return 0;
        }

        if(a.charAt(i) == '-' || a.charAt(i) == '+' ) {
            i++;
        }

        if (i>=n) {
            return 0;
        }

        /*while (i<n && isNumeric(a.charAt(i))) {
            i++;
            if (a.charAt(i) == '.'){
                i++;
                break;
            }
        }

        while ()*/
        while (i<n) {
            if (isNumeric(a.charAt(i))) {
                i++;
            } else {
                if(a.charAt(i) == '.' ){
                    if(dotFound || expFound) {
                        return 0;
                    }
                    if (i+1>= n || !isNumeric(a.charAt(i+1))){
                        return 0;
                    } else {
                        i+=2;
                        dotFound = true;
                    }
                } else if (a.charAt(i) == 'e') {
                    if (expFound) {
                        return 0;
                    }

                    if (i+1>= n || !(isNumeric(a.charAt(i+1)) || a.charAt(i+1) == '-' || a.charAt(i+1) == '+')) {
                        return 0;
                    } else {
                        i+=2;
                        expFound=true;
                    }
                } else {
                    return 0;
                }
            }

        }

        return 1;

    }

    public static boolean isNumeric(char a) {
        if (a >='0' && a<= '9') {
            return true;
        }
        return false;
    }
}
