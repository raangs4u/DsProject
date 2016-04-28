package com.company.Tree;

import java.util.Stack;

/**
 * @author rmandada
 */
public class LCA {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.right = n4;
        n3.left = n2;
        n2.left = n1;
        n2.right = n6;
        n4.left = n7;
        n4.right = n5;
        lca(n3, 1, 6);
    }

    public static int lca(TreeNode a, int val1, int val2) {
        findLca(a,val1,val2);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int v1,v2;
        if (getNode(a,val1,stack1) && getNode(a,val2,stack2)) {
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                v1 = stack1.peek();
                v2 = stack2.peek();
                if (v1 == v2) {
                    return v1;
                } else {
                    if (stack1.size()>stack2.size()) {
                        stack1.pop();
                    } else if (stack1.size()<stack2.size()){
                        stack2.pop();
                    } else {
                        stack1.pop();
                        stack2.pop();
                    }
                }
            }
        }
        return -1;
    }

    public static TreeNode findLca(TreeNode a, int val1, int val2) {
        if (a==null) {
            return null;
        }

        if (a.val == val1 || a.val == val2) {
            return a;
        }

        TreeNode leftLca = findLca(a.left, val1, val2);
        TreeNode rightLca = findLca(a.right, val1, val2);

        if (leftLca != null && rightLca != null) {
            return a;
        }
        return leftLca != null ? leftLca : rightLca;
    }


    public static boolean getNode(TreeNode root, int val1, Stack<Integer> stack) {
        if (root == null) {
            return false;
        }

        if (root.val == val1) {
            stack.push(val1);
            return true;
        }
        stack.push(root.val);
        if (getNode(root.left, val1, stack)){
            return true;
        }
        if (getNode(root.right, val1, stack)){
            return true;
        }
        stack.pop();
        return false;
    }
}
