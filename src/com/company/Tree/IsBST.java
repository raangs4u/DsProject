package com.company.Tree;

/**
 * @author rmandada
 */
public class IsBST {

    public boolean isBST1(TreeNode root) {
        return isBSTUtil1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTUtil1(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isBSTUtil1(root.left, min, root.val-1) && isBSTUtil1(root.right, root.val+1, max);
    }

    public boolean isBST2(TreeNode root) {
        return isBSTUtil2(root, null);
    }

    public boolean isBSTUtil2(TreeNode root, TreeNode prev) {
        if (root != null) {
            if(!isBSTUtil2(root.left, prev)) {
                return false;
            }

            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            return isBSTUtil2(root.right, prev);
        }
        return true;
    }

}
