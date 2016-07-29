package com.company.Tree;

import java.util.Stack;

/**
 * @author rmandada
 */
public class CheackLeafTraversalOfTwoBinaryTrees {

    public static void main(String[] args) {

    }

    public boolean checkifLeafTraversalOfTwoBinaryTreesIsSame(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode leaf1 = null;
        TreeNode leaf2 = null;

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty() || stack2.isEmpty()) {
                return false;
            }
            TreeNode node1 = stack1.pop();
            while (node1 !=null && !isLeaf(node1)) {
                if(node1.right != null) {
                    stack1.push(node1.right);
                }
                if(node1.left != null) {
                    stack1.push(node1.left);
                }
                node1 = stack1.pop();
            }

            TreeNode node2 = stack2.pop();
            while (node2 !=null && !isLeaf(node2)) {
                if(node2.right != null) {
                    stack2.push(node2.right);
                }
                if(node2.left != null) {
                    stack2.push(node2.left);
                }
                node2 = stack2.pop();
            }

            if (node1==null && node2!=null) {
                return false;
            }
            if (node2==null && node1!=null) {
                return false;
            }
            if (node1 != null && node2 != null ) {
                if (node1.val != node2.val) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }
}

