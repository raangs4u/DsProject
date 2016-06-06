package com.company.Graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author rmandada
 */
public class SteppingNumbers {

    public static void main(String[] args) {
        System.out.println(stepnum(0, 9));
    }

    public static ArrayList<Integer> stepnum(int a, int b) {
        int len = 0;
        int temp = b;
        while (temp!=0) {
            temp /= 10;
            len++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        dfs(len, a, b, 0, res);
        Collections.sort(res);
        return res;
    }

    public static void dfs(int len, int n, int m, int num, ArrayList<Integer> res) {
        if(num >=n && num <= m) {
            res.add(num);
        }

        if (len == 0) {
            return;
        }

        if (num == 0) {
            for (int i = 1; i <=9 ; ++i) {
                dfs(len-1, n, m, i, res);
            }
            return;
        }

        int lastDigit = num % 10;
        if (lastDigit == 0) {
            dfs(len-1, n, m, (num*10) + (lastDigit+1), res);
        } else if (lastDigit == 9) {
            dfs(len-1, n, m, (num*10)+ (lastDigit-1), res);
        } else {
            dfs(len-1, n, m, (num*10)+ (lastDigit-1), res);
            dfs(len-1, n, m, (num*10) + (lastDigit+1), res);
        }
    }
}
