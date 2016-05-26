package com.company.Algos.DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author RANGA.
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> s = Arrays.asList(new String[]{"trainer", "my", "interview"});
        System.out.println(wordBreak("mymyinterviewtrainer", s));
    }

    public static int wordBreak(String a, List<String> b) {
        int n = a.length();
        int[] x = new int[n];
        for (int i = 0; i <n ; i++) {
            x[i]=-1;
        }

        return memo(a,b,0,x);
    }

    public static int memo(String a, List<String> b, int start, int[] dp) {
        if (start>=a.length()) {
            return 1;
        }

        if (dp[start] >=0) {
            return dp[start];
        }
        int res =0;

        for (int i = start+1; i <=a.length() ; i++) {

            String s = a.substring(start, i);
            if (b.contains(s)) {
                res = memo(a,b,i,dp);
            }
            if (res==1) {
                break;
            }
        }
        dp[start]=res;
        return res;
    }
}
