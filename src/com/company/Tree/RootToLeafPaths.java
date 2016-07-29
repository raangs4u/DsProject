package com.company.Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author rmandada
 */
public class RootToLeafPaths {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
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
        //rootToLeaf(n3, res,new ArrayList<>());
        //rootToLeafWithSum(n3, res, new ArrayList<>(), 11);
        //System.out.println(res.size());
        rootToLeafPathsIterative(n3);
    }

    public static void rootToLeaf(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null) {

            res.add((ArrayList<Integer>) temp.clone());
            temp.remove(temp.size()-1);
            return;
        }
        rootToLeaf(root.left, res, temp);
        rootToLeaf(root.right, res, temp);
        temp.remove(temp.size()-1);
    }

    public static void rootToLeafWithSum(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int sum) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {

            res.add((ArrayList<Integer>) temp.clone());
            temp.remove(temp.size()-1);
            return;
        }
        rootToLeafWithSum(root.left, res, temp, sum);
        rootToLeafWithSum(root.right, res, temp, sum);
        temp.remove(temp.size()-1);
    }

    public static void rootToLeafPathsIterative(TreeNode root) {
        if (root==null) {
            return;
        }

        ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                //System.out.println(current.val);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                if (node.right== null) {
                    res.add(new ArrayList<>(stack));
                    current = null;
                } else {
                    current = node.right;
                }
            }
        }
    }
}
