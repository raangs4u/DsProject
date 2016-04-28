package com.company.Tree;

/**
 * @author rmandada
 */
public class ValidateBst {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        n2.right = n3;
        n2.left = n1;
        n4.left = n2;
        n4.right = n5;
        System.out.println(isValidBST(n4));
    }

    public static int isValidBST(TreeNode a) {
        if(a == null ) {
            return 1;
        }

        if(a.left == null && a.right == null) {
            return 1;
        } else if(a.left == null) {
            if(a.right.val <= a.val) {
                return 0;
            } else {
                if(isValidBST(a.right)==0) {
                    return 0;
                } else {
                    TreeNode rightMin = findMin(a.right);
                    if (rightMin.val <= a.val) {
                        return 0;
                    }
                    return 1;
                }
            }
        } else if(a.right == null) {
            if(a.left.val >= a.val ) {
                return 0;
            } else {
                if(isValidBST(a.left)==0 ) {
                    return 0;
                } else {
                    TreeNode leftMax = findMax(a.left);
                    if (leftMax.val >= a.val) {
                        return 0;
                    }
                    return 1;
                }
            }
        } else {
            if(a.left.val >= a.val || a.right.val <= a.val) {
                return 0;
            } else {
                if(isValidBST(a.left)==0 || isValidBST(a.right)==0) {
                    return 0;
                } else {
                    TreeNode leftMax = findMax(a.left);
                    TreeNode rightMin = findMin(a.right);
                    if (leftMax.val >= a.val || rightMin.val <= a.val) {
                        return 0;
                    }
                    return 1;
                }
            }
        }

        //return 1;
    }

    public static TreeNode findMin(TreeNode root) {
        TreeNode temp = root;
        while (temp.left!= null) {
            temp= temp.left;
        }
        return temp;
    }

    public static TreeNode findMax(TreeNode root) {
        TreeNode temp = root;
        while (temp.right!= null) {
            temp= temp.right;
        }
        return temp;
    }
}
