package com.company.Algos.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rmandada
 */
public class MaxRectangleInBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        if (m==0) {
            return 0;
        }
        int n = a.get(0).size();
        int[][][][] dp = new int[m][n][m][n];
        dp[0][0][0][0] = a.get(0).get(0);
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = i; k <m ; k++) {
                    for (int l = j; l <n ; l++) {
                        int x = a.get(k).get(l);
                        if (k==i && l==j) {
                            dp[i][j][k][l] = x;
                        } else if (k!=i && l==j) {
                            if (dp[i][j][k-1][l] ==1 && x==1) {
                                dp[i][j][k][l] = x;
                            }
                        } else if (k==i && l!=j) {
                            if (dp[i][j][k][l - 1] == 1 && x == 1) {
                                dp[i][j][k][l] = x;
                            }
                        } else {
                            if (dp[i][j][k-1][l] ==1 && dp[i][j][k][l - 1] == 1 && x == 1) {
                                dp[i][j][k][l] = x;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k < m; k++) {
                    for (int l = j; l < n; l++) {
                        if (dp[i][j][k][l] == 1) {
                            int area = (k-i+1) *(l-j+1);
                            if(max < area) {
                                max = area;
                            }
                        }
                    }
                }
            }
        }

        return max;
    }

    public int maximalRectangleByHistogramMethod(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        if (m == 0) {
            return 0;
        }
        int n = a.get(0).size();
        for (int i = 1; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(a.get(i).get(j) == 1) {
                    a.get(i).set(j, a.get(i-1).get(j)+1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i <m ; i++) {
            int area = largestRectangleArea(a.get(i));
            if (area > max) {
                max = area;
            }
        }
        for (int i = m-1; i >0 ; i--) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) >0) {
                    a.get(i).set(j, a.get(i).get(j)-a.get(i-1).get(j));
                }
            }
        }

        return max;
    }

    public static int largestRectangleArea(List<Integer> a) {
        int max = Integer.MIN_VALUE;
        int n = a.size();
        int i=0;
        int area;
        Stack<Integer> s = new Stack<>();
        while(i<n) {
            if(s.isEmpty() || a.get(s.peek())<= a.get(i)) {
                s.push(i++);
            } else {
                int tp = s.pop();
                area = a.get(tp) * (s.isEmpty() ? i : (i-s.peek()-1));
                if(area>max) {
                    max = area;
                }
            }
        }

        while(!s.isEmpty()) {
            int tp = s.pop();
            area = a.get(tp) * (s.isEmpty() ? i : (i-s.peek()-1));
            if(area>max) {
                max = area;
            }
        }

        return max;
    }
}
