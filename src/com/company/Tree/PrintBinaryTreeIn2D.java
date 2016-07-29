package com.company.Tree;

/**
 * @author rmandada
 */
public class PrintBinaryTreeIn2D {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        printBinaryTreeIn2DUtil(root, 0);

    }

    public static void printBinaryTreeIn2DUtil(TreeNode node, int space) {
        if (node == null) {
            return;
        }

        space += 10;

        // reverse inorder
        printBinaryTreeIn2DUtil(node.right, space);
        System.out.println();
        for (int i = 10; i <space ; i++) {
            System.out.print(" ");
        }
        System.out.print(node.val + "\n");
        printBinaryTreeIn2DUtil(node.left, space);
    }
}
