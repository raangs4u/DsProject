package com.company.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author rmandada
 */
public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.right = n4;
        n3.left = n2;
        n2.left = n1;
        n4.right = n5;
        zigzagLevelOrder(n3);
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(a);

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> r = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.peek();
                r.add(node.val);
                s1.pop();
                if (node.left!=null) {
                    s2.push(node.left);
                }
                if (node.right!=null) {
                    s2.push(node.right);
                }
            }
            if (!r.isEmpty()) {
                res.add(r);
            }
            r = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.peek();
                r.add(node.val);
                s2.pop();
                if (node.right!=null) {
                    s1.push(node.right);
                }
                if (node.left!=null) {
                    s1.push(node.left);
                }
            }
            if (!r.isEmpty()) {
                res.add(r);
            }
        }
        return res;
    }
}
