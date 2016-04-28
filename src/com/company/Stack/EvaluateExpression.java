package com.company.Stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rmandada on 29/3/16.
 */
public class EvaluateExpression {

    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> s = new Stack<Integer>();
        for(String c: a){
            if(c=="+") {
                if(s.size()<2) {
                    return 0;
                }
                int d = s.pop();
                int b = s.pop();
                b = b + d;
                s.push(b);
            } else if(c=="-") {
                if(s.size()<2) {
                    return 0;
                }
                int d = s.pop();
                int b = s.pop();
                b = b - d;
                s.push(b);
            } else if(c=="*") {
                if(s.size()<2) {
                    return 0;
                }
                int d = s.pop();
                int b = s.pop();
                b = b * d;
                s.push(b);
            } else if(c=="/") {
                if(s.size()<2) {
                    return 0;
                }
                int d = s.pop();
                int b = s.pop();
                b = b / d;
                s.push(b);
            } else {
                s.push(Integer.parseInt(c));
            }
        }

        if(!s.isEmpty()){
            return s.peek();
        }

        return 0;
    }
}
