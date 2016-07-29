package com.company.Tree;

/**
 * Given a Binary Tree and a key, write a function that returns level of the key.
 * http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 *
 * @author rmandada
 */
public class GetLevelOfNodeInBinaryTree {

    public int getLevel(TreeNode root, int data) {
        return getLevelUtil(root, data, 1);
    }

    public int getLevelUtil(TreeNode root, int data, int level) {
        if (root == null) {
            return 0;
        }

        if (root.val == data) {
            return level;
        }

        int downlevel = getLevelUtil(root.left, data, level+1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevelUtil(root.right, data, level+1);
        return downlevel;
    }
}
