package com.company.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RANGA on 1/14/2015.
 */
public class ParenthesisMatch {

    public static void main(String[] args) {

        char[] exp = "}[(5+x)-(y+z)(]".toCharArray();
        List<Character> expp = new ArrayList<Character>();
        List<Character> opbr = new ArrayList<Character>();
        List<Character> clbr = new ArrayList<Character>();
        for (int i = 0; i <exp.length ; i++) {
            expp.add(exp[i]);
        }

        char[] openingBraces = "([{<".toCharArray();
        char[] closingBraces = ")}>]".toCharArray();
        for (int i = 0; i <openingBraces.length ; i++) {
            opbr.add(openingBraces[i]);
        }
        for (int i = 0; i <closingBraces.length ; i++) {
            clbr.add(closingBraces[i]);
        }
        boolean valid = true;
        Stack<Character> stack = new ArrayStack<Character>();
        for (int i = 0; i <expp.size() ; i++) {
            char c = expp.get(i);
            if(opbr.contains(c)){
                stack.push(c);
            } else if(clbr.contains(c)){
                if(stack.isEmpty()){
                    System.out.println("Invalid expression");
                    valid = false;
                    break;
                }else {
                    stack.pop();
                }
            } else {

            }
        }
        if(!stack.isEmpty()){
            System.out.println("InValid expression");
        } else if (valid){
            System.out.println("valid expression");
        } else {

        }
    }
}
