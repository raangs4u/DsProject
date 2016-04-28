package com.company.Tree;

/**
 * @author rmandada
 */
public class MaxDepth {

    public int maxDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }

        int depth1 = maxDepth(a.left);
        int depth2 = maxDepth(a.right);
        return 1+ Math.max(depth1, depth2);
    }

    public int minDepth(TreeNode a) {
        if (a == null) {
            return 0;
        }

        if (a.left ==null && a.right == null) {
            return 1;
        }
        if (a.left == null) {
            return 1+ minDepth(a.right);
        }
        if (a.right == null) {
            return 1+ minDepth(a.left);
        }
        int depth1 = minDepth(a.left);
        int depth2 = minDepth(a.right);
        return 1+ Math.min(depth1, depth2);
    }
}
