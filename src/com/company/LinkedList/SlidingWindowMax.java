package com.company.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by rmandada on 28/3/16.
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[] {648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368});
        System.out.println(slidingMaximum(a, 9));
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        int n = a.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(b>=n) {
            int x = max(a);
            res.add(x);
            return res;
        }
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<b;i++) {
            while(!q.isEmpty() && a.get(i)>=a.get(q.getLast())) {
                q.removeLast();
            }
            q.addLast(i);
        }
        for(int i=b;i<n;i++) {
            res.add(a.get(q.peekFirst()));
            while(!q.isEmpty() && a.get(i)>=a.get(q.getLast())) {
                q.removeLast();
            }
            if(!q.isEmpty() && i-q.getFirst()==b) {
                q.removeFirst();
            }
            q.addLast(i);
        }

        res.add(a.get(q.peekFirst()));

        return res;

    }

    public static int max(Collection<Integer> s) {
        int max = Integer.MIN_VALUE;
        for(int a : s) {
            if(a>max) {
                max = a;
            }
        }
        return max;
    }
}
