package com.company.Tree;

/**
 * @author rmandada
 */
public class PrintCousinsOfANodeInBinaryTree {

    void printCousins(TreeNode root, TreeNode node) {
        int level = getLevel(root, node.val, 1);
    }

    void printGivenLevel(TreeNode root, TreeNode node, int level) {
        if (root == null || level < 2) {
            return;
        }

        if (level == 2) {
            if (root.left == node || root.right == node) {
                return;
            }
            if (root.left != null) {
                System.out.println(root.left.val);
            }
            if (root.right != null) {
                System.out.println(root.right.val);
            }
        } else if (level >2) {
            printGivenLevel(root.left, node, level-1);
            printGivenLevel(root.right, node, level-1);
        }
    }

    int getLevel(TreeNode root, int data, int level) {
        if (root == null) {
            return 0;
        }
        if (root.val == data) {
            return level;
        }

        int downlevel = getLevel(root.left, data, level+1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevel(root.right, data, level+1);
        return downlevel;
    }
}
