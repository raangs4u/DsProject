package com.company.Tree;

import java.util.ArrayList;

/**
 * @author RANGA.
 */
public class KthSmallest {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(kthsmallest(node, 1));
    }
    public static int kthsmallest(TreeNode root, int k) {
       return inorderTraversalUtil(new Value(k), root);
        //return node.val;
    }

    static class Value{
        int k;

        public Value(int k) {
            this.k = k;
        }
    }

    public static int inorderTraversalUtil(Value k, TreeNode a){
        if(a == null) {
            return -1;
        }

        int k1 = inorderTraversalUtil(k, a.left);
        if (k.k==0) return k1;
        k.k--;
        if (k.k==0) return a.val;
        //res.add(a.val);
        return inorderTraversalUtil(k, a.right);
        //return null;
    }
}
