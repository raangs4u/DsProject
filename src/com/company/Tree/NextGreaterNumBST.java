package com.company.Tree;

/**
 * @author rmandada
 */
public class NextGreaterNumBST {
    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode temp = a;
        while(temp!= null && temp.val != b) {
            if(b < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if(temp == null) {
            return null;
        }
        TreeNode current = temp;
        if(current.right != null) {
            TreeNode min = current.right;
            temp = min;
            while(temp.left!= null) {
                temp = temp.left;
            }
            min = temp;
            return min;
        } else {
            TreeNode succ = null;
            TreeNode anc = a;
            while(current != anc) {
                if(current.val<anc.val) {
                    succ = anc;
                    anc = anc.left;
                } else {
                    anc = anc.right;
                }
            }
            return succ;
        }

    }

    public TreeNode getPredecessor(TreeNode a, int b) {
        TreeNode current = find(a,b);
        if (current==null) {
            return null;
        }

        if (current.left != null) {
            return findMax(current.left);
        } else {
            TreeNode pred = null;
            TreeNode anc = a;
            while (current != anc) {
                if (current.val > anc.val) {
                    pred = anc;
                    anc = anc.right;
                } else {
                    anc = anc.left;
                }
            }

            return pred;
        }
    }

    public TreeNode find(TreeNode root, int v) {
        TreeNode temp = root;
        while(temp!= null && temp.val != v) {
            if(v < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }

    public TreeNode findMin(TreeNode root) {
        TreeNode temp = root;
        while (temp.left!= null) {
            temp= temp.left;
        }
        return temp;
    }

    public TreeNode findMax(TreeNode root) {
        TreeNode temp = root;
        while (temp.right!= null) {
            temp= temp.right;
        }
        return temp;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1+ Math.max(height(root.left), height(root.right));
    }

    public int isBalanced(TreeNode a) {
        if (a == null) {
            return 1;
        }

        return Math.abs(height(a.left)-height(a.right)) > 1 ? 0: 1;
    }

    public int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return 1;
        }

        if (a != null && b==null) {
            return 0;
        }

        if (b != null && a==null) {
            return 0;
        }

        if (a.val == b.val && isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right)==1) {
            return 1;
        }

        return 0;
    }

    public int isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return 1;
        }

        if (a!= null ^ b != null) {
            return 0;
        }

        if (a.val == b.val && isSymmetric(a.left, b.right) == 1 && isSymmetric(a.right, b.left) == 1) {
            return 1;
        }

        return 0;
    }


}
