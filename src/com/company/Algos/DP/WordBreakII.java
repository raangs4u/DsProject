package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RANGA.
 */
public class WordBreakII {

    public static void main(String[] args) {
        List<String> s = Arrays.asList(new String[]{"bababbbb", "bbbabaa", "abbb", "a", "aabbaab", "b", "babaabbbb", "aa", "bb"});
        System.out.println(wordBreak("aabbbabaaabbbabaabaab", s));
    }
    public static ArrayList<String> wordBreak(String a, List<String> b) {
        //return memo(a,b,0,a.length()-1);
        int n = a.length();
        ArrayList<String>[][] x = new ArrayList[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                x[i][j] = null;
            }
        }

        return memo(a,b,0,n-1,x);
    }

    public static ArrayList<String> memo(String a, List<String> b, int i, int j, ArrayList<String>[][] dp) {
        ArrayList<String> res = new ArrayList<String>();
        if (i>j) {
            return res;
        }

        if (dp[i][j] !=null) {
            return (ArrayList<String>) dp[i][j].clone();
        }

        for (int k = i+1; k <=j+1 ; k++) {
            String s =a.substring(i,k);
            if(b.contains(s)){
                ArrayList<String> x = memo(a,b,k,j,dp);
                ArrayList<String> y = (ArrayList<String>) x.clone();
                for (int l = 0; l <x.size() ; l++) {
                    y.set(l, s+" "+x.get(l));
                }
                if (k>j){
                    y.add(s);
                }
                res.addAll(y);
            }
        }

        dp[i][j] = res;
        return res;
    }
}
