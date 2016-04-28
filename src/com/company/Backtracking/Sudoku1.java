package com.company.Backtracking;

import java.util.ArrayList;

/**
 * @author rmandada
 */
public class Sudoku1 {

    public static void main(String[] args) {
        int grid[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, //
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, //
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, //
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, //
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, //
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, //
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, //
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, //
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        for(int[] row : grid) {
            ArrayList<Character> s = new ArrayList<Character>();
            for (int i = 0; i <row.length ; i++) {
                if (row[i] == 0) {
                    s.add('.');
                } else {
                    Character c = new Character(Integer.toString(row[i]).charAt(0));
                    s.add(c);
                }
            }
            a.add(s);
        }

        boolean solved = solve(a, new Cell(0, 0));
        if (!solved) {
            System.out.println("SUDOKU cannot be solved.");
            return;
        }
        System.out.println("SOLUTION\n");
        //printGrid(grid);

    }

    static boolean solve(ArrayList<ArrayList<Character>>  grid, Cell cur) {

        // if the cell is null, we have reached the end
        if (cur == null)
            return true;

        // if grid[cur] already has a value, there is nothing to solve here,
        // continue on to next cell
        if (grid.get(cur.row).get(cur.col) != '.') {
            // return whatever is being returned by solve(next)
            // i.e the state of soduku's solution is not being determined by
            // this cell, but by other cells
            return solve(grid, getNextCell(cur));
        }

        // this is where each possible value is being assigned to the cell, and
        // checked if a solutions could be arrived at.

        // if grid[cur] doesn't have a value
        // try each possible value
        for (int i = 1; i <= 9; i++) {
            // check if valid, if valid, then update
            boolean valid = isValid(grid, cur, Integer.toString(i).charAt(0));

            if (!valid) // i not valid for this cell, try other values
                continue;

            // assign here
            grid.get(cur.row).set(cur.col,Integer.toString(i).charAt(0));

            // continue with next cell
            boolean solved = solve(grid, getNextCell(cur));
            // if solved, return, else try other values
            if (solved)
                return true;
            else
                grid.get(cur.row).set(cur.col,'.'); // reset
            // continue with other possible values
        }

        // if you reach here, then no value from 1 - 9 for this cell can solve
        // return false
        return false;
    }

    static class Cell {

        int row, col;

        public Cell(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }

    static boolean isValid(ArrayList<ArrayList<Character>> grid, Cell cell, char value) {

        if (grid.get(cell.row).get(cell.col) != '.') {
            throw new RuntimeException(
                    "Cannot call for cell which already has a value");
        }

        // if v present row, return false
        for (int c = 0; c < 9; c++) {
            if (grid.get(cell.row).get(c) == value)
                return false;
        }

        // if v present in col, return false
        for (int r = 0; r < 9; r++) {
            if (grid.get(r).get(cell.col) == value)
                return false;
        }

        // if v present in grid, return false

        // to get the grid we should calculate (x1,y1) (x2,y2)
        int x1 = 3 * (cell.row / 3);
        int y1 = 3 * (cell.col / 3);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int x = x1; x <= x2; x++)
            for (int y = y1; y <= y2; y++)
                if (grid.get(x).get(y) == value)
                    return false;

        // if value not present in row, col and bounding box, return true
        return true;
    }

    static Cell getNextCell(Cell cur) {

        int row = cur.row;
        int col = cur.col;

        // next cell => col++
        col++;

        // if col > 8, then col = 0, row++
        // reached end of row, got to next row
        if (col > 8) {
            // goto next line
            col = 0;
            row++;
        }

        // reached end of matrix, return null
        if (row > 8)
            return null; // reached end

        Cell next = new Cell(row, col);
        return next;
    }
}
