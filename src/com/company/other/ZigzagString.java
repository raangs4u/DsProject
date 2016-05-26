package com.company.other;

/**
 * Created by RANGA on 3/12/2016.
 */
public class ZigzagString {

    public static void main(String[] args) {
        System.out.println(convert("ABCD", 2));
    }

    public static String convert(String a, int b) {
        int currentRow = 0;
        String direction = "down";
        StringBuilder[] rows = new StringBuilder[b];
        for (int i = 0; i <b ; i++) {
            rows[i] = new StringBuilder();
        }

        for (int i = 0; i <a.length() ; i++) {
            rows[currentRow].append(a.charAt(i));
            if(currentRow == b-1 && direction=="down") {
                currentRow--;
                direction = "up";
            } else if (currentRow == 0 && direction == "up") {
                currentRow++;
                direction = "down";
            } else {
                if (direction == "down") {
                    currentRow++;
                } else {
                    currentRow--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <b; i++) {
            res.append(rows[i].toString());
        }

        return res.toString();
    }
}
