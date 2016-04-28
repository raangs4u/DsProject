package com.company.Backtracking;

import java.util.ArrayList;

/**
 * @author rmandada
 */
public class NQueens {

    public static void main(String[] args) {
        solveNQueens(14);
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        int[][] mt = new int[a][a];
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        long time = System.currentTimeMillis();
        rec(res, mt, 0);
        System.out.println(System.currentTimeMillis()-time);
        return res;
    }

    public static void rec(ArrayList<ArrayList<String>> res, int[][] mt, int row) {
        int n = mt.length;
        if (row>=n) {
            //addCurrentSol(res, mt);
            return;
        }
        
        for (int i = 0; i <n ; i++) {
           if (isSafe(mt, row, i)) {
               mt[row][i] = 1;
               rec(res, mt, row+1);
               mt[row][i] = 0;
           }
        }
    }
    
    public static boolean isSafe(int[][] mt, int row, int col) {
        int i, j;
        for (i = row-1; i >=0 ; i--) {
            if (mt[i][col] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i>=0 && j>=0 ; i--,j--) {
            if (mt[i][j] == 1) {
                return false;
            }
        }

        for (i = row, j = col; j<mt.length && i>=0 ; i--,j++) {
            if (mt[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
    
    public static void addCurrentSol(ArrayList<ArrayList<String>> res, int[][] mt) {
        int n = mt.length;
        ArrayList<String> cur = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <n ; j++) {
                if (mt[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            
            cur.add(sb.toString());
        }
        
        res.add(cur);
    }
}
