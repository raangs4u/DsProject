package com.company.Strings;

/**
 * Created by rmandada on 7/3/16.
 */
public class SubString {

    public static void main(String[] args) {
        System.out.println(strStr("s", "s"));
    }

    public static int strStr(final String haystack, final String needle) {
        if (needle.length()==0) {
            return -1;
        }

        for (int i = 0; i <haystack.length() ; i++) {
            int found = i;
            if(needle.length()<= haystack.length()-i) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        found = -1;
                    }
                }
                if (found >= 0) {
                    return found;
                }
            }
        }

        return -1;

    }
}
