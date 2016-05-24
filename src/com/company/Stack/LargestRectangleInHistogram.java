package com.company.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author rmandada
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(new Integer[]{6,2,5,4,5,1,6});
        largestRectangleArea(s);


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
