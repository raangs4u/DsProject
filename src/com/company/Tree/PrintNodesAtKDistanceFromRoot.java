package com.company.Tree;

/**
 * @author rmandada
 */
public class PrintNodesAtKDistanceFromRoot {

    public void printKDistant(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k==0) {
            System.out.println(root.val);
        } else {
            printKDistant(root.left, k-1);
            printKDistant(root.right, k-1);
        }
    }
}
