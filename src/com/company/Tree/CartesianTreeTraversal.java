package com.company.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RANGA.
 */
public class CartesianTreeTraversal {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(new Integer[]{3,7,2,8,1,6,10,5,9,4});
        buildTree(l);
    }

    public TreeNode buildTree1(List<Integer> a, int st, int en) {
        if (st == en) {
            return new TreeNode(a.get(st));
        }

        if (st>en) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;

        for (int i = st; i <=en ; i++) {
            if (a.get(i) >max) {
                max = a.get(i);
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildTree1(a, st, max-1);
        node.right = buildTree1(a, max+1, en);
        return node;
    }

    public static TreeNode buildTree(List<Integer> a) {
        TreeNode x = temp(a, 0, a.size()-1, null);
        return x;
    }

    public static TreeNode temp(List<Integer> a, int i, int j, TreeNode root) {
        if(i>j) {
            return root;
        }
        TreeNode node = new TreeNode(a.get(i));
        /*if(i==j) {
            return node;
        }*/

        if(root == null) {
            root = node;
            return temp(a, i+1, j, root);
        }

        if(root.val < node.val) {
            node.left = root;
            return temp(a, i+1, j, node);
        }
        int k;
        if (i==j) {
            root.right = node;
            return root;
        }
        for(k = i+1; k<=j; k++){
            if(root.val < a.get(k)) {
                break;
            }
        }

        root.right = temp(a, i, k-1, null);
        return temp(a, k, j, root);
    }
}
