package com.company.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author RANGA.
 */
public class GenerateAllParenthesis {

    public static void main(String[] args) {
        generateParenthesis2(2);
    }

    public static ArrayList<String> generateParenthesis1(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
    }

    public static ArrayList<String> generateParenthesis2(int A) {
        ArrayList<String>res = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        rec(res,0, 0, 0, str, A);
        return res;
    }

    public static void rec(ArrayList<String> res, int leftCount, int rightCount, int index, StringBuilder str, int n) {

        if (leftCount > n || rightCount > n)
            return;

        if (rightCount > leftCount)
            return;

        if (index == 2 * n) {
            res.add(str.toString());
            return;
        }

        str.append('(');
        rec(res,leftCount + 1, rightCount, index + 1, str, n);
        str.deleteCharAt(str.length() - 1);

        str.append(')');
        rec(res,leftCount, rightCount + 1, index + 1, str, n);
        str.deleteCharAt(str.length() - 1);

    }

    public static ArrayList<String> generateParenthesis(int a) {
        //wrong sol
        ArrayList<String> res = new ArrayList<String>();
        if (a==0) {
            return res;
        }
        if(a == 1) {
            res.add("()");
            return res;
        }

        ArrayList<String> rem = generateParenthesis(a-1);
        for(String str: rem) {
            res.add("("+str+")");
        }
        for(String str: rem) {
            String s1 = str + "()";
            String s2 = "()"+ str;
            if (s1.equals(s2)) {
                res.add(s1);
            } else {
                res.add(s1);
                res.add(s2);
            }
        }

        Collections.sort(res);
        return res;
    }

    public static void dfs(ArrayList<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }
}
