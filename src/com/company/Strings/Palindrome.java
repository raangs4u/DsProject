package com.company.Strings;

/**
 * Created by rmandada on 7/3/16.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static int isPalindrome(String a) {
        a = a.toLowerCase();
        a = a.replaceAll("[^a-zA-Z0-9]", "");
        int n = a.length();
        int pal = 1;
        for (int i=0; i<n/2; i++){
            if(a.charAt(i) != a.charAt(n-i-1)){
                pal = 0;
                break;
            }
        }
        return pal;
    }
}
