package com.company.Backtracking;

import java.util.ArrayList;

/**
 * @author rmandada
 */
public class Sudoku {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        //Character[] c = "53..7....".toCharArray();
        //ArrayList a1 = new ArrayList<>(c);
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
       // rec(a);
    }

    public Pair getNextCell(Pair cell) {
        int row = cell.row;
        int col = cell.col;
        if(col < 8) {
            cell.col = cell.col +1;
            return cell;
        } else if (row < 8) {
            cell.col = 0;
            cell.row = cell.row+1;
        } else {
            return null;
        }
        return null;
    }

    public boolean rec(ArrayList<ArrayList<Character>> a, Pair cell) {

        if (cell == null) {
            return true;
        }

        int row = cell.row;
        int col = cell.col;
        if (a.get(row).get(col) != '.') {
            return rec(a, getNextCell(cell));
        }

        for (int i = 1; i <10 ; i++) {
            char c = Character.valueOf((char) i);
            if (!isValid(a, row, col, c)){
                continue;
            }

            a.get(row).set(col, c);
            if (rec(a, getNextCell(cell))) {
                return true;
            }
            a.get(row).set(col, '.');
        }

        return false;
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Pair findEmptyCell(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        Pair p = new Pair(-1,-1);
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (a.get(i).get(j) == '.') {
                    p.row = i;
                    p.col = j;
                    return p;
                }
            }
        }

        return p;
    }

    public boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, char c) {
        // row
        int n = a.size();
        for (int i = 0; i <n ; i++) {
            if (a.get(row).get(i) == c) {
                return false;
            }
        }

        //col
        for (int i = 0; i <n ; i++) {
            if (a.get(i).get(col) == c) {
                return false;
            }
        }

        int rowStart = row - row%3;
        int colStart = col - col%3;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                if (a.get(rowStart+i).get(colStart+j) == c) {
                    return false;
                }
            }
        }

        return true;
    }

}
