package com.company.Tree;

import java.util.List;

/**
 * @author rmandada
 */
public class MorrisTraversal {

    void morrisTraversal(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }

        TreeNode current = node;
        TreeNode prev;

        while (current!=null) {
            if (current.left == null) {
                res.add(current);
                current = current.right;
            } else {
                prev = current.left;
                while (prev.right != null && prev.right == current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    res.add(current);
                    current = current.right;
                }
            }
        }
    }
}
