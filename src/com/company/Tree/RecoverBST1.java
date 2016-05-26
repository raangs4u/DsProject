package com.company.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author RANGA.
 */
public class RecoverBST1 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n2.left = n1;
        n2.right = n3;
        //recoverTree(n2);
    }

    public ArrayList<Integer> recoverTree(TreeNode a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        recoverTreeUtil(a, s);
        if (s.size()>1) {
            res.add(s.pop());
            res.add(s.pop());
            Collections.sort(res);
        }
        return res;
    }

    public  void recoverTreeUtil(TreeNode node, Stack<Integer> s1) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            s1.push(node.left.val);
        }
        if (!s1.isEmpty()) {
            if (s1.peek() > node.val){
                s1.push(node.val);
                return;
            }
        }
        s1.push(node.val);
        if (node.right!= null) {
            if (s1.peek() > node.right.val) {
                s1.push(node.right.val);
                return;
            }
        }
        s1.clear();
        recoverTreeUtil(node.left,s1);
        if (s1.size()>=2) {
            return;
        }
        recoverTreeUtil(node.right, s1);
    }
}
