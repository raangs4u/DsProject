package com.company.Algos.DP;

/**
 * Created by RANGA on 9/25/2015.
 */
public class LongestPalindromeByBottomUp {

    public static void main(String[] args) {
        char[] s = new char[] {'c','h','a','r','a','c','t','e','r'};
        System.out.println("palindrome length: "+longestPalindromInSubSequence(s));
    }

    public static int longestPalindromInSubSequence(char[] s) {
        int n = s.length;
        int[][] c = new int[n][n];
        int[][] b = new int[n][n];

        for (int i = 0; i <n ; i++) {
            c[i][i] = 1;
        }

        for (int l = 2; l <=n ; l++) {
            for (int i = 0; i <n-l+1 ; i++) {
                int j = l+i-1;

                if (s[i] == s[j] && l==2) {
                    c[i][j] = 2;
                    b[i][j] = 5;
                } else if (s[i] == s[j]){
                    c[i][j] = c[i+1][j-1]+2;
                    b[i][j]=5;
                } else {
                    c[i][j] = Math.max(c[i+1][j],c[i][j-1]);
                    b[i][j]=0;
                }
            }
        }
        StringBuffer strBuff = new StringBuffer();
        int x = 0;
        int y = n-1;

        while (x<y){
            if (s[x]==s[y]){
                strBuff.append(s[x]);
                x++;
                y--;
            } else if (c[x][y-1]>c[x+1][y]){
                y--;
            }else {
                x++;
            }
        }
        StringBuffer strBuffCopy = new StringBuffer(strBuff);
        String str = strBuffCopy.reverse().toString();
        if(x == y){
            strBuff.append(s[x]+str);
        } else {
            strBuff.append(str);
        }
        System.out.println(strBuff.toString());
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        return c[0][n-1];
    }

}
