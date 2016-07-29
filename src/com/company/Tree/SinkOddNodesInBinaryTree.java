package com.company.Tree;

/**
 * Given a Binary Tree having odd and even elements, sink all its odd valued nodes such that no node with odd value could be parent of node with even value. There can be multiple outputs for a given tree, we need to print one of them. It is always possible to convert a tree (Note that a node with even nodes and all odd nodes follows the rule)
 * http://www.geeksforgeeks.org/sink-odd-nodes-binary-tree/
 *
 * @author rmandada
 */
public class SinkOddNodesInBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right==null;
    }
    public void sinkOddNodes(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return;
        }
        sinkOddNodes(root.left);
        sinkOddNodes(root.right);
        if (root.val %2!= 0) {
            sink(root);
        }
    }

    public void sink(TreeNode node) {
        if (node==null || isLeaf(node)) {
            return;
        }

        if (node.left!= null && node.left.val %2==0) {
            int t = node.val;
            node.val = node.left.val;
            node.left.val = t;
            sink(node.left);
        } else if (node.right!= null && node.right.val %2==0) {
            int t = node.val;
            node.val = node.right.val;
            node.right.val = t;
            sink(node.right);
        }
    }
}
