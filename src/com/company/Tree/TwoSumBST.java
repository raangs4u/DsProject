package com.company.Tree;

import java.util.Stack;

/**
 * @author RANGA.
 */
public class TwoSumBST {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;
        int res = t2Sum(n1, 19);
    }

    public static int t2Sum(TreeNode a, int B) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        boolean done1= false;
        boolean done2 = false;

        TreeNode current1 = a;
        TreeNode current2 = a;

        int val1 = 0;
        int val2 = 0;


        while (true) {
            while (!done1) {
                if (current1!=null) {
                    s1.push(current1);
                    current1 = current1.left;
                } else {
                    if (s1.isEmpty()) {
                        done1 = true;
                    } else {
                        current1 = s1.pop();
                        val1 = current1.val;
                        current1 = current1.right;
                        done1 = true;
                    }
                }
            }

            while (!done2) {
                if (current2!=null) {
                    s2.push(current2);
                    current2 = current2.right;
                } else {
                    if (s2.isEmpty()) {
                        done2 = true;
                    } else {
                        current2 = s2.pop();
                        val2 = current2.val;
                        current2 = current2.left;
                        done2 = true;
                    }
                }
            }

            if ((val1 != val2) && val1+val2 == B) {
                return 1;
            } else if ((val1+val2)<B) {
                done1 = false;
            } else if ((val1+val2)>B) {
                done2 = false;
            }

            if (val1 >=val2) {
                return 0;
            }
        }
    }
}
