package com.company.Hashing;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by RANGA on 4/17/2016.
 */
public class StraightLine {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{4,8,-4});
        List<Integer> b = Arrays.asList(new Integer[]{-4,-4,-4});
        maxPoints(a,b);
    }

    public static int maxPoints(List<Integer> a, List<Integer> b) {
        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<Pair<Integer, Integer>, Integer>();
        int n = a.size();
        if (n<=1) {
            return 0;
        }
        int max = 2;
        for (int i = 0; i <n ; i++) {
            map.clear();
            int same = 1, curMax = 0;
            for (int j = i+1; j <n ; j++) {
                //double m = (double)(b.get(j)-b.get(i))/(a.get(j)-a.get(i));
                /*if (m == Double.NEGATIVE_INFINITY) {
                    m = Double.POSITIVE_INFINITY;
                }*/
                int xdiff = a.get(i)-a.get(j);
                int ydiff = b.get(i)-b.get(j);
                if (xdiff == 0 && ydiff ==0) {
                    same++;
                    continue;
                }

                if (xdiff < 0) {
                    xdiff *= -1;
                    ydiff *= -1;
                }
                int g = gcd(xdiff, ydiff);
                Pair<Integer,Integer> p = new Pair<Integer, Integer>(xdiff/g, ydiff/g);
                if (map.containsKey(p)) {
                    map.put(p, map.get(p)+1);

                } else {
                    map.put(p, 1);
                }
                curMax = Math.max(curMax, map.get(p));
            }
            curMax = curMax+same;
            max = Math.max(max, curMax);
        }
        return max;
        /*HashMap<Integer, Integer> mapx = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapy = new HashMap<Integer, Integer>();
        int n = a.size();
        int max = 1;
        for (int i = 0; i < n; i++) {
            int x = a.get(i);
            int y = b.get(i);
            double m = (double) b.get(i) / a.get(i);
            if (a.get(i) == b.get(i)) {
                m = 1;
            }
            if (map.containsKey(m)) {
                int count = map.get(m) + 1;
                map.put(m, count);
                if (count > max) {
                    max = count;
                }
            } else {
                map.put(m, 1);
            }


            if (mapx.containsKey(x)) {
                int c = mapx.get(x) + 1;
                mapx.put(x, c);
                if (c > max) {
                    max = c;
                }
            } else {
                mapx.put(x, 1);
            }

            if (mapy.containsKey(y)) {
                int d = mapx.get(y) + 1;
                mapy.put(y, d);
                if (d > max) {
                    max = d;
                }
            } else {
                mapy.put(y, 1);
            }
        }

        *///return max;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < 0) return gcd(-1 * a, b);
        if (b < 0) return gcd(a, -1 * b);
        if (a > b) return gcd(b, a);
        return gcd(b%a, a);
    }
}
